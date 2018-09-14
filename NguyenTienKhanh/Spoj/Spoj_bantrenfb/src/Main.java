import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
public class Main {

    public static InputReader input = new InputReader(System.in);
    public static void main(String[] args) {
        
        int N = input.nextInt();
        int M = input.nextInt();
        int D= input.nextInt();
        int K=input.nextInt();
        StringBuilder sb=new StringBuilder();  
        HashMap<Integer,Integer> mapBirth=new HashMap<>();
        for(int i=0;i<N;i++){
            mapBirth.put(i, input.nextInt());
        }
        Vertex[] listRoad=readGraph(N, M);
        
          for(int i=0;i<N;i++){
              int count=0;
              for(int j=0;j<listRoad[i].neighbors.size();j++){
                  if(mapBirth.get(listRoad[i].neighbors.get(j).id)-D>=0 &&mapBirth.get(listRoad[i].neighbors.get(j).id)-D<=K )
                      count++;
              }
              sb.append(count+"\n");
             }
                  
          System.out.println(sb);
    }
    public static int countDay(int x,int y){
        if(x+y>30)
            return x+y-30;
        else
            return x+y;
    }
    	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
	}
		for (int i = 0; i < nEdges; ++i) {
			int u = input.nextInt()  ;
			int v = input.nextInt() ;
                            vertices[u].addNeighbor(vertices[v]);
                            vertices[v].addNeighbor(vertices[u]);
                        
		}
		return vertices;
	}


static class Vertex {
	public int id;
	public List<Vertex> neighbors = new ArrayList<Vertex>();

	public Vertex(int id) {
		this.id = id;
	}

	public void addNeighbor(Vertex child) {
		neighbors.add(child);
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
