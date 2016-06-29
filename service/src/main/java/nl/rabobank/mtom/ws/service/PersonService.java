package nl.rabobank.mtom.ws.service;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.PersonResponse;

/**
 * Created by ame21103 on 28-6-2016.
 */
public interface PersonService {
    public final static String NAMESPACE = "http://http://www.rabobank.nl/person/schema/beans";
    public final static String GET_PERSONS_REQUEST = "get-persons-request";

    /**
     * Gets person list.
     */
    public PersonResponse getPersons(GetPersonsRequest request);
}
