package cricketenthusiast;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class IPLAnalyserTest {

    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WICKETS_FACT_SHEET = ".src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns12.csv";

    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBatsmanRecords() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            long actual = IPLAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            Assert.assertEquals(101, actual);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPL2019_CSVFileWrong_ShouldReturnsException() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            long actual = IPLAnalyser.batsmanDetails(WRONG_FACT_SHEET);
//            Assert.assertEquals(101, actual);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
            e.printStackTrace();
        }
    }
}
