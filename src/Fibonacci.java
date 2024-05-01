import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner capture = new Scanner(System.in);
        int n;
        System.out.println("Digite numero de secuencia que desee realizar: " + "\t");
        n = capture.nextInt();
        System.out.println("Secuencia de Fibonacci hasta " + n + " términos:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) +	"\n");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
