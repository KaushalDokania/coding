package DataStructures.BinaryHeap;

public class MinHeap {
    public int[] heapArray;
    public int capacity;
    public int size;

    // create new heap with capacity n
    public MinHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        size = 0;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public void swapKeysAtIndex(int i1, int i2) {
        int temp = heapArray[i1];
        heapArray[i1] = heapArray[i2];
        heapArray[i2] = temp;
    }

    public boolean insertKey(int key) {
        if (size == capacity)
            return false;
        
        // insert at the end
        int i = size;
        heapArray[i] = key;
        size++;

        // fix the min heap if required
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            // swap
            swapKeysAtIndex(i, parent(i));
            i = parent(i);
        }
        return true;
    }

    public int getMin() {
        return heapArray[0];
    }

    public int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heapArray[0];
        }
        int root = heapArray[0];
        heapArray[0] = heapArray[--size];
        minHeapify(0);
        return root;
    }

    public void decreaseKey(int key, int new_val) {
        heapArray[key] = new_val;
    
        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swapKeysAtIndex(key, parent(key));
            key = parent(key);
        }
    }

    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    public void minHeapify(int index) {
        int l = leftChild(index);
        int r = rightChild(index);

        int smallest = index;
        if (l < size && heapArray[l] < heapArray[smallest])
            smallest = l;

        if (r < size && heapArray[r] < heapArray[smallest])
            smallest = r;
        
        if (smallest != index) {
            swapKeysAtIndex(index, smallest);
            minHeapify(smallest);
        }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        
        System.out.println(h.extractMin() + " ");
        System.out.println(h.getMin() + " ");

        h.decreaseKey(2, 1);
        System.out.println(h.getMin());
    }
}
