import java.util.Scanner;
class CPU{
    // Use the code from the prevoius problem.
    public String model;
    public int clocks,socket,memType;
    public boolean valid;
    CPU(String model,int clocks,int socket,int memType){
        this.model = model;
        this.clocks = clocks;
        this.socket = socket;
        this.memType = memType;
        valid = isValidSpec(model, clocks, socket, memType);
    }
    boolean isValidSpec(String model,int clocks,int socket,int memType){
        boolean result = true;
        if(model == null || model.length() == 0){
            result = false;
        }
        if(clocks <= 0){
            result = false;
        }
        if(socket <= 0){
            result = false;
        }
        if(memType <= 0 || memType > 10){
            result = false;
        }
        return result;
    }
    void printInfo(){
        System.out.println(model);
        System.out.println(clocks);
        System.out.println(socket);
        System.out.println(memType);
        System.out.println(valid);
    }
}
class MainBoard {
    //Enter your new code here.
    public String model;
    public int socket,memType;
    public boolean valid;
    MainBoard(String model,int socket,int memType){
        this.model = model;
        this.socket = socket;
        this.memType = memType;
        valid = isValidSpec(model, socket, memType);
    }
    boolean isValidSpec(String model,int socket,int memType){
        boolean result = true;
        if(model == null || model.length() == 0){
            result = false;
        }
        if(socket <= 0){
            result = false;
        }
        if(memType <= 0 || memType > 10){
            result = false;
        }
        return result;
    }
    void printInfo(){
        System.out.println(model);
        System.out.println(socket);
        System.out.println(memType);
        System.out.println(valid);
    }
}
class Computer {
    //Enter your new code here.
    MainBoard mb;
    CPU cpu;
    boolean valid;
    Computer(CPU cpu,MainBoard mb){
        this.mb = mb;
        this.cpu = cpu;
        valid = isValidCom(cpu,mb);
    }
    boolean isValidCom(CPU cpu,MainBoard mb){
        boolean result = true;
        if(!cpu.valid || !mb.valid){
            result = false;
        }
        if(cpu.memType != mb.memType){
            result = false;
        }
        if(cpu.socket != mb.socket){
            result = false;
        }
        return result;
    }
    void printInfo(){
        if(valid){
            System.out.println(cpu.model);
            System.out.println(cpu.clocks);
            System.out.println(mb.model);
            System.out.println(mb.socket);
            System.out.println(mb.memType);
        }
        else{
            System.out.println("Invalid Spec");
            cpu.printInfo();
            mb.printInfo();
        }
    }
}
public class MBCompat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String model = scan.nextLine();
        int clocks = scan.nextInt();
        int socket = scan.nextInt();
        int memType = scan.nextInt();

        if(model.length() == 0 && socket % 2 == 0)
            model = null;
        CPU cpu = new CPU(model,clocks,socket,memType);
        
        scan.nextLine(); // skip new line Character
        model = scan.nextLine();
        socket = scan.nextInt();
        memType = scan.nextInt();
        if(model.length() == 0 && socket % 2 == 0)
            model = null;
        MainBoard mb = new MainBoard(model,socket,memType);

        Computer com = new Computer(cpu,mb);
        com.printInfo();
    }
}
