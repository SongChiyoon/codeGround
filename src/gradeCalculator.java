/**
 * Created by songchiyun on 2017. 11. 13..
 * problem : https://www.acmicpc.net/problem/10984
 */
import java.util.*;
public class gradeCalculator {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for(int t=0;t<T;t++){

            int N = sc.nextInt();
            float sum = 0;
            int classes = 0;
            for(int i=0;i<N;i++){

                int size =sc.nextInt();
                float grade = sc.nextFloat();
                classes += size;
                sum += size*grade;

            }
            float get = Math.round(10*sum/classes);
            String f = String.format("%.1f",get/10);
            System.out.println(classes +" "+f);


        }
    }
}
