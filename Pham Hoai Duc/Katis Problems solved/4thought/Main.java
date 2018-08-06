import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void solve(HashMap<Integer, String> map, HashMap<Integer, Boolean> piority) {
		for (int first = 1; first <= 4; first++) {
			for (int second = 1; second <= 4; second++) {
				for (int third = 1; third <= 4; third++) {
					int sum = -1;
					if (piority.get(first) && piority.get(second) && piority.get(third)) {
						sum = first == 1 ? 4 * 4 : first == 4 ? 4 / 4 : 0;
						sum = second == 1 ? sum * 4 : second == 4 ? sum / 4 : 0;
						sum = third == 1 ? sum * 4 : third == 4 ? sum / 4 : 0;
					} else if (!piority.get(first) && piority.get(second) && piority.get(third)) {
						sum = second == 1 ? 4 * 4 : second == 4 ? 4 / 4 : 0;
						sum = third == 1 ? sum * 4 : third == 4 ? sum / 4 : 0;
						sum = first == 2 ? 4 + sum : first == 3 ? 4 - sum : 0;
					} else if (piority.get(first) && !piority.get(second) && piority.get(third)) {
						int sum1 = first == 1 ? 4 * 4 : first == 4 ? 4 / 4 : 0;
						int sum2 = third == 1 ? 4 * 4 : third == 4 ? 4 / 4 : 0;
						sum = second == 2 ? sum1 + sum2 : second == 3 ? sum1 - sum2 : 0;
					} else if (piority.get(first) && piority.get(second) && !piority.get(third)) {
						sum = first == 1 ? 4 * 4 : first == 4 ? 4 / 4 : 0;
						sum = second == 1 ? sum * 4 : second == 4 ? sum / 4 : 0;
						sum = third == 2 ? sum + 4 : third == 3 ? sum - 4 : 0;
					} else if (!piority.get(first) && !piority.get(second) && piority.get(third)) {
						int sum1 = third == 1 ? 4 * 4 : third == 4 ? 4 / 4 : 0;
						int sum2 = first == 2 ? 4 + 4 : first == 3 ? 4 - 4 : 0;
						sum = second == 2 ? sum2 + sum1 : second == 3 ? sum2 - sum1 : 0;
					} else if (!piority.get(first) && piority.get(second) && !piority.get(third)) {
						sum = second == 1 ? 4 * 4 : second == 4 ? 4 / 4 : 0;
						sum = first == 2 ? 4 + sum : first == 3 ? 4 - sum : 0;
						sum = third == 2 ? sum + 4 : third == 3 ? sum - 4 : 0;
					} else if (piority.get(first) && !piority.get(second) && !piority.get(third)) {
						sum = first == 1 ? 4 * 4 : first == 4 ? 4 / 4 : 0;
						sum = third == 2 ? sum + 4 : third == 3 ? sum - 4 : 0;
						sum = second == 2 ? sum + 4 : second == 3 ? sum - 4 : 0;
					} else {
						sum = first == 2 ? 4 + 4 : first == 3 ? 4 - 4 : 0;
						sum = third == 2 ? sum + 4 : third == 3 ? sum - 4 : 0;
						sum = second == 2 ? sum + 4 : second == 3 ? sum - 4 : 0;
					}
						String result = first == 1 ? "4 * 4 "
								: first == 2 ? "4 + 4 " : first == 3 ? "4 - 4 " : first == 4 ? "4 / 4 " : " ";
						result = second == 1 ? result + "* 4 "
								: second == 2 ? result + "+ 4 "
										: second == 3 ? result + "- 4 " : second == 4 ? result + "/ 4 " : " ";
						result = third == 1 ? result + "* 4 = " + sum
								: third == 2 ? result + "+ 4 = " + sum
										: third == 3 ? result + "- 4 = " + sum : third == 4 ? result + "/ 4 = " + sum : " ";
						map.put(sum, result);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ip = new Scanner(System.in);
		int m = ip.nextInt();
		StringBuilder builder = new StringBuilder();
		HashMap<Integer, Boolean> piority = new HashMap<>();
		HashMap<Integer, String> result = new HashMap<>();
		piority.put(1, true);
		piority.put(4, true);
		piority.put(2, false);
		piority.put(3,false);
		solve(result, piority);
		for(int i = 0; i < m; i++)
		{
			String r = result.get(ip.nextInt());
			if(r != null)
				builder.append(r+"\n");
			else
				builder.append("no solution\n");
		}
		System.out.println(builder);

	}

}
