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
        int Socks = sc.nextInt();
        int machine = sc.nextInt();
        int color = sc.nextInt();
        int[] SocksValue = new int[Socks];
        for (int i = 0; i < SocksValue.length; i++) {
            SocksValue[i] = sc.nextInt();
        }
        Arrays.sort(SocksValue);
        int machinesneed = 1;
        int socksinmachine = 1;
        int lowestinmachine = SocksValue[0];

        for (int i = 1; i < Socks; i++) {
            if (socksinmachine == machine) {
                machinesneed++;
                socksinmachine = 0;
                lowestinmachine = SocksValue[i];
            }
            if (SocksValue[i] - lowestinmachine > color) {
                machinesneed++;
                socksinmachine = 0;
                lowestinmachine = SocksValue[i];
            }
            socksinmachine++;
        }

        System.out.println(machinesneed);
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
