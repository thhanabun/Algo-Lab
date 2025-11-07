package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;

public class TopDownMerge<T extends Comparable<T>> implements SortStrategy<T>{
    public void sort(ArrayList<T> list){
        mergeSort(list, 0, list.size());
    }

    public void mergeSort(ArrayList<T> list,int l,int r){
        if(r-l > 1){
            int mid = (l+r)/2; 
            mergeSort(list, l, mid-1);
            mergeSort(list, mid, r);
            merge(list, l, mid, r);
        }
    }

    public void merge(ArrayList<T> list,int st, int mid ,int ed){
        int i = st;
        int j = mid;
        ArrayList<T> temp = new ArrayList<>();

        while(i < mid && j < ed){
            if(list.get(i).compareTo(list.get(j)) < 0){
                temp.add(list.get(i));
                i++;
            }else{
                temp.add(list.get(j));
                j++;
            }
        }

        while(i < mid){
            temp.add(list.get(i));
            i++;
        }

        while(j < ed){
            temp.add(list.get(j));
            j++;
        }

        for (int k = st; k < ed; k++) {
            list.set(k, temp.get(k-st));
        }
    }
}
