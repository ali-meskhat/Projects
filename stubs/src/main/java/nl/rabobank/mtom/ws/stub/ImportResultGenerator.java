package nl.rabobank.mtom.ws.stub;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import nl.rabobank.mtom.ws.generated.ImportFileRequest;
import nl.rabobank.mtom.ws.generated.ImportFileResponse;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonBatch;
import nl.rabobank.mtom.ws.generated.Picture;
import nl.rabobank.mtom.ws.generated.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ame21103 on 29-6-2016.
 */
public class ImportResultGenerator {

    private static Logger LOG = LoggerFactory.getLogger(ImportResultGenerator.class);

    public ImportFileResponse getImportResult(ImportFileRequest request) {
        ImportFileResponse importFileResponse = new ImportFileResponse();
        return importFileResponse.withResults(processRequest(request));

    }

    private List<Result> processRequest(ImportFileRequest request) {

        FileOutputStream fileOutputStream;
        ArrayList<Result> results = new ArrayList<>();

        PersonBatch personBatch = request.getPersonBatch();
        for (Person person : personBatch.getPersons()) {
            Result res = new Result().withKey(person.getId()).withValue("success");
            results.add(res);

            try {
                fileOutputStream = new FileOutputStream("output.JPG");
                DataHandler dataHandler = person.getPicture().getImageData();

                ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) dataHandler.getContent();

                int count = byteArrayInputStream.read();

                LOG.debug("Received Picture [{}]", person.getPicture().getTitle());
                LOG.debug("Received Picture [{}]", count);

                dataHandler.writeTo(fileOutputStream);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return results;

    }

}
