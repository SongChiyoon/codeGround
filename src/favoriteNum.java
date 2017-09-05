import java.util.Scanner;
import java.util.SortedSet;

/**
 * Created by songchiyun on 2017. 9. 5..
 * problem : https://www.acmicpc.net/problem/1526
 */
public class favoriteNum {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int n = Integer.valueOf(N);
        N = String.valueOf(n);
        int index = 0;
        String ans = "";
        while(index != N.length()){

            int f = Character.getNumericValue(N.charAt(index));


            if(f == 7 || f == 4){
                ans += N.charAt(index);
                index++;
            }
            else if(f > 7){
                ans += "7";
                index++;
                for(int i=index; i<N.length();i++){
                    ans += "7";
                }
                break;
            }
            else if(f > 4){
                ans += "4";
                index++;
                for(int i=index; i<N.length();i++){
                    ans += "7";
                }
                break;
            }
            else{
                if(ans.length() != 0){
                    index = 0;
                    ans = "";
                    if(N.charAt(index) == '7') {
                        ans += "4";
                        index++;
                    }
                    else{
                        index++;
                    }
                    for(int i=index;i<N.length();i++){
                        ans += "7";
                    }
                    break;
                }
                else{
                    index++;
                    for(int i=index; i<N.length();i++){
                        ans += "7";
                    }
                    break;
                }
            }

        }
        System.out.println(ans);


    }



}
