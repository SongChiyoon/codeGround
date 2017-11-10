public class Heap {
 
    int[] arr;
 
    public Heap(int[] arr) {
        this.arr = arr;
    }
 
    public void max_Heapify(int i) {
 
        if (arr == null || arr.length < 1)
            return;
 
        int leftChild = i * 2;
        int rightChild = leftChild + 1;
        int largest;
 
        if (leftChild < arr.length && arr[leftChild] > arr[i])
            largest = leftChild;
        else
            largest = i;
 
        if (rightChild < arr.length && arr[rightChild] > arr[largest])
            largest = rightChild;
 
        if (largest != i) {
            swap(i, largest);
            max_Heapify(largest);
        }
    }
 
    public void buildMaxHeap() {
 
        if (arr == null || arr.length < 1)
            return;
 
        for (int i = arr.length / 2; i > 0; i--) {
            max_Heapify(i);
        }
    }
 
    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
 
    public void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
            if (i == 0 || i == 1 || i == 3 || i == 7) {
                System.out.println();
            }
        }
    }
 
    public static void main(String args[]) {
        
        int[] arr = { 0, 16, 42, 15, 14, 67, 39, 13, 92, 18 };
 
        Heap heap = new Heap(arr);
        
        heap.buildMaxHeap();
        heap.printArr();
        
        System.out.println();
        System.out.println();
 
    }
}


