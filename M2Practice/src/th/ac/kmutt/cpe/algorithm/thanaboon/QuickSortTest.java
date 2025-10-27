package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;

public class QuickSortTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        SortContext<Integer> sorter = new SortContext<>(new QuickSort<Integer>());
        sorter.executeSort(arr);
        for(int i = 0 ; i < n ;i++){
            System.out.printf("%d ",arr.get(i));
        }
        sc.close();  
    }
}