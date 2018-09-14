import java.util.Scanner;

public class display {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		while (true) {
			String s = reader.next();
			if (s.equals("end")) {
			System.out.println("end");
				break;
			}
			String[] subS = s.split("");
			String[] a = num(subS[0]);
			String[] b = num(subS[1]);
			String[] c = num(subS[2]);
			String[] d = num(subS[3]);
			String[] e = num(subS[4]);

			StringBuilder str = new StringBuilder();

			for (int i = 0; i < 7; i++) {
				if(i!=7)
				str.append(a[i] + "  " + b[i] + "  " + c[i] + "  " + d[i] + "  " + e[i] + "\n");
				else str.append(a[i] + "  " + b[i] + "  " + c[i] + "  " + d[i] + "  " + e[i]);
			}
			str.append("\n"+"\n");
			System.out.print(str);
		}
	}

	static String[] num(String s) {

		String[] one = { "    +", "    |", "    |", "    +", "    |", "    |", "    +" };
		String[] zero = { "+---+", "|   |", "|   |", "+   +", "|   |", "|   |", "+---+" };
		String[] hai = { "+---+", "    |", "    |", "+---+", "|    ", "|    ", "+---+" };
		String[] ba = { "+---+", "    |", "    |", "+---+", "    |", "    |", "+---+" };
		String[] nam = { "+---+", "|    ", "|    ", "+---+", "    |", "    |", "+---+" };
		String[] bon = { "+   +", "|   |", "|   |", "+---+", "    |", "    |", "    +" };
		String[] sau = { "+---+", "|    ", "|    ", "+---+", "|   |", "|   |", "+---+" };
		String[] bay = { "+---+", "    |", "    |", "    +", "    |", "    |", "    +" };
		String[] tam = { "+---+", "|   |", "|   |", "+---+", "|   |", "|   |", "+---+" };
		String[] nine = { "+---+", "|   |", "|   |", "+---+", "    |", "    |", "+---+" };
		String[] dauphay = { " ", " ", "o", " ", "o", " ", " " };
		if (s.equals("1")) {
			return one;
		}
		if (s.equals("2")) {
			return hai;
		}
		if (s.equals("3")) {
			return ba;
		}
		if (s.equals("4")) {
			return bon;
		}
		if (s.equals("5")) {
			return nam;
		}
		if (s.equals("6")) {
			return sau;
		}
		if (s.equals("7")) {
			return bay;
		}
		if (s.equals("8")) {
			return tam;
		}
		if (s.equals("9")) {
			return nine;
		}
		if (s.equals("0")) {
			return zero;
		}
		return dauphay;
	}
}
