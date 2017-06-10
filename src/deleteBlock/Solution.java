package deleteBlock;
/* �Ʒ� �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
   ��, ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
		Scanner sc = new Scanner(new FileInputStream("sample_deleteBlock.txt"));
        
		//Scanner sc = new Scanner(System.in);

		int TC;
		int w;
		int test_case;
		int[] block;
		int[] h;
		int count;
		int sum;
		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			w = sc.nextInt();
			block = new int[w];
			h = new int[w];
			count = 0;
			
			for(int i=0;i<w;i++){
				block[i] = h[i] = sc.nextInt();

			}
			do{	
				
				sum = 0;
				for(int i=count;i<w;i++){
					if(block[i] == 0) continue;
					
					if(i == count || i == w-1){
						h[i] = 0;
						continue;
					}
					
					int min = Integer.min(block[i-1], block[i+1]);
					
					if(block[i] > min){
						h[i] =  min;
					}
					else{
						h[i]--;
					}
					sum += h[i];
					
				}
				
				for(int i=0;i<w;i++)
					block[i] = h[i];				
				
				count++;
				
			} while(sum != 0);
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(count);
			
		}
	}
}