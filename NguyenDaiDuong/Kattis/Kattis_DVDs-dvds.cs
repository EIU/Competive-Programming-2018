using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Introduction
{
    class Program
    {
        static void Main(string[] args)
        {
            Reader reader = new Reader();
            StringBuilder builder = new StringBuilder();
            int number = reader.NextInt();
            for (int i = 0; i < number; i++)
            {
                int[] arr = new int[reader.NextInt()];
                int temp = 1;
                for (int j = 0; j < arr.Length; j++)
                {
                    arr[j] = reader.NextInt();
                    temp = temp == arr[j] ? temp + 1 : temp;
                }
                builder.Append((arr.Length - temp + 1) + "\n");
            }
            Console.Write(builder);
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