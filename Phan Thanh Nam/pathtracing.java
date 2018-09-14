import java.util.ArrayList;
import java.util.Scanner;

public class pathtracing {
    static class position {
        int x;
        int y;

        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<position> pos = new ArrayList<>();
        ArrayList<String> moves = new ArrayList<>();
        while (sc.hasNext())
            moves.add(sc.next());
        for(int i=0;i<moves.size();i++){
            if (moves.get(i).equals("up")) {
                pos.add(new position(-1, 0));
            } else if (moves.get(i).equals("down")) {
                pos.add(new position(1, 0));
            } else if (moves.get(i).equals("left")) {
                pos.add(new position(0, -1));
            } else if (moves.get(i).equals("right")) {
                pos.add(new position(0, 1));
            }
        }
        int col, col_max, col_min;
        int row, row_max, row_min;
        col = col_max = col_min = 500;
        row = row_max = row_min = 500;
        char[][] character = new char[1001][1001];
        for(int i=0;i<character.length;i++){
           for(int j=0;j<character.length;j++){
               character[i][j]=' ';
           }
        }
        for (int i = 0; i < pos.size(); i++) {
            row += pos.get(i).x;
            col += pos.get(i).y;
            character[row][col] = '*';
            col_max = Math.max(col, col_max);
            col_min = Math.min(col, col_min);
            row_min = Math.min(row, row_min);
            row_max = Math.max(row, row_max);
        }
        character[500][500] = 'S';
        character[row][col] = 'E';
        col_max ++;
        col_min --;
        row_min --;
        row_max ++;
        for (int i = row_min; i <= row_max; i++) {
            character[i][col_max] = '#';
            character[i][col_min] = '#';
        }
        for (int i = col_min; i <= col_max; i++) {
            character[row_max][i] = '#';
            character[row_min][i] = '#';
        }
        for(int i=row_min;i<=row_max;i++){
            for(int j=col_min;j<=col_max;j++){
                System.out.print(character[i][j]);
            }
            System.out.println();
        }
    }
}