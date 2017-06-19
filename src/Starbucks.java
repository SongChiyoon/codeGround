import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 6. 19..
 */
public class Starbucks {
    static char Answer;

    public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);

        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int N, M, K;
            int[] c_i;
            int[] p_i;

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            c_i = new int[N+1];

            for(int i=1;i<N+1;i++){
                c_i[i] = sc.nextInt();
            }
            p_i = new int[M+1];

            for(int i=1;i<M+1;i++)
                p_i[i] = sc.nextInt();

            int sum = 0;
            for(int i=1;i<N+1;i++){
                sum += p_i[c_i[i]];
            }
            if(sum > K)
                Answer = 'N';
            else
                Answer = 'Y';
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
