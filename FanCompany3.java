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
class Motor{
    double V,I,eff;
    Motor(double V,double I, double eff){
        this.V = V;
        this.I = I;
        this.eff = eff/100;
    }
    Motor(double I,double eff){
        //call constructor choose from these keywords
        //(super,this,that)
        this(220,I,eff);
    }
    double horsepower(){
        return (V * I * eff) / 746;
    }
    void printInfo(){
        double hp = horsepower();
        System.out.println(V + " " + I + " " +eff+" " + String.format("%.2f", hp));
    }
}
class ElectricFan{
    int productID;
    Blade b;
    Motor m;
    static int count = 0;
    boolean status;
    ElectricFan(Blade b,Motor m){
        this.b = b;
        this.m = m;
        count++;
        productID = count;
        if(m.horsepower() >= b.horsepower){
            status = true;
        }
        else{
            status = false;
        }
    }
    boolean changeBlade(Blade B){
        b = B;
        if(m.horsepower() >= b.horsepower){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    boolean changeMotor(Motor M){
        m = M;
        if(m.horsepower() >= b.horsepower){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    void printInfo(){
        System.out.print(productID + " " + b.size + " " + b.horsepower + " " + m.I + " ");
        System.out.println(String.format("%.2f", m.horsepower()) + " " + status);
    }
}
public class FanCompany3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size,numb,angle;
        double hp,v,i,eff;
        Blade ablade = null;
        Motor motor = null;
        ElectricFan eFan= null;
        for(int index=0;index<n;index++){
            int cmd = sc.nextInt();
            if (cmd==0){
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade(size,numb,angle,hp);
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor(v,i,eff);
                eFan = new ElectricFan(ablade,motor);
            }
            else if(cmd==1){
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade(size,numb,angle,hp);
                eFan.changeBlade(ablade);
            }
            else if(cmd==2){
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor(v,i,eff);
                eFan.changeMotor(motor);
            }
            eFan.printInfo();
        }
    }
}