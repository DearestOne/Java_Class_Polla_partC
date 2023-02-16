import java.util.Scanner;
class Item {
 // Insert your code here, and only here.
    String name,id;
    int price,shipping,volume,quan;
    boolean valid;
    Item(String name,String id,int price,int shipping,int volume,int quan){
        this.name = name;
        this.id = id;
        this.price = price;
        this.shipping = shipping;
        this.volume = volume;
        this.quan = quan;
        valid = basicCheck(name,id,price,shipping,volume);
    }
    boolean basicCheck(String name,String id,int price,int shipping,int volume){
        boolean check = true;
        if(name == null || name.length() < 3 || id == null || id.length() < 3){
            check = false;
        }
        if(price <= 0 || volume <= 0){
            check = false;
        }
        if(shipping < 0){
            check = false;
        }
        return check;
    }
    boolean cutStock(int n){
        if(n > quan){
            return false;
        }
        else{
            quan -= n;
            return true;
        }
    }
    void printInfo(){
        System.out.println(name + " " + id + " " + price);
        System.out.println(shipping + " " + volume + " " + quan + " " + valid);
    }
}
public class ItemAndCart1 {
    // Do not change the code below this line.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        String id = scan.next();
        int price = scan.nextInt();
        int shipping = scan.nextInt();
        int volume = scan.nextInt();
        int quan = scan.nextInt();
        Item item = new Item(name, id, price, shipping, volume, quan);
        item.printInfo();

        int n = scan.nextInt();
        for(int i = 0; i < n; ++i) {
            int q = scan.nextInt();
            System.out.println(item.cutStock(q));
            item.printInfo();
        } 
    }
}