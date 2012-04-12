public class Words {
	
	// returns true if you can go from word 'from' to word 'to'
	public static boolean wordLinksTo(String from, String to) {
		for(int i = 1; i < from.length(); i++) {
			int at = to.indexOf(from.substring(i, i+1));
			if(at == -1) return false; // letter not found in (rest of) to
			to = to.substring(0,at) + to.substring(at+1,to.length());
		}
		return true;
	}
	
	public static void main(String[] args) {
		if(wordLinksTo(args[0], args[1])) {
			StdOut.println("yes");
		}
		else {
			StdOut.println("no");
		}
	}
}
