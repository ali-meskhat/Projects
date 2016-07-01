package nl.rabobank.ws.service;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StreamCorruptedException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonResponse;
import nl.rabobank.mtom.ws.generated.Picture;
import nl.rabobank.mtom.ws.service.endpoint.PersonEndPoint;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ame21103 on 29-6-2016.
 */
public class PersonServiceTest {

    private PersonEndPoint personService;
    private GetPersonsRequest personsRequest;
    private PersonResponse personResponse;
    private Picture picture;

    @Before
    public void before() {

        personService = new PersonEndPoint();

        final String fileName = "IMG_9720.JPG";

        DataSource dataSource = new FileDataSource(fileName);

        picture = new Picture().withImageData(new DataHandler(dataSource));

        Person ali = new Person().withId(0).withFirstName("Ali").withLastName("Last Name").withPicture(picture);

        personsRequest = new GetPersonsRequest().withName("Ali");
        personResponse = new PersonResponse().withPerson(ali);

    }

    @Test
    public void testEndPointResponse() {
        PersonResponse response = personService.getPersons(personsRequest);

        Person person = response.getPerson().get(0);

        assertSame("Ali", person.getFirstName());
        assertSame("Last Name", person.getLastName());

    }

    @Test
    public void testPictureStream() {
        Person p = personResponse.getPerson().get(0);

    }

}
