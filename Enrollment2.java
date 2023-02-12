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
    boolean enroll(int id,Student[] s){
        // find same id in class.
        for(int i=0;i<stuID.size();i++){
            if(id == stuID.get(i)){
                return false;
            }
        }

        // find in same student.
        // if it same --> save the order of that student.
        int order = -1;
        boolean isstudent = false;
        for(int i=0;i<s.length;i++){
            if(id == s[i].id){
                isstudent = true;
                order = i;
                break;
            }
        }
        if(!isstudent){
            System.out.print("Invalid ID ");
            return false;
        }

        // check space in class.
        if(current_stu == max_stu){
            return false;
        }
        else{
            current_stu++;
            stuID.add(id);
            s[order].printInfo();
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
class Student{
    int id;
    String firstname,lastname;
    Student(int id,String firstname,String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }
    void printInfo(){
        System.out.print(firstname + " " + lastname + " ");
    }
}
public class Enrollment2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int P = scan.nextInt();
        Student[] s = new Student[P];
        for(int i = 0; i < P; ++i) {
            int id = scan.nextInt();
            String firstName = scan.next();
            String lastName = scan.next();
            s[i] = new Student(id, firstName, lastName);
        }
        String str = scan.next();
        final int N = scan.nextInt();
        final int K = scan.nextInt();

        Course co = new Course(str, N);
        for(int i = 0; i < K; ++i) {
            int id = scan.nextInt();
            boolean result = co.enroll(id,s);
            System.out.println(result);
        }

        co.printInfo();
    }
}