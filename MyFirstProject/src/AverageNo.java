import java.util.Scanner;

public class AverageNo {
    public static int AverageNumber(int a, int b, int c){
        int avg = (a+b+c)/3;
        return avg;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int avg = AverageNumber(a, b, c);
        System.out.println(avg);
    }
}
