import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 22..
 */
public class Triangle {

    public static void main(String[] args){

        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] d = new int[N][M];
        for(int i=0;i<N;i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                d[i][j] = (int)input.charAt(j)-48;
            }
        }

        int ans = 1;
        for(int i=0;i<N;i++){

            boolean pass = false;
            for(int j=0;j<M;j++){

                int index = 1;
                int num = d[i][j];

                for(int k = 1; k+j < M && k+i < N; k++){
                    if(num == d[i][k+j] && num == d[k+i][j] && num == d[k+i][k+j]){
                        //System.out.println(i+","+j+" : "+k);
                        //System.out.println(d[i][j]+","+d[i][k+j]+","+d[k+i][j] +"."+d[k+i][k+j]);
                        ans = Math.max(ans, (k+1)*(k+1));
                    }

                }

            }

        }
        System.out.println(ans);
    }
}
