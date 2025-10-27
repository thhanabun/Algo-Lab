package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.Scanner;

public class EODReturn {
    public static int solve(int[]arr,int []dp,int i){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i]==-1){
            dp[i] = Math.max(solve(arr, dp, i+arr[i]+1)+arr[i]+1, solve(arr, dp,i+1));
        }
        return dp[i];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int [] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr,dp,0));
        sc.close();
    }
}
