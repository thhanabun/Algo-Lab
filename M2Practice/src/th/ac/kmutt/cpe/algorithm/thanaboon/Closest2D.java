package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;

public class Closest2D {
    
    public static double findDis(Point p1,Point p2){
        double xdis = p1.x - p2.x;
        double ydis = p1.y - p2.y; 
        double dis = Math.sqrt((ydis*ydis)+(xdis*xdis)); 
        return dis;
    }

    public static double closestSolve(ArrayList<Point> arr,int l,int r){
        if(l == r){
            return Integer.MAX_VALUE;
        }
        if(l == r-1){
            return findDis(arr.get(l), arr.get(r));
        }
        double middle = (arr.get(l).x + arr.get(r).x)/2;
        int m=-1;
        for (int i = 0; i < arr.size() ; i++) {
            if(arr.get(i).x > middle){
                m = i;
                break;
            }
        }
        double closestL = closestSolve(arr, l, m-1);
        double closestR = closestSolve(arr, m, r);
        double closest = Math.min(closestL, closestR);
        ArrayList<Point> midArr1 = new ArrayList<>();
        ArrayList<Point> midArr2 = new ArrayList<>();
        for (int i = m-1; i >= l; i--) {
            if(middle - arr.get(i).x <= closest){
                midArr1.add(arr.get(i));
            }else{
                break;
            }
        }

        for (int j = m; j <= r; j++) {
            if(arr.get(j).x - middle <= closest){
                midArr2.add(arr.get(j));
            }else{
                break;
            }
        }
        for (int i = 0; i < midArr1.size() ; i++) {
            for (int j = 0; j < midArr2.size(); j++) {
                closest = Math.min(closest, findDis(midArr1.get(i), midArr2.get(j)));
            }
        }
        return closest;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        SortContext<Point> sorter = new SortContext<>(new QuickSort<Point>());
        for (int i = 0; i < n; i++) {
            double x = sc.nextInt();
            double y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        sorter.executeSort(arr);
        
        System.out.printf("%.3f",closestSolve(arr, 0, n-1));
        sc.close();
    }
}