package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;

public class PresortUnique {
    
    public static void solve(ArrayList<Integer> arr){
        SortContext<Integer> sorter = new SortContext<>(new QuickSort<Integer>());
        sorter.executeSort(arr);
        for (int i = 0; i < arr.size() ; i++) {
            if(i > 0 ){
                int cur = arr.get(i);
                int prev = arr.get(i-1);
                if(cur != prev){ //not duplicate
                    System.out.printf("%d ",cur);
                }
            }else{
                System.out.printf("%d " , arr.get(i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        solve(arr);
        sc.close();
    }
}
