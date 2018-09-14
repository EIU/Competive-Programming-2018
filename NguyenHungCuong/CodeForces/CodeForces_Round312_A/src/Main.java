
import java.util.ArrayList;
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTree = scan.nextInt();
        ArrayList<tree> myTree = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numTree; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            myTree.add(new tree(a, b));
            if (a < 0) {
                count++;
            }
        }
        myTree.sort((a, b) -> {
            if (a.location > b.location) {
                return 1;
            }
            if (a.location < b.location){
                return -1;
            }
            return 0;
        });
        if (count == 0) {
            System.out.println(myTree.get(0).fruit);
        } else {
            int index;
            int i;
            int ans = 0;
            if (count >= (numTree / 2)) {
                index = Math.max(0, count * 2 - numTree - 1);
                
                for (i = index; i < myTree.size(); i++) {
                    ans += myTree.get(i).fruit;
                }
                System.out.println(ans);
            } else {
                index = count*2+1;
                for (i=0;i<index;i++){
                    ans+=myTree.get(i).fruit;
                }
                System.out.println(ans);
            }

        }
    }

    static class tree {

        private int location;
        private int fruit;

        public tree(int location, int fruit) {
            this.location = location;
            this.fruit = fruit;
        }

    }
}
