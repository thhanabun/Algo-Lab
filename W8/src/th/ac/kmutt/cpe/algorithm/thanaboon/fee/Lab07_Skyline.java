package th.ac.kmutt.cpe.algorithm.thanaboon.fee;
import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.fee.resource.reader.CSVReader;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.boxSort;

public class Lab07_Skyline {
    public static void SkylineSolve(ArrayList<MyBox> data,ArrayList<Integer> used  , double x ,double y){
        int floored = (int) Math.ceil(x);
        double[] skylines = new double[floored];
        for(int i=0 ; i < data.size(); i++){
            MyBox box = data.get(i);
            int boxL = (int) Math.ceil(box.L);
            int boxH = (int) Math.ceil(box.H);
            for (int j=0; j < floored - boxL ; j++) {
                double maxHeight = 0;
                for (int k = j; k < j + boxL; k++) {
                    if (skylines[k] > maxHeight) {
                        maxHeight = skylines[k];
                    }
                }
                if (maxHeight + boxH <= y) {
                    used.add(i);
                    for (int k = j; k < j + boxL; k++) {
                        skylines[k] = maxHeight + boxH;
                    }
                    break;
                }
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
        for(int i=0;i<data.size();i++){
            System.out.println(i+": " + data.get(i).L + " " + data.get(i).H);
        }
        ArrayList<Integer> used = new ArrayList<>();
        System.out.println("Enter Container length and height");
        double length = sc.nextDouble();
        double height = sc.nextDouble();
        SkylineSolve(data, used,length,height);
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
