package cricketenthusiast;

import opencsvbuilder.CSVBuilderException;
import opencsvbuilder.CSVBuilderFactory;
import opencsvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IplAdapter {
    public abstract Map<String, IPLDAO> loadIplCricketData(String csvFilePath) throws IPLAnalyserException;

    public <E> Map<String, IPLDAO> loadIplCricketData(Class<E> iplCSVClass, String csvFilePath) throws IPLAnalyserException {
        Map<String, IPLDAO> iplMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, iplCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            if (iplCSVClass.getName().equals("cricketenthusiast.IPLBatsmanCsv")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLBatsmanCsv.class::cast)
                        .forEach(iplBatsmanCSV -> iplMap.put(iplBatsmanCSV.player, new IPLDAO(iplBatsmanCSV)));
            } else if (iplCSVClass.getName().equals("cricketenthusiast.IPLBowlerCsv")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLBowlerCsv.class::cast)
                        .forEach(iplBowlerCSV -> iplMap.put(iplBowlerCSV.player, new IPLDAO(iplBowlerCSV)));
            }
        } catch (IOException e) {
            throw new IPLAnalyserException("Wrong File", IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException("Wrong File", IPLAnalyserException.ExceptionType.CSV_BUILDER_ERROR);
        } catch (RuntimeException e) {
            throw new IPLAnalyserException("Wrong File", IPLAnalyserException.ExceptionType.NOT_SUFFICIENT_FILES);
        }
        return iplMap;
    }
}
