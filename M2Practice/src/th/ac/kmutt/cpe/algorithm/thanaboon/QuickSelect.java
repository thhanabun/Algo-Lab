package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuickSelect {

    public static int QuickSelectSolve(ArrayList<Integer> arr,int k){
        int st = 0,ed = arr.size()-1 ;
        int pivot = LomutoPartition(arr,st,ed);
        while (pivot!=k) {
            if(pivot > k){
                ed = pivot-1;
                pivot = LomutoPartition(arr, st ,ed);
            }else if(pivot < k){
                st = pivot+1;
                pivot = LomutoPartition(arr, st, ed);
            }
        }
        return arr.get(pivot);
    }

    public static int QuickSelectSolve2(ArrayList<Integer> arr, int st,int ed ,int k){
        int pivot = LomutoPartition(arr, st, ed);
        if(pivot > k){
            return QuickSelectSolve2(arr, st ,pivot-1,k);
        }else if(pivot < k){
            return LomutoPartition(arr, pivot+1 , ed);
        }
        return arr.get(pivot);
    }

    public static int LomutoPartition(ArrayList<Integer> arr,int st,int pivot){
        int i;
        for (i=st ; i < pivot ; i++) {
            if(arr.get(i) < arr.get(pivot)){
                continue;
            }
            boolean canSwap = false;
            for (int j = i+1; j < pivot; j++) {
                if(arr.get(j) <= arr.get(pivot)){
                    canSwap = true;
                    Collections.swap(arr, i, j);
                    break;
                }
            }
            if(!canSwap){
                break;
            }
        }
        Collections.swap(arr, i , pivot);
        return i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(QuickSelectSolve(arr,k-1));
        System.out.println(QuickSelectSolve2(arr,0,n-1,k-1));
        sc.close();
    }    
}
