import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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
            Queue<Integer> Q = new LinkedList<>();
            int sum = 0;
            int len = 10000;


            for(int i=0;i<N;i++){
                int input = sc.nextInt();
                Q.add(input);
                sum += input;
                while(sum >= M){
                    int size = Q.size();

                    if(len > size)
                        len = size;
                    sum -= Q.remove();
                }
            }
            if(len == 10000)
                len = 0;


            /*
            for(int i=0;i<N;i++) {
                d[i] = sc.nextInt();
            }
            int front = 0;
            int back = 0;
            int sum = d[back];
            int len = Integer.MAX_VALUE;

            while(true) {

                if(sum < M){
                    if(back == N-1)
                        break;
                    back++;
                    sum += d[back];

                }
                else{
                    if(front == back){
                        len = 1;
                        break;
                    }

                    int tempLen = (back - front)+1;
                    if(len > tempLen) {
                        len = tempLen;
                    }
                    sum -= d[front];
                    front++;
                }

            }*/
            Answer = len;
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
