public class ExtendedEuclideanAlgorithm {
    public static void main(String[] args) {
        int a = 129;
        int b = 36;

        // Encuentra el máximo común divisor y los coeficientes de Bezout para a y b
        int[] result = extendedEuclideanAlgorithm(a, b);

        // Imprime el resultado
        System.out.println("El máximo común divisor de " + a + " y " + b + " es: " + result[0]);
        System.out.println("Coeficientes de Bézout: x = " + result[1] + ", y = " + result[2]);
    }

    // Algoritmo extendido de Euclides para encontrar el máximo común divisor y los coeficientes de Bezout
    public static int[] extendedEuclideanAlgorithm(int a, int b) {
        int x = 0, y = 1, lastx = 1, lasty = 0, temp;
        System.out.println("Resto\tCociente\t\t  x\t\t   y");
        while (b != 0) {
            int q = a / b;
            int r = a % b;

            System.out.println(r + "\t\t" + q + "\t\t" + x + "\t\t" + y);

            a = b;
            b = r;

            temp = x;
            x = lastx - q * x;
            lastx = temp;

            temp = y;
            y = lasty - q * y;
            lasty = temp;
        }
        System.out.println(a + "\t\t" + "-" + "\t\t" + lastx + "\t\t" + lasty);
        return new int[]{a, lastx, lasty};
    }
}

