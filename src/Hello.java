import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 14..
 * https://www.codeground.org/practice/practiceProblemList
 * 문제 : 안녕
 */
public class Hello {
    static int Answer;

    public static void main(String args[]) throws Exception	{

        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        /*HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String hello = "hello";
        init(hello, map);
        System.out.println(map.get('w'));*/
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            String input = sc.next();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            String hello = "hello";
            init(hello, map);
            for(int i=0;i<input.length();i++){
                char c = input.charAt(i);
                if(map.get(c) == null)
                    continue;
                map.put(c, map.get(c)+1);
            }
            //System.out.println(map.get('l'));
            map.put('l',map.get('l')/2);
            //System.out.println(map.get('l'));
            int min = Integer.MAX_VALUE;
            for(int i=0;i<hello.length();i++){
                min = Math.min(map.get(hello.charAt(i)), min);
            }
            Answer = min;
            /*
            for(int i=0;i<input.length();i++){
                if(input.charAt(i) == 'h') {
                    int index = 0;
                    String temp = input;
                    init(hello, map);
                    for (int j = i; j < input.length(); j++) {
                        char c = temp.charAt(j);

                        if (map.get(c) != null){
                            if(map.get(c) != 0) {
                                if(c != 'l')
                                    continue;
                                else if(map.get(c) >= 2) continue;
                                else{
                                    temp = temp.substring(0, j) + '_' + temp.substring(j + 1, temp.length());
                                    map.put(c, map.get(c) + 1);
                                    index++;
                                }
                            }
                            else{
                                if(map.get(c) == 0){
                                    temp = temp.substring(0,j) +'_'+temp.substring(j+1, temp.length());
                                    index++;
                                    map.put(c, map.get(c)+1);
                                }
                                else
                                    continue;
                            }

                            if(index == hello.length()) {
                                System.out.println(input +"->"+temp);
                                input = temp;
                                Answer++;
                                break;
                            }
                        }

                    }
                }
            }*/
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
    public static void init(String h, HashMap<Character, Integer> map){
        for(int i=0;i<h.length();i++){
            map.put(h.charAt(i), 0);
        }
    }
}
