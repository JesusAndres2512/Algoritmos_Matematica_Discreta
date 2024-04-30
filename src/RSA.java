import java.math.BigInteger;

public class RSA {
    private final BigInteger p;
    private final BigInteger q;
    private BigInteger n;
    private BigInteger phi_n;
    private BigInteger e;
    private BigInteger d;

    public RSA(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        generateKeys();
    }

    private void generateKeys() {
        // Calcular n
        n = p.multiply(q);

        // Calcular φ(n)
        phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Elegir un valor para (e)
        e = BigInteger.valueOf(5); 

        // Calcular d (inverso multiplicativo de (e) módulo φ(n))
        d = extendedEuclidean(e, phi_n)[1];
        if (d.compareTo(BigInteger.ZERO) < 0) {
            // Si d es negativo, sumar phi_n para obtener un valor positivo
            d = d.add(phi_n);
        }
    }
    
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(d, n);
    }

    private BigInteger[] extendedEuclidean(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[]{a, BigInteger.ONE, BigInteger.ZERO};
        } else {
            BigInteger[] vals = extendedEuclidean(b, a.mod(b));
            BigInteger d = vals[0];
            BigInteger p = vals[2];
            BigInteger q = vals[1].subtract(a.divide(b).multiply(vals[2]));
            return new BigInteger[]{d, p, q};
        }
    }

    public void printKeys() {
        System.out.println("Clave pública (n, e): (" + n + ", " + e + ")");
        System.out.println("Clave privada (n, d): (" + n + ", " + d + ")");
    }

    public void printValue() {
        System.out.println("Valor de p: " + p);
        System.out.println("Valor de q: " + q);
        System.out.println("Valor de φ(n): " + phi_n);
    }

    public static void main(String[] args) {
        BigInteger p = new BigInteger("13");
        BigInteger q = new BigInteger("19");

        RSA rsa = new RSA(p, q);
        
        rsa.printValue();
        rsa.printKeys();

        String message = "Hola mundo";
        BigInteger plaintext = new BigInteger(message.getBytes());

        // Cifrado
        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Mensaje cifrado: " + ciphertext);

        // Descifrado
        BigInteger decryptedMessage = rsa.decrypt(ciphertext);
        System.out.println("Mensaje descifrado: " + new String(decryptedMessage.toByteArray()));
    }
    
}
