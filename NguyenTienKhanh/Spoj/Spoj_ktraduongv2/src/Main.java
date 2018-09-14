import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
public class Main {

    public static InputReader input = new InputReader(System.in);
    public static void main(String[] args) {
        
        int N = input.nextInt();
        int M = input.nextInt();
        int Q = input.nextInt();
        StringBuilder sb=new StringBuilder();  
        Vertex[] listRoad=readGraph(N, M);
        
          for(int i=0;i<Q;i++){
              int o=input.nextInt()-1;
             int p=input.nextInt()-1;
             if(listRoad[o].neighbors.size()==0){
                 sb.append("N"+"\n");
                 continue;
             }
                  if(listRoad[o].neighbors.contains(listRoad[p]))
                      sb.append("Y"+"\n");
                  else{
                      for(int j=0;j<listRoad[o].neighbors.size();j++){
                          if(listRoad[o].neighbors.get(j).neighbors.contains(listRoad[p])){
                              sb.append("Y"+"\n");
                              break;
                          }else{
                              if(j==listRoad[o].neighbors.size()-1){
                                  sb.append("N"+"\n");break;
                              }
                                  
                          }
                              
                      }
                  }
            
          }
          System.out.println(sb);
    }
    	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i+1);
	}
		for (int i = 0; i < nEdges; ++i) {
			int u = input.nextInt()-1  ;
			int v = input.nextInt()-1 ;
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
