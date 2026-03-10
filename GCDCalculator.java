public class GCDCalculator {

    // Recursive GCD with exception handling
    static int gcd(int a, int b) {
        // Check for invalid input
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("GCD is not defined for negative numbers");
        }
        // Check for both zero
        if (a == 0 && b == 0) {
            throw new ArithmeticException("GCD is undefined for both numbers being zero");
        }

        if (a == 0)
            return b;  // base case
        else
            return gcd(b % a, a);  // recursive call
    }

    public static void main(String[] args) {
        try {
            int a = 20, b = 28;
            System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));

            // Test negative number
            int x = -5, y = 10;
            System.out.println(gcd(x, y));

        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

/*reference-codedost.com
link-https://codedost.com/java/methods-and-recursion-in-java/java-program-to-find-gcd-hcf-using-euclidean-algorithm-using-recursion/?utm_source=chatgpt.com */