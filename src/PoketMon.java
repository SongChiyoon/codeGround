/*
 * problem : https://www.acmicpc.net/problem/1620
 */
import java.util.*;
public class PoketMon {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		int N = Integer.parseInt(num.split(" ")[0]);
		int M = Integer.parseInt(num.split(" ")[1]);
		Map<String, Integer> nameToNum = new HashMap<>();
		Map<Integer, String> numToName = new HashMap<>();
		String name;
		for(int i=1;i<=N;i++){			
			name = sc.nextLine();
			nameToNum.put(name, i);
			numToName.put(i, name);	
		}
		System.out.println("get doc!");
		String quiz;
		for(int i=0;i<M;i++){
			
			quiz = sc.nextLine();
			if(quiz.charAt(0) >= 'A' && quiz.charAt(0) <= 'Z'){
				System.out.println(nameToNum.get(quiz));
			}
			else{
				System.out.println(numToName.get(Integer.parseInt(quiz)));
			}
		}
		
	}
}
