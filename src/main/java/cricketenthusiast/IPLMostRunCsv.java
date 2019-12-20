package cricketenthusiast;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunCsv extends IPLDAO {

    @CsvBindByName(column = "POS")
    public int position;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat")
    public int matches;

    @CsvBindByName(column = "Inns")
    public int innings;

    @CsvBindByName(column = "NO")
    public int notOut;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "HS")
    public int highestScore;

    @CsvBindByName(column = "Avg")
    public double average;

    @CsvBindByName(column = "BF")
    public int ballPhase;

    @CsvBindByName(column = "SR")
    public double batStrikeRate;

    @CsvBindByName(column = "100")
    public int century;

    @CsvBindByName(column = "50")
    public int halfCentury;

    @CsvBindByName(column = "6s")
    public int sixes;

    @CsvBindByName(column = "4s")
    public int fours;
}
