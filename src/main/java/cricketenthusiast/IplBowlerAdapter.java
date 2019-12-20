package cricketenthusiast;

import java.util.Map;

public class IplBowlerAdapter extends IplAdapter {

    @Override
    public Map<String, IPLDAO> loadIplCricketData(String csvFilePath) throws IPLAnalyserException {
        Map<String, IPLDAO> iplCsvData = super.loadIplCricketData(IPLBowlerCsv.class, csvFilePath);
        return iplCsvData;
    }
}
