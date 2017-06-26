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

    public static int Answer;
    private int start;
    private int target;
    private Station[] stations;
    private int K;
    private int sum;

    DiscountTicket(Station[] stations){
        this.stations = stations;
        for(int i = 1; i < stations.length; i++){
            stations[i].cost = Integer.MAX_VALUE;
        }
    }
    public void computePath(Station source){
        PriorityQueue<Station> pq = new PriorityQueue<>();
        source.cost = 0;
        pq.offer(source);

        while(!pq.isEmpty()){

            Station actualStation = pq.poll();

            for(edge e : actualStation.getEdges()){

                Station station = stations[e.b];
                int newDistance = actualStation.cost + e.cost;

                if(station.cost > newDistance) {
                    pq.remove(station);
                    station.cost = newDistance;
                    pq.offer(station);
                }
            }

        }
    }
    public int getCost(Station target){
        System.out.println("target : "+target.name + " cost :"+target.cost);
        return target.cost;
    }


    public static void main(String args[]) throws Exception	{

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("discountTicket_input.txt"));
        Station[] stations;
        List<edge> edgeList = new ArrayList<>();
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;

            int N = sc.nextInt();
            stations = new Station[N+1];

            for(int i=1;i<=N;i++) {
                stations[i] = new Station(i);
            }
            int M = sc.nextInt();

            int K = sc.nextInt();  //ticket 가격

            for(int i=0;i<M;i++){
                int s, t, c;
                s = sc.nextInt();
                t = sc.nextInt();
                c = sc.nextInt();
                edge e1 = new edge(s,t,c);
                stations[s].addEdge(e1);
                edge e2 = new edge(t,s,c);
                stations[t].addEdge(e2);
            }


            int P = sc.nextInt();
            for(int i=0;i<P;i++){
                int s, t;
                s = sc.nextInt();
                t = sc.nextInt();

                DiscountTicket d = new DiscountTicket(stations);
                d.computePath(stations[s]);

                int cost = d.getCost(stations[t]);

                if(cost < K)
                    Answer++;
            }
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
class Station implements Comparable<Station>{
    int name;
    List<edge> edges;
    boolean visited;
    int cost;
    Station(int name){
        this.name = name;
        this.visited =false;
        edges = new ArrayList<>();
    }
    public void addEdge(edge e){
        edges.add(e);
    }
    public List<edge> getEdges(){
        return this.edges;
    }

    @Override
    public int compareTo(Station other) {
        return Integer.compare(this.cost, other.cost);
    }
}
class edge{
    int a;
    int b;
    int cost;
    edge(int s, int t, int c){
        this.a = s;
        this.b = t;
        this.cost = c;
    }
}