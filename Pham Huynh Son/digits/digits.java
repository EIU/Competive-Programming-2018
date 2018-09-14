import java.util.*;

public class digits {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
			double[] list = new double[1000000 + 1];
            list[1] = Math.log10(1);
            for (int i=2;i<=1000000;i++){
                list[i] = list[i-1] + Math.log10(i);
            }
            while (true) {
                System.out.println((int)list[input.nextInt()] + 1);
}
		
	}
}
