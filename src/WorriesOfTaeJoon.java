import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 14..
 * https://www.codeground.org/practice/practiceProblemView
 * 문제 : 태준이의 걱정
 */
public class WorriesOfTaeJoon {

    static int Answer;

    public static void main(String args[]) throws Exception	{

        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            int A = sc.nextInt();
            int B = sc.nextInt();
            int D = sc.nextInt();

            int m = 1;
            int t = D/(A-B);
            t += 1;

            if(((A-B)*(t-1) + A) >= D){
                for(int i = t; i >= 1; i--){

                    if(((A-B)*(i-1) + A) < D){
                        m = i+1;
                        break;
                    }
                }
            }
            else {
                while(((A-B)*(t-1) + A) < D){
                    t++;
                }
                m = t;
            }

           /* while(((A-B)*(m-1) + A) < D)
                m++;*/

            System.out.println("Case #"+(test_case+1));
            System.out.println(m);
        }
    }

}
