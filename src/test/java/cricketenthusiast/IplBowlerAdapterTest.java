package cricketenthusiast;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IplBowlerAdapterTest {

    private static final String DELIMITER_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
    private static final String HEADER_ERROR_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
    private static final String WICKETS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns12.csv";
    private String NULL_FILE_PATH;

    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBowlerExactRecords() {
        try {
            IplBowlerAdapter iplBowlerAdapter = new IplBowlerAdapter();
            Map<String, IPLDAO> stringIPLDAOMap = iplBowlerAdapter.loadIplCricketData(WICKETS_FACT_SHEET);
            Assert.assertEquals(99, stringIPLDAOMap.size());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPL2019_CSVFileWrong_ShouldReturnsException() {
        try {
            IplBowlerAdapter iplBowlerAdapter = new IplBowlerAdapter();
            iplBowlerAdapter.loadIplCricketData(WRONG_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals("Wrong File", e.getMessage());
        }
    }

    @Test
    public void givenIPL2019_CSVFileDelimiterProb_ShouldReturnException() {
        try {
            IplBowlerAdapter iplBowlerAdapter = new IplBowlerAdapter();
            iplBowlerAdapter.loadIplCricketData(DELIMITER_RUNS_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileHeaderProb_ShouldReturnException() {
        try {
            IplBowlerAdapter iplBowlerAdapter = new IplBowlerAdapter();
            iplBowlerAdapter.loadIplCricketData(HEADER_ERROR_RUNS_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileEmpty_ShouldReturnException() {
        try {
            IplBowlerAdapter iplBowlerAdapter = new IplBowlerAdapter();
            iplBowlerAdapter.loadIplCricketData("");
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileNull_ShouldReturnException() {
        try {
            IplBowlerAdapter iplBowlerAdapter = new IplBowlerAdapter();
            iplBowlerAdapter.loadIplCricketData(NULL_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.NOT_SUFFICIENT_FILES, e.type);
        }
    }
}
