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
class Factory {
    int count,maxlabor;
    boolean[] can;
    int currentLabor;
    public Factory(int count,boolean[] can,int maxlabor){
        this.can = java.util.Arrays.copyOf(can,can.length);
        this.maxlabor = maxlabor;
        this.count = count;
        currentLabor = 0;
    }
}
public class AliCarCar2 {
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
            }
        }
        boolean[] can = new boolean[n];
        Factory[] F = new Factory[5];
        for(int i=0;i<5;i++){
            int maxlabor = scan.nextInt();
            for(int j=0;j<n;j++){
                can[j] = scan.nextInt() == 1 ? true : false;
            }
            F[i] = new Factory(count, can, maxlabor);
        }
        int k = scan.nextInt();
        for(int i=0;i<k;i++){
            int num = scan.nextInt();
            boolean isinrange = num > 0 && num <= count;
            boolean isfound = false;
            for(int j=0;j<5;j++){
                if(!isinrange){
                    System.out.println("invalid model");
                    break;
                }
                boolean canbuild = F[j].can[num - 1];
                boolean islabor = (c[num - 1].labor + F[j].currentLabor <= F[j].maxlabor);

                if(islabor && canbuild){//find can build in factory
                    System.out.println("okay " + (j+1));
                    F[j].currentLabor += c[num - 1].labor;
                    isfound = true;
                    break;
                }
            }
            if(!isfound && isinrange){
                System.out.println("unable to build");
            }
        }
    }
}
