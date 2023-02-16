import java.util.Scanner;
class Blade{
    int size,number,angle;
    double horsepower;
    boolean valid;
    Blade(int size,int number,int angle,double hp){
        this.size = size;
        this.angle = angle;
        this.number = number;
        horsepower = hp;
        // find data mistake save to valid
        valid = true;
        if(size > 24 || size < 16 || size % 2 == 1){
            valid = false;
            System.out.println("invalid size");
        }
        if(number < 3 || number > 5){
            valid = false;
            System.out.println("invalid number of blades");
        }
        if(angle != 27 && angle != 30 && angle != 33){
            valid = false;
            System.out.println("invalid angle");
        }
        if(horsepower <= 0){
            valid = false;
            System.out.println("invalid horsepower");
        }
    }
    void printInfo(){
        System.out.println(size + " " + number + " " + angle + " " + horsepower + " " + valid);
    }
}
public class FanCompany1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int numb = scan.nextInt();
        int angle = scan.nextInt();
        double hp = scan.nextDouble();
        Blade ablade = new Blade(size, numb, angle, hp);
        ablade.printInfo();;
    }
}