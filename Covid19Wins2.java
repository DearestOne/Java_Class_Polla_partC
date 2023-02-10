import java.util.Scanner;
import java.util.ArrayList;
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
    void printVisitHours(String name){
        System.out.println(name);
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
            System.out.println();
        }
    }
}
class Person{
    String name;
    ArrayList<Visitation> v;
    ArrayList<place> pl;
    Person(String name){
        this.name = name;
        v = new ArrayList<>();
        pl = new ArrayList<>();
    }
    void addVisitation(Visitation vis){
        if(vis.count() > 0){
            this.v.add(vis);
        }
    }
    void addplace(ArrayList<place> p){
        this.pl = p;
    }
    void printAllVisitations(){
        System.out.println(v.size());
        for(int i=0;i<v.size();i++){
            for(int j=0;j<pl.size();j++){
                if(pl.get(j).id == v.get(i).id){
                    v.get(i).printVisitHours(pl.get(j).name);
                }
            }
        }
    }
}
class place{
    int id;
    String name;
    place(int id,String name){
        this.id = id;
        this.name = name;
    }
}
public class Covid19Wins2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<place> p = new ArrayList<>();
        for(int i=0;i<n;i++){
            int id = scan.nextInt();
            String name = scan.next();
            if(id > 0 && id <= 300){
                for(int j=0;j<p.size();j++){
                    if(p.get(j).id == id){
                        p.remove(j);
                    }
                }
                place pl = new place(id, name);
                p.add(pl);
            }
        }
        String name = scan.next();
        Person person = new Person(name);
        person.addplace(p);
        int k = scan.nextInt();
        for(int i=0;i<k;i++){
            int id = scan.nextInt();
            int date = scan.nextInt();
            Visitation v = new Visitation(id, date);
            int K = scan.nextInt();
            for(int j=0;j<K;j++){
                int hour = scan.nextInt();
                v.visit(hour);
            }
            person.addVisitation(v);
        }
        person.printAllVisitations();
    }
}