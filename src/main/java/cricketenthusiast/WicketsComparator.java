package cricketenthusiast;

public class WicketsComparator implements java.util.Comparator<IPLDAO> {
    @Override

    public int compare(IPLDAO obj1, IPLDAO obj2) {
        return ((obj1.fiveWickets) + (obj1.fourWickets)) - ((obj2.fiveWickets) + (obj2.fourWickets));
    }
}
