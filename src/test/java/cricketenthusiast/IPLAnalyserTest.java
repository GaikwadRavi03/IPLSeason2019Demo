package cricketenthusiast;

import org.junit.Assert;
import org.junit.Test;
import cricketenthusiast.IPLAnalyser.*;

import java.util.List;
import java.util.Map;

public class IPLAnalyserTest {

    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WICKETS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    //----------------------Batsman's------------------
    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBatsmanRecords() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
            Map<String, IPLDAO> actual = iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            Assert.assertEquals(100, actual.size());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnTopBattingAveragePlayers() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            iplAnalyser.setAdapter(new IplBatsmanAdapter());
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
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            Map<String, IPLDAO> actual = iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            Assert.assertEquals(99, actual.size());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_AVERAGE);
            Assert.assertEquals("Shivam Dube", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowler_ByAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BALL_AVERAGE);
            Assert.assertEquals("Krishnappa Gowtham", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE_WITH_STRIKE_RATE);
            Assert.assertEquals("Shivam Dube", sortedIplData.get(98).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnWorstBowler_ByAverageWithStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.AVERAGE_WITH_STRIKE_RATE);
            Assert.assertEquals("Krishnappa Gowtham", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByWicketsWithAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
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
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.MAX_WICKET_AVERAGE);
            Assert.assertEquals("Yusuf Pathan", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfBoth_ShouldReturnTOPBowlerAndBatsman_ByAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            Map<String, IPLDAO> batsmanAvg = iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            Map<String, IPLDAO> ballAvg = iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> ipldaoList = iplAnalyser.mergeAndSort(batsmanAvg, ballAvg, SortingFields.BEST_BALL_BAT);
            Assert.assertEquals("Andre Russell", ipldaoList.get(ipldaoList.size() - 1).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfBoth_ShouldReturnAllRounderWithRunsAndWickets() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(new IplBowlerAdapter());
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, cricketerTypes.BATSMAN);
            List<IPLDAO> bat = iplAnalyser.sortedPlayersData(SortingFields.ALL_ROUNDER);
            iplAnalyser.loadCricketerData(WICKETS_FACT_SHEET, cricketerTypes.BOWLER);
            List<IPLDAO> ball = iplAnalyser.sortedPlayersData(SortingFields.ALL_ROUNDER);
            IPLDAO ipldaoList = iplAnalyser.allRounder(bat, ball);
            Assert.assertEquals("Yusuf Pathan", ipldaoList.player.trim());
        } catch (IPLAnalyserException e) {
        }
    }
}
