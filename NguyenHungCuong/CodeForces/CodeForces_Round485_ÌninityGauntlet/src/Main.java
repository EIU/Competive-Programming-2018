
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
        HashMap<String,String> allGems = new HashMap<>();
        
        allGems.put("purple", "Power");
        allGems.put("green", "Time");
        allGems.put("red", "Reality");
        allGems.put("blue", "Space");
        allGems.put("orange", "Soul");
        allGems.put("yellow", "Mind");
        
        int n= scan.nextInt();
        
        
        ArrayList<String> gems = new ArrayList<>();
        
        for (int i=0;i<n;i++) {
         
            gems.add(scan.next());
            
        }
        
        if (n==6){
            System.out.println("0");
            return;
        }
        
        System.out.println(6-n);
        
        Iterator it = allGems.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (!gems.contains((String)pair.getKey())) {
                
                System.out.println(pair.getValue());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
}
        
    }
    
