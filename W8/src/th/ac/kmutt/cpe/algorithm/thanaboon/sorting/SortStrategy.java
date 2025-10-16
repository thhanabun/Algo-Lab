package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;
public interface SortStrategy<T extends Comparable<T>> {
    public void sort(ArrayList<T> list);
}
