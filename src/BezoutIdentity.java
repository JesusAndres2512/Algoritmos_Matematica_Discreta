public class BezoutIdentity {
    public static void main(String[] args) {
        int a = 129;
        int b = 36;

        // Encuentra la identidad de Bézout para a y b
        int[] bezout = bezoutIdentity(a, b);

        // Imprime la identidad de Bézout
        System.out.println("Identidad de Bézout para " + a + " y " + b + ":");
        System.out.println("x = " + bezout[0] + ", y = " + bezout[1]);
    }

    // Encuentra la identidad de Bézout para a y b
    public static int[] bezoutIdentity(int a, int b) {
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

        return new int[]{x0, y0};
    }
}
