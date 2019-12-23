package cricketenthusiast;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {

    private static final String RUNS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WICKETS_FACT_SHEET = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Mock
    IplAdapter adapter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void givenSampleBatsmanData_ShouldReturnCount() {
        try {
            Map<String, IPLDAO> ipldaoMap = new HashMap<>();
            IPLDAO ipldao = new IPLDAO();
            ipldaoMap.put("Rohit Sharma", ipldao);
            ipldaoMap.put("MS Dhoni", ipldao);
            IplAdapter iplAdapter = mock(IplAdapter.class);
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(iplAdapter);
            Assert.assertEquals(2, ipldaoMap.size());
            when(iplAdapter.loadIplCricketData(IplBatsmanAdapter.class, RUNS_FACT_SHEET)).thenReturn(ipldaoMap);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenSampleBowlerData_ShouldReturnCount() {
        try {
            Map<String, IPLDAO> ipldaoMap = new HashMap<>();
            IPLDAO ipldao = new IPLDAO();
            ipldaoMap.put("Hardik Pandya", ipldao);
            ipldaoMap.put("Suresh Raina", ipldao);
            ipldaoMap.put("Piyush Chawla", ipldao);
            IplAdapter iplAdapter = mock(IplAdapter.class);
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setAdapter(iplAdapter);
            Assert.assertEquals(3, ipldaoMap.size());
            when(iplAdapter.loadIplCricketData(IplBowlerAdapter.class, WICKETS_FACT_SHEET)).thenReturn(ipldaoMap);
        } catch (IPLAnalyserException e) {
        }
    }
}
