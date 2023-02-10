import java.util.Scanner;
class Visitation {
    int id,date,time[];
    Visitation(int id,int date){
        this.id = id;
        this.date = date;
        time = new int[24];
    }
    void visit(int hour){
        if(hour < 0 || hour > 23){
            System.out.println("invalid hour: " + hour);
        }
        else{
            time[hour]++;
        }
    }
    int count(){
        int c = 0;
        for(int i=0;i<24;i++){
            c += time[i];
        }
        return c;
    }
    void printVisitHours(){
        System.out.println(id);
        System.out.println(date);
        System.out.println(count());
        if(count() == 0){
            System.out.println("no visit");
        }
        else {
            for(int i=0;i<24;i++){
                if(time[i] > 0){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
public class Covid19Wins1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        int date = scan.nextInt();
        final int K = scan.nextInt();

        // Create object and correctly use it here
        Visitation v = new Visitation(id,date);
        for(int i=0;i<K;i++){
            int hour = scan.nextInt();
           v.visit(hour);
        }
        v.printVisitHours();
    }
}