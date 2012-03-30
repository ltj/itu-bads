import java.util.*;

public class RandomGenerator {
	private static int n;
	
	public static void main(String[] args) {
		n = Integer.parseInt(args[0]);
		Out out = new Out("RandomNumbers"+n+".txt");
		
		for (int i = 0; i < n; i++) {
			out.print("number"+i+" , ");
			out.printf("%.2f",(StdRandom.uniform(n)-n/2)*StdRandom.uniform());
			out.println();
		}
	}
}