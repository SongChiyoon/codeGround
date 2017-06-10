import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Scanner;
class Block implements Comparable<Block>{
	private int hang;
	private int yul;
	Block(int hang, int yul){
		this.hang = hang;
		this.yul = yul;
	}

	public int getHang() {
		return hang;
	}

	public void setHang(int hang) {
		this.hang = hang;
	}

	public int getYul() {
		return yul;
	}

	public void setYul(int yul) {
		this.yul = yul;
	}

	@Override
	public int compareTo(Block other) {
		return Integer.compare(this.hang,other.getHang());

	}
}
public class chessMath {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PriorityQueue<Block> blockQueue = new PriorityQueue<>();

		int TC;
		int test_case;

		TC = sc.nextInt();
		for (test_case = 1; test_case <= TC; test_case++) {

			int N, M, bNum;
			int[] d;
			N = sc.nextInt();
			M = sc.nextInt();

			d = new int[M + 1];
			bNum = sc.nextInt();
			Block[] block = new Block[bNum];

			for (int i = 0; i < bNum; i++) {

				int r = sc.nextInt();
				int c = sc.nextInt();
				if(r < 0 || r > N || c < 0 || c > M)
					continue;
				block[i] = new Block(r, c);
				blockQueue.offer(block[i]);

			}

			for (int i = 1; i <= N; i++) {

				int[] b = new int[M+1];

				while (!blockQueue.isEmpty()) {

					if (blockQueue.peek().getHang() == i) {
						Block temp = blockQueue.remove();
						b[temp.getYul()] = -1;
					} else {
						break;
					}
				}

				for (int j = 1; j <= M; j++) {
					if (i == 1 && b[j] != -1) {
						d[j] = 1;
						continue;
					}
					if (b[j] == -1) {
						d[j] = -1;
						continue;
					}
					if(d[j] == -1)
						d[j] = 0;

					if(d[j-1] != -1)
						d[j] += d[j-1];

					d[j] %= 1000000007;
				}
			}

			System.out.println("Case #" + test_case);
			for(int i = 1; i <= M; i++)
				System.out.println(d[i] + " ");
		}

	}


}

