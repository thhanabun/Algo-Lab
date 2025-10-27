package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;

public class Closest2D {
    
    public static int closestSolve(){
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        SortContext<Point> sorter = new SortContext<>(new QuickSort<Point>());
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        sorter.executeSort(arr);
        
        sc.close();
    }
}