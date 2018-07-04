
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows 10 Version 2
 */
public class Main {

    public static void main(String[] args) {
        InputReader input = new InputReader(System.in);
         int N= input.nextInt(),count = 0;
        ArrayList<Integer> listPawn1=new ArrayList<>();
         ArrayList<Integer> listPawn2=new ArrayList<>();
      
        for(int i=0;i<N;i++){
         listPawn1.add(input.nextInt());
         listPawn2.add(input.nextInt());
            
        }
        Collections.sort(listPawn1);
        Collections.sort(listPawn2);
        for(int i=0;i<N;i++){
            if(listPawn1.get(i)-i-1<0)
                count-=listPawn1.get(i)-i-1;
            else
                count+=listPawn1.get(i)-i-1;
            if(listPawn2.get(i)-i-1<0)
                count-=listPawn2.get(i)-i-1;
            else
                count+=listPawn2.get(i)-i-1;
        }
        System.out.println(count);
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
