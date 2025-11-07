package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

public class TestTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0 ; i<n ;i++){
            for (int j = 0; j < r; j++) {
                if(j == 0){
                    arr.add(new ArrayList<>());
                }
                arr.get(i).add(sc.nextInt());
            }
        }
        BinarySearch2D<Integer> searcher = new BinarySearch2D<>();
        int x = searcher.search(arr, 9);
        System.out.println(x);
        sc.close();
    }
}
