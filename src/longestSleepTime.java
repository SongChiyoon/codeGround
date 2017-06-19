import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by songchiyun on 2017. 6. 18..
 */
class Meeting implements Comparable<Meeting>{
    int day;
    int sHour;
    int sMin;
    int fHour;
    int fMin;
    public Meeting(int day,int sHour, int sMin, int fHour, int fMin) {
        this.day = day;
        this.sHour = sHour;
        this.sMin = sMin;
        this.fHour = fHour;
        this.fMin = fMin;
    }

    @Override
    public int compareTo(Meeting m) {
        if(m.day < this.day)
            return 1;
        else if(m.day > this.day)
            return -1;
        else{
            if(m.sHour < this.sHour)
                return 1;
            else if(m.sHour > this.sHour)
                return -1;
            else{
                if(m.sMin < this.sMin)
                    return 1;
                else
                    return -1;
            }
        }
    }
}
public class Solution1 {
    //Sun 01:00-21:00

    public static void main(String[] args){

        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Meeting> workList = new PriorityQueue<>();
        map.put("Mon", 0);
        map.put("Tue", 1);
        map.put("Wed", 2);
        map.put("Thu", 3);
        map.put("Fri", 4);
        map.put("Sat", 5);
        map.put("Sun", 6);

        String s = "Mon 01:00-23:00\n" +
                "Tue 01:00-23:00\n" +
                "Wed 01:00-23:00\n" +
                "Thu 01:00-23:00";

        String[] line = s.split("\n");
        int M = line.length;
        for(int i = 0; i < M; i++){
            Meeting meeting;
            //System.out.println(line[i].split(" ")[0]);
            int day = map.get(line[i].split(" ")[0]);
            String[] time = line[i].split(" ")[1].split("-");
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");

            meeting = new Meeting(day,Integer.parseInt(start[0]), Integer.parseInt(start[1]),
                    Integer.parseInt(end[0]), Integer.parseInt(end[1]));

            workList.offer(meeting);
        }

        for(Meeting m : workList){
            System.out.println(m.day);
        }

        int max = -1;
        Meeting prior = null;

        for(Meeting m : workList){
            if(max == -1){
                int day = m.day - 0;
                max = 24 * 60 * day + 60 * m.sHour + m.sMin;
                prior = m;
                continue;
            }
            else{
                int day = m.day - prior.day;
                int compare = (24 * 60 * day + 60 * m.sHour + m.sMin) -
                        (60 * prior.fHour + prior.fMin);
                if(max < compare)
                    max = compare;

                prior = m;
            }
        }
        int day = 7 - prior.day;
        int compare = (24 * 60 * day) - (60 * prior.fHour + prior.fMin);
        if(max < compare)
            max = compare;

        System.out.println(max);


    }
}

