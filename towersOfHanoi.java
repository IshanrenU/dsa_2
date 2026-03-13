import java.util.*;
import java.io.*;


public class towersOfHanoi
{


    static int towers(int n, int src, int det, int level)
   {

     
    
        if(n == 1)
        {
            System.out.println("Recursion Level : " + level); // recursion Level
            moveDisk( n, src,det);
        }
        else{
            int tmp = 6 - src - det;
            towers(n-1,src,tmp,level +1);
            System.out.println("Recursion Level : " + level); // recursion Level
            moveDisk(n ,src, det);
            towers(n-1,tmp,det, level +1);
        }
      


        return 0;
    }

    static void moveDisk(int disk, int src, int det) // prints the moving process
     {
            System.out.println(" Moving Disk  "+ disk + " from " + src + " to " + det);
            System.out.println( "n = " + disk + " src = " + src + " des = " + det);
        

    }

     static int input()
    {
        System.out.println("Enter the number of disks");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        return num;
    }



    public static void main(String [] args)
    {
        int diskNum = input();
         int src = 1;
         int dest = 3;
         towers(diskNum, src, dest, 1);


    }




}