import java.sql.*;
import java.util.ArrayList;


public class DatabaseHandler {

    // Handler            ...........................................................
    static final String DB_URL = "jdbc:mysql://localhost/student_information_system";
    final static String USER = "root";
    final static String PASS = "sudo";

    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from student";
            rs = stmt.executeQuery(sql);


        }
        catch (SQLException se){
            se.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    // Student Record     ............................................................

    static void add(Student stu){
        try{
            PreparedStatement ps = conn.prepareStatement("insert into student values (?, ?, ?)");
            ps.setInt(1, stu.id);
            ps.setString(2, stu.name);
            ps.setString(3, stu.dep);

            int er = ps.executeUpdate();

        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void update(Student stu){
        try{
            PreparedStatement ps = conn.prepareStatement("update student set name = ?, dept = ? where id = ?");
            ps.setString(1, stu.name);
            ps.setString(2, stu.dep);
            ps.setInt(3, stu.id);

            int er = ps.executeUpdate();

        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void delete(int id){
        
        try{
            String sql = "delete from student where id = ?";
            PreparedStatement ps = conn.prepareStatement("delete from student where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException se){
            se.printStackTrace();
        }

    }

    static void getStudentsDetails(){
        try{
            String sql = "select * from student";
            rs = stmt.executeQuery(sql);
            System.out.println("\nThe Database is : \n");
            while(rs.next()){
                System.out.print("id : " + rs.getInt("id"));
                System.out.print(" name : "+rs.getString("name"));
                System.out.print(" dept : " + rs.getString("dept"));
                System.out.println();
            }
            System.out.println();

        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void getStudentDetails(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("select * from student where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.print("id : " + rs.getInt("id"));
                System.out.print(" name : "+rs.getString("name"));
                System.out.print(" dept : " + rs.getString("dept"));
                System.out.println();
            }

        }
        catch (SQLException se){
            se.printStackTrace();
        }

    }

    static void loadData(ArrayList student_record){
        try{
            String sql = "select id from student";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                student_record.add(rs.getInt("id"));
            }
        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }


  // Exam Record          ..............................................................


    void addExamDetails(){

    }

    void updateMarks(){

    }

    void deleteExamDetails(){

    }

    void getExamDetails(){

    }

    void getExamDetails(int id){

    }


    public static void main(String[] args) {

    }
}
