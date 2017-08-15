import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 10..
 * 문제 : https://www.acmicpc.net/problem/2146
 */

public class Bridge {
	static class coord{
		int x,y;
		coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static class island{
		int name;
		List<coord> leftside, rightside, topside, bottomside;
		
		int left;
		int bottom;
		island(int name){
			this.name = name;
			this.left = Integer.MAX_VALUE;
			this.bottom = -1;
			leftside = new LinkedList<>();
			rightside = new LinkedList<>();
			bottomside = new LinkedList<>();
			topside = new LinkedList<>();
		}
		public void add(coord c){
			int x = c.x;
			int y = c.y;
			if(x-1>=0){
				if(d[y][x-1] == 0)
					leftside.add(c);
			}
			if(x+1<N){
				if(d[y][x+1] == 0)
					rightside.add(c);
			}
			if(y-1>=0)
				if(d[y-1][x] == 0)
					topside.add(c);
			if(y+1<N)
				if(d[y+1][x] == 0)
					bottomside.add(c);
		}
		public void getBottom(int b){
			this.bottom = Math.max(this.bottom, b);
		}
		public void getLeft(int l){
			this.left = Math.min(this.left, l);
		}
	}
	static int[][] d;
	static int N;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	
        d = new int[N][N];
        boolean[][] v = new boolean[N][N];
        
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++) 
            	d[i][j] = sc.nextInt();
        
        Queue<coord> q = new LinkedList<>();
        List<island> islands = new LinkedList<>();
        int name = 0;
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
            	if(d[i][j] == 1 && !v[i][j]){
            		name += 1;
            		island is = new island(name);
            		
            		d[i][j] = name;
            		q.add(new coord(j,i));
            		if(checkSea(j,i,N)){
            			is.add(new coord(j,i));
            			is.getLeft(j);
            			is.getBottom(i);
            		}
                    v[i][j] = true;
                    while( !q.isEmpty() ){
                    	coord active = q.remove();
                    	int x = active.x;
                    	int y = active.y;
                    	if(x-1 >=0){
                    		if(!v[y][x-1] && d[y][x-1]!=0){
                    			v[y][x-1] = true;
                    			d[y][x-1] = name;
                    			q.add(new coord(x-1,y));
                    			if(checkSea(x-1,y,N)){
                        			is.add(new coord(x-1,y));
                        			is.getLeft(x-1);
                        			is.getBottom(y);
                    			}
                    		}
                    	}
                    	if(x+1 < N){
                    		if(!v[y][x+1] && d[y][x+1]!=0){
                    			v[y][x+1] = true;
                    			d[y][x+1] = name;
                    			q.add(new coord(x+1,y));
                    			if(checkSea(x+1,y,N)){
                    				is.add(new coord(x+1,y));
                    				is.getLeft(x+1);
                        			is.getBottom(y);
                    			}
                    		}
                    	}
                    	if(y-1>=0){
                    		if(!v[y-1][x] && d[y-1][x]!=0){
                    			v[y-1][x] = true;
                    			d[y-1][x] = name;
                    			q.add(new coord(x,y-1));
                    			if(checkSea(x,y-1,N)){
                    				is.add(new coord(x,y-1));
                    				is.getLeft(x);
                        			is.getBottom(y-1);
                    			}
                    		}
                    	}
                    	if(y+1<N){
                    		if(!v[y+1][x] && d[y+1][x]!=0){
                    			v[y+1][x] = true;
                    			d[y+1][x] = name;
                    			q.add(new coord(x,y+1));
                    			if(checkSea(x,y+1,N)){
                    				is.add(new coord(x,y+1));
                    				is.getLeft(x);
                        			is.getBottom(y+1);                   			
                    			}
                    		}
                    	}
                    }
                    islands.add(is);
                               		
            	}
            }
            
         
        double min = Double.MAX_VALUE;
        coord source = null;
        coord target = null;
        List<coord> alist, blist;
        for(int i=0;i<islands.size();i++){
        	for(int j=i+1;j<islands.size();j++){
        		island a = islands.get(i);
        		island b = islands.get(j);
        		
        		if(a.left < b.left){
        			if(a.bottom < b.bottom){
        				blist = b.topside + b.leftside;
        			}
        			else{
        				
        			}
        		}
        		for(coord ac : a.islandList){
        			for(coord bc : b.islandList){
        				if(min > getDistance(ac, bc)){
        					min = getDistance(ac, bc);
        					source = ac;
        					target = bc;
        				}
        			}
        		}
       		
        	}
        }
        if(source != null && target != null){
        	System.out.println(Math.abs(source.y-target.y)+Math.abs(source.x-target.x)-1);
        }
        else{
        	System.out.println(0);
        }
        
                    
	}
	public static boolean checkSea(int x, int y, int N){
		if(x-1>=0){
			if(d[y][x-1] == 0)
				return true;
		}
		if(x+1<N){
			if(d[y][x+1] == 0)
				return true;
		}
		if(y-1>=0){
			if(d[y-1][x] == 0)
				return true;
		}
		if(y+1<N){
			if(d[y+1][x] == 0)
				return true;
		}
		return false;
		
	}
	public static double getDistance(coord a, coord b){
		return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
	}

}
