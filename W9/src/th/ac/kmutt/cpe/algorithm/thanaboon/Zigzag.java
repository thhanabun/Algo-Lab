package th.ac.kmutt.cpe.algorithm.thanaboon;
import java.util.Scanner;

public class Zigzag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] num = new int[n];
        for(int i=0 ;i<n;i++){
            num[i] = sc.nextInt();
        }
        int [][] dp = new int[2][n]; 
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i=1 ;i<n ;i++){
            int despos=-1;
            int ascpos=-1;
            for(int j=i-1;j>=0;j--){
                if(despos !=-1 && ascpos!=-1){
                    break;
                }
                if(despos == -1 && num[i]<num[j]){
                    despos = j;
                }
                else if(ascpos== -1 && num[i]>num[j]){
                    ascpos = j;
                }
            }
            System.out.println(despos +" " +ascpos);
            if(despos!=-1 ){
                dp[1][i] = dp[0][despos]+1;
            }else{
                dp[1][i] = 1;
            }
            if(ascpos!= -1){
                dp[0][i] = dp[1][ascpos]+1;
            }else{
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.printf("%d ",dp[i][j]);
            }
            System.out.println();
        }
        sc.close();       
    }
}