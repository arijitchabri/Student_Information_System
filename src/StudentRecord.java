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
    /*
    We will use insertion sorting at here for sorting the record roll wise
    and we have to modify the sort for make it work along with the names also
    so we can find the proper name and roll number at same index.
    */

    public static void addStudent(){
        System.out.println("Student name :- ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Student roll :- ");
        int roll = sc.nextInt();
        names[index] = name;
        rollNumber[index] = roll;
        index++;
        System.out.println("Student added successfully");
    }
    public static void updateStudent(int index){
        sc.nextLine();
        System.out.println("Student name :- ");
        String name = sc.nextLine();
        System.out.println("Student roll :- ");
        int roll = sc.nextInt();
        names[index] = name;
        rollNumber[index] = roll;
    }

    public static void update(){
        boolean flag = false;
        System.out.println("Roll of the student you want to update details.");
        int stu = sc.nextInt();
        //TODO :- At here we will call the binary search function and pass the returned value to the updateStudent() function

        for (int i = 0; i < index; i++) {
            if (rollNumber[i] == stu) {
                updateStudent(i);
                flag = true;
                System.out.println("Student record Updated.");
                break;
            }
        }
        if (!flag){
            System.out.println("""
                    Sorry there is no such student in the records.\s
                    Press 1 if you wish to add this in records.
                    Press 2 for re-searching.
                    Press 3 to continue without adding.
                    """);
            int choice = sc.nextInt();
            switch (choice) {
                case 1 : {
                    addStudent();
                    break;

                }
                case 2 : {
                    update();

                }
                default : {

                }
            }
        }

    }

    public static void main(String[] args) {
        int choice;
        System.out.println("""
                1. For adding a student
                2. For printing a particular Student
                3. For printing the whole Student record
                4. For updating a student record
                5. For exiting""");
        while(true) {
            System.out.println("\n----------------------------------------------\n");
            System.out.println("press 6 for help ! \n What is your choice :- ");
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
                case 4:{
                    update();
                    break;
                }
                case 5 :{
                    System.exit(0);
                    break;
                }
                case 6 :{
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
