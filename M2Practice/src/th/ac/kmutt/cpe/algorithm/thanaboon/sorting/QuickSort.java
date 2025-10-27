package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort<T extends Comparable<T>> implements SortStrategy<T>{
    public void sort(ArrayList<T> list){
        QS(list, 0, list.size()-1 );
    }

    public void QS(ArrayList<T> list ,int l ,int r){
        if(l < r){
            int s = HoraePartition(list, l, r);
            QS(list, l, s-1);
            QS(list, s+1, r);
        }
    }

    public int HoraePartition(ArrayList<T> list , int l,int r){
        T p = list.get(l);
        int i = l;
        int j = r+1;
        while (true) {
            do{
            i++;
            }while(i < r &&  list.get(i).compareTo(p) < 0);
            do{
                j--;
            }while(j > l && list.get(j).compareTo(p) > 0);
            if(i>=j){
                break;
            }
            Collections.swap(list, i, j);
        }
        Collections.swap(list, l, j);
        return j ; 
    }
}
