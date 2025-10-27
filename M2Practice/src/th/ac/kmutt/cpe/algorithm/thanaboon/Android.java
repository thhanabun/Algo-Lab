package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.searching.SearchContext;
import th.ac.kmutt.cpe.algorithm.thanaboon.searching.StringSearch;

public class Android {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int s =  sc.nextInt();
        int n = sc .nextInt();
        String str = alphabet.substring(0,s);
        System.out.println(str);
        LexicoOrder solver = new LexicoOrder(str);
        ArrayList<String> order = solver.permute();
        SearchContext<String,Integer> searcher = new SearchContext<>(new StringSearch<String>());
        for (int i = 0; i < n; i++) {
            String Q = sc.next();
            System.out.println(searcher.executeSearch(order, Q)+1);
        }
        sc.close();
    }
}
