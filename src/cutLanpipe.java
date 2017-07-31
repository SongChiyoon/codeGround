import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 31..
 * 문제 : https://www.acmicpc.net/problem/1654
 */
public class cutLanpipe {
    public static boolean check(long[] a, int m, long x) {
        int cnt = 0;
        for (int i=0; i<a.length; i++) {
            cnt += a[i]/x;
        }
        return cnt >= m;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long max = 0;
        long[] lines = new long[K];
        for(int i=0;i<K;i++){
            lines[i] = sc.nextLong();
            if(max < lines[i])
                max = lines[i];
        }
        long s ;
        long left = 1;
        long right = max;
        long ans = 0;
        while( left <= right ){
            long mid = (left+right)/2;
            if (check(lines, N, mid)) {
                ans = Math.max(ans,mid);
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(ans);
    }
}
