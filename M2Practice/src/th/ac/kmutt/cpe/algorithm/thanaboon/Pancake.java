package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.PancakeSort;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;

public class Pancake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr.add(num);
        }
        SortContext<Integer> sorter = new SortContext<>(new PancakeSort<Integer>());
        sorter.executeSort(arr);
        
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("%d ",arr.get(i));   
        }

        sc.close();
    }
}
