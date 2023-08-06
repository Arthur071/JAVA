import java.util.Scanner;

public class Firstclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter the operator");
        System.out.println("type 1 for addition \ntype 2 for substraction \ntype 3 for multiplication \ntype 4 for division \ntype 5 for modulus");
        int c = sc.nextInt();
        switch(c){
            case 1 : System.out.println("sum is "  +  (a + b));
            break;
            case 2 : System.out.println("difference is " +  (a - b));
            break;
            case 3 : System.out.println("multiplication is " +  (a * b));
            break;
            case 4 : System.out.println("division is " +  (a / b));
            break;
            case 5 : System.out.println("modulus is " + (a % b));
            break;
            default : System.out.println("invalid operator");
        }

        
            
        

    }
    
}
