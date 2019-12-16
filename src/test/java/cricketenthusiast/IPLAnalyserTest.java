package cricketenthusiast;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {

    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String DELIMITER_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
    private static final String HEADER_ERROR_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
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
        } catch (IPLAnalyserException e) {
            Assert.assertEquals("Wrong File", e.getMessage());
        }
    }

    @Test
    public void givenIPL2019_CSVFileDelimiterProb_ShouldReturnException() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            IPLAnalyser.batsmanDetails(DELIMITER_RUNS_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileHeaderProb_ShouldReturnException() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            long actual = IPLAnalyser.batsmanDetails(HEADER_ERROR_RUNS_FACT_SHEET);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnTopBattingAveragePlayers() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE);
            Assert.assertEquals("MS Dhoni", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorst_BattingAveragePlayers() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE);
            Assert.assertEquals("Tim Southee", sortedIplData.get(100).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnTopBatsman_ByStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.STRIKE_RATE);
            Assert.assertEquals("Ishant Sharma", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_ByStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.STRIKE_RATE);
            Assert.assertEquals("Bhuvneshwar Kumar", sortedIplData.get(100).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_BySixesAndSixes() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Andre Russell", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_BySixesAndSixes() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Shakib Al Hasan", sortedIplData.get(100).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_BySixesAndSixesWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Andre Russell", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_BySixesAndSixesWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Shakib Al Hasan", sortedIplData.get(100).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_ByAverageWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE);
            Assert.assertEquals("MS Dhoni", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_ByAverageWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE);
            Assert.assertEquals("Tim Southee", sortedIplData.get(100).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_ByMaximumRunWithAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.RUNS);
            Assert.assertEquals("David Warner", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_ByMinimumRunWithAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.batsmanDetails(RUNS_FACT_SHEET);
            List<IPLMostRunCsv> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.RUNS);
            Assert.assertEquals("Tim Southee", sortedIplData.get(100).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }
}
