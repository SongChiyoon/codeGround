import java.io.FileInputStream;
import java.util.*;

/**
 * Created by songchiyun on 2017. 6. 28..
 * 문제 : https://www.codeground.org/practice/practiceProblemView
 */
public class takingClass {

    static int Answer;

    public static void main(String args[]) throws Exception	{


        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("tackingClass_sample.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            boolean[] d = new boolean[M+1];
            int[] inputs = new int[N];

            for(int i=0;i<=M;i++)
                d[i] = false;

            for(int i=0;i<N;i++) {
                inputs[i] = sc.nextInt();
            }

            boolean[] temp = new boolean[M+1];
            for(int i=0;i<N;i++){

                for(int j=0;j<=M;j++){

                    if(d[j]) {
                        if(j+inputs[i] <= M) {
                            temp[j + inputs[i]] = true;
                        }
                    }
                }
                temp[inputs[i]] = true;
                d = Arrays.copyOf(temp, M+1);
            }
            for(int i=M;i>=0;i--){
                if(d[i]){
                    Answer = i;
                    break;
                }

            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
