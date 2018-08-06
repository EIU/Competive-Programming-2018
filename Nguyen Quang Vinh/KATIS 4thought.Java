
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    public static String d(int temp) {
        if (temp == 0) {
            return " * ";
        }
        if (temp == 1) {
            return " + ";
        }
        if (temp == 2) {
            return " - ";
        }

        return " / ";
    }

    public static String str(int a, int b, int c) {
        return "4" + d(a) + "4" + d(b) + "4" + d(c) + "4";
    }

    public static void main(String[] args) throws IOException, ScriptException {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        String stringOfNumber = "";

        HashMap<Integer, String> map = new HashMap();
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {

                    
                        stringOfNumber = str(i, j, k);

                        Object result = engine.eval(stringOfNumber);
                        String str = result.toString();

                        double temp3 = (double) Math.round((Double.valueOf(str)*10)/10);
                        
                        int temp4 = Integer.valueOf((int) temp3);
                        if(!map.containsKey(temp4))
                        map.put(temp4, stringOfNumber);
                    
                }
            }
        }


        

        for (int i = 0; i < n; i++) {
            int number = reader.nextInt();
            if (map.containsKey(number)) {
                System.out.println(map.get(number) + " = " + number);
            } else {
                System.out.println("no solution");
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
