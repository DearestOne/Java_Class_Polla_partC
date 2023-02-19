import java.util.Scanner;
class Product{// from ProductShipping1 
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
class PurchaseOrder{
    // your code here
    int num,amount[],sumprice = 0,sumweight = 0;
    Product[] p;
    PurchaseOrder(int n,Product[] P,int[] Amount){
        this.p = java.util.Arrays.copyOf(P,P.length);
        this.amount = java.util.Arrays.copyOf(Amount,Amount.length);
        num = n;
        for(int i=0;i<num;i++){
            sumprice += p[i].price * amount[i];
            sumweight += p[i].weight * amount[i];
        }
    }
    void printInfo(){
        System.out.println(num + " items = " + sumprice + " baht " + sumweight + " grams");
        for(int i=0;i<num;i++){
            int sum = amount[i] * p[i].price;
            System.out.println(p[i].name + " " + amount[i] + "x" + p[i].price + " = " + sum);
        }
    }
}
public class ProductShipping2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
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
        po.printInfo();
    }
}