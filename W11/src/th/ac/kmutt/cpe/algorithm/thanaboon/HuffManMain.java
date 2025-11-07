package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Scanner;

public class HuffManMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HuffManTree tree = new HuffManTree();
        String str = sc.next();
        tree.buildTree(str);
        tree.encode("", tree.root);

        //print Encoded tree
        for (String string : tree.encodedMap.keySet()) {
            System.out.println(string + " " +tree.decode(string));
        }

        String str2 = sc.next();
        //Encoding New Str
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < str2.length(); i++) {
            arr.add(tree.encodeCh(str.charAt(i)));
            System.out.printf("%s",tree.encodeCh(str.charAt(i)));
        }
        System.out.println();
        //Decoding Encoded new Str
        for (int i = 0; i < arr.size() ; i++) {
            System.out.printf("%c",tree.decode(arr.get(i)));
        }
        sc.close(); 
    }
}
