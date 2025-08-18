import java.util.Scanner;

public class BombLoop{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+arr[i]+1;j<n;j++){
                for(int k=j+arr[j]+1;k<n;k++){
                    for(int l=k+arr[k]+1;l<n;l++){
                        ans = Math.max(ans, arr[i]+arr[j]+arr[k]+arr[l]+4);
                    }
                    ans = Math.max(ans, arr[i]+arr[j]+arr[k]+3);
                }
            }
        }
        System.out.println(ans);
        sc.close();      
    }
}