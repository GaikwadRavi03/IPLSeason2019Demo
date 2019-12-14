package cricketenthusiast;

import opencsvbuilder.CSVBuilderException;
import opencsvbuilder.CSVBuilderFactory;
import opencsvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IPLAnalyser {

    List<IPLMostRunCsv> iplMostRunCsvs = null;
    Map<SortingFields, Comparator<IPLMostRunCsv>> sortingMap = null;
    Comparator<IPLMostRunCsv> runCsvComparator=null;
    public IPLAnalyser() {
        this.iplMostRunCsvs = new ArrayList();
        this.sortingMap = new HashMap<>();
        this.sortingMap.put(SortingFields.AVERAGE, Comparator.comparing(census -> census.average));
        this.sortingMap.put(SortingFields.STRIKE_RATE, Comparator.comparing(census -> census.strikeRate));
    }

    public long batsmanDetails(String filePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostRunCsv> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLMostRunCsv.class);
            Iterable<IPLMostRunCsv> csvIterable = () -> csvFileIterator;
            StreamSupport.stream(csvIterable.spliterator(), false).
                    forEach(iplCsv -> iplMostRunCsvs.add(iplCsv));
        } catch (IOException | CSVBuilderException e) {
            throw new IPLAnalyserException("Wrong File", IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        }
        return iplMostRunCsvs.size();
    }

    public List<IPLMostRunCsv> getStateWiseSortedCensusData(SortingFields fieldName) {
        List<IPLMostRunCsv> sortedPlayer = (List<IPLMostRunCsv>) iplMostRunCsvs.stream()
                .sorted(sortingMap.get(fieldName).reversed())
                .collect(Collectors.toList());
        return sortedPlayer;
    }
}
