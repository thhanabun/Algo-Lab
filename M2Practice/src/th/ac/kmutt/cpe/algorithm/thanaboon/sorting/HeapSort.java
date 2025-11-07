package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;

public class HeapSort<T extends Comparable<T>> implements SortStrategy<T> {

    public void sort(ArrayList<T> list) {

    }

    public void heapify(ArrayList<T> list,int n){
        for(int i= n/2 ; i>= 1 ; i--){
            int k = i;
            T v = list.get(k-1);
            boolean isHeap = false;
            while(!isHeap && (2*k) <= n){
                int j = 2 * k;
                if(j < n){
                    if(list.get(j-1).compareTo(list.get(j)) > 0){
                        j++;
                    }
                }
                if(v.compareTo(list.get(j-1)) <  0){
                    isHeap = true;
                }else{
                    list.set(k-1, list.get(j-1));
                    k = j;
                }
                
            }
            list.set(k-1, v);
        }
    }
    
}
