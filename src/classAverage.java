/**
 * Created by songchiyun on 2017. 11. 13..
 * problem : https://www.acmicpc.net/problem/10039
 */
import java.util.*;
public class classAverage {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i=0;i<5;i++){
            int num = sc.nextInt();
            if(num < 40)
                num = 40;
            sum += num;
        }
        System.out.println(sum/5);
    }
}
