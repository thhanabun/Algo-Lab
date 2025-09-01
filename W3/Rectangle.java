public class Rectangle extends Shape {
    private Pair p1;
    private Pair p2;

    public Rectangle(String color,double x1,double y1,double x2,double y2){
        super(color);
        this.p1 = new Pair(x1,y1);
        this.p2 = new Pair(x2, y2);
    }

    public void setP1(double x,double y){
        this.p1.setA(x);
        this.p1.setB(y);
    }

    public Pair getP1(){
        return this.p1;
    }

    public void setP2(double x,double y){
        this.p2.setA(x);
        this.p2.setB(y);
    }

    public Pair getP2(){
        return this.p2;
    }

    public double area(){
        double xDiff = Math.abs(this.p1.getA()-this.p2.getA());
        double yDiff = Math.abs(this.p1.getB()-this.p2.getB());
        return xDiff*yDiff;
    }

    public double perimeter(){
        double xDiff = Math.abs(this.p1.getA()-this.p2.getA());
        double yDiff = Math.abs(this.p1.getB()-this.p2.getB());
        return 2*(xDiff+yDiff);
    }
}
