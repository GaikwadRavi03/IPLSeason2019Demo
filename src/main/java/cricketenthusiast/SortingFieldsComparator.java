package cricketenthusiast;

import java.util.Comparator;

public class SortingFieldsComparator implements Comparator<IPLDAO> {
    @Override
    public int compare(IPLDAO obj1, IPLDAO obj2) {
        return ((obj1.sixes * 6) + (obj1.fours * 4)) - ((obj2.sixes * 6) + (obj2.fours * 4));
    }
}
