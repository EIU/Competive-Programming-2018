import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

   public static void main (String[] args) throws java.lang.Exception
	{
	   Scanner s = new Scanner(System.in);
	   int N = s.nextInt();
       int[] arr = new int[N];
       int i = 1 ;
       int j = 0 ;
       while(i*2<=N){
           arr[j]=i;
           i *= 2;
           j++;
       }
       arr[j]=i;
       System.out.println(j+1);
       for(int k = 0 ; k < j+1 ; k++){
           System.out.print(arr[k]+" ");
       }
	}
}