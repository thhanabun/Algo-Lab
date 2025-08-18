import java.util.*;
public class CannedGoose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goose=0,tomato=0,normal=0,big=0;
        int a,b,cmd=1;
        do{
            cmd = sc.nextInt();
            if(cmd == 1){
                a = sc.nextInt();
                b = sc.nextInt();
                goose += a;
                tomato += b;
            }
            if(cmd ==2){
                a = sc.nextInt();
                b = sc.nextInt();
                int usedG = a*3 + b*5;
                int usedT = a*2 + b*3;
                if(goose >= usedG && tomato>= usedT){
                    System.out.println("yes");
                    goose-=usedG;
                    tomato-=usedT;
                    normal+=a;
                    big+=b;
                }
                else{
                    System.out.println("no");
                }
            }

        }while(cmd!=0);
        System.out.printf("%d %d %d %d",goose,tomato,normal,big);
        sc.close();
    }
}
