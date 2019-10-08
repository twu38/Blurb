/*  TestBlurb.java
 *   
 *  To use recursion in the program to determine whether a string is a valid Blurb.   
 *  
 *  @author    TICHIN WU
 *  @version   1.8.0
 */

import java.util.Scanner;

public class TestBlurb
{
   private static String input,sub;
   private static int i,startOfNextWhatszit;
   
   public static void main (String[] arg)
   {
       // get the input from the user.
       inputBlurb();
       
       // check valid Whoozit and return the beginning position of following string
       int startOfNextWhatszit=checkWhoozit(input);
       
       // then find the string after first Whoozit-sub.
       if(startOfNextWhatszit!=-1&&startOfNextWhatszit<input.length())
       {
           // find the sub string.
           sub=input.substring(startOfNextWhatszit);
           // then check it is a Whatszit.
           checkWhatszit(sub);
            
           if(checkWhatszit(sub)==false)
               System.out.print(" this is not a blurb");
           else
               System.out.print(" this is a blurb");    
       }
       else// if the beginning is not x0 or xy(s) or the string is shoter then a blurb.
       {
           System.out.print(" this is not a blurb");
       }        
   }
   
   // let user to create a string and return 
   public static String inputBlurb()
   {
      Scanner keyboard=new Scanner(System.in);
     
      System.out.println("Input a string(suggest to use combination of x0,xy(s),qd,qz): ");
      input=keyboard.nextLine();
     
      return input;
   }
   
   //Whoozit starts with 'x' followed by '0' or 'y's
   public static int checkWhoozit(String s)
   {     
         i=0;
         if(s.charAt(i)=='x')
         {             
            i++; 
            // xy(s)....
            while ((i < s.length() && s.charAt(i) == 'y')&&s.charAt(i+1) == 'y') 
            {
               i=i+2;
            }
            // x0
            while (i < s.length()&&s.charAt(i)=='0')
            {
               i++;
            }            
            
            return i;            
         }                
         else 
         {
             // It is not a Whoozit.
             return -1;
         }
    }
    
    // Whatszit is 'qd' or 'qz' followed by Whoozit 
    private static boolean checkWhatszit(String s)
    {
         
        // If this sub string does not start with a 'qd' or 'qz', then it 
        // cannot be a whatszit.  Also, a whatszit must be longer than 3.        
        if ((!s.startsWith("qd") && !s.startsWith("qz")) || s.length() < 3) 
        {
            return false;
        }
        
        // if the sub string starts with qd or qz the find the rest string.        
        s = s.substring(2);

        // A Whatszit is a "qd" or "qz" follows by a Whoozit.  Check for
        // Whoozit here.
        int startOfNextWhatszit = checkWhoozit(s);

        // If "qd" or "qz" is not followed by a Whoozit.
        if (startOfNextWhatszit == -1)
            return false;
        // If there is nothing left, then we have exactly one Whatszit.   
        else if (startOfNextWhatszit == s.length())
            return true;
        // Otherwise, recursively check for more Whatszit
        else
            return checkWhatszit(s.substring(startOfNextWhatszit));
     }        

}
        

