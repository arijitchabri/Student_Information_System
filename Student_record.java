import java.util.*;


public class Student_record {

    static ArrayList<Integer> student_record = new ArrayList<>();

    static DatabaseHandler databaseHandler = new DatabaseHandler();

    static Scanner sc = new Scanner(System.in);


    static void addStudent(){

        int id;
        String name ;
        String dep ;

        System.out.println("Student id : ");
        id = sc.nextInt();

        if (student_record.contains(id)){
            System.out.println("The student exists with the same id. ");
            return;
        }
        sc.nextLine();
        System.out.println("Student name : ");
        name = sc.nextLine();
        System.out.println("Dep Code : ");
        dep = sc.nextLine();
        student_record.add(id);

        Student stu = new Student(id, name, dep);
        databaseHandler.add(stu);

    }

    static void search(){
        System.out.println("Enter the id of the student you want to fetch : ");
        int id = sc.nextInt();
        if (student_record.contains(id)){
            System.out.println("The Student exists.\n Details are : ");
            return;
        }
        System.out.println("Student does not exits with id : " + id);
        databaseHandler.getStudentDetails(id);
    }

    static void update(){
        System.out.println("Enter the id of the student you want to rewrite : ");
        int id = sc.nextInt();
        if (student_record.contains(id) == false){
            System.out.println("Student does not exits with id : " + id);
            return;
        }
        sc.nextLine();
        System.out.println("Student name : ");
        String  name = sc.nextLine();
        System.out.println("Dep Code : ");
        String  dep = sc.nextLine();

        Student stu = new Student(id, name, dep);
        databaseHandler.update(stu);
    }

    static void delete(){
        System.out.println("Enter the id of the student you want to delete : ");
        int id = sc.nextInt();
        if (student_record.contains(id) == false){
            System.out.println("Student does not exits with id : " + id);
            return;
        }
        databaseHandler.delete(id);
    }

    static void getStudents(){
        databaseHandler.getStudentsDetails();
    }

    static void loadData(){
        databaseHandler.loadData(student_record);
        System.out.println("The students are : " + student_record);
    }


    public static void main(String[] args) {
        loadData();
        System.out.println(
                """
                
                Enter Your Choice :
                
                0. Show the menu again
                1. Add Student
                2. Search Student
                3. Update Student
                4. Delete Student
                5. Show Students
                6. Exit
                
                """
        );
        try{

            while(true){
                System.out.print("\nWhat is your choice press 0 for menu : ");
                int choice = sc.nextInt();

                switch (choice){
                    case 0:{
                        main(null);
                        break;
                    }

                    case 1:{
                        addStudent();
                        break;
                    }

                    case 2:{
                        search();
                        break;
                    }

                    case 3:{
                        update();
                        break;
                    }

                    case 4:{
                        delete();
                        break;
                    }

                    case 5:{
                        getStudents();
                        break;
                    }

                    case 6: {
                        System.exit(0);
                    }

                    default:{
                        System.out.println("Wrong entry pls try again. ");
                        main(null);
                    }

                }
            }
        }catch (InputMismatchException e){
            main(null);
        }
    }
}

class Student{

    int id;
    String name ;
    String dep ;

    Student(int id, String name, String dep){

        this.id = id;
        this.name = name;
        this.dep = dep;

    }
}
