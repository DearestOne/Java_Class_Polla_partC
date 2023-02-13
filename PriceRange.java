import java.util.Scanner;
class ProductInfo {
    // Enter your code here and only here.
    String name;
    int min_price = 1000000,max_price = 0;
    ProductInfo(String name,int[] price){
        this.name = name;
        // find min/max in constructer.
        for(int i=0;i<price.length;i++){
            min_price = Math.min(min_price,price[i]);
            max_price = Math.max(max_price,price[i]);
        }
    }
    void printInfo(){
        System.out.println(name + " " + min_price + " " + max_price);
    }
}
public class PriceRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int N = scan.nextInt();
        int[] prices = new int[N];
        for(int i = 0; i < N; ++i)
            prices[i] = scan.nextInt();
        ProductInfo pInfo = new ProductInfo(name, prices);
        pInfo.printInfo();
    }
}
