package JumpBridge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;


class JumpBridgeSolution {
	private int sum;
	private int count;
	private int N, K, L;
	private int[] bomb;
	private Stack<Integer> stack;

	JumpBridgeSolution(int n, int k, int l){
		this.N = n;
		this.K = k;
		this.L = l;
		this.count = 0;
		this.stack = new Stack<Integer>();
	}
	JumpBridgeSolution(int n, int k, int l, int[] b){
		this.N = n;
		this.K = k;
		this.L = l;
		this.bomb = b;
		this.count = 0;
		this.stack = new Stack<Integer>();

	}
	public void setSum(int sum) {
		this.sum = sum;
	}

	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(new FileInputStream("jumpBridge.txt"));

		//Scanner sc = new Scanner(System.in);

		int T, N, K, L;
		int result;
		int test_case;
		int[] bomb;
		JumpBridgeSolution solution;
		T = sc.nextInt();
		for(test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			K = sc.nextInt();
			L = sc.nextInt();

			if(L == 0){
				solution = new JumpBridgeSolution(N, K, L);
			}
			else{
				bomb = new int[L];
				for(int i = 0; i < L; i++)
					bomb[i] = sc.nextInt();
				solution = new JumpBridgeSolution(N, K, L, bomb);

			}
			result = solution.getResult();
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}
	public int getResult(){
		for(int i = 1; i <= this.K; i++){
			if(L != 0 && !checkBomb(i))
				continue;
			setSum(0);
			addStair(i);
		}
		return count;
	}
	public int getResultStack(){
		int pre = -1;
		for(int i = 1; i <= this.K; i++){
			if(pre == -1){
				if(i == this.N){
					count++;
					continue;
				}
				else if(!checkBomb(i))
					continue;
				else{
					pre = i;
					setSum(i);
					stack.push(i);
				}
			}
			else{
				while(!stack.isEmpty()){
					pre = stack.pop();
					for(int j = 1; j <= this.K; j++){
						if(pre != j){
							if(sum + j == this.N){
								count++;
								break;
							}
							else if(sum + j > this.N) break;
							else{
								stack.push(pre);
								stack.push(j);
								sum += j;
							}
						}
						
					}
					stack.pop();
				}
				pre = -1;
			}
		
		}
		
		
		return count;
	}
	private boolean checkBomb(int firstStep){
		for (int i = 0; i < L; i++)
			if (firstStep == bomb[i])
				return false;
		return true;

	}
	private void addStairInQueue(){
		
	}
	private void addStair(int index){
		if(sum == 0 && index == this.N){
			count++;
			return;
		}

		for(int i = 1; i <= this.K; i++) {
			if (this.L == 0) {
				if (index != i) {
					if (this.sum + i == this.N) {
						count++;
						break;
					} else if (this.sum + i < this.N) {
						this.sum += i;
						addStair(i);
						this.sum -= i;
					}
				}
			}
			else{
				if (i != index) {
					if (this.sum + i == K) {
						count++;
					}
					else{
						if(this.sum + i < this.K) {
							for (int j = 0; j < L; j++) {
								if (this.sum + i == bomb[j])
									break;
								else{
									this.sum += i;
									addStair(i);
									this.sum -= i;
								}
							}
						}
					}
				}
			}
		}
	}

}