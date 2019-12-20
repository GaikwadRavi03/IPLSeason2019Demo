package cricketenthusiast;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IplBatsmanAdapterTest {

    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String DELIMITER_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
    private static final String HEADER_ERROR_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns12.csv";
    private String NULL_FILE_PATH;

    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBatsmanRecords() {
        try {
            IplBatsmanAdapter iplBatsmanAdapter = new IplBatsmanAdapter();
            Map<String, IPLDAO> iplDAOMap = iplBatsmanAdapter.loadIplCricketData(RUNS_FACT_SHEET);
            Assert.assertEquals(100, iplDAOMap.size());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPL2019_CSVFileWrong_ShouldReturnsException() {
        try {
            IplBatsmanAdapter iplBatsmanAdapter = new IplBatsmanAdapter();
            iplBatsmanAdapter.loadIplCricketData(WRONG_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals("Wrong File", e.getMessage());
        }
    }

    @Test
    public void givenIPL2019_CSVFileDelimiterProb_ShouldReturnException() {
        try {
            IplBatsmanAdapter iplBatsmanAdapter = new IplBatsmanAdapter();
            iplBatsmanAdapter.loadIplCricketData(DELIMITER_RUNS_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileHeaderProb_ShouldReturnException() {
        try {
            IplBatsmanAdapter iplBatsmanAdapter = new IplBatsmanAdapter();
            iplBatsmanAdapter.loadIplCricketData(HEADER_ERROR_RUNS_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileEmpty_ShouldReturnException() {
        try {
            IplBatsmanAdapter iplBatsmanAdapter = new IplBatsmanAdapter();
            iplBatsmanAdapter.loadIplCricketData("");
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileNull_ShouldReturnException() {
        try {
            IplBatsmanAdapter iplBatsmanAdapter = new IplBatsmanAdapter();
            iplBatsmanAdapter.loadIplCricketData(NULL_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.NOT_SUFFICIENT_FILES, e.type);
        }
    }
}
