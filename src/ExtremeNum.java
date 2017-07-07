import java.util.Scanner;
import java.util.Stack;

/**
 * Created by songchiyun on 2017. 7. 7..
 */
public class ExtremeNum {
    public static int Answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            int N = sc.nextInt();
            System.out.println("Case #" + (test_case + 1));

            int position = 0;
            int i = 0;
            int num = 0;

            while(position < N){
                i++;
                num = position;
                position += Math.pow(2,i);
            }

            position = N - num;

            int front = 0;
            int back = (int)Math.pow(2, i);

            for(int j = i; j > 0 ; j--){

                int mid = (int)(front+back)/2;
                if(position <= mid){
                    System.out.print(4);
                    back = mid;
                }else{
                    System.out.print(7);
                    front = mid+1;
                }

            }
            System.out.println();

        }
    }
}
