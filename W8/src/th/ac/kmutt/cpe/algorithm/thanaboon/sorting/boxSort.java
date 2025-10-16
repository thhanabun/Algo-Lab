package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;
import java.util.Collections;

import th.ac.kmutt.cpe.algorithm.thanaboon.fee.MyBox;

public class boxSort<T extends Comparable<T>> implements SortStrategy<MyBox> {
    public void sort(ArrayList<MyBox> list){
        for(int i=0;i<list.size()-1;i++){
            int mx = i;
            for(int j=i;j<list.size();j++){
                if(list.get(mx).compareTo(list.get(j)) < 0){
                    mx =j;
                }
            }
            Collections.swap(list, i, mx);
        }
        return;
    }
}
