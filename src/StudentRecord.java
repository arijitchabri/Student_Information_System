import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class StudentRecord {

    static Scanner sc = new Scanner(System.in);

    static {
        System.out.println("How many Students :- ");
    }

    static int num = sc.nextInt();
    static int index = 0;
    static String[] names = new String[num];
    static int[] rollNumber = new int[num];

    public static int binarySearch(int element, int low, int high) {
        int mid = (high + low) / 2;
        if (low >= high) {
            return -1;
        } else if (rollNumber[mid] == element) {
            return mid;
        } else if (rollNumber[mid] > element) {
            return binarySearch(element, low, mid);
        } else {
            return binarySearch(element, mid + 1, high);
        }

    }

    public static void swap(int temp1, int temp2) {
        int rtemp = rollNumber[temp1];
        String ntemp = names[temp1];
        rollNumber[temp1] = rollNumber[temp2];
        names[temp1] = names[temp2];
        rollNumber[temp2] = rtemp;
        names[temp2] = ntemp;
    }

    public static void sort(int pos) {
        int temp = pos;
        if (index > 0) {
            try {
                while (rollNumber[temp] < rollNumber[temp - 1]) {
                    swap(temp, temp - 1);
                    temp--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

        }

    }

    public static void updateStudent(int pos) {
        System.out.println("Student roll :- ");
        int roll = sc.nextInt();
        if(binarySearch(roll, 0, index) == -1 || binarySearch(roll, 0, index) == pos){
            sc.nextLine();
            System.out.println("Student name :- ");
            String name = sc.nextLine();
            names[pos] = name;
            rollNumber[pos] = roll;
            sort(pos);
            System.out.println("Student record updated.");
            return;
        }
        System.out.println("The roll number exist can't add new student.");

    }

    public static void addStudent() {
        System.out.println("Student roll :- ");
        int roll = sc.nextInt();
        if(binarySearch(roll, 0, index) != -1){
            System.out.println("The roll number exist can't add new student.");
            return;
        }
        sc.nextLine();
        System.out.println("Student name :- ");
        String name = sc.nextLine();
        names[index] = name;
        rollNumber[index] = roll;
        sort(index);
        index++;
        System.out.println("Student added successfully");
    }

    public static void printStudent(int pos) {
        System.out.println("Name        Roll");
        int ind = binarySearch(pos, 0, index);
        if (pos == -1){
            System.out.println("Student does not exist.");
            return;
        }
        System.out.println(names[binarySearch(pos, 0, index)] + "        " + rollNumber[binarySearch(pos, 0, index)]);
    }

    public static void printStudents() {
        System.out.printf("Name %20s\n", "Roll");
        for (int i = 0; i < index; i++) {
            String name = String.format("%" + (-22) + "s", names[i]);
            System.out.println(name + rollNumber[i]);
        }
    }

    public static void update() {

        boolean flag = false;
        System.out.println("Roll of the student you want to update details :- ");
        int stu = sc.nextInt();
        int pos = binarySearch(stu, 0, index);
        if (pos != -1) {
            updateStudent(pos);
            flag = true;
            return;
        }
        try{

            if (!flag) {
                System.out.println("""
                    Sorry there is no such student in the records.\s
                    Press 1 if you wish to add this in records.
                    Press 2 for re-searching.
                    Press 3 to continue without adding.
                    """);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        addStudent();
                        break;

                    }
                    case 2: {
                        update();

                    }
                    default: {

                    }
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please give a valid input (int).");
        }

    }

    public static void delete(){
        System.out.println("Give the roll of the student you want to delete record ");
        int element = sc.nextInt();
        int pos = binarySearch(element, 0, index);
        if (pos == -1){
            System.out.println("No such student exists. ");
        }
        else{
            while(pos < index - 1){
                swap(pos, pos + 1);
                pos++;
            }
            index--;
        }
    }


    public static void main(String[] args) {
        int choice;
        System.out.println("""
                1. For adding a student
                2. For printing a particular Student
                3. For printing the whole Student record
                4. For updating a student record
                5. For deleting a student record
                6. For exiting""");
        try{

            while (true) {
                System.out.println("\n----------------------------------------------\n");
                System.out.println("press 7 for help ! \n What is your choice :- ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        addStudent();
                        break;
                    }
                    case 2: {
                        System.out.println("Give me the index number :- ");
                        printStudent(sc.nextInt());
                        break;
                    }
                    case 3: {

                        printStudents();
                        break;
                    }
                    case 4: {

                        update();
                        break;
                    }
                    case 5: {
                        delete();
                        break;
                    }
                    case 6: {
                        System.exit(0);
                        break;
                    }
                    case 7: {
                        System.out.println("""
                            1. For adding a student
                            2. For printing a particular Student
                            3. For printing the whole Student record
                            4. For updating a student record
                            5. For deleting a student record
                            6. For exiting""");
                        break;
                    }
                    default: {
                        System.out.println("Wrong input please try again !");
                    }
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please give a valid input (int). ");
            main(null);
        }
    }
}


