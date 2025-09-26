package th.ac.kmutt.cpe.algorithm.thanaboon.fee.resource.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import th.ac.kmutt.cpe.algorithm.thanaboon.fee.MyBox;

public class CSVReader {
    public CSVReader(){
    }
    private String file(int n){
        if(n==1){
            return "src\\th\\ac\\kmutt\\cpe\\algorithm\\thanaboon\\fee\\resource\\boxSize1.csv";
        }
        if(n==2){
            return "src\\th\\ac\\kmutt\\cpe\\algorithm\\thanaboon\\fee\\resource\\boxSize2.csv";
        }
        if(n==3){
            return  "src\\th\\ac\\kmutt\\cpe\\algorithm\\thanaboon\\fee\\resource\\boxSize3.csv";
        }
        return "";
    }
    public ArrayList<MyBox> read(int type){
        ArrayList<MyBox> data = new ArrayList<>();
        BufferedReader reader = null;
        String line = "";  
        try {
        reader = new BufferedReader(new FileReader(file(type)));
        while((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            ArrayList<Double> rowdata = new ArrayList<>();
            for(int i=0 ; i<row.length ; i++ ) {    
                rowdata.add(Double.parseDouble(row[i]));    
            }
            MyBox temp = new MyBox(rowdata.get(0),rowdata.get(1));
            data.add(temp);
        }}
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
}
