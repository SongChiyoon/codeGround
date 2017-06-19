import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class makeOne {
    private int count;
    int[] d;
    int min = Integer.MAX_VALUE;
    makeOne(int N){
        count = 0;
        d = new int[N+1];
    }
    public int getMin(){
        return min;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        do{
            N = sc.nextInt();
        }while(N < 1 || N >1000000);
        makeOne solution = new makeOne(N);
        solution.dp(N);
        System.out.println(solution.dp2(N));
        sc.close();

    }
    public int dp2(int N){
        if(N == 1)
            return 0;
        if(d[N] > 0)
            return d[N];
        d[N] = dp2(N-1)+1;
        if(N % 2 == 0) {
            int temp = dp2(N / 2) + 1;
            if(temp < d[N]) d[N] = temp;
        }
        if(N%3 == 0){
            int temp = dp2(N/3)+1;
            if(temp < d[N]) d[N] = temp;
        }
        return d[N];
    }
    public void dp(int N){
        if(N == 1) {
            if(min > count)
                min = count;
            return;
        }
        if(N % 3 ==0){
            count++;
            dp(N/3);
            count--;
        }
        if(N % 2 ==0){
            count++;
            dp(N/2);
            count--;
        }
        count++;
        dp(N-1);
        count--;
    }

}
