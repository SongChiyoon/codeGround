import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 15..
 */
public class JusaWee {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[][] map;
        int N = sc.nextInt();
        int M = sc.nextInt();

        int y = sc.nextInt();
        int x = sc.nextInt();

        int K = sc.nextInt();
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

            }
        }

        JusaWee solution = new JusaWee(map[y][x]);
        int[] result = new int[K];
        for(int i = 0; i < K; i++){
            result[i] = -1;
            int a = sc.nextInt();
            if(a == 1)if(x+1 < M) {
                result[i] = solution.goRight(map[y][x + 1]);
                x = x+1;
            }
            if(a == 2)if(x-1 >= 0) {
                result[i] = solution.goLeft(map[y][x - 1]);
                x = x-1;
            }

            if(a == 3)if(y-1 >= 0) {
                result[i] = solution.goBack(map[y - 1][x]);
                y = y-1;
            }
            if(a == 4)if(y+1 < N) {
                result[i] = solution.goFront(map[y + 1][x]);
                y = y+1;
            }
        }
        for(int i = 0; i < K; i++){
            if(result[i] != -1)
                System.out.println(result[i]);
        }
    }

    private int[] p; //1-top 2-front 3-bottom 4-back 5-right 6-left
    private int top = 1;
    private int front = 2;
    private int bottom = 3;
    private int back = 4;
    private int right = 5;
    private int left = 6;

    JusaWee(int point){
        p = new int[7];
        for(int i = 1; i <= 6; i++)
            p[i] = 0;
        p[bottom] = point;
    }
    public int goFront(int point){
        int temp = p[back];
        p[back] = p[bottom];
        p[bottom] = p[front];
        p[front] = p[top];
        p[top] = temp;

        p[bottom] = point;
        return p[top];
    }
    public int goBack(int point){
        int temp = p[1];
        for(int i = 1; i <= 4; i++){
            if(i != 4){
                p[i] = p[i+1];
            }else{
                p[i] = temp;
            }
        }
        p[bottom] = point;
        return p[top];
    }
    public int goRight(int point){
        int temp = p[left];
        p[left] = p[bottom];
        p[bottom] = p[right];
        p[right] = p[top];
        p[top] = temp;
        p[bottom] = point;
        return p[top];
    }
    public int goLeft(int point){
        int temp = p[left];
        p[left] = p[top];
        p[top] = p[right];
        p[right] = p[bottom];
        p[bottom] = temp;

        p[bottom] = point;

        return p[top];
    }


}
