import java.util.Scanner;
public class Test {
    static Scanner sc = new Scanner(System.in);
    static void fun(){
        String name = sc.nextLine();
        int i = sc.nextInt();
        System.out.println(name + "       " + i);
    }
    public static void main(String[] args) {
        fun();
    }
}
