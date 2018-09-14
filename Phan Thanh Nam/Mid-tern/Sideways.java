import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sideways {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (r == 0 && c == 0) {
				break;
			}
			String[]charac=new String[c];
			for (int i = 0; i < charac.length; i++) {
				charac[i]="";
				
			}
			for(int i=0;i<r;i++) {
				String s=sc.next();
				for(int j=0;j<c;j++) {
					charac[j]+=s.charAt(j);
				}
			}
			Arrays.sort(charac,new Comparator<String>() {
				public int compare(String s1,String s2) {
					s1=s1.toUpperCase();
					s2=s2.toUpperCase();
					return s1.compareTo(s2);
				}
			});
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(charac[j].charAt(i));
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
