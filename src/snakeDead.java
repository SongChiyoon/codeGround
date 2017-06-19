import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 15..
 */
class turn{
    private int minute;
    private boolean left;
    turn(int m, boolean left){
        this.minute = m;
        this.left = left;
    }
    public int getMinute(){return this.minute;}
    public boolean getLeft(){return this.left;}
}
public class snakeDead {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int num = sc.nextInt();
        Queue<turn> queue = new LinkedList<>();

        for(int i = 0; i < num; i++){
            int m = sc.nextInt();
            String c = sc.next();
            if(c.equals("L"))
                queue.add(new turn(m, true));
            else
                queue.add(new turn(m, false));
        }


    }
}
