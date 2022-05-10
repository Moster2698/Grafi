
public class MainStrutture {

	public static void main(String[] args) {
		Queue queue = new Queue();
		for(int i=0;i<10;i++)
			queue.Enqueue(i);
		
		for(int i=0;i<10;i++)
			System.out.println(queue.Dequeue());
		
	}

}
