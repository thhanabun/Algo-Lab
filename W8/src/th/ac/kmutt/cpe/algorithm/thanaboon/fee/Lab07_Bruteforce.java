package th.ac.kmutt.cpe.algorithm.thanaboon.fee;
import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.fee.resource.reader.CSVReader;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.boxSort;

public class Lab07_Bruteforce {
    //too slow
    public static void BruteForceSolve(ArrayList<MyBox> data,ArrayList<Integer> used , ArrayList<Integer> ans ,int[][] bigbox, double x ,double y ,int ceilL ,int ceilH,double maxArea){
        double curArea = calculateArea(data, used);
        if(curArea > maxArea){
            maxArea = curArea;
            ans.clear();
            ans.addAll(used);
        }
        for (int i = 0; i < data.size(); i++) {
            if (!used.contains(i)) {
                int boxL = (int) Math.ceil(data.get(i).L);
                int boxH = (int) Math.ceil(data.get(i).H);
                for (int row = 0; row <= ceilH - boxH; row++) {
                    for (int col = 0; col <= ceilL - boxL; col++) {
                        boolean canPlace = true;
                        for (int r = row; r < row + boxH && canPlace; r++) {
                            for (int c = col; c < col + boxL; c++) {
                                if (bigbox[r][c] != 0) {
                                    canPlace = false;
                                    break;
                                }
                            }
                        }
                        if (canPlace) {
                            for (int r = row; r < row + boxH; r++) {
                                for (int c = col; c < col + boxL; c++) {
                                    bigbox[r][c] = i + 1;
                                }
                            }
                            used.add(i);
                            BruteForceSolve(data, used, ans, bigbox, x, y, ceilL, ceilH, maxArea);
                            used.remove(used.size() - 1);
                            for (int r = row; r < row + boxH; r++) {
                                for (int c = col; c < col + boxL; c++) {
                                    bigbox[r][c] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }        
    }
    public static double calculateArea(ArrayList<MyBox> data,ArrayList<Integer> used){
        double total = 0;
        for (Integer idx : used) {
            total += data.get(idx).H *data.get(idx).L;
        }
        return total;
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
        int ceilL = (int) Math.ceil(length);
        int ceilH = (int) Math.ceil(height);
        int[][] Bigbox = new int[ceilH][ceilL];
        ArrayList<Integer> ans = new ArrayList<>(); 
        BruteForceSolve(data, used, ans ,Bigbox,length,height,ceilL,ceilH,0);
        if(ans.size() != data.size()){
            System.out.println("not used box");
        }
        else{
            System.out.println("used all box");
        }
        double usedArea = 0;
        for(int i =0;i<data.size();i++){
            if(!ans.contains(i)){
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
