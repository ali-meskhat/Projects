package nl.rabobank.ws.client;

import nl.rabobank.mtom.ws.generated.ImportFileRequest;
import nl.rabobank.mtom.ws.generated.ImportFileResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Created by ame21103 on 29-6-2016.
 */
@Component
public class ImportPersonBatchServiceClient {

    private static Logger LOG = LoggerFactory.getLogger(ImportPersonBatchServiceClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    /**
     * Gets person list.
     */
    public ImportPersonBatchServiceClient() {
    }

    public ImportFileResponse importBatch(ImportFileRequest request) {

        ImportFileResponse response = (ImportFileResponse) webServiceTemplate.marshalSendAndReceive(request);
        LOG.debug("Response [{}]: " + response.getResults().toString());
        return response;
    }

}
