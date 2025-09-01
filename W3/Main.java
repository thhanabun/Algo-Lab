import java.util.Scanner;

//input format n = shap number
//each n -> shape [args]
//TestCase
// 3
// 1
// red 0 0 1
// 2
// red 0 0 1 1
// 3
// blue 0 0 0 2 2 0
// Output
// red : 4.141592653589793
// green : 0.0
// blue : 1.9999999999999993
// black : 17.111612431925778
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double red=0,green=0,blue=0,black=0;
        System.out.println("Select Shape");
        System.out.println("1.Circle");
        System.out.println("2.Rectangle");
        System.out.println("3.Triangle");
        for(int i=0;i<n;i++){
            int choice = sc.nextInt();
            if(choice == 1){
                String Color = sc.next();
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double r = sc.nextDouble();
                Circle c = new Circle(Color, x, y, r);
                if(c.getColor().equals("red")){
                    red += c.area(); 
                }
                else if(c.getColor().equals("blue")){
                    blue += c.area();
                }
                else if(c.getColor().equals("green")){
                    green += c.area();
                }
                black += c.perimeter();
            }
            if(choice == 2){
                String Color = sc.next();
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2  = sc.nextDouble();
                double y2 = sc.nextDouble();
                Rectangle R = new Rectangle(Color, x1, y1, x2 ,y2);
                if(R.getColor().equals("red")){
                    red += R.area(); 
                }
                else if(R.getColor().equals("blue")){
                    blue += R.area();
                }
                else if(R.getColor().equals("green")){
                    green += R.area();
                }
                black += R.perimeter();
            }
            if(choice == 3){
                String Color = sc.next();
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();
                double x3 = sc.nextDouble();
                double y3 = sc.nextDouble();
                Triangle T = new Triangle(Color, x1, y1, x2 ,y2,x3,y3);
                if(T.getColor().equals("red")){
                    red += T.area(); 
                }
                else if(T.getColor().equals("blue")){
                    blue += T.area();
                }
                else if(T.getColor().equals("green")){
                    green += T.area();
                }
                black += T.perimeter();
            }
        }
        System.out.printf("red : %.2f\ngreen : %.2f\nblue : %.2f\nblack : %.2f",red,green,blue,black);
        sc.close();
    }
}
