import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import sun.applet.AppletViewer;
public class Main {

    public static InputReader input ;
    public static StringBuilder sb= new StringBuilder();
    public static int count=0;
    public static void main(String[] args) throws IOException {
       input = new InputReader();
        while(input.hasNext()){
            sb.append(input.next());
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        HashMap<Integer,Integer> list = new HashMap<>();
        for(int i =0;i<64;i++){
            if(sb.charAt(i)=='*'){
                list1.add(i);
                list.put(i, (i+8)/8);
            }
        }
        if(list1.size()<8){
            System.out.println("invalid");
        }else{
            boolean res = true;
        for(int i=0;i<list.size();i++){
             int t=list1.get(i);
            int tl=list1.get(i)-8;
                    int d=list1.get(i)+8;
                    int tr=list1.get(i)-1;
                    int ph=list1.get(i)+1;
                    int trt=list1.get(i)-9;
                    int trd=list1.get(i)+7;
                    int pht=list1.get(i)-7;
                    int phd=list1.get(i)+9;
                    
           while(tl>0){
                            if(list1.contains(tl))
                                res=false;
                            tl-=8;
                        }
                        while(d<64){
                            if(list1.contains(d))
                                res=false;
                            d+=8;
                        }
                        while((tr+1)%8!=0&&tr >0){
                           if(list1.contains(tr))
                                res=false;
                            tr-=1;
                        }
                         while((ph)%8!=0&&ph<64){
                            if(list1.contains(ph))
                                res=false;
                            ph+=1;
                        }
                          while(trt>0&& list.get(t)!=(trt+8)/8&&(((trt+9)/8)-((trt)/8))==1){
                            if(list1.contains(trt))
                                res=false;
                            trt-=9;
                        }
                           while(trd<64 && list.get(t)!=(trd+8)/8 &&(((trd)/8)-((trd-7)/8))==1){
                            if(list1.contains(trd))
                                res=false;
                            trd+=7;
                        }
                            while(pht>0&& list.get(t)!=(pht+8)/8&& (((pht+7)/8)-((pht)/8))==1){
                            if(list1.contains(pht))
                                res=false;
                            pht-=7;
                        }
                             while(phd<64&& list.get(t)!=(phd+8)/8 && (((phd+8)/8)-((phd-1)/8))==1){
                            if(list1.contains(phd))
                                res=false;
                            phd+=9;
                        }
        }
        if(res== true)
            System.out.println("valid");
        else
            System.out.println("invalid");
        }
        
    }
   static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 23];
        int lenbuf = 0, ptrbuf = 0;

        public InputReader() throws IOException {
            lenbuf = is.read(inbuf);
        }

        public int readByte() {

            if (ptrbuf >= lenbuf) {
                return -1;
            }

            return inbuf[ptrbuf++];
        }

        public boolean hasNext() {
            int t = skip();

            if (t == -1) {
                return false;
            }
            ptrbuf--;
            return true;
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextChar() {
            return (char) skip();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] ns(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char[][] nm(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++)
                map[i] = ns(m);
            return map;
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

    }

}
