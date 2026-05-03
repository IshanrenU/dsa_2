import java.io.NotActiveException;

public class DSAHashTable{
   

    private DSAHashEntry[] hashArray;
    private int count;
    private int size;
    private static final double UPPER_LOAD = 0.7;
    private static final double LOWER_LOAD = 0.3;
    public DSAHashTable(int tableSize)
    {
        size = tableSize;
        count = 0;
        hashArray = new DSAHashEntry[size];

        for (int i = 0; i < size; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }
    }
    private int hash(String key)
   {
    int hashIdx = 0;

    for (int i = 0; i < key.length(); i++)
    {
        hashIdx = (hashIdx * 31 + key.charAt(i)) % size;
    }

    return hashIdx;
    }
    private int stepHash(String key)
{
    int hashVal = 0;

    // Convert string to number (same style as main hash)
    for (int i = 0; i < key.length(); i++)
    {
        hashVal = (hashVal * 31 + key.charAt(i));
    }

    // Secondary hash (must NOT be zero)
    int step = 7 - (hashVal % 7);

    return step;
}
    private double getLoadFactor()
{
    return (double) count / size;
}
    private void resize(int newSize)
{
    DSAHashEntry[] oldArray = hashArray;

    hashArray = new DSAHashEntry[newSize];
    size = newSize;
    count = 0;

    for (int i = 0; i < size; i++)
    {
        hashArray[i] = new DSAHashEntry();
    }

    // Rehash all valid entries
    for (int i = 0; i < oldArray.length; i++)
    {
        if (oldArray[i].state == 1)
        {
            put(oldArray[i].key, oldArray[i].value);
        }
    }
}
private int nextPrime(int n)
{
    while (true)
    {
        if (isPrime(n)) return n;
        n++;
    }
}

private boolean isPrime(int n)
{
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++)
    {
        if (n % i == 0) return false;
    }
    return true;
}
    public Object get(String inKey)
   {
    int hashIdx = hash(inKey);
    int origIdx = hashIdx;
    boolean found=false;
    boolean giveUp=false;
    int step=stepHash(inKey);

    while (!found && !giveUp) // not FREE
    {
        if (hashArray[hashIdx].state == 0 )
        {
            giveUp=true; // found
        }
        else if(hashArray[hashIdx].key.equals(inKey)){
            found=true;
        }
        else{
            hashIdx=(hashIdx+step)%hashArray.length;
            if(hashIdx==origIdx){
                giveUp=true;
            }
        }
    }
        if(!found){
            throw new RuntimeException("value not found");
        }
        Object retValue=hashArray[hashIdx].value;
        return retValue;

// empty or removed slot
    }
    public void put(String inKey, Object inValue)
{   if (getLoadFactor() > UPPER_LOAD)
        {
        resize(nextPrime(size * 2));
        }
    int hashIdx = hash(inKey);
    int origIdx = hashIdx;
    int step=stepHash(inKey);

    boolean found = false;
    boolean giveUp = false;
    int firstRemoved = -1;

    while (!found && !giveUp)
    {
        if (hashArray[hashIdx].state == 0)
        {
            giveUp = true;
        }
        else if (hashArray[hashIdx].state == 1 &&
                 hashArray[hashIdx].key.equals(inKey))
        {
            found = true;
        }
        else
        {
            if (hashArray[hashIdx].state == -1 && firstRemoved == -1)
            {
                firstRemoved = hashIdx;
            }

            hashIdx = (hashIdx + step) % hashArray.length;

            if (hashIdx == origIdx)
            {
                giveUp = true;
            }
        }

    }

    // If key already exists → update
    if (found)
    {
        hashArray[hashIdx].value = inValue;
    }
    else
    {
        // Insert into first removed if available
        if (firstRemoved != -1)
        {
            hashIdx = firstRemoved;
        }

        hashArray[hashIdx].key = inKey;
        hashArray[hashIdx].value = inValue;
        hashArray[hashIdx].state = 1;
        count++;
    }

}
    public void remove(String inKey)
{   if (getLoadFactor() < LOWER_LOAD && size > 10)
    {
    resize(nextPrime(size / 2));
    }
    int hashIdx = hash(inKey);
    int origIdx = hashIdx;
    int step=stepHash(inKey);
    boolean found = false;
    boolean giveUp = false;

    while (!found && !giveUp)
    {
        if (hashArray[hashIdx].state == 0)
        {
            giveUp = true;
        }
        else if (hashArray[hashIdx].state == 1 &&
                 hashArray[hashIdx].key.equals(inKey))
        {
            found = true;
        }
        else
        {
            hashIdx = (hashIdx + step) % hashArray.length;

            if (hashIdx == origIdx)
            {
                giveUp = true;
            }
        }
    }

    if (!found)
    {
        throw new RuntimeException("Key not found");
    }

    // Mark as REMOVED (IMPORTANT)
    hashArray[hashIdx].key = "";
    hashArray[hashIdx].value = null;
    hashArray[hashIdx].state = -1;

    count--;
}   
public boolean hasKey(String inKey)
{
    int hashIdx = hash(inKey);
    int origIdx = hashIdx;
    int step=stepHash(inKey);

    boolean found = false;
    boolean giveUp = false;

    while (!found && !giveUp)
    {
        if (hashArray[hashIdx].state == 0)
        {
            giveUp = true;
        }
        else if (hashArray[hashIdx].state == 1 &&
                 hashArray[hashIdx].key.equals(inKey))
        {
            found = true;
        }
        else
        {
            hashIdx = (hashIdx + step) % hashArray.length;

            if (hashIdx == origIdx)
            {
                giveUp = true;
            }
        }
    }

    return found;

}
    public int getSize()
{
    return size;
}

public DSAHashEntry getEntry(int index)
{
    return hashArray[index];
}

}