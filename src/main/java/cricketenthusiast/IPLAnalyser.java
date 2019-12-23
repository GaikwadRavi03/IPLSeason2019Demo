package cricketenthusiast;

import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {

    Map<String, IPLDAO> iplMostRunWicketsCsvs = null;
    Map<SortingFields, Comparator<IPLDAO>> sortingMap;
    Map<String, IPLDAO> allRounderMap = null;
    IplAdapter adapter;

    public void setAdapter(IplAdapter adapter) {
        this.adapter = adapter;
    }

    public enum cricketerTypes {BATSMAN, BOWLER}

    public IPLAnalyser() {
        this.iplMostRunWicketsCsvs = new HashMap<>();
        this.sortingMap = new HashMap<>();
        allRounderMap = new HashMap<>();
        this.sortingMap.put(SortingFields.BAT_AVERAGE, Comparator.comparing(census -> census.batAverage));
        this.sortingMap.put(SortingFields.BAT_STRIKE_RATE, Comparator.comparing(census -> census.batStrikeRate));
        this.sortingMap.put(SortingFields.SIX_AND_FOURS, new SortingFieldsComparator());
        this.sortingMap.put(SortingFields.ECONOMY, Comparator.comparing(census -> census.economy));
        this.sortingMap.put(SortingFields.SIX_AND_FOURS, new SortingFieldsComparator().thenComparing(census -> census.batStrikeRate));
        Comparator<IPLDAO> comparing = Comparator.comparing(census -> census.batAverage);
        this.sortingMap.put(SortingFields.BAT_AVERAGE, comparing.thenComparing(census -> census.batStrikeRate));
        Comparator<IPLDAO> comparing1 = Comparator.comparing(census -> census.batRuns);
        this.sortingMap.put(SortingFields.BALL_STRIKE_RATE, Comparator.comparing(census -> census.ballStrikeRate));
        this.sortingMap.put(SortingFields.RUNS, comparing1.thenComparing(census -> census.batAverage));
        this.sortingMap.put(SortingFields.BALL_AVERAGE, comparing1.thenComparing(census -> census.ballAverage));
        this.sortingMap.put(SortingFields.WICKETS_FIVES_FOURES, new WicketsComparator());
        Comparator<IPLDAO> comparing2 = Comparator.comparing(census -> census.ballStrikeRate);
        this.sortingMap.put(SortingFields.BALL_STRIKE_RATE_WITH_WICKETS, comparing2.thenComparing(new WicketsComparator()));
        this.sortingMap.put(SortingFields.AVERAGE_WITH_STRIKE_RATE, comparing1.thenComparing(census -> census.ballAverage));
        this.sortingMap.put(SortingFields.WICKETS, Comparator.comparing(census -> census.wickets));
        Comparator<IPLDAO> comparing3 = Comparator.comparing(census -> census.wickets);
        this.sortingMap.put(SortingFields.MAX_WICKET_AVERAGE, comparing3.thenComparing(census -> census.ballAverage).reversed());

        Comparator<IPLDAO> comparing4 = Comparator.comparing(census -> census.batAverage);
        this.sortingMap.put(SortingFields.BEST_BALL_BAT, comparing4.thenComparing(census -> census.ballAverage).reversed());
        Comparator<IPLDAO> comparing5 = Comparator.comparing(census -> census.wickets);
        this.sortingMap.put(SortingFields.ALL_ROUNDER, comparing5.thenComparing(census -> census.batRuns));
    }


    public Map<String, IPLDAO> loadCricketerData(String filePath, cricketerTypes type) throws IPLAnalyserException {
        IplAdapter iplAdapter = (IplAdapter) this.adapter.loadIplCricketData(filePath);
        iplMostRunWicketsCsvs = iplAdapter.loadIplCricketData(filePath);
        return iplMostRunWicketsCsvs;
    }

    public List<IPLDAO> sortedPlayersData(SortingFields fieldName) {
        List<IPLDAO> sortedPlayer = iplMostRunWicketsCsvs.values().stream()
                .sorted(sortingMap.get(fieldName).reversed())
                .collect(Collectors.toList());
        return sortedPlayer;
    }

    public List<IPLDAO> mergeAndSort(Map<String, IPLDAO> batsmanData, Map<String, IPLDAO> bowlerData, SortingFields fieldName) {
        for (Map.Entry<String, IPLDAO> entry : batsmanData.entrySet()
        ) {
            for (Map.Entry<String, IPLDAO> entry1 : bowlerData.entrySet()
            )
                if (entry.getKey().equals(entry1.getKey())) {
                    allRounderMap.put(entry.getKey(), new IPLDAO(entry.getValue()
                            .player, entry.getValue()
                            .batAverage, entry.getValue().ballAverage));
                }
        }

        List<IPLDAO> sortedPlayer = allRounderMap.values().stream()
                .sorted(sortingMap.get(fieldName).reversed())
                .collect(Collectors.toList());
        return sortedPlayer;
    }

    public IPLDAO allRounder(List<IPLDAO> batsmanData, List<IPLDAO> bowlerData) {
        for (IPLDAO batsman : batsmanData) {
            for (IPLDAO bowler : bowlerData) {
                if (batsman.player.trim().equals(bowler.player.trim())) {
                    return batsman;
                }
            }
        }
        return null;
    }
}
