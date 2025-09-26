package th.ac.kmutt.cpe.algorithm.thanaboon.searching;

import java.util.ArrayList;

public class MultipleLinearSearch<T extends Comparable<T>> implements SearchStrategy<T,ArrayList<Integer>> {
    public ArrayList<Integer> search(ArrayList<T> list, T target){
        ArrayList<Integer> TarArr = new ArrayList<>();
        for(int i=0; i<list.size();i++){
            if(list.get(i) == target){
                TarArr.add(i);
            }
        }
        return TarArr;
    }
}
