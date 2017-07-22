import java.util.PriorityQueue;
import java.util.Scanner;

public class MeetingRoom {

	public static class meeting implements Comparable<meeting>{
		int start;
		int end;
		meeting(int s, int e){
			this.start = s;
			this.end = e;
		}
		@Override
		public int compareTo(meeting other) {
			if(this.start == other.start){
				return Integer.compare(this.end, other.end);
			}
			return Integer.compare(this.start, other.start);
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<meeting> m = new PriorityQueue<meeting>();
		for(int i=0;i<N;i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			m.add(new meeting(s,e));
		}
		int Answer = 0;
		/*while( !m.isEmpty() ){
			meeting t = m.remove();
			System.out.println(t.start+"-"+t.end);
		}*/
		meeting s = m.remove();
		Answer++;

		while( !m.isEmpty() ){
			meeting temp = m.remove();

			if(temp.start >= s.end){
				s = temp;				
				Answer++;
			}
			else{
				if(temp.end <= s.end){
					s = temp;
				}
			}
			
		}
		System.out.println(Answer);
		
	}
}
