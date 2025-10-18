package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.Scanner;

public class EODReturn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int [] dp = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        dp[0]=0;
        for(int i=1 ; i<=n ; i++){
            int exp = arr[i-1]+1;
            for (int j = i+exp; j < dp.length; j++) {
                    dp[j] = Math.max(dp[j], dp[i]+exp);
            }
            dp[i] = Math.max(dp[i-1], dp[i] + exp);
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
