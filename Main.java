public class Main{
    public static void main(String[] args){
        DSAHashTable table = new DSAHashTable(11);

        // Load file
        HashTableIO.loadFromCSV("RandomNames7000.csv", table);

        // Test lookup
        System.out.println(table.get("14495655"));

        // Save table
        HashTableIO.saveToCSV("output.csv", table);
    }
}