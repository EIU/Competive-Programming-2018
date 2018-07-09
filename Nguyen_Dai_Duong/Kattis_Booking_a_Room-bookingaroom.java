import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfRooms = reader.nextInt();
        int roomsWasBooked = reader.nextInt();
        if(numberOfRooms == roomsWasBooked){
            System.out.println("too late");
        }
        else{
            List<Integer> listRoom = new ArrayList<>();
            int i=0;
            for(;i < roomsWasBooked;i++){
                int temp=reader.nextInt();
                listRoom.add(temp);
            }
            i--;
            int j=1;
            while(listRoom.contains(j)&&i>=0){
                j++;i--;
            }
            System.out.println(j);
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