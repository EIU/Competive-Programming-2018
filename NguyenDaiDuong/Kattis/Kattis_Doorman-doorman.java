import java.io.*;
import java.util.*;

class Doorman {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int absoluteDifference= reader.nextInt();
        int men=0,women=0,people=0;
        char[] gender=reader.next().toCharArray();
        int i=0;
        boolean check=false;
        while(i<gender.length) {
            if(gender[i]=='M'&&Math.abs(men+1-women)<=absoluteDifference) {
                men++;
                people++;
                check=false;
            }
            else {
                if(gender[i]=='W'&&Math.abs(men-(women+1))<=absoluteDifference) {
                    women++;
                    people++;
                    check=false;
                }else {
                    if(check==true)
                        break;
                    swap(gender, i);
                    i--;
                    check=true;
                }
            }
            i++;
        }
        System.out.println(people);
    }
    static void swap(char[]temp,int index) {
        char acc;
        if(index<temp.length-1) {
            acc=temp[index+1];
            temp[index+1]=temp[index];
            temp[index]=acc;
        }
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
