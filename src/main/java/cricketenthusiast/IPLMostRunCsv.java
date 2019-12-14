package cricketenthusiast;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunCsv {

    @CsvBindByName(column = "PLAYER")
    private String player;

    @CsvBindByName(column = "Mat")
    private String matches;

    @CsvBindByName(column = "Inns")
    private String innings;

    @CsvBindByName(column = "NO")
    private String notOut;

    @CsvBindByName(column = "Runs")
    private String runs;

    @CsvBindByName(column = "HS")
    private String highestScore;

    @CsvBindByName(column = "Avg")
    private String average;

    @CsvBindByName(column = "BF")
    private String ballPhase;

    @CsvBindByName(column = "SR")
    private String strikeRate;

    @CsvBindByName(column = "100")
    private String century;

    @CsvBindByName(column = "50")
    private String halfCentury;

    @CsvBindByName(column = "6s")
    private String sixes;

    @CsvBindByName(column = "4s")
    private String fours;

}
