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
                    boolean find = false;
                    int p = -1;
                    for(int i=index-1;i>=0;i--){
                        if(ans.charAt(i) == '7'){
                            find = true;
                            p = i;
                            break;
                        }
                    }
                    if(find){
                        String temp = "";
                        for(int i=0;i<p;i++){
                            temp += ans.charAt(i);
                        }
                        temp += "4";
                        for(int i =p+1;i<N.length();i++){
                            temp += "7";
                        }
                        ans = temp;
                    }
                    else{
                        index = 1;
                        ans = "";
                        for(int i =index;i<N.length();i++)
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
