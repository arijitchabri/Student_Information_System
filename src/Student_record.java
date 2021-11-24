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
            System.out.println("The Student exists.\n Details are : \n");
            databaseHandler.getStudentDetails(id);
            return;
        }
        System.out.println("Student does not exits with id : " + id);
        databaseHandler.getStudentDetails(id);
    }

    static void update(){
        System.out.println("Enter the id of the student you want to rewrite : ");
        int id = sc.nextInt();
        if (!student_record.contains(id)){
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

    static Exam examCreator(){
        System.out.println("Give the id you want modify Exam details : ");
        int id = sc.nextInt();
        int sem_1, sem_2, sem_3, sem_4, sem_5, sem_6;
        if (student_record.contains(id)){
            System.out.println("Enter the marks from sem 1 to sem 6 : ");

            sem_1 = sc.nextInt();
            sem_2 = sc.nextInt();

            sem_3 = sc.nextInt();
            sem_4 = sc.nextInt();

            sem_5 = sc.nextInt();
            sem_6 = sc.nextInt();

            Exam exam = new Exam(id, sem_1, sem_2, sem_3, sem_4, sem_5, sem_6);
            return exam;
        }
        System.out.println("There is no student having the id : " + id);
        return null;
    }

    static void addExamDetails(){
        Exam exam = examCreator();
        if(exam != null){
            databaseHandler.addExamDetails(exam);
        }

    }

    static void updateExamDetails(){
        Exam exam = examCreator();
        if(exam != null){
            databaseHandler.updateMarks(exam);
        }
    }

    static void deleteExamDetails(){
        System.out.println("Give the id you want to delete Exam details : ");
        int id = sc.nextInt();
        if (student_record.contains(id)){
            databaseHandler.deleteExamDetails(id);
        }
        else{
            System.out.println("There is no student having id : " + id);
        }
    }

    static void getExamDetails(){
        System.out.println("Give the id you want to search Exam details : ");
        int id = sc.nextInt();
        if (student_record.contains(id)){
            databaseHandler.getExamDetails(id);
        }
        else{
            System.out.println("There is no student having id : " + id);
        }
    }

    static void getAllDetails(){

    }
    static void runYourOwnQuarry(){

    }


    public static void main(String[] args) {
        loadData();
        System.out.println(
                """
                
                Enter Your Choice :
                
                0.  Show the menu again
                1.  Add Student
                2.  Search Student
                3.  Update Student
                4.  Delete Student
                5.  Show Students
                6.  Add Exam detail
                7.  Update Exam details
                8.  Search Exam details
                9.  Delete Exam details
                10. Show Exam details
                11. Show full record
                12. Run your custom quarry
                
                13. Exit
                
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

                    case 8:
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

                    case 6:{
                        addExamDetails();
                        break;
                    }

                    case 7:{
                        updateExamDetails();
                        break;
                    }


                    case 9:{
                        deleteExamDetails();
                        break;
                    }

                    case 10:{
                        getExamDetails();
                        break;
                    }

                    case 11:{
                        getAllDetails();
                        break;
                    }

                    case 12: {
                        runYourOwnQuarry();
                        break;
                    }


                    case 13: {
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

class Exam{

    int id, sem_1, sem_2, sem_3, sem_4, sem_5, sem_6;
    Exam(int id, int sem_1, int sem_2, int sem_3, int sem_4, int sem_5, int sem_6){
        this.id = id;
        this.sem_1 = sem_1;
        this.sem_2 = sem_2;
        this.sem_3 = sem_3;
        this.sem_4 = sem_4;
        this.sem_5 = sem_5;
        this.sem_6 = sem_6;
    }
}
