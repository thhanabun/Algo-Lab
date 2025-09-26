package th.ac.kmutt.cpe.algorithm.thanaboon.fee;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.fee.resource.reader.CSVReader;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.boxSort;

public class Lab06 {
    public static void solve(ArrayList<MyBox> data,ArrayList<Integer> used,double x1,double x2,double y1,double y2){
        if(used.size() == data.size()){
            return ;
        }
        else{
            double curL = x2-x1;
            double curH = y2-y1;
            for(int i=0 ; i< data.size() ; i++){
                if(!used.contains(i) && data.get(i).H <= curH && data.get(i).L <= curL){
                    used.add(i);
                    solve(data, used, x1+data.get(i).L, x2, y1, data.get(i).H);
                    solve(data, used, x1, x2, y1+data.get(i).H, y2);
                    break;
                }
            }
            return ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Box sixe file 1-3");
        int type = sc.nextInt();
        CSVReader reader = new CSVReader();
        ArrayList<MyBox> data = reader.read(type); 
        SortContext<MyBox> sorter = new SortContext<>(new boxSort<>());
        sorter.executeSort(data);
        //L is first column H is Second Column
        for(int i=0;i<data.size();i++){
            System.out.println(i+": " + data.get(i).L + " " + data.get(i).H);
        }
        ArrayList<Integer> used = new ArrayList<>();
        System.out.println("Enter Container length and height");
        double length = sc.nextDouble();
        double height = sc.nextDouble();
        solve(data, used, 0, length, 0, height);
        if(used.size() != data.size()){
            System.out.println("not used box");
        }
        else{
            System.out.println("used all box");
        }
        double usedArea = 0;
        for(int i =0;i<data.size();i++){
            if(!used.contains(i)){
                System.out.println( i + ": " +data.get(i).L + " " +data.get(i).H);
            }
            else{
                usedArea += data.get(i).H * data.get(i).L;
            }
        }
        System.out.println("Remain Area is " + (length*height - usedArea));
        System.out.println("Box insert order" + used);
        sc.close();
    }
}
