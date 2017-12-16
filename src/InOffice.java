/*
 * problem : https://www.acmicpc.net/problem/7785
 */
import java.util.*;
public class InOffice {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		Map<String, Boolean> log = new HashMap<>();
		String input;
		String name;
		String state;
		for(int i=0;i<N;i++){
			input = sc.nextLine();
			name = input.split(" ")[0];
			state = input.split(" ")[1];
			if(state.equals("enter")){
				log.put(name, true);
			}
			else{
				log.remove(name);
			}
		}
		List<String> results = new LinkedList<>();
		Iterator itr = log.keySet().iterator();
		while(itr.hasNext()){
			results.add((String)itr.next());
		}
		Collections.sort(results);
		for(int i=results.size()-1;i>=0;i--){
			System.out.println(results.get(i));
		}
	}
}
