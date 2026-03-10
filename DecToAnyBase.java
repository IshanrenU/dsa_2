public class DecToAnyBase {

    // Recursive conversion with exception handling
    static int convert(int n, int base) {
        if (n < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base must be between 2 and 16");
        }

        if (n == 0) {  // base case
            return 0;
        }

        return convert(n / base, base) * 10 + (n % base);
    }

    public static void main(String[] args) {
        try {
            int number = 25; // decimal number
            int base = 2;    // base (2–16)

            int result = convert(number, base);

            System.out.println("Decimal: " + number);
            System.out.println("Base " + base + ": " + result);

            // Test with invalid input
            int invalidNumber = -5;
            int invalidBase = 20;
            convert(invalidNumber, 2);  // throws exception
            convert(10, invalidBase);   // throws exception

        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
/*reference link-https://runestone.academy/ns/books/published/javads/recursion_converting-an-integer-to-a-string-in-any-base.html */