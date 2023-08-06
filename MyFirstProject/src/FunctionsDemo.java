import java.util.Scanner;

public class FunctionsDemo {
    public static int printMyName(int a , int b ){
        int add = a+b;
        
        return add;

    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int add = printMyName(a, b);
        System.out.println(add);
    }
    
}
