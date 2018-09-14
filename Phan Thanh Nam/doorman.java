import java.util.Scanner;

public class doorman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int differ = sc.nextInt();
		String s = sc.next();
		int men = 0;
		int women = 0;
		while (true) {
			boolean check = false;
			if (Math.abs((men + 1) - women) <= differ) {
				if (s.length() > 0 && s.charAt(0) == 'M') {
					s = s.substring(1);
					men++;
					check = true;
				} else if (s.length() > 1 && s.charAt(1) == 'M') {
					s = s.substring(0, 1) + s.substring(2);
					men++;
					check = true;
				}
			}
			if (!check && Math.abs(men - (women + 1)) <= differ) {
				if (s.length() > 0 && s.charAt(0) == 'W') {
					s = s.substring(1);
					women++;
					check = true;
				} else if (s.length() > 1 && s.charAt(1) == 'W') {
					s = s.substring(0, 1) + s.substring(2);
					women++;
					check = true;
				}
			}
			if (!check || s.isEmpty()) {
				break;
			}
		}
		System.out.println(men + women);
	}

}
