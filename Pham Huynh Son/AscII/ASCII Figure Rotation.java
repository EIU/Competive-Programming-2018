import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Test {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean firstline = true;

		while (true) {
			int n = reader.nextInt();
			if (n == 0)
				break;
			String[] Str = new String[n + 1];
			HashMap<Integer, String[]> hm = new HashMap<Integer, String[]>();
			List<String> S = new ArrayList<String>();
			int max = 0,j=0;

			for (int i = 0; i <= n; i++) {
				Str[i] = reader.nextLine();
			}
			
			for (int i = 1; i <= n; i++) {

				String subStr = Str[i];
				String part[] = subStr.split("");
				if (part.length > max)
					max = part.length;
				hm.put(i, part);
			}
			
			if (firstline == false)
				System.out.println();

			while (true) {				
				
				for (int i = n; i > 0; i--) {
					String[] charr = hm.get(i);
					if (j < charr.length) {
						if (charr[j].equals("-"))
							S.add("|");
						else if (charr[j].equals("|"))
							S.add("-");
						else
							S.add(charr[j]);
					} else
						S.add(" ");
				}

				TrimRight(S);

				for (int i = 0; i < S.size(); i++) {
					System.out.print(S.get(i));
				}
				System.out.println();
				S.clear();
				j++;
				if (j == max)
					break;
			}
			firstline = false;
		}
	}

	static List<String> TrimRight(List S) {
		for (int i = S.size() - 1; i >= 0; i--) {
			if (S.get(i).equals(" "))
				S.remove(i);
			else
				return S;
		}
		return S;
	}
}