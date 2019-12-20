package cricketenthusiast;

import org.junit.Assert;
import org.junit.Test;
import cricketenthusiast.IPLAnalyser.*;

import java.util.List;

public class IPLAnalyserTest {

    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String DELIMITER_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
    private static final String HEADER_ERROR_RUNS_FACT_SHEET = "./src/test/resources/Delimiter_IPL2019FactsheetMostRuns.csv";
    private static final String WICKETS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns12.csv";

    //----------------------Batsman's------------------
    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBatsmanRecords() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            long actual = IPLAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            Assert.assertEquals(100, actual);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPL2019_CSVFileWrong_ShouldReturnsException() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            long actual = IPLAnalyser.loadCricketerData(WRONG_FACT_SHEET, cricketerTypes.BATSMAN);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals("Wrong File", e.getMessage());
        }
    }

    @Test
    public void givenIPL2019_CSVFileDelimiterProb_ShouldReturnException() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            IPLAnalyser.loadCricketerData(DELIMITER_RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPL2019_CSVFileHeaderProb_ShouldReturnException() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            long actual = IPLAnalyser.loadCricketerData(HEADER_ERROR_RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnTopBattingAveragePlayers() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BAT_AVERAGE);
            Assert.assertEquals("MS Dhoni", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorst_BattingAveragePlayers() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BAT_AVERAGE);
            Assert.assertEquals("Tim Southee", sortedIplData.get(99).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnTopBatsman_ByStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BAT_STRIKE_RATE);
            Assert.assertEquals("Ishant Sharma", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_ByStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BAT_STRIKE_RATE);
            Assert.assertEquals("Bhuvneshwar Kumar", sortedIplData.get(99).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_BySixesAndSixes() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Andre Russell", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_BySixesAndSixes() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Shakib Al Hasan", sortedIplData.get(99).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_BySixesAndSixesWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Andre Russell", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_BySixesAndSixesWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.SIX_AND_FOURS);
            Assert.assertEquals("Shakib Al Hasan", sortedIplData.get(99).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_ByAverageWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BAT_AVERAGE);
            Assert.assertEquals("MS Dhoni", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_ByAverageWithStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BAT_AVERAGE);
            Assert.assertEquals("Tim Southee", sortedIplData.get(99).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnBestBatsman_ByMaximumRunWithAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.RUNS);
            Assert.assertEquals("David Warner", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnWorstBatsman_ByMinimumRunWithAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.RUNS);
            Assert.assertEquals("Tim Southee", sortedIplData.get(99).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    //--------------Bowlers------------
    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBowlerRecords() {
        try {
            IPLAnalyser IPLAnalyser = new IPLAnalyser();
            long actual = IPLAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            Assert.assertEquals(99, actual);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_AVERAGE);
            Assert.assertEquals("Suresh Raina", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowler_ByAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_AVERAGE);
            Assert.assertEquals("Deepak Chahar", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_STRIKE_RATE);
            Assert.assertEquals("Shivam Dube", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowler_ByStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_STRIKE_RATE);
            Assert.assertEquals("Krishnappa Gowtham", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnBestEconomyBowler() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.ECONOMY);
            Assert.assertEquals("Shivam Dube", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstEconomyBowler() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.ECONOMY);
            Assert.assertEquals("Ben Cutting", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowlerBY5sAnd4s() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.WICKETS_FIVES_FOURES);
            Assert.assertEquals("Sandeep Warrier", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowlerBY5sAnd4s() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.WICKETS_FIVES_FOURES);
            Assert.assertEquals("Imran Tahir", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByStrikeRateWithWickets() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_STRIKE_RATE_WITH_WICKETS);
            Assert.assertEquals("Shivam Dube", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowler_ByAverageRateWithWickets() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_STRIKE_RATE_WITH_WICKETS);
            Assert.assertEquals("Krishnappa Gowtham", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByAverageRateWithStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE_WITH_STRIKE_RATE);
            Assert.assertEquals("Suresh Raina", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowler_ByAverageWithStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE_WITH_STRIKE_RATE);
            Assert.assertEquals("Deepak Chahar", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByWicketsWithAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.MAX_WICKET_AVERAGE);
            Assert.assertEquals("Imran Tahir", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowler_ByWicketsWithAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.MAX_WICKET_AVERAGE);
            Assert.assertEquals("Yusuf Pathan", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }
}
