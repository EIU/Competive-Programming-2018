import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketImpl;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ColorSock {

    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int NumSocks = sc.nextInt();
        int Nummachine = sc.nextInt();
        int color = sc.nextInt();
        int[] SocksValue = new int[NumSocks];
        for (int i = 0; i < SocksValue.length; i++) {
            SocksValue[i] = sc.nextInt();
        }
        Arrays.sort(SocksValue);
        int need = 1;
        int machine = 1;
        int lowemachine = SocksValue[0];

        for (int i = 1; i < NumSocks; i++) {
            if (machine == machine) {
                need++;
                machine = 0;
                lowemachine = SocksValue[i];
            }
            if (SocksValue[i] - lowemachine > color) {
                need++;
                machine = 0;
                lowemachine = SocksValue[i];
            }
            machine++;
        }

        System.out.println(need);
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
