import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
	static Scanner sc=new Scanner(System.in);
	static class Vertex {
		public int id = -1;
		public List<Vertex> neighbors = new ArrayList<Vertex>();
		//private boolean visited = false;
 
		public Vertex(int id) {
			this.id = id;
		}
 
		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}
 
	}
	public static Vertex[] readGraph(int nVertices, int nEdges) {	
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nEdges; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);		
		}
		return vertices;
	}
	public static void main(String[] args) {	
		int n=sc.nextInt();
		Vertex[] vertices=readGraph(n, n-1);
		StringBuilder sb=new StringBuilder();
		int m=sc.nextInt();
		for(int i=0;i<m;i++) {			
			sb.append(vertices[sc.nextInt()].neighbors.size()+"\n");
		}
		System.out.println(sb);
	}
 
}