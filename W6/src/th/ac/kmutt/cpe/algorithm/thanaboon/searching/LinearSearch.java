package th.ac.kmutt.cpe.algorithm.thanaboon.searching;

import java.util.ArrayList;

public class LinearSearch<T extends Comparable<T>> implements SearchStrategy<T,Integer>{
    public Integer search(ArrayList<T> list, T target) {
        int size = list.size();
        for(int i=0 ; i<size ; i++){
            if(list.get(i) == target){
                return i; 
            }
        }
        return -1;
    }
}
