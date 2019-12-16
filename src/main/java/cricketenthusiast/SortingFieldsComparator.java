package cricketenthusiast;

import java.util.Comparator;

public class SortingFieldsComparator implements Comparator<IPLMostRunCsv> {
    @Override
    public int compare(IPLMostRunCsv obj1, IPLMostRunCsv obj2) {
        return ((obj1.sixes * 6) + (obj1.fours * 4)) - ((obj2.sixes * 6) + (obj2.fours * 4));
    }
}
