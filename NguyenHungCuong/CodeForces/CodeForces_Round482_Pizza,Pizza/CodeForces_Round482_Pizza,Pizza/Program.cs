using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CodeForces_Round482_Pizza_Pizza
{
    class Program
    {
        static void Main(string[] args)
        {
            long n = long.Parse(Console.ReadLine());
            if (n == 0)
            {
                Console.WriteLine(n);
            }
            else
            if (n % 2 != 0)
            {
                Console.WriteLine((n + 1) / 2);
            }

            else
            {
                Console.WriteLine(n + 1);
            }

        }
    }
}
