import java.sql.*;

public class Database {

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


    static void show(){
        try{
            String sql = "select * from student";
            rs = stmt.executeQuery(sql);
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

    public static void main(String[] args) {
        show();
    }
}
