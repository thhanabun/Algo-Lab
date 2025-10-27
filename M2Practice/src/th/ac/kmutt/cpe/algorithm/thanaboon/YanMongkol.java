package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

public class YanMongkol {

        public static int maxCrossingSum(ArrayList<Integer> arr, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += arr.get(i);
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr.get(i);
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
    
    public static int solve(ArrayList<Integer> arr, int left, int right) {
        if (left == right) {
            return arr.get(left); // base case
        }

        int mid = (left + right) / 2;

        int leftMax = solve(arr, left, mid);
        int rightMax = solve(arr, mid + 1, right);
        int crossMax = maxCrossingSum(arr, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    public static void solver(ArrayList<Integer> arr){
        ArrayList<Integer> Sum = new ArrayList<>();
        boolean isMinus = false;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            if(i == 0){
                if(num < 0){
                    isMinus = true;
                    Sum.add(num);
                }else{
                    isMinus = false;
                    Sum.add(num);
                }
            }
            else if(num >= 0){
                if(!isMinus){
                    Sum.set(Sum.size()-1, Sum.getLast()+num);
                }else{
                    isMinus = false;
                    Sum.add(num);
                }
            }
            else{
                if(isMinus){
                    Sum.set(Sum.size()-1, Sum.getLast()+num);
                }else{
                    isMinus = true;
                    Sum.add(num);
                }
            }
        }
        System.out.println(Sum);
        System.out.println(solve(Sum, 0,Sum.size()-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }   
        solver(arr);
        // int curSub = arr.get(0);
        // int ans = arr.get(0);
        // for(int i=0; i<n ;i++){
        //     int num = arr.get(i);
        //     curSub = Math.max(num, curSub+num);
        //     ans = Math.max(ans, curSub); 
        // }
        // System.out.println(ans);
        sc.close();    
    }
}
