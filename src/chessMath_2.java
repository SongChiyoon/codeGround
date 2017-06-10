import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Scanner;

public class chessMath_2 {

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
            int colSum;

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

                }

            }

            System.out.println("Case #" + test_case);
            for(int i = 1; i <= M; i++)
                System.out.println(d[i] + " ");
        }

    }


}

