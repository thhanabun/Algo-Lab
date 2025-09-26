package th.ac.kmutt.cpe.algorithm.thanaboon.fee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.thanaboon.searching.EMSSearch;
import th.ac.kmutt.cpe.algorithm.thanaboon.searching.EMSSearchHandle;
import th.ac.kmutt.cpe.algorithm.thanaboon.searching.SearchContext;

public class Lab05 {
    static String file(int op){
        if(op==1){
            return "src\\th\\ac\\kmutt\\cpe\\algorithm\\thanaboon\\fee\\resource\\EMS_Domestic.csv";
        }
        else if(op==2){
            return "src\\th\\ac\\kmutt\\cpe\\algorithm\\thanaboon\\fee\\resource\\EMS_World.csv";
        }
        else{
            return "";
        }
    }

    static ArrayList<ArrayList<Integer>> CSVread(int type){
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        BufferedReader reader = null;
        String line = "";  
        try {
        reader = new BufferedReader(new FileReader(file(type)));
        int cnt=0;
        while((line = reader.readLine()) != null) {
            
            String[] row = line.split(",");
            for(int i=0 ; i<row.length ; i++ ) {    
                if(cnt==0){
                    data.add(new ArrayList<>());
                }
                else{
                    if(!row[i].equals("")){
                        data.get(i).add(Integer.parseInt(row[i]));
                    }
                    else{
                        data.get(i).add(-1);
                    }
                    
                }
            }
                cnt++;
            }
        }
        catch(Exception e) {
        e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.EMS_Domestic");
        System.out.println("2.EMS_Wolrd");
        int type = sc.nextInt();
        ArrayList<ArrayList<Integer>> data = CSVread(type); 
        System.out.println("Input Weight");
        double weight = sc.nextDouble();
        int w = (int) Math.ceil(weight);
        SearchContext<Integer,Integer> solver = new SearchContext<>(new EMSSearch<Integer>());
        int idx = solver.executeSearch(data.get(0), w);
        if(idx == -1){
            solver.SetStrategy(new EMSSearchHandle<>());
            idx = solver.executeSearch(data.get(1), w);
        }
        if(idx == -1){
            System.out.println("Error not found");
        }
        else if(type == 1){
            System.out.println("Price :" + data.get(2).get(idx));
        }
        else if(type ==2){
            System.err.println("Input YourZone");
            System.out.println("1.Zone1 to 10.Zone10");
            int zone = sc.nextInt();
            if(data.get(zone+1).get(idx)!=-1){
                System.out.println("Price :" + data.get(zone+1).get(idx));
            }
            else{
                System.out.println("Error");
            }
        }
        sc.close();
    }
}
