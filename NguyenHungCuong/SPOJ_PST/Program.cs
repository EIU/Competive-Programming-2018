using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace EIMAKEFRIE
{
    class Program
    {
        static void Main(string[] args)
        {
            Reader scan = new Reader();
            int n = scan.NextInt();
            int m = scan.NextInt();
            int q = scan.NextInt();
            Vertex[] list = ReadGraph(n,m,scan);
            StringBuilder result = new StringBuilder();
            while (q-- > 0)
            {
                result.Append((list[scan.NextInt()].level - 1)+"\n");
            }
            Console.Write(result);
            Console.ReadKey();
        }
        static void Bfs(Vertex u)
        {
            u.visited = true;
            Queue<Vertex> queue = new Queue<Vertex>();
            queue.Enqueue(u);
            while (queue.Count != 0)
            {
                Vertex current = queue.Dequeue();
                foreach (Vertex v in current.neighbors)
                {
                    if (!v.visited)
                    {
                        v.visited = true;
                        v.level = current.level + 1;
                        queue.Enqueue(v);
                    }
                }
            }
        }

        public static Vertex[] ReadGraph(int nVertices,int nEdges, Reader scan)
        {
            Vertex[] vertices = new Vertex[nVertices];
            for (int i = 0; i < nVertices; ++i)
            {
                vertices[i] = new Vertex(i);
            }
            for (int i = 0; i < nEdges; ++i)
            {
                int u = scan.NextInt();
                int v = scan.NextInt();
                vertices[u].addNeighbor(vertices[v]);
                vertices[v].addNeighbor(vertices[u]);
            }
            Bfs(vertices[0]);
            return vertices;
        }

        public class Vertex
        {

            public int id;
            public List<Vertex> neighbors = new List<Vertex>();
            public Boolean visited = false;
            public int level = 0;

            public Vertex(int id)
            {
                this.id = id;
            }

            public int getDeg()
            {
                return this.neighbors.Capacity;
            }

            public void addNeighbor(Vertex child)
            {
                neighbors.Add(child);
            }
        }
        #region Reader Class
        internal class Reader
        {
            int s_index = 0;
            List<string> s_tokens;

            public string Next()
            {
                while (s_tokens == null || s_index == s_tokens.Count)
                {
                    s_tokens = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();
                    s_index = 0;
                }
                return s_tokens[s_index++];
            }

            public int NextInt()
            {
                String s = Next();

                return int.Parse(s);
            }

            public long NextLong()
            {
                String s = Next();
                return long.Parse(s);
            }

            public bool HasNext()
            {
                while (s_tokens == null || s_index == s_tokens.Count)
                {
                    s_tokens = null;
                    s_index = 0;
                    var nextLine = Console.ReadLine();
                    if (nextLine != null)
                    {
                        s_tokens = nextLine.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();
                        if (s_tokens.Count == 0)
                        {
                            continue;
                        }
                    }
                    return false;
                }
                return false;
            }
        }
        #endregion
    }
}
