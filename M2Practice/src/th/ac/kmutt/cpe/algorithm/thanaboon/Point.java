package th.ac.kmutt.cpe.algorithm.thanaboon;

public class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x,int y){
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
