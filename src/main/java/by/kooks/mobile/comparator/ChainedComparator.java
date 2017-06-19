package by.kooks.mobile.comparator;

import java.util.Comparator;

public class ChainedComparator<T> {

    public Comparator<T> getChain(Comparator<T>...comparators) {
        Comparator<T> comparator = null;
        if (comparators.length > 0) {
            comparator = comparators[0];
        }
        for (Comparator<T> comparator1 : comparators) {
            if (comparator != null) {
                comparator = comparator.thenComparing(comparator1);
            }
        }
        return comparator;
    }
}