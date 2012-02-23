public class MiningNobel 
{
    int count;
    private static int N;
    private static double[] A = new double[N];
    
    public static void main(String[] args) {
        for (int i = 0; i < N; ++i) {
		    A[i] = StdIn.readDouble();
        }
        StdOut.println(count());
    }
    
    private static int count() {
        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    for (int l = 0; l < N; l++) {
                        if (A[i] + A[j] + A[k] + A[l] == 0) { count++; }
                    }
                }
            }
        }
        return count;
    }
}
