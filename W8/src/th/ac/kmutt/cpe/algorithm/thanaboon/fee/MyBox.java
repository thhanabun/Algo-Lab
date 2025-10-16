package th.ac.kmutt.cpe.algorithm.thanaboon.fee;

public class MyBox implements Comparable<MyBox> {
    public Double L;
    public Double H;
    public MyBox(double l,double h){
        this.H = h;
        this.L = l;
    }
    @Override
    public int compareTo(MyBox box2){
        if(this.H > box2.H){
            return 1;
        }
        else if(this.H < box2.H){
            return -1;
        }
        else{
            if(this.L > box2.L){
                return 1;
            }
            else if(this.L < box2.L){
                return -1;
            }
            return 0;
        }
    }

}
