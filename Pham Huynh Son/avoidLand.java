import java.util.Arrays;
import java.util.Scanner;

public class avoidLand {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int count = 0;
		int [] row= new int [n];
		int [] colum= new int [n];
		
		for(int i =0;i<n;i++) {
			row[i]= input.nextInt();
			colum[i]= input.nextInt();
		}

		Arrays.sort(row);
		Arrays.sort(colum);
		
		for(int i=0;i<n;i++) {
			count+=Math.abs(row[i]-1-i);
			count+=Math.abs(colum[i]-i-1);
		}
System.out.println(count);
	}

}