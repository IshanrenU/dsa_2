public class factorial {

    // Iterative factorial with exception handling
    public long calcNFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        long nFactorial = 1;
        for (int ii = n; ii >= 2; ii--) {
            nFactorial *= ii;
        }
        return nFactorial;
    }

    // Recursive factorial with exception handling
    public long calcNFactorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        if (n == 0) {
            return 1;
        } else {
            return n * calcNFactorialRecursive(n - 1);
        }
    }

    public static void main(String[] args) {
        factorial fact = new factorial();

        try {
            int n = 5;  // Change this to test different values
            System.out.println("Iterative factorial of " + n + " = " + fact.calcNFactorial(n));
            System.out.println("Recursive factorial of " + n + " = " + fact.calcNFactorialRecursive(n));

            // Test with a negative number to see exception handling
            int negativeTest = -3;
            System.out.println(fact.calcNFactorial(negativeTest));

        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}