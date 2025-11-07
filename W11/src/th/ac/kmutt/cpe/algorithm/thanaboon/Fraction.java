package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.Scanner;

public class Fraction {

    public static void toEgyptian(int numerator,int denominator){
        long nume = numerator;
        long deno = denominator;
        while(true){
            if(nume > deno){
                System.out.printf("%d + ",nume/deno);
                nume = nume%deno;
            }
            else if(deno % nume == 0){
                System.out.printf("1/%d",deno/nume);
                break;
            }else{
                long n = deno/nume +1 ;
                System.out.printf("1/%d + ",n);
                nume = nume*n - deno;
                deno = deno*n;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nume = sc.nextInt();
        int deno = sc.nextInt();
        toEgyptian(nume, deno);
        sc.close(); 
    }
}
