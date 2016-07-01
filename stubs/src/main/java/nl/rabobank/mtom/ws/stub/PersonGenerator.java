package nl.rabobank.mtom.ws.stub;

import java.util.Arrays;
import java.util.List;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonResponse;

/**
 * Created by ame21103 on 29-6-2016.
 */
public class PersonGenerator {

    public static PersonResponse generatePerson(GetPersonsRequest request) {

        return new PersonResponse().withPerson(new Person().withId(0).withFirstName(request.getName()).withLastName("Last Name"));

    }

}
