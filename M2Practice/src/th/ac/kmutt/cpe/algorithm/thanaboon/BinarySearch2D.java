package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;

public class BinarySearch2D<T extends Comparable<T>> {

    public BinarySearch2D(){
    }
    
    public int search(ArrayList<ArrayList<T>> list2d,T target){
        int R = list2d.size()*list2d.get(0).size();
        return searchRecursion(list2d ,0, R-1 ,target );
    }

    public int searchRecursion(ArrayList<ArrayList<T>>list2d,int l,int r, T k){
        if(l > r){
            return -1;
        }
        int mid = (l + r) / 2;
        int numrow = list2d.get(0).size();
        int col = mid%numrow;
        int row = mid/numrow;
        int temp = list2d.get(row).get(col).compareTo(k);
        if(temp == 0){
            return mid;
        }else if(temp < 0){
            return searchRecursion(list2d, mid+1, r, k);
        }else{
            return searchRecursion(list2d, l, mid-1, k);
        }
    }
}
