package cricketenthusiast;

import opencsvbuilder.CSVBuilderException;
import opencsvbuilder.CSVBuilderFactory;
import opencsvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IPLAnalyser {
    public long batsmanDetails(String filePath) throws IPLAnalyserException {
        long count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostRunCsv> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLMostRunCsv.class);
            Iterable<IPLMostRunCsv> csvIterable = () -> csvFileIterator;
            count = StreamSupport.stream(csvIterable.spliterator(), false).count();
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException(IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
