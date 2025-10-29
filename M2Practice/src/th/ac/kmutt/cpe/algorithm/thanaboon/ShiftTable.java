package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;

public class ShiftTable {
    ArrayList<Character> ch;
    ArrayList<Integer> shift;
    int PatternL;

    public ShiftTable(int PatternL){
        this.ch = new ArrayList<>();
        this.shift = new ArrayList<>();
        this.PatternL = PatternL;
    }

    public void insert(char c){
        ch.add(c);
        shift.add(PatternL);
    }

    public int find(char c){
        for (int i = 0; i < ch.size() ; i++) {
            if(ch.get(i) == c){
                return i;
            }
        }
        return -1;
    }

    public void tableSet(char c,int newVal){
        int idx = find(c);
        if(idx != -1){
            shift.set(idx, newVal);
        }
    }

    public int size(){
        return ch.size();
    }

    public int getShift(int i){
        if(i==-1){
            return PatternL;
        }
        return shift.get(i);
    }
}
