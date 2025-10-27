package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;

public class LexicoOrder {
    
    private String str;

    public LexicoOrder(String S){
        this.str = new String(S);    
    }

    public void chSwap(char[] ch,int i , int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public void chReverse(char[] ch, int st){
        int ed = ch.length-1;
        while (st < ed) {
            chSwap(ch, st, ed);
            st++;
            ed--;
        }
    }

    public ArrayList<String> permute(){
        char ch[] = str.toCharArray();
        ArrayList<String> order = new ArrayList<>();
        order.add(new String(ch));
        do{
            int i;
            for(i = ch.length-2 ;i >= 0 ; i--){
                if(ch[i] < ch[i+1]){
                    break;
                }
            }

            if(i == -1 ){
                break;
            }

            int j;
            for (j = ch.length-1 ; j >= 0; j--) {
                if(ch[j] >  ch[i] ){
                    break;
                }
            }
            chSwap(ch,i,j);
            chReverse(ch, i+1);
            order.add(new String(ch));
        }while(true);
        return order; 
    }
    public String getStr(){
        return this.str;
    }
}