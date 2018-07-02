package javaapplication12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        ArrayList<Integer> arrList = new ArrayList();
        ArrayList<String> arrList2 = new ArrayList();
        for (int i = 0; i < n; i++) {
            int temp = reader.nextInt();
            arrList.add(temp);
        }

        Collections.sort(arrList);

        for (int i = 0; i < arrList.size(); i++) {
            if (i + 1 >= arrList.size() || i + 2 >= arrList.size()) {
                System.out.print(arrList.get(i) + " ");

            } else {

                if (arrList.get(i + 1) - arrList.get(i) == 1 && arrList.get(i + 2) - arrList.get(i + 1) == 1) {
                    int temp1 = arrList.get(i);
                    int temp2 = arrList.get(i + 2);

                    if (i + 3 >= arrList.size()) {
                        System.out.print(temp1 + "-" + temp2 + " ");
                        i = arrList.size();
                        break;
                    } else {

                        for (int j = i + 3; j < arrList.size(); j++) {
                            if (arrList.get(j) - temp2 == 1) {
                                temp2 = arrList.get(j);
                                if (j == arrList.size() - 1) {
                                    System.out.print(temp1 + "-" + temp2 + " ");
                                    i = j;
                                    break;
                                }
                            } else {
                                i = j - 1;
                                System.out.print(temp1 + "-" + temp2 + " ");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.print(arrList.get(i) + " ");
                }

            }

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
