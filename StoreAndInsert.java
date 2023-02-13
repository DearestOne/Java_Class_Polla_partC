import java.util.Scanner;
import java.util.ArrayList;
class ProductInfo {
// Use the code from the previous problem here.
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
class Store {
    // Enter your new code here and only here.
    ArrayList<ProductInfo> p = new ArrayList<>();
    private ProductInfo products;
    void enterProductInfo(Scanner scan){
        String name = scan.next();
        int N = scan.nextInt();
        int[] prices = new int[N];
        for(int i = 0; i < N; ++i){
            prices[i] = scan.nextInt();
        }
        products = new ProductInfo(name, prices);
        p.add(products);
    }
    void printAllProductInfo(){
        for(int i=0;i<p.size();i++){
            p.get(i).printInfo();
        }
    }
}
public class StoreAndInsert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Store store = new Store();
        int K = scan.nextInt();
        for(int i = 0; i < K; ++i) {
            store.enterProductInfo(scan);
        }
        store.printAllProductInfo();
    }
}