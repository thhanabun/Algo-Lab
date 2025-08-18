import java.util.Scanner;

public class Combo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[] = new int[n]; 
        for(int i=0 ; i<n;i++){
            arr1[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int arr2[] = new int[k];
        for(int i=0; i<k ;i++){
            arr2[i] = sc.nextInt();
        }
        int F = fact(n-1);
        int ans = (n-k)*F*F;
        System.out.println(ans);
        sc.close();
    }

    static int fact(int n){
        if(n==0){
            return 1;
        }
        return n  * fact(n-1);
    }
}
