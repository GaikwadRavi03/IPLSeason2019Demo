package cricketenthusiast;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsCsv {

    @CsvBindByName(column = "PLAYER")
    private String player;

    @CsvBindByName(column = "Mat")
    private String matches;

    @CsvBindByName(column = "Inns")
    private String innings;

    @CsvBindByName(column = "Ov")
    private String overs;

    @CsvBindByName(column = "Runs")
    private String runs;

    @CsvBindByName(column = "Wkts")
    private String wickets;

    @CsvBindByName(column = "BBI")
    private String bbi;

    @CsvBindByName(column = "Avg")
    private String average;

    @CsvBindByName(column = "Econ")
    private String economy;

    @CsvBindByName(column = "SR")
    private String strikeRate;

    @CsvBindByName(column = "4w")
    private String w4;

    @CsvBindByName(column = "5w")
    private String w5;
}
