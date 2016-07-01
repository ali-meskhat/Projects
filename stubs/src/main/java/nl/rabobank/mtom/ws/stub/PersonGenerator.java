package nl.rabobank.mtom.ws.stub;

import java.util.Arrays;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonResponse;
import nl.rabobank.mtom.ws.generated.Picture;

/**
 * Created by ame21103 on 29-6-2016.
 */
public class PersonGenerator {

    public static PersonResponse generatePerson(GetPersonsRequest request) {

        final String fileName = "IMG_9720.JPG";

        final DataSource dataSource = new FileDataSource(fileName);

        Picture picture = new Picture().withImageData(new DataHandler(dataSource));

        return new PersonResponse().withPerson(
            new Person().withId(0).withFirstName(request.getName()).withLastName("Last Name").withPicture(picture));

    }

}
