public class DecToAnyBase {

    // Recursive conversion with exception handling


    public static String convert(int n, int base) {

        // Error handling
        if (n < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base must be between 2 and 16");
        }

        String[] digitStrings = {"0", "1", "2", "3", "4", "5",
                                 "6", "7", "8", "9", "A", "B",
                                 "C", "D", "E", "F"};

        // Base case
        if (n < base) {
            return digitStrings[n];
        }

        // Recursive case
        int remainder = n % base;
        return convert(n / base, base) + digitStrings[remainder];
    }

    public static void main(String[] args) {

        try {

            System.out.println("13 in base 2: " + convert(13, 2));     
            System.out.println("1066 in base 16: " + convert(1066, 16));

            // Example of invalid input
            System.out.println(convert(-5, 2));

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }
    
}
}
/*reference link-https://runestone.academy/ns/books/published/javads/recursion_converting-an-integer-to-a-string-in-any-base.html */
