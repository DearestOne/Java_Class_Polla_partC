import java.util.Scanner;
class Truck{
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
class GasStation{
    double[] amount;
    GasStation(double[] amount){
        this.amount = java.util.Arrays.copyOf(amount, amount.length);
    }
    void fillTank(int type,Truck T,int distance){
        if(T.calFuel(distance) <= amount[type - 1]){
            amount[type - 1] -= T.calFuel(distance);
        }
        else{
            System.out.println(type + " out of gasoline");
        }
    }
    void refuel(double[] Amount){
        for(int i=0;i<Amount.length;i++){
            amount[i] += Amount[i];
        }
    }
    void print(){
        for(int i=0;i<amount.length;i++){
            System.out.print(amount[i] + " ");
        }
        System.out.println();
    }
}
public class TestGasStation {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        Truck[] t = new Truck[n];
        for(int i=0;i<n;i++){
            t[i] = new Truck(scan.nextInt(),scan.nextInt());
        }
        int k = scan.nextInt();
        double[] fuel = new double[k];
        for(int i=0;i<k;i++){
            fuel[i] = scan.nextDouble();
        }
        GasStation G = new GasStation(fuel);
        int m = scan.nextInt();
        for(int i=0;i<m;i++){
            int option = scan.nextInt();
            if(option == 0){
                int A = scan.nextInt();
                int T = scan.nextInt();
                int D = scan.nextInt();
                G.fillTank(T,t[A - 1],D);
            }
            else if(option == 1){
                double[] a = new double[k];
                for(int j=0;j<k;j++){
                    a[j] = scan.nextDouble();
                }
                G.refuel(a);
            }
            G.print();
        }
    }
}
