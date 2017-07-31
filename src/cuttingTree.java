import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 31..
 * 문제 : https://www.acmicpc.net/problem/2805
 */
public class cuttingTree {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        long max = 0;
        long[] t = new long[N];
        for(int i=0;i<N;i++){
            t[i] = sc.nextLong();
            max = Math.max(max, t[i]);
        }
        long left = 1;
        long right = max;
        long ans = 0;
        while(left <= right){

            long mid = (right+left)/2;
            long s=0;
            for(int i=0;i<N;i++){
                if(mid < t[i])
                    s += (t[i]-mid);
            }
            if(s >= M){
                ans = Math.max(ans, mid);
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(ans);


    }
}
