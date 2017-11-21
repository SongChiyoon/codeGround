/*
 * problem : https://www.acmicpc.net/problem/1181
 */
import java.util.*;
public class WordSort {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<N;i++){
			list.add(sc.next());		
		}
		
		Comparator sort = new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				if(s1.length() == s2.length()){
					return s1.compareTo(s2);
				}
				else{
					return Integer.compare(s1.length(), s2.length());
				}
			}
			
		};
		Collections.sort(list, sort);
		String pre = "";
		StringBuilder result = new StringBuilder();
		for(String s : list){
			if(pre.equals(s))
				continue;
			result.append(s+"\n");
			pre = s;
		}
		System.out.println(result);
	}
}
