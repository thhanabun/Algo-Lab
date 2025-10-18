package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

public class Jaothi {
    
    public static int solve(ArrayList<Brand> arr,int T,int n,int [][] dp){
        if(n < 0){
            return  0;
        }
        if(dp[T][n] < 0){
            if(T < arr.get(n).t){
                dp[T][n] = solve(arr, T, n-1, dp);
            }
            else{
                dp[T][n] = Math.max(solve(arr, T - arr.get(n).t , n-1,dp) + arr.get(n).v, solve(arr, T, n-1,dp));

            }
        }
        return dp[T][n];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        ArrayList<Brand> arr= new ArrayList<>();
        for(int i=0 ;i < n;i++){
            int t = sc.nextInt();
            int v = sc.nextInt();
            Brand b = new Brand(t, v);
            arr.add(b);
        }
        int [][] dp = new int[T+1][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = solve(arr,T,n-1,dp); 
        System.out.println(ans);
        sc.close();
    }
}
