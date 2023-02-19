import java.util.Scanner;
class Station {
    // Enter your code here
    int benzin,diesel;
    Station(int benzin,int diesel){
        this.benzin = benzin;
        this.diesel = diesel;
    }
    void dispense(Car c){
        if(c.gastype == 1){//benzin
            if(c.getNeededVol() <= benzin){
                System.out.println("Dispense "+ c.getNeededVol() + " liters of benzin");
                benzin -= c.getNeededVol();
                c.amount = c.maxCapacity;
            }
            else{
                System.out.println("Dispense "+ benzin + " liters of benzin");
                c.amount += benzin;
                benzin = 0;
            }
        }
        else if(c.gastype == 2){//diesel
            if(c.getNeededVol() <= diesel){
                System.out.println("Dispense "+ c.getNeededVol() + " liters of diesel");
                diesel -= c.getNeededVol();
                c.amount = c.maxCapacity;
            }
            else{
                System.out.println("Dispense "+ diesel + " liters of diesel");
                c.amount += diesel;
                diesel = 0;
            }
        }
    }
    void refillBenzin(int Amount){
        benzin += Amount;
        System.out.println("Station has " + benzin + " liters of benzin");
    }
    void refillDiesel(int Amount){
        diesel += Amount;
        System.out.println("Station has " + diesel + " liters of diesel");
    }
}
class Car {
    // Enter your code here
    int gastype,maxCapacity,amount;
    Car(int fueltype,int maxCapacity,int amount){
        this.amount = amount;
        this.maxCapacity = maxCapacity;
        this.gastype = fueltype;
    }
    int getNeededVol(){
        return maxCapacity - amount;
    }
}
public class StationAndCar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int benzin = scan.nextInt();
        int diesel = scan.nextInt();
        Station s = new Station(benzin, diesel);

        final int Q = scan.nextInt();
        for(int i = 0; i < Q; ++i) {
            final int A = scan.nextInt();
            final int B = scan.nextInt();
            final int C = scan.nextInt();
            final int D = scan.nextInt();
            if(A == 1){
                Car c = new Car(B,C,D);
                s.dispense(c);
            }
            else if(A == 2){
                if(B == 1){
                    s.refillBenzin(C);
                }
                else if(B == 2){
                    s.refillDiesel(C);
                }
            }
        }
    }
}