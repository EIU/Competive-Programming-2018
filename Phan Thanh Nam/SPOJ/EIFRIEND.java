import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s=sc.next();
		int count=0;
		int j=0;
		char[]c= {'k','o','n','i','c','h','i','w','a'};
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==c[j]) {
				count++;
				j++;
			}
			if(count==c.length) {
				break;
			}
		}
		//System.out.println(count);
		if(count==c.length) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
 
	}
 
}