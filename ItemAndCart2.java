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
class Cart{
    int capacity,current;
    Item item;
    Cart(int capacity,Item item){
        this.capacity = capacity;
        this.item = item;
        current = 0;
    }
    void printStats(){
        int price = item.price * current;
        int shipping = item.shipping * current;
        int allprice = price + shipping;
        String box;
        if(current == 0){
            box = " 0";
        }
        else if(current * item.volume <= capacity){
            box = " 1";
        }
        else {
            box = " 2+";
        }
        System.out.println(current + " " + price + " " + shipping + " " + allprice + box);
    }
    boolean adjustQuan(int amount){
        if(amount > 0){
            if(item.cutStock(amount)){
                current += amount;
                return true;
            }
            else{
                return false;
            }
        }
        else if(amount < 0){
            if(current + amount >= 0){
                item.cutStock(amount);
                current += amount;
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
public class ItemAndCart2 {
    // Do not change the code below this line.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        String id = scan.next();
        int price = scan.nextInt();
        int shipping = scan.nextInt();
        int volume = scan.nextInt();
        int quan = scan.nextInt();
        Item item = new Item(name, id, price, shipping, 
        volume, quan);
        int capacity = scan.nextInt();
        Cart cart = new Cart(capacity, item);

        int n = scan.nextInt();
        for(int i = 0; i < n; ++i) {
            int q = scan.nextInt();
            System.out.println(cart.adjustQuan(q));
            cart.printStats();
        } 
    }
}
