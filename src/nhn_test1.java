package NHN_preTest1;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class test1 {
	static class num implements Comparable<num>{
		
		String number;
		String compare;
		num(String number){
			this.number = number;
		}
		@Override
		public int compareTo(num o) {
			// TODO Auto-generated method stub
		
			int length_1 = number.length();
			int length_2 = o.number.length();
			if(length_1 != length_2){
				if(number.charAt(0) > o.number.charAt(0))
					return -1;
				else if(number.charAt(0) < o.number.charAt(0))
					return 1;
				
				if(length_1 > length_2){
					return -Integer.compare(Integer.parseInt(number.charAt(1)+""), Integer.parseInt(o.number));
				}
				else{
					return -Integer.compare(Integer.parseInt(number), Integer.parseInt(o.number.charAt(1)+""));
				}
			}
			else{
				return -Integer.compare(Integer.parseInt(number), Integer.parseInt(o.number));
			}
			
		}		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String a1 = "11";
		System.out.println(Integer.parseInt(a1.charAt(1)+""));
		String input = sc.nextLine();
		String[] data = input.split(" ");
		
		int n = data.length;
		
		num[] d = new num[data.length];
		
		PriorityQueue<num> pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++){

			d[i] = new num((data[i]));
		
			pq.add(d[i]);
		}
		String min = "";
		String max = "";
		Stack<String> s = new Stack<>();
		while(!pq.isEmpty()){
			num a = pq.remove();
			min += a.number;
			s.add(a.number);
		}
		while(!s.isEmpty()){
			max += s.pop();
		}
		System.out.println(Integer.parseInt(min)+Integer.parseInt(max));
		
		
	}
}
