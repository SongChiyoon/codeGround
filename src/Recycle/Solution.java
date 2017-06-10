package Recycle;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

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
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� sample_input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� sample_input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� sample_input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
		Scanner sc = new Scanner(new FileInputStream("sample_input_recycle.txt"));
        
		//Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		int N, M; //N ���� , M �������� ��
		int[] home;
		int[] box;
		Distance[] distance;
		PriorityQueue<Distance> priorityQueue = new PriorityQueue<>();

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
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
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			
		}

	}
}