import java.util.Scanner;
import java.lang.String;

public class StudentRecord {

    static Scanner sc = new Scanner(System.in);

    static {
        System.out.println("How many Students :- ");
    }

    static int index = 0;
    static int num = sc.nextInt();
    static String[] names =new String[num];
    static int[] rollNumber = new int[num];

    public static void printStudent(int index){
        System.out.println(       "Name        Roll");
        System.out.println(names[index] + "        " + rollNumber[index]);
    }

    public static void printStudents(){
        System.out.println(       "Name        Roll");
        for (int i = 0; i < index; i++){
            System.out.println(names[i] + "        " + rollNumber[i]);
        }
    }

    // TODO :- Have to create a binary searchable pattern for adding items.

    public static void addStudent(){
        System.out.println("Student name :- ");
        String name = sc.nextLine();
        System.out.println("Student roll :- ");
        int roll = sc.nextInt();
        names[index] = name;
        rollNumber[index] = roll;
        index++;
    }

    // TODO :- Have to create a update function

    public static void main(String[] args) {
        int choice;
        System.out.println("""
                1. For adding a student
                2. For printing a particular Student
                3. For printing the whole Student record
                4. For exiting""");
        while(true) {
            System.out.println("\n----------------------------------------------\n");
            System.out.println("press 5 for help ! \n What is your choice :- ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 :{
                    addStudent();
                    break;
                }
                case 2 :{
                    System.out.println("Give me the index number :- ");
                    printStudent(sc.nextInt());
                    break;
                }
                case 3 :{
                    printStudents();
                    break;
                }
                case 4 :{
                    System.exit(0);
                    break;
                }
                case 5 :{
                    System.out.println("""
                            1. For adding a student
                            2. For printing a particular Student
                            3. For printing the whole Student record
                            4. For exiting""");
                    break;
                }
                default :{
                    System.out.println("Wrong input please try again !");
                }
            }
        }

    }
}
