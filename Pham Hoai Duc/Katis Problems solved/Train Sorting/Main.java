
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader(System.in);
        int n = ip.nextInt();
        LinkedList<Long> train = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
        	long carWeigth = ip.nextLong();
        	if(train.isEmpty())
        		train.add(carWeigth);
        	else
        		if(train.peekFirst() < carWeigth)
        			train.addFirst(carWeigth);
        		else
        			if(train.peekLast() > carWeigth)
        				train.addLast(carWeigth);
        }
        System.out.println(builder.append(train.size()));
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