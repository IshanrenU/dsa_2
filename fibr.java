public class fibr {

    public static int fibrecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }

        int fibval = 0;

        if (n == 0) {
            fibval = 0;
        } 
        else if (n == 1) {
            fibval = 1;
        } 
        else {
            return fibrecursive(n - 1) + fibrecursive(n - 2);
        }

        return fibval;
    }

    public static int fibIterative(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }

        int fibVal = 0;
        int currVal = 1;
        int lastVal = 0;

        if (n == 0) {
            fibVal = 0;
        } 
        else if (n == 1) {
            fibVal = 1;
        } 
        else {
            for (int ii = 2; ii <= n; ii++) {
                fibVal = currVal + lastVal;
                lastVal = currVal;
                currVal = fibVal;
            }
        }

        return fibVal;
    }

    public static void main(String[] args) {
        try {
            int n = 1000;

            System.out.println("Recursive Fibonacci: " + fibrecursive(n));
            System.out.println("Iterative Fibonacci: " + fibIterative(n));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}