package sort;

public class MergeSort {

	public void sort(int begin, int end, int[] data){
		divide(begin, end, data);
	}
	private void divide(int begin, int end, int[] data){
		
		if(begin >= end)
			return;
		int mid = (begin+end)/2;
		divide(begin, mid, data);
		divide(mid+1,end,data);
		merge(begin, mid, end, data);
		
		
	}
	private void merge(int begin, int mid, int end, int[] data){
		
		int n1 = mid-begin+1;
		int n2 = end-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i=0;i<n1;i++)
			L[i] = data[begin+i];
		for(int i=0;i<n2;i++)
			R[i] = data[mid+1+i];
		
		int i, j;
		int index = 0;
		i = j = 0;
		while(i < n1 && j < n2){
			if(L[i] > R[j]){
				data[begin+index] = R[j];
				j++;
				index++;
			}
			else{
				data[begin+index] = L[i];
				i++;
				index++;
			}
		}
		while(i < n1){
			data[begin+index] = L[i];
			index++;
			i++;
		}
		while(j < n2){
			data[begin+index] = R[j];
			index++;
			j++;
		}
		
	}
}
