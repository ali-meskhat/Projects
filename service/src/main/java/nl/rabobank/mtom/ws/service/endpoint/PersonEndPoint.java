package nl.rabobank.mtom.ws.service.endpoint;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.PersonResponse;
import nl.rabobank.mtom.ws.service.PersonService;
import nl.rabobank.mtom.ws.stub.PersonGenerator;

import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * Created by ame21103 on 28-6-2016.
 */
@Endpoint
public class PersonEndPoint implements PersonService {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(PersonService.class);

    /**
     * Gets person list.
     */
    @PayloadRoot(localPart = GET_PERSONS_REQUEST, namespace = NAMESPACE)
    public PersonResponse getPersons(GetPersonsRequest request) {

        LOG.info("getPersons: request [{}]" + request);
        return PersonGenerator.generatePerson(request);
    }
}
