package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

public class JohnsonTrotterTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        JohnsonTrotter solver = new JohnsonTrotter();
        ArrayList<ArrayList<Integer>> order = solver.permute(list);
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }       
        sc.close();
    }
}
