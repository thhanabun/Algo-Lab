package th.ac.kmutt.cpe.algorithm.thanaboon.fee;
import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.fee.resource.reader.CSVReader;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.boxSort;

public class Lab07_BFDH {
    public static double sumH(ArrayList<Double> levelH){
        double sum = 0;
        for (Double h : levelH) {
            sum+= h;
        }
        return sum;
    }
    public static void BFDHsolve(ArrayList<MyBox> data,ArrayList<Integer> used,double x,double y){
        ArrayList<Double> levelH= new ArrayList<>();
        ArrayList<Double> levelW = new ArrayList<>();
        for(int i=0;i<data.size();i++){
            if(used.contains(i)){
                continue;
            }
            MyBox curbox = data.get(i);
            for(int j=0;j<levelW.size();j++){
                if(levelW.get(j) + curbox.L <= x && curbox.H <= levelH.get(j)){
                    System.err.println("add " + i + "th box to level " + j );
                    levelW.set(j, levelW.get(j)+ curbox.L);
                    used.add(i);
                    break;
                }
            }
            if(!used.contains(i) && curbox.H + sumH(levelH) <= y){
                levelW.add(curbox.L);
                levelH.add(curbox.H);
                System.out.println("create new level " + i + " th box with height " + curbox.H + " total height " + sumH(levelH));
                used.add(i);
            }
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
        System.out.println("All box after sort");
        for(int i=0;i<data.size();i++){
            System.out.println(i+": " + data.get(i).L + " " + data.get(i).H);
        }
        ArrayList<Integer> used = new ArrayList<>();
        System.out.println("Enter Container length and height");
        double length = sc.nextDouble();
        double height = sc.nextDouble();
        BFDHsolve(data, used,length,height);
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
