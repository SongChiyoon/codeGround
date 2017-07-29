import java.util.*;

/**
 * Created by songchiyun on 2017. 7. 27..
 */
class island {
    int name;
    int cost;
    int x, y;
    island(int cost, int x, int y) {
        this.cost =cost;
        this.name = 0;
        this.x = x;
        this.y = y;

    }

    public void getName(int name){this.name = name;}
    public void getCost(int cost){this.cost = cost;}
}
public class makeBridge {

    static island[][] d;
    static boolean[][] b;
    int numberOfIsland;
    int ans;
    List<island>[] list;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        makeBridge cl = new makeBridge();

        int N = sc.nextInt();
        d = new island[N][N];
        b = new boolean[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++) {
                int src = sc.nextInt();
                if (src == 1) {
                    b[i][j] = true;
                    d[i][j] = new island(0, j, i);
                }
                else {
                    b[i][j] = false;
                    d[i][j] = new island(Integer.MAX_VALUE, j, i);
                }
            }
        cl.findIsland(N);
        cl.buildBridge(N);
        System.out.println(cl.ans-1);
    }

    public void init(int N){

        for(int i =0;i<N;i++){

            for(int j=0;j<N;j++){
                if (b[i][j]) {
                    d[i][j].cost = 0;
                }
                else {
                    d[i][j].cost = Integer.MAX_VALUE;
                }
            }
        }
    }
    public void checkName(int N){
        int[][] c = new int[N][N];
        for(int i =0;i < numberOfIsland; i++){
            for(island a : list[i]){
                c[a.y][a.x] = 1;
            }
        }
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(c[i][j] +"  ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public void buildBridge(int N){

        int minCost = -1;
        Queue<island> q = new LinkedList<>();
        for(int i=0;i<numberOfIsland;i++){
            init(N);
            for(island s: list[i]) {
                island source =s;
                int sourceName = s.name;
                q.add(s);
                while( !q.isEmpty() ){
                    island is = q.remove();
                    if(is.y-1>=0){
                        if(!b[is.y-1][is.x]){  //바다
                            if(minCost == -1){
                                d[is.y - 1][is.x].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y - 1][is.x]);
                            }
                            else if(minCost > d[is.y][is.x].cost+1) {
                                d[is.y - 1][is.x].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y - 1][is.x]);
                            }
                        }
                        else if(sourceName != d[is.y-1][is.x].name){
                            if(minCost == -1){
                                minCost = d[is.y][is.x].cost+1;
                            }
                            else{
                                if(minCost > d[is.y][is.x].cost+1){
                                    minCost = d[is.y][is.x].cost+1;
                                }
                            }
                        }
                    }
                    if(is.y+1<N){
                        if(!b[is.y+1][is.x]){
                            if(minCost == -1){
                                d[is.y+1][is.x].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y+1][is.x]);
                            }
                            else if(minCost > d[is.y][is.x].cost+1) {
                                d[is.y+1][is.x].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y+1][is.x]);
                            }
                        }
                        else if(sourceName != d[is.y+1][is.x].name){
                            if(minCost == -1){
                                minCost = d[is.y][is.x].cost+1;
                            }
                            else{
                                if(minCost > d[is.y][is.x].cost+1){
                                    minCost = d[is.y][is.x].cost+1;
                                }
                            }
                        }
                    }
                    if(is.x-1>=0){
                        if(!b[is.y][is.x-1]){
                            if(minCost == -1){
                                d[is.y][is.x-1].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y][is.x-1]);
                            }
                            else if(minCost > d[is.y][is.x].cost+1) {
                                d[is.y][is.x-1].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y][is.x-1]);
                            }
                        }
                        else if(sourceName != d[is.y][is.x-1].name){
                            if(minCost == -1){
                                minCost = d[is.y][is.x].cost+1;
                            }
                            else{
                                if(minCost > d[is.y][is.x].cost+1){
                                    minCost = d[is.y][is.x].cost+1;
                                }
                            }
                        }
                    }
                    if(is.x+1<N){
                        if(!b[is.y][is.x+1]){
                            if(minCost == -1){
                                d[is.y][is.x+1].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y][is.x+1]);
                            }
                            else if(minCost > d[is.y][is.x].cost+1) {
                                d[is.y][is.x+1].cost = d[is.y][is.x].cost + 1;
                                q.add(d[is.y][is.x+1]);
                            }
                        }
                        else if(sourceName != d[is.y][is.x+1].name){
                            if(minCost == -1){
                                minCost = d[is.y][is.x].cost+1;
                            }
                            else{
                                if(minCost > d[is.y][is.x].cost+1){
                                    minCost = d[is.y][is.x].cost+1;
                              }
                            }
                        }
                    }


                }
            }
        }
        ans = minCost;

    }

    private void getNumIsland(int num, List<island> embed){

        this.numberOfIsland = num;
        this.list= new List[numberOfIsland];
        for(int i=0;i<numberOfIsland;i++)
            this.list[i] = new LinkedList<island>();
        for(island i : embed){
            list[i.name-1].add(i);
        }
    }


    public void findIsland(int N){
        int iname = 0;
        Stack<island> s = new Stack<>();
        List<island> embed = new LinkedList<island>();

        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                if(b[i][j] && d[i][j].name == 0){
                    iname++;
                    d[i][j].name = iname;
                    s.add(d[i][j]);
                    while( !s.isEmpty() ){

                        island temp = s.pop();
                        //checkName(N);
                        if(temp.x-1 >= 0){
                            if(b[temp.y][temp.x-1] && d[temp.y][temp.x-1].name == 0){
                                d[temp.y][temp.x-1].name = iname;
                                s.add(d[temp.y][temp.x-1]);
                            }
                        }
                        if(temp.x+1 < N){
                            if(b[temp.y][temp.x+1] && d[temp.y][temp.x+1].name == 0){
                                d[temp.y][temp.x+1].name = iname;
                                s.add(d[temp.y][temp.x+1]);
                            }
                        }
                        if(temp.y-1 >= 0){
                            if(b[temp.y-1][temp.x] && d[temp.y-1][temp.x].name == 0){
                                d[temp.y-1][temp.x].name = iname;
                                s.add(d[temp.y-1][temp.x]);
                            }
                        }
                        if(temp.y+1 < N){
                            if(b[temp.y+1][temp.x] && d[temp.y+1][temp.x].name == 0){
                                d[temp.y+1][temp.x].name = iname;
                                s.add(d[temp.y+1][temp.x]);
                            }
                        }
                    }
                }

                if(b[i][j]){
                    if((i-1)>=0 && !b[i-1][j]){embed.add(d[i][j]); continue;}
                    if((i+1)<N && !b[i+1][j]){embed.add(d[i][j]); continue;}
                    if((j-1)>0 && !b[i][j-1]){embed.add(d[i][j]); continue;}
                    if((j+1)<N && !b[i][j+1]){embed.add(d[i][j]); continue;}
                }

            }
        }
        this.getNumIsland(iname, embed);

    }
}
