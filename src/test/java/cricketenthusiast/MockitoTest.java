package cricketenthusiast;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {
    Map<String, IPLDAO> batsmanData = null;
    Map<String, IPLDAO> bowlerData = null;
    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WICKETS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    IPLAnalyser iplAnalyser;
    IPLAnalyser iplAnalyser1;

    @Mock
    IplBatsmanAdapter adapter;
    IplBowlerAdapter iplBowlerAdapter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        try {
            batsmanData = new HashMap<>();
            IPLDAO ipldao = new IPLDAO();
            batsmanData.put("Hardik Pandya", new IPLDAO("Hardik Pandya", 12, 20));
            batsmanData.put("Suresh Raina", new IPLDAO("Suresh Raina", 21, 21));
            batsmanData.put("MS Dhoni", new IPLDAO("MS Dhoni", 20, 33));
            IplBatsmanAdapter iplAdapter = mock(IplBatsmanAdapter.class);
            when(iplAdapter.loadIplCricketData(RUNS_FACT_SHEET)).thenReturn(batsmanData);
            iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(iplAdapter);


            bowlerData = new HashMap<>();
            IPLDAO ipldao1 = new IPLDAO();
            bowlerData.put("Jasprit Bumrah", new IPLDAO("Jasprit Bumrah", 12, 32));
            bowlerData.put("Imran Tahir", new IPLDAO("Imran Tahir", 17, 10));
            IplBowlerAdapter iplBowlerAdapter = mock(IplBowlerAdapter.class);
            when(iplBowlerAdapter.loadIplCricketData(WICKETS_FACT_SHEET)).thenReturn(bowlerData);
            iplAnalyser1 = new IPLAnalyser();
            iplAnalyser1.setAdapter(iplBowlerAdapter);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenSampleBatsmanData_ShouldReturnCount() {
        try {
            Map<String, IPLDAO> data = iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, IPLAnalyser.cricketerTypes.BATSMAN);
            Assert.assertEquals(3, data.size());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenSampleBowlerData_ShouldReturnCount() {
        try {
            Map<String, IPLDAO> data = iplAnalyser1.loadCricketerData(WICKETS_FACT_SHEET, IPLAnalyser.cricketerTypes.BOWLER);
            Assert.assertEquals(2, data.size());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfRuns_ShouldReturnTopBattingAveragePlayers() {
        try {
            iplAnalyser.loadCricketerData(RUNS_FACT_SHEET, IPLAnalyser.cricketerTypes.BATSMAN);
            List<IPLDAO> sortedIplData = iplAnalyser.sortedPlayersData(SortingFields.BAT_AVERAGE);
            Assert.assertEquals("Suresh Raina", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenMessage_SortedListOfWickets_ShouldReturnTopBowler_ByAverage() {
        try {
            iplAnalyser1.loadCricketerData(WICKETS_FACT_SHEET, IPLAnalyser.cricketerTypes.BOWLER);
            List<IPLDAO> sortedIplData = iplAnalyser1.sortedPlayersData(SortingFields.BALL_AVERAGE);
            Assert.assertEquals("Jasprit Bumrah", sortedIplData.get(0).player.trim());
        } catch (IPLAnalyserException e) {
        }
    }
}
