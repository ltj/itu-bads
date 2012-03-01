import java.util.Iterator;

public class Congress {
	
	public static void main(String[] args) {
		
		In in = new In(args[0]);
		
		// read no. states/seats from first two lines
		// In.readInt() is not an option here since we
		// cannot control scanner position - or is it me?
		int states = Integer.parseInt(in.readLine());
		int seats = Integer.parseInt(in.readLine());
		
		MaxPQ<State> dpq = new MaxPQ<State>(states);
		
		// insert states into queue with one seat
		// and calculated quotient dependency
		for(int i = states; i > 0 && !in.isEmpty(); i--) {
			String name = in.readLine().trim();
			int pop = Integer.parseInt(in.readLine());
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
		
		Iterator I = dpq.iterator();
		while(I.hasNext()) {
			State s = (State) I.next();
			StdOut.println(s.getName() + " " + s.getSeats());
		}
	}
	
}