package nl.rabobank.ws.client;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.PersonResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Created by ame21103 on 29-6-2016.
 */
@Component
public class GetPersonServiceClient {

    private static Logger LOG = LoggerFactory.getLogger(GetPersonServiceClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    /**
     * Gets person list.
     */
    public GetPersonServiceClient() {
    }

    public PersonResponse getPersons(GetPersonsRequest request) {

        PersonResponse response = (PersonResponse) webServiceTemplate.marshalSendAndReceive(request);
        LOG.debug("Response [{}]: " + response.getPerson().toString());
        return response;
    }

}
