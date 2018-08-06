import java.util.Scanner;

public class fox {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			char c = 'a';
			char[] letters = new char[26];
			String s = sc.nextLine().toLowerCase();
			String reuslt = "";
			for (int j = 0; j < letters.length; j++) {
				letters[j] = c;
				c++;
			}
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < letters.length; k++) {
					if (s.charAt(j) == letters[k]) {
						letters[k] = '0';
					}
				}
			}
			for (int j = 0; j < letters.length; j++) {
				if (letters[j] != '0') {
					reuslt += letters[j];
				}
			}
			if (reuslt.equals("")) {
				System.out.println("pangram");
			} else {
				System.out.println("missing" + " " + reuslt);
			}
		}
	}

}
