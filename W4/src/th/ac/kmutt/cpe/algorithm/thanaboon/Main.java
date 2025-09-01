package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.searching.MultipleLinearSearch;
import th.ac.kmutt.cpe.algorithm.thanaboon.searching.SearchContext;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<Character> charList = new ArrayList<>();
        for(int i=0;i< str.length() ;i++){
            charList.add(str.charAt(i));
        }
        // System.out.println(charList);
        char st = sc.next().charAt(0);
        char end = sc.next().charAt(0);
        int minlength = sc.nextInt();
        int size = str.length();
        ArrayList<Integer> stArr = new ArrayList<>();
        int cnt = 0;
        for(int i=0;i<size;i++){
            if( str.charAt(i) == st){
                cnt++;
            }
            stArr.add(cnt);
        }
        SearchContext<Character,ArrayList<Integer>> solver = new SearchContext<>(new MultipleLinearSearch<Character>());
        ArrayList<Integer> edArr = solver.executeSearch(charList, end);
        // System.out.println(edArr); 
        int ans = 0;
        for (Integer edIdx : edArr) { 
            if(edIdx-minlength+1 >= 0){
                ans+=stArr.get(edIdx-minlength+1);
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
