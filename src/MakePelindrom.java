/*
 * https://www.acmicpc.net/problem/1213
 */
import java.util.*;
public class MakePelindrom {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> wordCount = new HashMap<>();
		String name = sc.nextLine();
		
		for(int i=0;i<name.length();i++){
			
			if(!wordCount.containsKey(name.charAt(i))){
				wordCount.put(name.charAt(i), 1);
			
			}
			else
				wordCount.put(name.charAt(i), wordCount.get(name.charAt(i))+1);
			
		}

		Iterator itr = wordCount.keySet().iterator();
		List<Character> newName = new ArrayList<>();

		int cnt = 0;
		char last = ' ';
		while(itr.hasNext()){
			char word = (char)itr.next();
			if(wordCount.get(word) % 2 ==0){
				for(int i=0;i<wordCount.get(word)/2;i++){
					newName.add(word);
				}
			}
			else{
				cnt++;
				if(cnt > 1)
				{
					break;
				}
				for(int i=0;i<wordCount.get(word)/2;i++){
					newName.add(word);
				}
				last = word;
			}
			
		}
		Collections.sort(newName);
		StringBuilder result = new StringBuilder();
		for(int i=0;i<newName.size();i++){
			result.append(newName.get(i));
		}
		if(last != ' ')
			result.append(last);
		for(int i=newName.size()-1;i>=0;i--){
			result.append(newName.get(i));
		}
		if(cnt > 1)
			System.out.println("I'm Sorry Hansoo");
		else{
			System.out.println(result);
		}
		
		
		
		
	}
}
