import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        int numberOfLine = reader.nextInt();
        StringBuilder builder = new StringBuilder();
        while (numberOfLine != 0) {
            List<List<String>> lists = new ArrayList<>();
            int maxLength = 0;
            for (int i = 0; i < numberOfLine; i++) {
                char[] temp = reader.nextLine().toCharArray();
                List<String> tempList = new ArrayList<>();
                for (int j = 0; j < temp.length; j++) {
                    String s = Character.toString(temp[j]);
                    tempList.add(s);
                }
                lists.add(tempList);
                if (temp.length > maxLength) {
                    maxLength = temp.length;
                }
            }
            String str="";
            for (int i = 0; i < maxLength; i++) {
                for (int j = numberOfLine - 1; j >= 0; j--) {
                    if (i < lists.get(j).size()) {
                        if (lists.get(j).get(i).equals("-")) {
                            str+="|";
                        } else {
                            if (lists.get(j).get(i).equals("|")) {
                                str+="-";
                            } else {
                                str+=lists.get(j).get(i);
                            }
                        }
                    }else {
                        str+=" ";
                    }
                }
                builder.append(str.replaceAll("\\s+$","")).append("\n");
                str="";
            }
            numberOfLine = reader.nextInt();
            if (numberOfLine == 0) {
                builder.delete(builder.lastIndexOf("\n"), builder.lastIndexOf("\n") + 1);
                break;
            }
            builder.append("\n");
        }
        System.out.println(builder);
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