import java.util.Scanner;

public class FunctionsQ1 {
    public static int Sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = Sum(n);
        System.out.println(sum);

    }

}
