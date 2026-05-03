import java.io.*;

public class HashTableIO
{
    // Load data from CSV into an existing hash table
    public static void loadFromCSV(String filename, DSAHashTable table)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");

                if (parts.length < 2)
                {
                    parts = line.split("\t"); // fallback for tab-separated
                }

                if (parts.length >= 2)
                {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    table.put(key, value); // use existing hash table
                }
            }

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void saveToCSV(String filename, DSAHashTable table)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (int i = 0; i < table.getSize(); i++)
            {
                DSAHashEntry entry = table.getEntry(i);

                if (entry.getState() == 1) // only FULL entries
                {
                    bw.write(entry.getKey() + "," + entry.getValue());
                    bw.newLine();
                }
            }

            bw.close();
        }
        catch (IOException e)
        {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

