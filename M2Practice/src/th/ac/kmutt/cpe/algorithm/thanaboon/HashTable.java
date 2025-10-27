package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

public class HashTable {

    public static int calculateIdx(String S){
        int score = 0;
        for (int i = 0; i < S.length(); i++) {
            score += S.charAt(i)-'A'+1;
        }
        return score;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        ArrayList<String> hash = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            hash.add("");
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int Idx = calculateIdx(str) % s;
            for (int j = Idx; j < Idx + s ; j++) {
                if(hash.get(j).equals("")){
                    hash.set(j%s, str);
                    break;
                }
            } 
        }
        for (int i = 0; i < hash.size(); i++) {
            String temp = hash.get(i);
            if(temp.equals("")){
                System.out.printf("NULL ");
            }else{
                System.out.printf("%s ",temp);
            }

        }
        sc.close();
    }

}
