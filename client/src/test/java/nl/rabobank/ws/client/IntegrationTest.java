package nl.rabobank.ws.client;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;

import nl.rabobank.mtom.ws.generated.ImportFileRequest;
import nl.rabobank.mtom.ws.generated.ImportFileResponse;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonBatch;
import nl.rabobank.mtom.ws.generated.Picture;
import nl.rabobank.mtom.ws.generated.Result;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created by ame21103 on 29-6-2016.
 */

@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-ws-client-context.xml" })

public class IntegrationTest {

    private ImportFileRequest request;
    private ImportFileResponse response;

    @Autowired
    private ImportPersonBatchServiceClient importPersonBatchServiceClient;

    @Before
    public void before() throws IOException {

        final File imageFile = new File("src\\test\\resources\\IMG_9720.JPG");
        final byte[] imageData = Files.readAllBytes(imageFile.toPath());


        final File imageFile2 = new File("src\\test\\resources\\IMG_9720.JPG");
        final byte[] imageData2 = Files.readAllBytes(imageFile2.toPath());

        final Picture picture =
                new Picture().withImageData(new DataHandler(imageData, "application/octet-stream")).withTitle("Flowers");
        final Picture picture2 =
                new Picture().withImageData(new DataHandler(imageData2, "application/octet-stream")).withTitle("Cat");

        request = new ImportFileRequest();
        response = new ImportFileResponse();

        Person joseph = new Person().withFirstName("Josph").withLastName("K").withId(0).withPicture(picture);
        Person M = new Person().withFirstName("M").withLastName("L").withId(1).withPicture(picture2);

        List<Person> persons = new ArrayList<>();

        persons.add(joseph);
        persons.add(M);

        PersonBatch personBatch = new PersonBatch().withPersons(persons);

        request.withPersonBatch(personBatch);

        List<Result> results = new ArrayList<>();

        Result result1 = new Result();
        Result result2 = new Result();

        result1.setKey(joseph.getId());
        result2.setKey(M.getId());

        result1.setValue("success");
        result2.setValue("success");

        results.add(result1);
        results.add(result2);

        response.withResults(results);
    }

    @Test
    public void testResponse() throws InterruptedException {
        Assert.assertEquals(response, importPersonBatchServiceClient.importBatch(request));

    }

}
