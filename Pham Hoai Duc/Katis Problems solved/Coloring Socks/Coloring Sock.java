/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2problemc.pkg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Duc PC
 */
public class W2ProblemC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ip = new Scanner(System.in);
        int s = ip.nextInt();
        int c = ip.nextInt();
        int k = ip.nextInt();
        HashMap<Integer, Integer> amount = new HashMap();
        for(int i = 0; i < s; i++)
        {
            int d = ip.nextInt();
            if(amount.containsKey(d))
                amount.compute(d, (t, v) -> v + 1);
            else
                amount.put(d, 1);
        }
        ArrayList<Integer> list = new ArrayList<>(amount.keySet());
        Collections.sort(list);
        int machines = 0;
        int length = list.size();
        //solve problem here:
        for (int i = 0; i < length; i++) {
            int di = list.get(i);
            machines += (amount.get(di) / c);
            if (amount.get(di) % c != 0) {
                if(i + 1 < length && list.get(i + 1) - di <= k)
                    amount.compute(list.get(i + 1), (t,v)-> v+(amount.get(di) % c));
                else
                    machines++;
            }
        }
        System.out.println(machines);
    }
    
}
