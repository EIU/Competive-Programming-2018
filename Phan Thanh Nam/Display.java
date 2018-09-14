import java.util.Scanner;

public class Display {
    public static String[] check(String s) {
        String[] one = { "    +", "    |", "    |", "    +", "    |", "    |", "    +" };
        String[] two = { "+---+", "    |", "    |", "+---+", "|    ", "|    ", "+---+" };
        String[] zero = { "+---+", "|   |", "|   |", "+   +", "|   |", "|   |", "+---+" };
        String[] four = { "+   +", "|   |", "|   |", "+---+", "    |", "    |", "    +" };
        String[] five = { "+---+", "|    ", "|    ", "+---+", "    |", "    |", "+---+" };
        String[] six = { "+---+", "|    ", "|    ", "+---+", "|   |", "|   |", "+---+" };
        String[] seven = { "+---+", "    |", "    |", "    +", "    |", "    |", "    +" };
        String[] eight = { "+---+", "|   |", "|   |", "+---+", "|   |", "|   |", "+---+" };
        String[] nine = { "+---+", "|   |", "|   |", "+---+", "    |", "    |", "+---+" };
        String[] three = { "+---+", "    |", "    |", "+---+", "    |", "    |", "+---+" };
        String[] point = { " ", " ", "o", " ", "o", " ", " " };
        if (s.equals(":")) {
            return point;
        }
        int a = Integer.parseInt(s);
        switch (a) {
        case 0:
            return zero;
        case 1:
            return one;
        case 2:
            return two;
        case 3:
            return three;
        case 4:
            return four;
        case 5:
            return five;
        case 6:
            return six;
        case 7:
            return seven;
        case 8:
            return eight;
        case 9:
            return nine;
        }
        return point;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {          
            String t = sc.nextLine();
            String s=t;
            if(t.equals("end")) {
                sb.append("end");
                break;
            }
            String[] time = t.split("");
            String[]a=check(time[0]);
            String[]b=check(time[1]);
            String[]c=check(time[2]);
            String[]d=check(time[3]);
            String[]e=check(time[4]);
            for(int i=0;i<7;i++) {
                sb.append(a[i]+"  "+b[i]+"  "+c[i]+"  "+d[i]+"  "+e[i]+"\n");
            }           
            sb.append("\n");
            sb.append("\n");
            
        }
        System.out.println(sb);
    }
}
