package nl.rabobank.mtom.ws.service;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * Created by ame21103 on 28-6-2016.
 */
@Endpoint
public class PersonEndPoint implements PersonService {
    /**
     * Gets person list.
     */
    @PayloadRoot(localPart = GET_PERSONS_REQUEST, namespace = NAMESPACE)
    public PersonResponse getPersons(GetPersonsRequest request) {
        return new PersonResponse().withPerson(new Person().withId(1).withFirstName("Joe").withLastName("Smith"),
            new Person().withId(2).withFirstName("John").withLastName("Jackson"));
    }
}
