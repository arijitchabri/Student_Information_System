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

    public static int binarySearch(int element, int low, int high){
        int mid = (high + low)/2;
        if(low >= high){
           return -1;
        }
        else if(rollNumber[mid] == element){
            return mid;
        }
        else if(rollNumber[mid] > element){
             return binarySearch(element, low, mid);
        }
        else{
            return binarySearch(element, mid+1, high);
        }

    }

    public static void printStudent(int index){
        System.out.println(       "Name        Roll");
        System.out.println(names[index] + "        " + rollNumber[index]);
    }

    public static void printStudents(){
        System.out.printf("Name %20s\n", "Roll");
        for (int i = 0; i < index; i++){
            String name = String.format("%" + (-22) + "s", names[i]);
            System.out.println(name + rollNumber[i]);
        }
    }

    public static void swap(int temp){
        int rtemp = rollNumber[temp];
        String ntemp = names[temp];
        rollNumber[temp] = rollNumber[temp - 1];
        names[temp] = names[temp - 1];
        rollNumber[temp - 1] = rtemp;
        names [temp - 1] = ntemp;
    }


    public static void sort(int pos){
        int temp = pos;
        if (index > 0){
            try{
                while(rollNumber[temp] < rollNumber[temp-1]){
                    swap(temp);
                    temp--;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){

            }

        }

    }


    public static void addStudent(){
        System.out.println("Student name :- ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Student roll :- ");
        int roll = sc.nextInt();
        names[index] = name;
        rollNumber[index] = roll;
        sort(index);
        index++;
        System.out.println("Student added successfully");
    }
    public static void updateStudent(int pos){
        sc.nextLine();
        System.out.println("Student name :- ");
        String name = sc.nextLine();
        System.out.println("Student roll :- ");
        int roll = sc.nextInt();
        names[pos] = name;
        rollNumber[pos] = roll;
        sort(pos);

    }

    public static void update(){

        boolean flag = false;
        System.out.println("Roll of the student you want to update details :- ");
        int stu = sc.nextInt();
        int pos = binarySearch(stu, 0, index);
        if (pos != -1) {
            updateStudent(pos);
            flag = true;
            System.out.println("Student record Updated.");
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
                case 1 : {
                    addStudent();
                    break;
                }
                case 2 : {
                    System.out.println("Give me the index number :- ");
                    printStudent(sc.nextInt());
                    break;
                }
                case 3 : {

                    printStudents();
                    break;
                }
                case 4: {

                    update();
                    break;
                }
                case 5 : {
                    System.exit(0);
                    break;
                }
                case 6 : {
                    System.out.println("""
                            1. For adding a student
                            2. For printing a particular Student
                            3. For printing the whole Student record
                            4. For updating a student record
                            5. For exiting""");
                    break;
                }
                default : {
                    System.out.println("Wrong input please try again !");
                }
            }
        }

    }
}
