import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 6. 28..
 * 부분배열 : https://www.codeground.org/practice/practiceProblemView
 */
public class DisposalPartition {
    static int Answer;

    public static void main(String args[]) throws Exception	{

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("disposal_sample.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            int N = sc.nextInt();
            int M = sc.nextInt();


            int[] d = new int[N];
            for(int i=0;i<N;i++)
                d[i] = sc.nextInt();

            int front = 0;
            int back = -1;
            int sum = 0;
            int len = Integer.MAX_VALUE;

            System.out.println((front != N-1) && (back != N-1));
            while( (front != N-1) && (back != N-1)) {

                //System.out.println("?");
                if(sum < M){
                    back++;
                    sum += d[back];
                }
                else{

                    if(len > (back -front)+1) {
                        System.out.println(len + "vs" + (back -front)+1);
                        len = (back - front) + 1;
                    }
                    sum -= d[front];
                    front++;
                }
                if(back == N-1){

                    if(sum < M)
                        break;
                }

            }
            Answer = len;



            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
