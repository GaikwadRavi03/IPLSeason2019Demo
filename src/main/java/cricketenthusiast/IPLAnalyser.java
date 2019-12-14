package cricketenthusiast;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IPLAnalyser {
    public int batsmanDetails(String filePath) {
        int noOfPlayers = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CsvToBeanBuilder<IPLMostRunCsv> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IPLMostRunCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IPLMostRunCsv> csvToBean = csvToBeanBuilder.build();
            Iterator<IPLMostRunCsv> censusCSVIterator = csvToBean.iterator();
            Iterable<IPLMostRunCsv> csvIterator = () -> censusCSVIterator;
            noOfPlayers = (int) StreamSupport.stream(csvIterator.spliterator(), false).count();
        } catch (IOException e) {
        }
        return noOfPlayers;
    }
}
