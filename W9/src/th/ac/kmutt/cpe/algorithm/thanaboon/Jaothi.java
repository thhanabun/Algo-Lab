package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

public class Jaothi {
    
    public static int solve(ArrayList<Brand> arr,int T,int n){
        if(n < 1){
            return 0;
        }
        int nextT = T-arr.get(n-1).t;
        if(T == 0){
            return 0;
        }
        if(nextT < 0){
            return solve(arr, T, n-1);
        }
        return Math.max(solve(arr, nextT , n-1) + arr.get(n-1).v, solve(arr, T, n-1));
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
        int ans = solve(arr,T,n); 
        System.out.println(ans);
        sc.close();
    }
}
