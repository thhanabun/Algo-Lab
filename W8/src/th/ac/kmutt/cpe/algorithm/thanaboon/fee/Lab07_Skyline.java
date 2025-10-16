package th.ac.kmutt.cpe.algorithm.thanaboon.fee;
import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.fee.resource.reader.CSVReader;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.boxSort;

public class Lab07_Skyline {
    public static void SkylineSolve(ArrayList<MyBox> data,ArrayList<Integer> used  , double x ,double y){
        
        int[] skylines = new int[Math.floor(x)];
        for(int i=0 ; i < data.size(); i++){
            for (MyBox skyline : skylines) {
                    if( data.get(i).L + skyline.L <= x && data.get(i).H + skyline.H <= y){
                        used.add(i);
                        skylines.add(new MyBox(skyline.L + data.get(i).L, skyline.H));
                        skylines.add(new MyBox(skyline.L, skyline.H + data.get(i).H));
                        skylines.remove(skyline);
                        updateSkylines(skylines);
                        break;
                    }
            }
        }    
    }

    public static void updateSkylines(ArrayList<MyBox> skylines){
        int size = skylines.size();
        MyBox last1 = skylines.get(size-2);
        MyBox last2 = skylines.get(size-1); 
        boolean rm1 = false,rm2 = false;
        for(int i=0 ; i< size -2 ;i++){
            MyBox cursky = skylines.get(i);
            if(cursky.L == last2.L && !rm2){
                if(cursky.H > last2.H){
                    skylines.remove(last2);
                    rm2 = true;
                }
                else{
                    skylines.remove(cursky);
                    break;
                }
            }
            if(cursky.H == last1.H && !rm1){
                if(cursky.H < last1.H){
                    skylines.remove(last1);
                    rm1 = true;
                }
                else{
                    skylines.remove(cursky);
                    break;
                }
            }
            else if(cursky.L < last1.L && cursky.L > last2.L && cursky.H < last2.H){
                skylines.add(new MyBox(last2.L, cursky.H));
                skylines.remove(cursky);
                skylines.remove(last2);
                break;
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
        ArrayList<MyBox> skylines = new ArrayList<>();
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
