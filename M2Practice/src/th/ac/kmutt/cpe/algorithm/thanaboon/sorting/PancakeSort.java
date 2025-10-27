package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class PancakeSort<T extends Comparable<T>> implements SortStrategy<T> {
    public void sort(ArrayList<T> arr){
        for (int i = arr.size()-1; i >= 0 ; i--) {
            int mxIdx = i;
            T mx = arr.get(i);
            for(int j=0; j < i ; j++){
                T temp = arr.get(j);
                if(temp.compareTo(mx)>0){
                    mxIdx = j;
                    mx = temp; 
                }
            }
            if(mxIdx == i){
                continue;
            }else{
                reverse(arr, mxIdx);
                reverse(arr, i);
            }
        }
    }

    public void reverse(ArrayList<T> arr , int ed){
        int st=0;
        while(st < ed){
            Collections.swap(arr, st, ed);
            st++;
            ed--;
        }
    }
}
