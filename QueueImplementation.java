import java.util.LinkedList;
import java.util.Queue;

public class Queues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new LinkedList<Integer>();
		for(int i=10;i>0;i--)
			queue.add(i);
		System.out.println("Size of queue:"+queue.size());
		while(!queue.isEmpty()){
			System.out.print(queue.poll()+" ");
			
		}
	}

}
