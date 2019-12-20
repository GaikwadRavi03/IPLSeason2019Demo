package cricketenthusiast;

public class IplAdapterFactory extends IPLAnalyser {
    protected static IplAdapter getIplObject(IPLAnalyser.cricketerTypes type) throws IPLAnalyserException {
        if (type.equals(IPLAnalyser.cricketerTypes.BATSMAN)) {
            return new IplBatsmanAdapter();
        }
        if (type.equals(IPLAnalyser.cricketerTypes.BOWLER)) {
            return new IplBowlerAdapter();
        }
        throw new IPLAnalyserException("Unkonwn player type", IPLAnalyserException.ExceptionType.UNKNOWN_PLAYER);
    }
}
