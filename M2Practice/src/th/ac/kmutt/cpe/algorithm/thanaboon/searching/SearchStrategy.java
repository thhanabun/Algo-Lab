package th.ac.kmutt.cpe.algorithm.thanaboon.searching;

import java.util.ArrayList;
public interface SearchStrategy<T extends Comparable<T>,R> {
    public R search(ArrayList<T> list ,T target);
}
