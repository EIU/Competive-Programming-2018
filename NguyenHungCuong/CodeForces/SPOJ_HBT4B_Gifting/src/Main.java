
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        PriorityQueue<gift> list;
        HashMap<Long,gift> input;
        for (int i=0;i<test;i++){
            int numBear = scan.nextInt();
            input=new HashMap<>();
            for (int j=0;j<numBear;j++){
                long a = scan.nextLong();
                if (input.containsKey(a)){
                    input.get(a).quantity++;
                } else{
                    input.put(a, new gift(a, 1));
                }
            }
            list=new PriorityQueue<>(input.values());
            int count=0;
            while (list.size()>=3){
                gift a = list.poll();
                gift b = list.poll();
                gift c = list.poll();
                int minus = Math.min(a.quantity, Math.min(b.quantity, c.quantity));
                a.quantity-=minus;
                b.quantity-=minus;
                c.quantity-=minus;
                if (a.quantity!=0){
                    list.add(a);
                }
                if (b.quantity!=0){
                    list.add(b);
                }
                if (c.quantity!=0){
                    list.add(c);
                }
                count+=minus;
            }
            System.out.println(count);
        }
    }
    static class gift implements Comparable<gift>{
        long color;
        int quantity;

        public gift(long color, int quantity) {
            this.color = color;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(gift t) {
            return t.quantity-this.quantity;
        }
        
    }
    
}
