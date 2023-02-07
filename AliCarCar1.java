import java.util.Scanner;
class car {
    String name;
    int price,labor,id;
    public car(int id,String name,int price,int labor){
        this.id = id;
        this.name = name;
        this.price = price;
        this.labor = labor;
    }
    static boolean check(String name,int price,int labor){
        boolean can = true;
        if(name == null || name.length() == 0){
            can = false;
        }
        if(price <= 0){
            can = false;
        }
        if(labor <= 0){
            can = false;
        }
        return can;
    }
}
public class AliCarCar1 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        car[] c = new car[n];
        int count = 0;
        for(int i=0;i<n;i++){
            String name = scan.next();
            int price = scan.nextInt();
            int labor = scan.nextInt();
            if(c[count].check(name, price, labor)){
                c[count] = new car(count + 1,name,price,labor);
                count++;
                System.out.println("valid");
            }
            else{
                System.out.println("invalid");
            }
        }
        for(int i=0;i<count;i++){
            System.out.println((i + 1) + " " + c[i].name);
        }
    }
}
