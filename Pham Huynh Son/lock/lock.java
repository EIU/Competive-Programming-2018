import java.io.*;
import java.util.*;

public class lock {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		while (true) {
			int[] list = new int[4];
			for (int i = 0; i < 4; i++) {
				list[i] = reader.nextInt();
			}
			if (list[1] == 0 && list[2] == 0 && list[0] == 0 && list[3] == 0)
				return;
			int temp = 0;
			temp += (list[0]-list[1]+40)%40 + (list[2] - list[1]+40)%40 +(list[2]- list[3]+40)%40;
			temp = temp * 9 + 1080;
			System.out.println(temp);

		}

	}
}