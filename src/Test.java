import java.util.Scanner;
import java.lang.String;

public class Test {
    static Scanner sc = new Scanner(System.in);
    static void fun(){
        int i = sc.nextInt();
        String name = sc.nextLine();

        System.out.println(name + "       " + i);
    }
    public static void main(String[] args) {
        fun();
    }
}