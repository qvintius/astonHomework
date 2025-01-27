package homework2;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.equals(o2) ? 0 : -1;
    }
}
