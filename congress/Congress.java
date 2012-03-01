import java.util.Iterator;

public class Congress {
	
	public static void main(String[] args) {
		
		DynPQ<State> dpq = new DynPQ<State>();
		In in = new In(args[0]);
		
		// read no. states/seats from first two lines
		int states = in.readInt();
		int seats = in.readInt();
		
		// insert states into queue with one seat
		// and calculated quotient dependency
		for(int i = states; i > 0 && !in.isEmpty(); i--) {
			String name = in.readString();
			int pop = in.readInt();
			dpq.insert(new State(name, pop));
		}
		
		// All states get 1 seat
		int seatsleft = seats - states;
		
		while(seatsleft > 0) {
			State s = dpq.delMax();
			s.addSeat();
			dpq.insert(s);
			seatsleft--;
		}
		StdOut.println("Done.");
		
		Iterator I = dpq.iterator();
		while(I.hasNext()) {
			State s = (State) I.next();
			StdOut.println(s.getName() + " " + s.getSeats());
		}
	}
	
}