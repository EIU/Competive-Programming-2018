import java.io.*;
import java.util.*;

class Strength {

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		StringBuilder builder= new StringBuilder();
		int numberOfTest=reader.nextInt();
		for(int i=0;i<numberOfTest;i++) {
			int godzillaMonters=reader.nextInt();
			int mechaGodzillaMonters=reader.nextInt();
			int []godzillaArmy=new int [godzillaMonters];
			int []mechagodzillaArmy=new int [mechaGodzillaMonters];
			int j=0;
			for(;j<godzillaMonters;j++) {
				godzillaArmy[j]=reader.nextInt();
			}
			j=0;
			for(;j<mechaGodzillaMonters;j++) {
				mechagodzillaArmy[j]=reader.nextInt();
			}
			Arrays.sort(godzillaArmy);
			Arrays.sort(mechagodzillaArmy);
			int h=0,k=0;
			while(h<godzillaMonters&&k<mechaGodzillaMonters) {
				if(godzillaArmy[h]>=mechagodzillaArmy[k])
					k++;
				else {
					h++;
				}
			}
			if(k==mechaGodzillaMonters)
				builder.append("Godzilla"+"\n");
			else {
				if(h==godzillaMonters)
					builder.append("MechaGodzilla"+"\n");
				else {
					builder.append("uncertain"+"\n");
				}
			}
		}
		System.out.print(builder);
	}

	static class InputReader {

		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}

				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

	}
}