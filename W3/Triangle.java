public class Triangle extends Shape {
    private Pair p1;
    private Pair p2;
    private Pair p3;

    public Triangle(String color,double x1,double y1,double x2,double y2,double x3,double y3){
        super(color);
        this.p1 = new Pair(x1,y1);
        this.p2 = new Pair(x2, y2);
        this.p3 = new Pair(x3, y3);
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

    public void setP3(double x,double y){
        this.p3.setA(x);
        this.p3.setB(y);
    }
    public Pair getP3(){
        return this.p3;
    }

    public double area(){
        double a = Math.sqrt(Math.pow(this.p1.getA()-this.p2.getA(), 2)+Math.pow(this.p1.getB()-this.p2.getB(), 2));
        double b = Math.sqrt(Math.pow(this.p1.getA()-this.p3.getA(), 2)+Math.pow(this.p1.getB()-this.p3.getB(), 2));
        double c = Math.sqrt(Math.pow(this.p2.getA()-this.p3.getA(), 2)+Math.pow(this.p2.getB()-this.p3.getB(), 2));
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public double perimeter(){
        double a = Math.sqrt(Math.pow(this.p1.getA()-this.p2.getA(), 2)+Math.pow(this.p1.getB()-this.p2.getB(), 2));
        double b = Math.sqrt(Math.pow(this.p1.getA()-this.p3.getA(), 2)+Math.pow(this.p1.getB()-this.p3.getB(), 2));
        double c = Math.sqrt(Math.pow(this.p2.getA()-this.p3.getA(), 2)+Math.pow(this.p2.getB()-this.p3.getB(), 2));
        return a+b+c;
    }
}
