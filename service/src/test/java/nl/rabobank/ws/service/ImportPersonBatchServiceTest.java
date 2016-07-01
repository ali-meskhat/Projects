package nl.rabobank.ws.service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import nl.rabobank.mtom.ws.generated.ImportFileRequest;
import nl.rabobank.mtom.ws.generated.ImportFileResponse;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.Picture;
import nl.rabobank.mtom.ws.service.endpoint.ImportPersonBatchEndPoint;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ame21103 on 29-6-2016.
 */
public class ImportPersonBatchServiceTest {

    private ImportPersonBatchEndPoint personService;
    private ImportFileRequest personsRequest;
    private ImportFileResponse personResponse;
    private Picture picture;

    @Before
    public void before() {

        personService = new ImportPersonBatchEndPoint();

        final String fileName = "IMG_9720.JPG";

        DataSource dataSource = new FileDataSource(fileName);

        picture = new Picture().withImageData(new DataHandler(dataSource));

        Person ali = new Person().withId(0).withFirstName("Ali").withLastName("Last Name").withPicture(picture);

        personsRequest = new ImportFileRequest();
        personResponse = new ImportFileResponse();



    }



}
