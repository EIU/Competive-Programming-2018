
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        int N = input.nextInt();
        int M = input.nextInt();
        StringBuilder sb=new StringBuilder(); 
        int[][] listRoad = new int[N+1][N+1];
        int u,w,v;
         
        
        for(int i=0;i<M;i++){
            u=input.nextInt();
            v=input.nextInt();
            w=input.nextInt();
            listRoad[u][v]=w;
            listRoad[v][u]=w;
            
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(j==N)
                    sb.append(listRoad[i][j]+"\n");
                else
                     sb.append(listRoad[i][j]+" ");
               
            }
        }
        System.out.println(sb);
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
