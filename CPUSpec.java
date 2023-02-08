import java.util.Scanner;
class CPU{
    // insert your code here and only here
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
public class CPUSpec {
    // do not change the main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String model = scan.nextLine();
        int clocks = scan.nextInt();
        int socket = scan.nextInt();
        int memType = scan.nextInt();

        if(model.length() == 0 && socket % 2 == 0)
            model = null;
        CPU cpu = new CPU(model,clocks,socket,memType);
        cpu.printInfo();
    }
}
