package nl.rabobank.mtom.ws.service.endpoint;

import nl.rabobank.mtom.ws.generated.ImportFileRequest;
import nl.rabobank.mtom.ws.generated.ImportFileResponse;
import nl.rabobank.mtom.ws.service.ImportPersonBatchService;
import nl.rabobank.mtom.ws.stub.ImportResultGenerator;

import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * Created by ame21103 on 28-6-2016.
 */
@Endpoint
public class ImportPersonBatchEndPoint implements ImportPersonBatchService {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(ImportPersonBatchService.class);

    /**
     * Gets person list.
     */
    @PayloadRoot(localPart = GET_PERSONS_REQUEST, namespace = NAMESPACE)
    public ImportFileResponse getImportResults(ImportFileRequest request) {
        LOG.info("getImportResults: request [{}]" + request);
        ImportResultGenerator resultGenerator = new ImportResultGenerator();

        return resultGenerator.getImportResult(request);
    }
}
