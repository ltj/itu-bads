import java.util.*;

public class Congress {
	
	//Initializing Variables
	private static int states;
	private static int seats;
	
	//Defines a comparator for later use.
	public static class StateOrderComparator implements Comparator<State> {
			
		@Override
		//We are overriding the comparator method compare with our own method.
		public int compare(State x, State y) {
			if (x.compareTo(y) < 0) return 1;
			if (x.compareTo(y) > 0) return -1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		//Creates an In instance, to read the input file.
		In in = new In(args[0]);
		//Defines states and seats from the input file (2 top lines)
		states = Integer.parseInt(in.readLine());
		seats = Integer.parseInt(in.readLine());
		
		//Creates the comparator instance and the priorityqueue
		Comparator<State> comparator = new StateOrderComparator();
		PriorityQueue<State> queue = new PriorityQueue<State>(states, comparator);
		
		//Initializes the queue, by adding the states to the queue.
		for (int i = 0; i < states; i++) {
			State tmpState = new State(in.readLine(), Integer.parseInt(in.readLine()));
			queue.add(tmpState);
		}
		
		//Removes the initial seats that are created from the states being added.
		seats = seats - states;
		while(seats > 0) {
			//Pulls the top state and adds seats to it. Then places it back in the
			//	queue, and decrements the remaining seats..
			State tmpState = queue.poll();
			tmpState.addSeat();
			queue.add(tmpState);
			seats--;
		}
		
		//Creates an output stream, and writes a file called Output with the output.
		Out out = new Out("Output.txt");
		for (State state : queue) {
			out.println("State: "+state.getName()+" Seats: "+state.getSeats());
		}
	}
}