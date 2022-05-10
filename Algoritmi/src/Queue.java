import java.util.Arrays;

public class Queue {

	private int[] queue;
	private int tail;
	private int head;
	private int length;
	private int elementsInside;
	public Queue() {
		queue=new int[10];
		head=0;
		tail=0;
		length=10;
		elementsInside=0;
	}
	public void Enqueue(int number){
		elementsInside++;
		if(tail==length) {
			tail=0;
			queue[tail]=number;
		}
		if(tail==head && elementsInside>10) {
			throw new Error("StackOverflow");
		}
		
		
		else {
			queue[tail] = number;
			tail++;
		}
			
	}
	public int Dequeue() {
		int number;
		if(elementsInside==0)
			throw new Error("Lo Stack non ha elementi al suo interno");
		if(head==length) {
			head=0;
			number=queue[head];
		}
		else {
			number=queue[head];
			head++;	
		}
			
		elementsInside--;
		return number;
	}
	public String toString() {
		return Arrays.toString(queue);
	}
}
