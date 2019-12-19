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

    List<IPLDAO> iplMostRunWicketsCsvs = null;
    Map<SortingFields, Comparator<IPLDAO>> sortingMap = null;

    public IPLAnalyser() {
        this.iplMostRunWicketsCsvs = new ArrayList();
        this.sortingMap = new HashMap<>();
        this.sortingMap.put(SortingFields.AVERAGE, Comparator.comparing(census -> census.average));
        this.sortingMap.put(SortingFields.STRIKE_RATE, Comparator.comparing(census -> census.strikeRate));
        this.sortingMap.put(SortingFields.SIX_AND_FOURS, new SortingFieldsComparator());
        this.sortingMap.put(SortingFields.ECONOMY, Comparator.comparing(census -> census.economy));
        this.sortingMap.put(SortingFields.SIX_AND_FOURS, new SortingFieldsComparator().thenComparing(census -> census.strikeRate));
        Comparator<IPLDAO> comparing = Comparator.comparing(census -> census.average);
        this.sortingMap.put(SortingFields.AVERAGE, comparing.thenComparing(census -> census.strikeRate));
        Comparator<IPLDAO> comparing1 = Comparator.comparing(census -> census.runs);
        this.sortingMap.put(SortingFields.RUNS, comparing1.thenComparing(census -> census.average));
    }

    public long batsmanDetails(String filePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostRunCsv> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLMostRunCsv.class);
            Iterable<IPLMostRunCsv> csvIterable = () -> csvFileIterator;
            StreamSupport.stream(csvIterable.spliterator(), false).
                    map(IPLMostRunCsv.class::cast).
                    forEach(iplCsv -> iplMostRunWicketsCsvs.add(new IPLDAO(iplCsv)));
        } catch (IOException | CSVBuilderException e) {
            throw new IPLAnalyserException("Wrong File", IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        }
        return iplMostRunWicketsCsvs.size();
    }

    public long bowlerDetails(String filePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostWicketsCsv> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLMostWicketsCsv.class);
            Iterable<IPLMostWicketsCsv> csvIterable = () -> csvFileIterator;
            StreamSupport.stream(csvIterable.spliterator(), false).
                    map(IPLMostWicketsCsv.class::cast).
                    forEach(iplCsv -> iplMostRunWicketsCsvs.add(new IPLDAO(iplCsv)));
        } catch (IOException | CSVBuilderException e) {
            throw new IPLAnalyserException("Wrong File", IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        }
        return iplMostRunWicketsCsvs.size();
    }

    public List<IPLDAO> sortedPlayersData(SortingFields fieldName) {
        List<IPLDAO> sortedPlayer = iplMostRunWicketsCsvs.stream()
                .sorted(sortingMap.get(fieldName).reversed())
                .collect(Collectors.toList());
        return sortedPlayer;
    }
}
