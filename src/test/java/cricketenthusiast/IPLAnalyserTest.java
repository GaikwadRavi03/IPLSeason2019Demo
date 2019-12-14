package cricketenthusiast;

import org.junit.Assert;
import org.junit.Test;

public class CricketEnthusiastTest {

    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WICKETS_FACT_SHEET = ".src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBatsmanRecords() {
        CricketEnthusiast cricketEnthusiast = new CricketEnthusiast();
        int actual = cricketEnthusiast.batsmanDetails(RUNS_FACT_SHEET);
        Assert.assertEquals(101, actual);
    }

    @Test
    public void givenIPL2019_CSVFileShouldReturns_NoOFBowlersRecords() {
        CricketEnthusiast cricketEnthusiast = new CricketEnthusiast();
//        int actual = cricketEnthusiast.bowlerDetails(WICKETS_FACT_SHEET);
//        Assert.assertEquals(100, actual);
    }
}
