public class Circle extends Shape {
    private Pair p;
    private double r;

    public Circle(String color,double x,double y,double r){
        super(color);
        this.p = new Pair(x, y);
        this.r = r;
    }

    public void setP(double x,double y) {
        this.p.setA(x);
        this.p.setB(y);
    }

    public Pair getP(){
        return this.p;
    }

    public void setR(double r){
        this.r = r;
    }

    public double getR(){
        return this.r;
    }

    public double area(){
        return Math.PI*r*r;
    } 

    public double perimeter(){
        return Math.PI*r*2;
    }
}
