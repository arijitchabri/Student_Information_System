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

            ps.executeUpdate();

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

            ps.executeUpdate();

        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void delete(int id){
        
        try{
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
            System.out.println("""
DEPT       Name                      ID""");
            printFormatter(rs);

        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void getStudentDetails(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("select * from exam_details left join student on exam_details.id = student.id where student.id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            System.out.println("""
DEPT       Name                     ID    Sem1  Sem2  Sem3  Sem4  Sem5  Sem6""");
            while(rs.next()){
                String str;
                for (int i = rs.getMetaData().getColumnCount(); i > 0 ; i--){
                    if (i == 7)continue;
                    if (rs.getObject(i) instanceof  String){
                        str = rs.getObject(i).toString();
                        System.out.print(truncate(str) + "     ");
                    }
                    else{
                        System.out.print(rs.getObject(i) + "     ");
                    }
                }
                System.out.println();
            }

        }
        catch (SQLException se){
            se.printStackTrace();
        }
        finally {
            System.out.println("\n");
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


    static void addExamDetails(Exam exam){
        try{

            PreparedStatement ps = conn.prepareStatement("insert into exam_details values (?, ?, ?, ?, ?, ?, ?)" );

            ps.setInt(1, exam.sem_1);
            ps.setInt(2, exam.sem_2);
            ps.setInt(3, exam.sem_3);
            ps.setInt(4, exam.sem_4);
            ps.setInt(5, exam.sem_5);
            ps.setInt(6, exam.sem_6);
            ps.setInt(7, exam.id);

            ps.executeUpdate();


        }catch (SQLException se){
            se.printStackTrace();
        }

    }

    static void updateMarks(Exam exam){
        try{
            PreparedStatement ps = conn.prepareStatement("update exam_details set sem_1 = ?, sem_2 = ?, sem_3 = ?, sem_4 = ?, sem_5 = ?, sem_6 = ? where id = ?");
            ps.setInt(1, exam.sem_1);
            ps.setInt(2, exam.sem_2);
            ps.setInt(3, exam.sem_3);
            ps.setInt(4, exam.sem_4);
            ps.setInt(5, exam.sem_5);
            ps.setInt(6, exam.sem_6);
            ps.setInt(7, exam.id);

            ps.executeUpdate();
        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void deleteExamDetails(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("delete from exam_details where id = ?");
            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch (SQLException se){
            se.printStackTrace();
        }

    }

    static void getExamDetails(int id){
        try{
            System.out.println("id   sem6  sem5  sem4  sem3  sem2  sem1");
            PreparedStatement ps = conn.prepareStatement("select * from exam_details where id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            printFormatter(rs);
        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void getExamDetails(){
        try{
            PreparedStatement ps = conn.prepareStatement("select * from exam_details");

            rs = ps.executeQuery();

            System.out.println("""
ID    Sem1  Sem2  Sem3  Sem4  Sem5  Sem6""");
            printFormatter(rs);
        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void customQuarry(String quarry){
        try{
            PreparedStatement ps = conn.prepareStatement(quarry);

            rs = ps.executeQuery();

            printFormatter(rs);
        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }

    static void getAllDetails(){
        try{
            PreparedStatement ps = conn.prepareStatement("select * from exam_details left join student on student.id = exam_details.id");

            rs = ps.executeQuery();
            System.out.println("""
DEPT       Name                     ID    Sem1  Sem2  Sem3  Sem4  Sem5  Sem6""");
            while(rs.next()){
                String str;
                for (int i = rs.getMetaData().getColumnCount(); i > 0 ; i--){
                    if (i == 7)continue;
                    if (rs.getObject(i) instanceof  String){
                        str = rs.getObject(i).toString();
                        System.out.print(truncate(str) + "     ");
                    }
                    else{
                        System.out.print(rs.getObject(i) + "     ");
                    }
                }
                System.out.println();
            }
        }
        catch (SQLException se){
            se.printStackTrace();
        }
        finally {
            System.out.println("\n");
        }
    }

    static String truncate(String str){
        if (str.length() < 8){
            for (int i = 8; i > str.length(); i--){
                str = str + " ";
            }
            return str;
        }
        else{
            int len = 20 - str.length();
            if (len > 0){
                for (int i = 0; i <= len; i++){
                    str = str + " ";
                }
                return str;
            }
            else{
                str = str.substring(0,19);
            }
            return str;
        }
    }

    static void printFormatter(ResultSet rs){
        try{
            while(rs.next()){
                String str;
                for (int i = rs.getMetaData().getColumnCount(); i > 0 ; i--){
                    if (rs.getObject(i) instanceof  String){
                        str = rs.getObject(i).toString();
                        System.out.print(truncate(str) + "     ");
                    }
                    else{
                        System.out.print(rs.getObject(i) + "     ");
                    }
                }
                System.out.println();
            }
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        finally {
            System.out.println("\n");
        }
    }


    public static void main(String[] args) {
        getStudentsDetails();
        getStudentDetails(1);
        getAllDetails();
        getExamDetails();
        getExamDetails(1);
    }
}
