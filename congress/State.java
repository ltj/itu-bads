public class State implements Comparable<Integer>{
	
	private final String name;	// name of state
	private int seats;			// seats in congress
	private final int cpop;		// census population
	private Double q;			// priority quotient
	
	public State(String name, int pop) {
		this.name = name;
		cpop = pop;
		seats = 1;
		q = cpop / populationDivider();
	}
	
	public String getName() {
		return name;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public int getPopulation() {
		return cpop;
	}
	
	public double getQuotient() {
		return q;
	}
	
	// add one seat and update quotient
	public void addSeat() {
		seats++;
		q = cpop / populationDivider();
	}
	
	// calculate divider
	public double populationDivider() {
		return Math.sqrt(seats*(seats+1));
	}
	
	// Comparable compareTo() implementation
	public int compareTo(Object obj) {
		State s = (State) obj;
		return q.compareTo(s.getQuotient());
	}
	
}