
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) {
        InputReader input = new InputReader(System.in);
         int N= input.nextInt();
        ArrayList<Integer> listNumbers = new ArrayList<>();
        int pivot=0;
        for(int i=0;i<N;i++){
            listNumbers.add(input.nextInt());         
        }
        ArrayList<Integer> listNumbers1 = new ArrayList<>(listNumbers);
        listNumbers1.remove(0);listNumbers1.remove(N-2);
        ArrayList<Integer> listBigger = new ArrayList<Integer>();
        ArrayList<Integer> listSmaller = new ArrayList<Integer>();
        listBigger.add(listNumbers.get(0));
        listSmaller.add(listNumbers.get(N-1));
        for(int i=1;i<N;i++){
            listBigger.add(Math.max(listBigger.get(i-1),listNumbers.get(i))); 
        }
        for(int i = N-2;i>=0;i--){
            listSmaller.add(Math.min(listSmaller.get(N-i-2),listNumbers.get(i))); 
        }
        if( listNumbers.get(0)< (int)Collections.min(listNumbers1))
                pivot++;
        if(listNumbers.get(N-1)>(int)Collections.max(listNumbers1))
                pivot++;
        for(int i=1;i<N-1;i++){
                if(listNumbers.get(i)> listBigger.get(i-1)&& listNumbers.get(i)<listSmaller.get(N-i-2))
                    pivot++;
            
            }
        System.out.println(pivot);
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
