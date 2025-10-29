package th.ac.kmutt.cpe.algorithm.thanaboon;

public class Point implements Comparable<Point>{
    double x;
    double y;

    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point p2){
        if( this.x > p2.x){
            return 1;
        }else if(this.x < p2.x){
            return -1;
        }else{
            return 0;
        }
    }
}
