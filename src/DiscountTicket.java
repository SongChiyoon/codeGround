import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 6. 25..
 * https://www.codeground.org/practice/practiceProblemView
 */
public class DiscountTicket {

    static int Answer;
    public static class edge{
        int s;
        int d;
        int cost;
        edge(int s, int d, int cost){
            this.s = s;
            this.d = d;
            this.cost = cost;
        }
    }
    public static class station implements Comparable<station>{
        int cost;
        int name;
        List<edge> edgeList;
        station(int name){
            this.name = name;
            edgeList = new ArrayList<>();
        }
        public void addEdge(edge e){edgeList.add(e);}

        @Override
        public int compareTo(station other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    public static void init(station[] stations){
        for(int i=1;i<stations.length;i++)
            stations[i].cost = Integer.MAX_VALUE;
    }
    public static void main(String args[]) throws Exception {

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("discountTicket_input.txt"));

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            int N = sc.nextInt();  //number of stations
            int M = sc.nextInt(); // number of edges
            int K = sc.nextInt();

            station[] s = new station[N+1];
            for(int i=0;i<N+1;i++)
                s[i] = new station(i);

            for(int i=0;i<M;i++){
                int src = sc.nextInt();
                int des = sc.nextInt();
                int cost = sc.nextInt();
                edge e1 = new edge(src,des,cost);
                edge e2 = new edge(des,src,cost);
                s[src].addEdge(e1);
                s[des].addEdge(e2);
            }
            int P =sc.nextInt();
            Answer = 0;
            for(int i=0;i<P;i++){
                int src = sc.nextInt();
                int des = sc.nextInt();

                init(s);
                PriorityQueue<station> pq = new PriorityQueue<>();

                s[src].cost = 0;

                pq.add(s[src]);
                while( !pq.isEmpty() ){
                    station actual = pq.remove();
                    for(edge e : actual.edgeList){
                        if(e.s == actual.name || e.d == actual.name){
                            int tempDes;
                            if(e.s == actual.name)
                                tempDes = e.d;
                            else
                                tempDes = e.s;

                            int compare = actual.cost + e.cost;

                            if(compare < s[tempDes].cost) {
                                s[tempDes].cost = compare;
                                pq.add(s[tempDes]);
                            }
                        }
                    }
                }
                if(s[des].cost > K)
                    Answer++;

            }

            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}