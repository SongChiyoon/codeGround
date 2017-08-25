import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 25..
 * problem : https://www.acmicpc.net/problem/5021
 */
public class King {

    static class person{
        int num;
        String name;
        double cost;
        List<Integer> sonList;
        person(String name){
            this.name = name;
            sonList = new LinkedList<>();
        }
        public void addSon(int s)
        {
            this.sonList.add(s);
        }
        public void setCost(double c){
            this.cost = c;
        }
    }
    static class edge{
        int son, parent;
        edge(int t, int s){
            this.son = s;
            this.parent = t;
        }
    }
    static HashMap<String, Integer> map;
    static HashMap<Integer,String> ItoSmap;
    static person[] d;
    static boolean[] v;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        d = new person[2*N+1];
        v = new boolean[2*N+1];
        int num = 0;

        String king = sc.next();
        map = new HashMap<>();
        ItoSmap = new HashMap<>();
        map.put(king, num);
        ItoSmap.put(num, king);
        d[num] = new person(king);
        num++;
        for(int i=0;i<N;i++){
            String son = sc.next();
            String m = sc.next();
            String f = sc.next();

            d[num] = new person(son);
            map.put(son, num);
            ItoSmap.put(num, son);
            num++;

            if(map.get(m) == null) {
                map.put(m, num);
                ItoSmap.put(num, m);
                d[num] = new person(m);
                d[num].addSon(map.get(son));
                num++;
            }
            else{
                d[map.get(m)].addSon(map.get(son));
            }

            if(map.get(f) == null){
                map.put(f, num);
                ItoSmap.put(num, f);
                d[num] = new person(f);
                d[num].addSon(map.get(son));
                num++;
            }
            else{
                d[map.get(f)].addSon(map.get(son));
            }
        }

        double cost=10000;

        dfs(0, cost, 1);


        double max = Double.MIN_VALUE;
        String ans = "";

        for(int i=0;i<M;i++){
            String compare = sc.next();
            System.out.println(compare+" : "+d[map.get(compare)].cost);
            if(max < d[map.get(compare)].cost){
                max = d[map.get(compare)].cost;
                ans = compare;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int current, double cost, int i){

        System.out.println(ItoSmap.get(current)+" : "+"1/"+i);
        d[current].setCost(cost);
        for(int son : d[current].sonList){
            dfs(son, cost/2, i*2);
        }
    }
}
