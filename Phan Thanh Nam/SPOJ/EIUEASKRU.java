import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
 
class Prime {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Integer> hs = new HashMap<>();
 
	static class Vertex {
		public int id = -1;
		public List<Vertex> neighbors = new ArrayList<Vertex>();
		public List<Edge> edges = new ArrayList<>();
		private boolean visited = false;
		public int node = 0;
		public int deg = 0;
 
		public Vertex(int id) {
			this.id = id;
		}
 
		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}
 
		public void AddEdge(Edge other) {
			edges.add(other);
		}
	}
 
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		long w;
 
		public Edge(int u, int v, long w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
 
		@Override
		public int compareTo(Edge other) {
			return Long.compare(this.w, other.w);
		}
	}
 
	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i + 1);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int k = sc.nextInt();
			if (!vertices[u].neighbors.contains(vertices[v])) {
				vertices[u].AddEdge(new Edge(u, v, k));
				vertices[v].AddEdge(new Edge(v, u, k));
				vertices[u].addNeighbor(vertices[v]);
				vertices[v].addNeighbor(vertices[u]);
			}
		}
		return vertices;
	}
 
	public static long Prim(Vertex[] vertices, Vertex u) {
		Queue<Edge> q = new PriorityQueue<>();
		long total = 0;
		u.visited = true;
		for (Edge edge : u.edges) {
			q.add(edge);			
		}
		while (!q.isEmpty()) {
			Edge current = q.poll();
			if (vertices[current.u].visited && vertices[current.v].visited) {
				continue;
			}
			if (vertices[current.u].visited) {
				for (Edge ed : vertices[current.v].edges) {
					q.add(ed);
				}
			}
			if (vertices[current.v].visited) {
				for (Edge ed : vertices[current.u].edges) {
					q.add(ed);
				}
			}
			vertices[current.u].visited = vertices[current.v].visited = true;
			total += current.w;
		}
		return total;
	}
 
	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		Vertex[] vertices = readGraph(n, m);
		long sum = 0;
		for (Vertex u : vertices) {
			if(!u.visited) {
				sum = Math.max(Prim(vertices, u), sum);
			}			
		}
		System.out.println(sum);
	}
 
}
 