package Recycle;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	
	public static class Distance implements Comparable<Distance>{
		private int distance;
		private int index;
		public Distance(int distance, int index){
			this.distance = distance;
			this.index = index;
		}
		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		@Override
		public int compareTo(Distance otherDistance) {
			return Integer.compare(distance, otherDistance.getDistance());
		}
	}
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		Scanner sc = new Scanner(new FileInputStream("sample_input_recycle.txt"));
        
		//Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		int N, M; //N 집수 , M 쓰레기통 수
		int[] home;
		int[] box;
		Distance[] distance;
		PriorityQueue<Distance> priorityQueue = new PriorityQueue<>();

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
			N = sc.nextInt();
			home = new int[N];
			M = sc.nextInt();
			box = new int[M];
			distance = new Distance[N-1];
			
			for(int i=0;i<N;i++){
				home[i] = sc.nextInt();
				
				if(i!=0){
					distance[i-1] = new Distance(home[i] - home[i-1], i);
					priorityQueue.add(distance[i-1]);
				}
				
			}
			
			while(!priorityQueue.isEmpty()){
				Distance d = priorityQueue.remove();
				System.out.println(d.getDistance());
			}    
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			
		}

	}
}