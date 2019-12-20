package cricketenthusiast;

import java.util.Map;

public class IplBatsManAdapter extends IplAdapter {
    @Override
    public Map<String, IPLDAO> loadIplCricketData(String csvFilePath) throws IPLAnalyserException {
        Map<String, IPLDAO> iplCsvDataMap = super.loadIplCricketData(IPLBatsmanCsv.class, csvFilePath);
        return iplCsvDataMap;
    }
}
