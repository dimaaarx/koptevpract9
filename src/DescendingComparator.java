import java.util.Comparator;

public class DescendingComparator implements Comparator<MyNumber> {
    @Override
    public int compare(MyNumber a, MyNumber b) {
        return b.getValue() - a.getValue();
    }
}
