package sort;
import java.util.*;
public class QuickSort {
	
	public void sort(int[] arr, int left, int right) {
		
		int pivot = arr[left];
		int i=left;
		int j=right;
		if(i >= j)
			return;
		while(i < j) {
			
			while(j > i && arr[j] > pivot) j--;
			while(i<j && arr[i] <= pivot) i++;
			if(i < j) {

				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}

		
		int tmp = pivot;
		arr[left] = arr[i];
		arr[i] = tmp;
				
		sort(arr, left, i-1);
		sort(arr, i+1, right);
		
		
	}

}
