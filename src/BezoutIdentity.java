import java.util.Scanner;

public class BezoutIdentity {
    public static void main(String[] args) {
        Scanner capture = new Scanner(System.in);

        int a;
        int b;

        System.out.println("Digite primer término: ");
        a = capture.nextInt();
        System.out.println("Digite segundo término: ");
        b = capture.nextInt();

        // Encuentra el máximo común divisor y la identidad de Bézout para a y b
        int[] gcdAndBezout = calculateGCDAndBezout(a, b);
        int gcd = gcdAndBezout[0];
        int x = gcdAndBezout[1];
        int y = gcdAndBezout[2];

        // Imprime el máximo común divisor y la identidad de Bézout
        System.out.println("Máximo común divisor de " + a + " y " + b + ": " + gcd);
        System.out.println("Identidad de Bézout para " + a + " y " + b + ":");
        System.out.println("x = " + x + ", y = " + y);
    }

    // Calcula el máximo común divisor y la identidad de Bézout para a y b
    public static int[] calculateGCDAndBezout(int a, int b) {
        int x0 = 1, y0 = 0, x1 = 0, y1 = 1;

        while (b != 0) {
            int q = a / b;
            int temp = b;
            b = a % b;
            a = temp;

            int xTemp = x1;
            x1 = x0 - q * x1;
            x0 = xTemp;

            int yTemp = y1;
            y1 = y0 - q * y1;
            y0 = yTemp;
        }

        return new int[]{a, x0, y0};
    }
}

