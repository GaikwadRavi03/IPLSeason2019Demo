package cricketenthusiast;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunCsv {

    @CsvBindByName(column = "POS")
    private int position;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat")
    private int matches;

    @CsvBindByName(column = "Inns")
    private int innings;

    @CsvBindByName(column = "NO")
    private int notOut;

    @CsvBindByName(column = "Runs")
    private int runs;

    @CsvBindByName(column = "HS")
    private String highestScore;

    @CsvBindByName(column = "Avg")
    public double average;

    @CsvBindByName(column = "BF")
    private int ballPhase;

    @CsvBindByName(column = "SR")
    private double strikeRate;

    @CsvBindByName(column = "100")
    private int century;

    @CsvBindByName(column = "50")
    private int halfCentury;

    @CsvBindByName(column = "6s")
    private int sixes;

    @CsvBindByName(column = "4s")
    private int fours;

    public double getAverage() {
        return average;
    }
}
