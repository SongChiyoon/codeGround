/*
 * https://www.acmicpc.net/problem/7562
 */
import java.util.*;
public class NightMoving {
	
	static class Night{
		int y, x;
		int count;
		Night(int y, int x){
			this.y = y;
			this.x = x;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getCount() {
			return this.count;
		}
	}
	static int[] dy = {1, 1, 2, 2, -1, -1, -2, -2};
	static int[] dx = {-2,2,-1, 1, 2, -2, 1, -1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			
			int boardSize = sc.nextInt();
			boolean[][] board = new boolean[boardSize][boardSize];
			int y = sc.nextInt();
			int x = sc.nextInt();
			board[y][x] = true;
			
			Night night = new Night(y,x);
			night.setCount(0);
			int arriveY = sc.nextInt();
			int arriveX = sc.nextInt();
			
			Queue<Night> queue = new LinkedList<>();
			queue.add(night);
			while(!queue.isEmpty()) {
				
				Night active = queue.remove();
				if(active.y == arriveY && active.x == arriveX) {
					System.out.println(active.count);
					break;
				}
				for(int i=0;i<8;i++) {
					int tempY = active.y + dy[i];
					int tempX = active.x + dx[i];
					if(tempY>=0 && tempY<boardSize && tempX>=0 && tempX<boardSize && !board[tempY][tempX]) {
						board[tempY][tempX] = true;
						Night newNight = new Night(tempY, tempX);
						newNight.setCount(active.getCount()+1);
						queue.add(newNight);
					}
				}
				
			}
		}
	}
}
