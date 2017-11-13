/**
 * Created by songchiyun on 2017. 11. 13..
 * problem : https://www.acmicpc.net/problem/2160
 */
import java.util.*;
public class similarDrawing {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int A = 5;
        int N = sc.nextInt();
        int M = 7;
        char[][][] d = new char[N][A][M];
        int num =-1;

        for(int i=0;i<N;i++){
            for(int j=0;j<A;j++){
                String input = sc.next();
                for(int k=0;k<M;k++){
                    d[i][j][k] = input.charAt(k);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int num1, num2;
        num1 = num2 = -1;
        for(int i=0;i<N;i++){

            for(int j=i+1;j<N;j++){
                int temp = 0;
                for(int k=0;k<M;k++){
                    for(int l=0;l<A;l++){

                        if(d[i][l][k] != d[j][l][k]){
                            temp++;
                        }
                    }
                }
                if(min > temp){
                    min = temp;
                    num1 = i+1;
                    num2 = j+1;
                }
            }

        }
        System.out.println(num1 +" "+num2);

    }
}
