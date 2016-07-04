package nl.rabobank.mtom.ws.stub;

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

/**
 * Created by ame21103 on 29-6-2016.
 */
public class ImportResultGenerator {

    public static ImportFileResponse generateImportResult(ImportFileRequest request) {

        final String fileName = "IMG_9720.JPG";
        final DataSource dataSource = new FileDataSource(fileName);
        final List<Map<String, Integer>> result = new ArrayList<>();

        Picture picture = new Picture().withImageData(new DataHandler(dataSource));

        ImportFileResponse importFileResponse = new ImportFileResponse();

        ArrayList<Result> results = new ArrayList<>();

        PersonBatch personBatch = request.getPerson();
        for (Person person : personBatch.getPersons()) {
            Result res = new Result().withKey(person.getId()).withValue("success");
            results.add(res);

        }

        return importFileResponse.withResults(results);

    }

}
