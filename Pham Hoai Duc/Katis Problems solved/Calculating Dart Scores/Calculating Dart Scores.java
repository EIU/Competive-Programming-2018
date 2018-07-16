import java.util.*;
import java.io.*;


public class Main {
	static boolean readFile = false;
	 public static void printfab(int timesOf20, int a){
        while(timesOf20 > 0)
        {
            if(timesOf20 >= 3)
            {
                System.out.println("triple "+a);
                timesOf20 -= 3;
            }
            else if(timesOf20 == 2)
            {
                System.out.println("double "+a);
                timesOf20 -= 2;
            }
            else{
                System.out.println("single "+a);
                timesOf20--;
            }
        }
    }
         public static void dequy(int n, int a)
         {
             if(a > 0)
             {
                if(n % a == 0 && n / a <= 9)
                {
                    printfab(n / a, a);
                }
                else
                {
                    
                    int kc = n - 6*a;
                    if(kc > a)
                    {
                        if(kc % 3 == 0 && kc / 3 <= a)
                        {
                            int c = kc / 3;
                            System.out.println("triple " + a);
                            System.out.println("triple " + a);
                            System.out.println("triple "+ c);
                        }
                        else if(kc % 2 == 0 && kc / 2 <= a)
                        {
                            int c = kc / 2;
                            System.out.println("triple "+a);
                            System.out.println("triple "+a);
                            System.out.println("double "+c);
                        }
                        else
                        {
                            dequy1(n, a);
                        }
                    }
                    else
                    {
                        int c = kc;
                        System.out.println("triple "+a);
                        System.out.println("triple "+a);
                        System.out.println("single " + c);
                    }                  
                }
             }
             else
             {
                 System.out.println("impossible");
             }
         }
            public static void dequy1(int n, int a)
         {
             if(a > 0)
             {
                if(n % a == 0 && n / a <= 9)
                {
                    printfab(n / a, a);
                }
                else
                {
                    
                    int kc = n - 5*a;
                    if(kc > a)
                    {
                        if(kc % 3 == 0 && kc / 3 <= a)
                        {
                            int c = kc / 3;
                            System.out.println("triple " + a);
                            System.out.println("double " + a);
                            System.out.println("triple "+ c);
                        }
                        else if(kc % 2 == 0 && kc / 2 <= a)
                        {
                            int c = kc / 2;
                            System.out.println("triple "+a);
                            System.out.println("double "+a);
                            System.out.println("double "+c);
                        }
                        else
                        {
                            dequy1(n, a - 1);
                        }
                    }
                    else
                    {
                        int c = kc;
                        System.out.println("triple "+a);
                        System.out.println("double "+a);
                        System.out.println("single " + c);
                    }                  
                }
             }
             else
             {
                 System.out.println("impossible");
             }
         }
	public static void main(String[] args) throws IOException {
		InputReader ip = new InputReader();
		int n = ip.nextInt();
        //i*a + j*b + k*c = n
        if(n <= 20)
        {
            System.out.println("single "+n);
        }
        else
        {
            if(n / 20 < 7)
            {
                printfab(n / 20, 20);
                int c = n % 20;
                if(c > 0)
                {
                    System.out.println("single "+c);
                }
            }
            else
            {
                dequy(n, 20);
            }
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


