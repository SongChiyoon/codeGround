import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 15..
 */
public class Coin1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int k = sc.nextInt();

        int[] c = new int[N+1];
        int[] d = new int[10001];

        for(int i = 1; i <= N; i++) {
            c[i] = sc.nextInt();
            d[c[i]] = 1;
        }
        Arrays.sort(c);

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= k; j++){

                if(j - c[i] >= 1){
                    d[j] += d[j-c[i]];
                }
            }
        }
        for(int i = 1; i <= k; i++)
            System.out.print(d[i] + " ");
        System.out.println("\n"+d[k]);


    }

}
