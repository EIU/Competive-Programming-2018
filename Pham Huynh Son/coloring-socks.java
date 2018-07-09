import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class coloringSocks {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int s = reader.nextInt();
        int c = reader.nextInt();
        int k = reader.nextInt();
        List<Integer> color = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < s; i++) {
            int count = 1;
            int key = reader.nextInt();
            if (!hm.containsKey(key)) {
                hm.put(key, count);
            } else {
                hm.put(key, hm.get(key) + 1);
            }
        }

        for (int i : hm.values()) {
            color.add(i);
        }

        Collections.sort(color);
        int h = c;
        int type = 0, machine = 0;

            for (int i = 0; i < color.size(); i++) {            
                if (color.get(i) > h) {
                    color.add(color.get(i) - h);
                    machine++;
                    type = 0;
                    h = c;
                } else {
                    h -= color.get(i);
                    type++;
                    if (type > k||i==color.size()-1) {
                        machine++;
                        type = 0;
                        h = c;
                    }
                }
            }
            System.out.println(machine);       
    }
}