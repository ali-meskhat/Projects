package nl.rabobank.mtom.ws.service;


import nl.rabobank.mtom.ws.generated.ImportFileRequest;
import nl.rabobank.mtom.ws.generated.ImportFileResponse;

/**
 * Created by ame21103 on 28-6-2016.
 */

public interface ImportPersonBatchService {

    String NAMESPACE = "http://www.rabobank.nl/import/schema/beans";
    String GET_PERSONS_REQUEST = "import-file-request";

    /**
     * Gets person list.
     */
    ImportFileResponse getImportResults(ImportFileRequest request);
}
