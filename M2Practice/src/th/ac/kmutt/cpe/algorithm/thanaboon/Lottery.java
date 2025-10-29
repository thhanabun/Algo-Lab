package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.Scanner;

public class Lottery {
    public static LotteryAns horsePool(String Pattern,String txt){
        ShiftTable table = shiftTable(Pattern);
        int PatternL = Pattern.length();
        int txtL = txt.length();
        int i = PatternL -1;
        int shift = 0;
        while(i <= txtL-1){
            int k = 0;
            while(k <= PatternL-1 && Pattern.charAt(PatternL-1-k) == txt.charAt(i-k)){
                k++;
            }
            if(k == PatternL){
                return  new LotteryAns(shift, i - PatternL + 1);
            }else{
                shift++;
                i = i + table.getShift(table.find(txt.charAt(i)));
            }
        }
        return new LotteryAns(shift, -1);
    }

    public static ShiftTable shiftTable(String Pattern){
        int PatternL = Pattern.length();
        ShiftTable st = new ShiftTable(PatternL);
        for (int i = 0; i < PatternL ; i++) {
            char curCh = Pattern.charAt(i);
            if(st.find(curCh) == -1){
                st.insert(curCh);
            }
        }

        for (int j = 0; j < PatternL - 1; j++) {
            char curCh = Pattern.charAt(j);
            st.tableSet(curCh, PatternL-1-j);
        }
        
        return st;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int txtL = sc.nextInt();
        int pL = sc.nextInt();
        String txtF = sc.next();
        String pF = sc.next();
        String txt =  txtF.substring(0,txtL);
        String p = pF.substring(0, pL);
        LotteryAns ans = horsePool(p, txt);
        if(ans.idx == -1){
            System.out.printf("No %d %d",ans.sh,ans.idx);
        }else{
            System.out.printf("Yes %d %d",ans.sh,ans.idx);
        }
        sc.close();
    }
}
