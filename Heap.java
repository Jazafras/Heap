import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Heap {

	int [] heap;
	int size;
	public Heap() {
		heap = new int[100000];
	}
	
	public void add(int e) {
		size++;
		int i = size - 1; //start at last element
		while (i > 0 && heap[(i-1)/2] > e) //new element is less than its parent
		{
			heap[i] = heap[(i-1)/2]; //make child the parent
			i = (i-1)/2; //check next parent
		}
		heap[i] = e;
	}
	public long removeMin() {
		int min = 0;
		if (size < 1) //nothing is in the heap
		{
			System.out.println("error");
		}
		else
		{
			min = heap[0]; //assign the root as the minimum
			heap[0] = heap[size-1]; //last element is the new root 
			size--; //decrement the size
			minHeapify(0); //heapify the new root
		}
		return min; //return what was removed
	}
	
	private void minHeapify(int index) {
		int left, right, min, fluff;
		left = (index*2) + 1; //left child
		right = (index*2) + 2; //right child
		if (left < size && heap[left] < heap[index]) //left child is less than the parent
		{
			min = left; //left child is the new minimum
		}
		else
		{
			min = index; //parent is still the minimum
		}
		if (right < size && heap[right] < heap[min]) //right child is less that the current minimum
		{
			min = right; //right child is the new minimum
		}
		if (min != index)
		{
			fluff = heap[index];
			heap[index] = heap[min]; //put the parent in the child's spot
			heap[min] = fluff; //put the child in the parent's spot
			minHeapify(min); //do the process over
		}
	}
	
	public static void main(String[] args) {
		Heap test = new Heap ();
		test.add(10);
		test.add(30);
		test.add(4);
		test.add(5);
		test.add(64);
		test.add(7);
		test.add(2);
		test.add(8);
		for (int i = 0; i < test.size; i++)
		{
			System.out.println(test.heap[i]);
		}
		test.removeMin();
		System.out.println("Removed minimum");
		for (int i = 0; i < test.size; i++)
		{
			System.out.println(test.heap[i]);
		}
	}
}
