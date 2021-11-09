import java.util.Scanner;
import java.lang.String;

public class Student_record {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Student stu = new Student("Arijit Chabri", 3327, 80, 20);
        Node head = new Node();
        System.out.println("""
        1. for insert.
        2. for delete.
        3. for print.
        4. for update.
        5. for search.
        6. for max grade.
        7. for exit.
        """);
        while(true){
            System.out.println("What is your choice :");
            choice = sc.nextInt();
            switch(choice){
                case 1:{
                    Student newStudent = new Student();
                    head.insert(newStudent);
                    break;
                }
                case 2:{
                    System.out.println("Enter the id you want to delete");
                    int id = sc.nextInt();
                    head.delete(id);
                    break;
                }
                case 3:{
                    head.print();
                    break;
                }
                case 4:{
                    System.out.println("Enter the id you want to update");
                    int id = sc.nextInt();
                    Student newStudent = new Student(id);
                    head.update(newStudent);
                    break;
                }

                case 5:{
                    System.out.println("Enter the id you want to search");
                    int id = sc.nextInt();
                    head.searchStudent(id);
                    break;
                }

                case 6:{
                    head.maxGradeCheck();
                    break;
                }



                case 7:{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Try again wrong input");
                    main(null);
                }
            }

        }
    }

}

class Student{
    private String name;
    private int id;
    private int grade;
    private int age;
    Scanner sc = new Scanner(System.in);

    public Student(String name, int id, int grade, int age) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.age = age;
    }

    public Student(){
        System.out.println("Enter the student details :- \n Name :");
        name = sc.nextLine();
        System.out.println("Id : ");
        id = sc.nextInt();
        System.out.println("Grade (in percentage) : ");
        grade = sc.nextInt();
        System.out.println("Age :");
        age = sc.nextInt();
    }

    public Student(int id){
        System.out.println("Enter the student details :- \n Name :");
        name = sc.nextLine();
        this.id = id;
        System.out.println("Grade (in percentage) : ");
        grade = sc.nextInt();
        System.out.println("Age :");
        age = sc.nextInt();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Name: " + name + "\n" + "ID: " + id + "\n" + "Grade: " + grade + "\n" + "Age: \n" + age;
    }
}

class Node{
    Student stu;
    Node next = null;

    Node(Student stu) {
        this.stu = stu;
        this.next = null;
    }

    Node(){
        this.next = null;
    }

    void insert(Student stu) {
        Node newNode = new Node(stu);
        newNode.next = this.next;
        this.next = newNode;
    }

    void delete(int id) {
        Node current = this;
        while (current.next != null) {
            if (current.next.stu.getId() == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("No Student Found");
    }

    void print() {
        Node current = this.next;
        while (current.next != null) {
            System.out.println(current.stu);
            current = current.next;
            return;
        }
        System.out.println("No record found");
    }

    void update(Student stu) {
        Node current = this;
        while (current.next != null) {
            if (current.next.stu.getId() == stu.getId()) {
                current.next.stu.setName(stu.getName());
                current.next.stu.setAge(stu.getAge());
                current.next.stu.setGrade(stu.getGrade());
                return;
            }
            current = current.next;
        }
        System.out.println("No Student found");
    }

    void searchStudent(int id){
        Node current = this.next;
        while (current != null) {
            if (id == current.stu.getId()){
                System.out.println(current.stu);
                return;
            }
        }
        System.out.println("No record found");
    }

    void maxGradeCheck() {
        Node current = this.next;
        int max = 0;
        int id = -1;
        while (current != null) {
            if(current.stu.getGrade() > max){
                id = current.stu.getId();
            }
        }
        searchStudent(id);
    }
}
