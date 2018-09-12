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
            Dictionary<Char,List<String>> list = new Dictionary<Char,List<String>>();
            StringBuilder builder = new StringBuilder();
            string number = reader.Next();
            list.Add('1',("    +\n    |\n    |\n    +\n    |\n    |\n    +").Split('\n').ToList());
            list.Add('2',("+---+\n    |\n    |\n+---+\n|    \n|    \n+---+").Split('\n').ToList());
            list.Add('3',("+---+\n    |\n    |\n+---+\n    |\n    |\n+---+").Split('\n').ToList());
            list.Add('4',("+   +\n|   |\n|   |\n+---+\n    |\n    |\n    +").Split('\n').ToList());
            list.Add('5',("+---+\n|    \n|    \n+---+\n    |\n    |\n+---+").Split('\n').ToList());
            list.Add('6',("+---+\n|    \n|    \n+---+\n|   |\n|   |\n+---+").Split('\n').ToList());
            list.Add('7',("+---+\n    |\n    |\n    +\n    |\n    |\n    +").Split('\n').ToList());
            list.Add('8',("+---+\n|   |\n|   |\n+---+\n|   |\n|   |\n+---+").Split('\n').ToList());
            list.Add('9',("+---+\n|   |\n|   |\n+---+\n    |\n    |\n+---+").Split('\n').ToList());
            list.Add('0',("+---+\n|   |\n|   |\n+   +\n|   |\n|   |\n+---+").Split('\n').ToList());
            list.Add(':',(" \n \no\n \no\n \n ").Split('\n').ToList());
            list.Add('s',("  \n  \n  \n  \n  \n  \n  \n").Split('\n').ToList());
            while(true){
                if (number == "end"){
                    builder.Append("end");
                    break;
                }
                else{
                    char[] temp = number.ToCharArray();
                    string str = "";
                    for (int j = 0; j < 7; j++)
                        {
                            for (int i = 0; i < temp.Length;i++){
                            if(i==temp.Length-1){
                                str += list[temp[i]].ElementAt(j);
                            }else
                                str += list[temp[i]].ElementAt(j) + list['s'].ElementAt(j);
                            }
                            str += "\n";
                        }
                    builder.Append(str+ "\n\n");
                }
                number = reader.Next();
            }
            Console.WriteLine(builder);

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
