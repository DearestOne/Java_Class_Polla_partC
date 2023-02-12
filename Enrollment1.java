import java.util.Scanner;
import java.util.ArrayList;
class Course {
    // Enter your code here.
    String class_name;
    int max_stu,current_stu;
    ArrayList<Integer> stuID;
    Course(String class_name,int max_stu){
        this.class_name = class_name;
        this.max_stu = max_stu;
        stuID = new ArrayList<>();
        current_stu = 0;
    }
    boolean enroll(int id){
        for(int i=0;i<stuID.size();i++){
            if(id == stuID.get(i)){
                return false;
            }
        }
        if(current_stu == max_stu){
            return false;
        }
        else{
            current_stu++;
            stuID.add(id);
            return true;
        }
    }
    void printInfo(){
        System.out.println(class_name + " " + stuID.size());
        for(int i=0;i<stuID.size();i++){
            System.out.println(stuID.get(i));
        }
    }
}
public class Enrollment1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        final int N = scan.nextInt();
        final int K = scan.nextInt();

        Course co = new Course(str, N);
        for(int i = 0; i < K; ++i) {
            int id = scan.nextInt();
            boolean result = co.enroll(id);
            System.out.println(result);
        }

        co.printInfo();
    }
}
