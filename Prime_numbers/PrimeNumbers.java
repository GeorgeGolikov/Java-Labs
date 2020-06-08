package ru.spbstu.labsSpring2020.Prime_numbers.PrimeNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class PrimeNumbers
{
   public static void main(String[] args) throws IOException
   {
       try
       {
           if (args.length != 2)
           {
               throw new IOException("Wrong args!");
           }
           else
           {
               Scanner sc1 = new Scanner(args[0]);
               Scanner sc2 = new Scanner(args[1]);

               long begin;
               long end;

               if (sc1.hasNextLong())
               {
                   begin = sc1.nextLong();
               }
               else
               {
                   throw new IOException("Wrong args!");
               }

               if (sc2.hasNextLong())
               {
                   end = sc2.nextLong();
               }
               else
               {
                   throw new IOException("Wrong args!");
               }

               if (begin <= end)
               {
                   System.out.println("Interval: [" + begin + ";" + end + "]");
                   System.out.print("Prime numbers in the given interval: ");
                   if (begin <= 0 && end <= 0) // отрицательный промежуток
                   {
                       System.out.println("No prime numbers in the given interval.");
                   }
                   else // часть промежутка отрицательная, часть - положительная или же весь промежуток положительный
                   {
                       if (begin <= 0) begin = 1;
                       for (long i = begin; i <= end; ++i)
                       {
                           boolean flag = true;
                           for (long j = 2; j < (long)sqrt(i) + 1; ++j)
                           {
                               if (i % j == 0)
                               {
                                   flag = false;
                                   break;
                               }
                           }
                           if (flag) System.out.print(i + " ");
                       }
                       System.out.println("");
                   }
               }
               else
               {
                   throw new IOException("Wrong args! End is less than begin.");
               }
           }
       }
       catch (IOException e)
       {
           System.err.println(e.getMessage());
       }
   }
}
