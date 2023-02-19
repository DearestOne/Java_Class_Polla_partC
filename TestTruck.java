import java.util.Scanner;
class Truck{
    //put your code here
    int weight,amount;
    Truck(int weight,int amount){
        this.weight = weight;
        this.amount = amount;
    }
    double calFuel(int distance){
        double result = (double)(distance + weight) / 10;
        result = (double)Math.ceil(result);
        return result;
    }
}
public class TestTruck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Truck[] t = new Truck[n];
        for(int i=0;i<n;i++){
            t[i] = new Truck(in.nextInt(),in.nextInt());
        }
        int m = in.nextInt();
        for(int i=0;i<m;i++) {
            int x = in.nextInt();
            int distance = in.nextInt();
            //call method and show the answer
            System.out.println(t[x - 1].calFuel(distance));
        }
    }
}
