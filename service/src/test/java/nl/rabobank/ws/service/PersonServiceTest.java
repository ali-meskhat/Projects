package nl.rabobank.ws.service;

import static junit.framework.Assert.assertEquals;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonResponse;
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

    @Before
    public void before() {

        personService = new PersonEndPoint();

        Person ali = new Person().withId(0).withFirstName("Ali").withLastName("Last Name");

        personsRequest = new GetPersonsRequest().withName("Ali");
        personResponse =
                new PersonResponse().withPerson(ali);

    }

    @Test
    public void testEndPointResponse() {
        assertEquals(personResponse, personService.getPersons(personsRequest));

    }

}
