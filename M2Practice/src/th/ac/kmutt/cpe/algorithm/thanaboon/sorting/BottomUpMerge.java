package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;

public class BottomUpMerge<T extends Comparable<T>> implements SortStrategy<T>{
    
    public void sort(ArrayList<T> list) {
        int n = list.size();
        if(n < 2){
            return;
        }
        int i=1;
        while(i < n){
            int j = 0;
            while(j < n - i){
                if(n < j + ( 2 * i)){
                    merge(list,j,j+i,n);
                }
                else{
                    merge(list,j,j+i,j+(2*i));
                }
                j += (2*i);
            }
            i *= 2 ;
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
