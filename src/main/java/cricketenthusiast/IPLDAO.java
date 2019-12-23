package cricketenthusiast;

public class IPLDAO {

    public double batAverage;
    public double ballAverage;
    public int position;
    public String player;
    public int matches;
    public int innings;
    public double notOut;
    public double runs;
    public int highestScore;
    public int ballPhase;
    public double ballStrikeRate;
    public double batStrikeRate;
    public int century;
    public int halfCentury;
    public int sixes;
    public int fours;
    public int bestBowlingIn;
    public int fourWickets;
    public int fiveWickets;
    public double overs;
    public double economy;
    public int wickets;

    public IPLDAO() {
    }

    public IPLDAO( String player,double batAverage, double ballAverage) {
        this.batAverage = batAverage;
        this.ballAverage = ballAverage;
        this.player = player;
    }

    public IPLDAO(IPLBatsmanCsv iplBatsmanCsv) {
        position = iplBatsmanCsv.position;
        player = iplBatsmanCsv.player;
        matches = iplBatsmanCsv.matches;
        innings = iplBatsmanCsv.innings;
        notOut = iplBatsmanCsv.notOut;
        runs = iplBatsmanCsv.runs;
        highestScore = iplBatsmanCsv.highestScore;
        batAverage = iplBatsmanCsv.batAverage;
        ballPhase = iplBatsmanCsv.ballPhase;
        batStrikeRate = iplBatsmanCsv.batStrikeRate;
        century = iplBatsmanCsv.century;
        halfCentury = iplBatsmanCsv.halfCentury;
        sixes = iplBatsmanCsv.sixes;
        fours = iplBatsmanCsv.fours;
    }

    public IPLDAO(IPLBowlerCsv iplBowlerCsv) {
        player = iplBowlerCsv.player;
        matches = iplBowlerCsv.matches;
        innings = iplBowlerCsv.innings;
        overs = iplBowlerCsv.overs;
        runs = iplBowlerCsv.runs;
        wickets = iplBowlerCsv.wickets;
        bestBowlingIn = iplBowlerCsv.bestBowlingIn;
        ballAverage = iplBowlerCsv.ballAverage;
        economy = iplBowlerCsv.economy;
        ballStrikeRate = iplBowlerCsv.ballStrikeRate;
        fourWickets = iplBowlerCsv.fourWickets;
        fiveWickets = iplBowlerCsv.fiveWickets;
    }
}
