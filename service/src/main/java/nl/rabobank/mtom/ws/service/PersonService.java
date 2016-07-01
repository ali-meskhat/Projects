package nl.rabobank.mtom.ws.service;


import nl.rabobank.mtom.ws.generated.PersonResponse;

/**
 * Created by ame21103 on 28-6-2016.
 */

public interface PersonService {

    String NAMESPACE = "http://www.rabobank.nl/person/schema/beans";
    String GET_PERSONS_REQUEST = "get-persons-request";

    /**
     * Gets person list.
     */
    PersonResponse getPersons(nl.rabobank.mtom.ws.generated.GetPersonsRequest request);
}
