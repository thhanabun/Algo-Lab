import java.util.*;
public class BombRec{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = solve(0,arr,n,0,0); 
        System.out.println(ans);
    }

    static int solve(int cur,int arr[],int n,int score,int k){
        if(k>4 || cur>=n){
            return score;
        }
        return Math.max(solve(cur+1, arr, n, score, k), solve(cur+arr[cur]+1, arr, n, score+arr[cur]+1, k+1));
    }
}