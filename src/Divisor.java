import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 6. 19..
 * 최대공약수 최소공배수
 */
public class Divisor {

    public static void main(String[] args){
        int a, b;
        int min = 1, max= -1;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int temp;
        //set a is smaller than b
        if(a > b) {
            temp = b;
            b = a;
            a = temp;
        }
        else if(b > a) {
            // null
        }
        else {
            System.out.println(a);
            System.out.println(a);
            return;
        }

        for(int i = a-1; i > 0; i--){
            if(a % i == 0){
                if(b % i ==0) {
                    min = i;
                    break;
                }
            }
            if(i == 1)
                min = 1;
        }
        temp = a;
        int i = 2;
        while(true){
            if(temp % b == 0)
            {
                max = temp;
                break;
            }
            else{
                temp = a * i;
                i++;
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
