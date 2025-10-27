package th.ac.kmutt.cpe.algorithm.thanaboon.searching;

import java.util.ArrayList;

public class StringSearch<T extends Comparable<T>> implements SearchStrategy<T,Integer> {
    public Integer search(ArrayList<T> list, T target){
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).equals(target)){
                return i;
            }
        }
        return -1;
    }
}
