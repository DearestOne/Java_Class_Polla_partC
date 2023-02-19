import java.util.Scanner;
class Product { //from ProductShipping1 
    String name;
    int weight;
    int price;
    Product(String name,int weight,int price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    void printInfo(){
        System.out.println(weight + " grams of " + name + " costs " + price + " baht.");
    }
}
class PurchaseOrder{ //from ProductShipping2
    int num,amount[],sumprice = 0,weight = 0;
    Product[] p;
    PurchaseOrder(int n,Product[] P,int[] Amount){
        this.p = java.util.Arrays.copyOf(P,P.length);
        this.amount = java.util.Arrays.copyOf(Amount,Amount.length);
        num = n;
        for(int i=0;i<num;i++){
            sumprice += p[i].price * amount[i];
            weight += p[i].weight * amount[i];
        }
    }
    void printInfo(){
        System.out.println(num + " items = " + sumprice + " baht " + weight + " grams");
        for(int i=0;i<num;i++){
            int sum = amount[i] * p[i].price;
            System.out.println(p[i].name + " " + amount[i] + "x" + p[i].price + " = " + sum);
        }
    }
}
class Truck {
    // write your code here
    int netWeight,laststation;
    PurchaseOrder p;
    double price;
    Truck(int capacity){
        this.netWeight = capacity;
        laststation = 0;
        price = 0;
    }
    void add(PurchaseOrder P,int ls){
        laststation = ls;
        p = P;
    }
    double getFee(){
        double kweight = p.weight / (double)1000;
        price = kweight * laststation;
        double roundedPrice = Math.round(price * 1000.0) / 1000.0;
        //price = 22.2222222222223
        //Math.round(22222.2222222223) = 22222
        //22222 / 1000 = 22.222
        return roundedPrice;
    }
}
public class ProductShipping3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        Truck[] trucks = new Truck[m];
        for (int i=0;i<m;i++){
            int capacity = in.nextInt();
            trucks[i] = new Truck(capacity);
        }
        int n = in.nextInt();
        int dest = in.nextInt();
        Product[] products = new Product[n];
        int[] amount = new int[n];
        for(int i=0;i<n;i++){
            String name = in.next();
            int weight = in.nextInt();
            int price = in.nextInt();
            products[i] = new Product(name,weight,price);
            amount[i] = in.nextInt();
        }
        PurchaseOrder po = new PurchaseOrder(n,products, amount);
        int minvalue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i=0;i<m;i++){
            if((trucks[i].netWeight>=po.weight)&&(minvalue>trucks[i].netWeight)){
                minvalue = trucks[i].netWeight;
                minIndex = i;
            }
        }
        if (minIndex >= 0){
            trucks[minIndex].add(po, dest);
            System.out.println("Truck#"+ (minIndex+1));
            System.out.println("Fee="+ trucks[minIndex].getFee());
        }else{
            System.out.println("No truck");
            System.out.println("Fee="+ po.weight*dest/1000.0);
        }
    }
}