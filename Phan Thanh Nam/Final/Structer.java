import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Structer {
	public static boolean Stack(int []cmd,int []value) {
		ArrayList<Integer>stack=new ArrayList<>();
		for(int i=0;i<cmd.length;i++) {
			if(cmd[i]==1) {
				stack.add(value[i]);
			}else {
				if(stack.isEmpty()||stack.remove(stack.size()-1)!=value[i]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean Queue(int []cmd,int []value) {
		ArrayList<Integer>queue=new ArrayList<>();
		for(int i=0;i<cmd.length;i++) {
			if(cmd[i]==1) {
				queue.add(value[i]);
			}else {
				if(queue.isEmpty()||queue.remove(0)!=value[i]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean Priority_Queue(int []cmd,int []value) {
		ArrayList<Integer>pq=new ArrayList<>();
		for(int i=0;i<cmd.length;i++) {
			if(cmd[i]==1) {
				pq.add(value[i]);
			}else {
				Collections.sort(pq);
				if(pq.isEmpty()||pq.remove(pq.size()-1)!=value[i]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] cmd = new int[n];
			int[] value = new int[n];
			for (int i = 0; i < n; i++) {
				cmd[i] = sc.nextInt();
				value[i] = sc.nextInt();
			}
			int count=0;
			String s="impossible";
			if(Stack(cmd,value)) {
				s="stack";
				count++;
			}
			if(Queue(cmd, value)) {
				s="queue";
				count++;
			}
			if(Priority_Queue(cmd, value)) {
				s="priority queue";
				count++;
			}
			if(count>1) {
				System.out.println("not sure");
			}else {
				System.out.println(s);
			}
		}
	}

}
