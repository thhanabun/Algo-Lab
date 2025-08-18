import java.util.*;

public class WelcomeParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }

        for(int j=0;j<n;j++){
            arr2[j] = sc.nextInt();
        }
        System.out.println(Solve(arr1, arr2, n));
        sc.close();
    }

    static int Solve(int[] arr1,int[] arr2,int size){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int mn=Integer.MAX_VALUE ;
        int mx =Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            int height = arr1[i] + arr2[size-i-1];
            if(height < mn){
                mn = height;
            }
            if(height > mx){
                mx = height;
            }
        }
        return mx-mn;
    }

    static void PrintArr(int[] arr,int size){
        for(int i=0 ;i<size;i++ ){
            System.out.printf("%d ",arr[i]);
        }
        System.out.println();
        return;
    }
}