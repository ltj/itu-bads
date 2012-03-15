* Assignment: QuickInsertSort
** Student info:
   - Group name: Algorythms/LordOfTheCode
   - Name1: Lars Toft Jacobsen
   - Email1: latj@itu.dk
   - Name2: Alexander Kirk Jørgensen
   - Email2: akir@itu.dk
   - Operating system: Mac OS X/Win 7
   - Processor: 2.2GHz Intel Core i7
   - Clock Speed: Well...2.2GHz
   - Computer desciption (if that makes sense, e.g., "2008 MacBook
     Pro", "Commodore 64", "Intel-based box I assembled myself", 
     etc.): MacBook Pro 15" early 2011
   - Compiler: javac 1.6.0_29
   - Text editor / IDE: TextMate/Notepad++

** Assignment info:
   Mark one of the following boxes with an X
   [X] Yes, to the best of our knowledge, everything works as it
   should. In particular, here is the test client that our code has
   passed:


   	// test client
	public static void main(String[] args) {
		
		int ntest = 100; // no. tests/cutoff value
		int cmin = 0; // cutoff min value
		int cmax = 20; // cutoff max value
		double[] runtime = new double[ntest];
		
		// for each size of array
		for (int n = 100; n <= 1000000; n *= 10) {
			StdOut.println("Testing for n="+n);
			// for each cutoff value 0..cmax
			for(int m = cmin; m < cmax+1; m++) {
				double total = 0.0;
				double dev = 0.0;
				double avg = 0.0;
				double stdDeviate = 0.0;
				// do ntest tests
				for(int t = 0; t < ntest; t++) {
					int[] a = randomIntList2(n, 10*n);
					// time and sort
					long start = System.currentTimeMillis();
					sort(a, m);
					runtime[t] = (System.currentTimeMillis() - start) / 1000.0;
				}
				// average runtime for all tests
				for (int k = 0; k < runtime.length; k++) {
					avg += runtime[k];
				}
				avg /= ntest;
				// std deviation
				for (int l = 0; l < runtime.length; l++) {
					dev += Math.pow(runtime[l]-avg, 2);
				}
				stdDeviate = Math.sqrt(dev/100);
				StdOut.println("m="+m+" avg="+avg+" std dev="+stdDeviate);
			}
			StdOut.println("n="+n+" done\n\n");
		}
		
	}



   [ ] No, our solution does not work. (We will not get credit for this.)
   In particular, it sorts 

   .... (some numbers)

   to 

   .... (some numbers, not correctly sorted)


   - Total hours to complete the assignment (optional): ...


   RESULTS
   
   For each N, either complete the 7 lines (where it says ...) or
   remove the lines are write "Couldn't see a difference".

   N = 100:
   No cutoff:
   mean running time: 5.0E-5 s
   standard deviation: 2.18E-4
   
   With cutoff = 12
   mean running time: 1.0E-5 s 
   standard deviation: 9.95E-5
   improvement in percent: ...

   N = 1000:
   No cutoff: 
   mean running time: ... 
   standard deviation: ...
   
   With cutoff = ...
   mean running time: ... 
   standard deviation: ...
   improvement in percent: ...

   N = 10000:
   No cutoff: 
   mean running time: ... 
   standard deviation: ...
   
   With cutoff = ...
   mean running time: ... 
   standard deviation: ...
   improvement in percent: ...

   N = 100000:
   No cutoff: 
   mean running time: ... 
   standard deviation: ...
   
   With cutoff = ...
   mean running time: ... 
   standard deviation: ...
   improvement in percent: ...

   N = 1000000:
   No cutoff: 
   mean running time: ... 
   standard deviation: ...
   
   With cutoff = ...
   mean running time: ... 
   standard deviation: ...
   improvement in percent: ...

** Help
   List whatever help (if any) that you received, including help from
   TAs or fellow students. (Such help is allowed, but we want you to
   acknowledge it.)

   ...

** Comments
   List any other comments here. Feel free to provide any feedback on
   how much you learned from doing the assignment, and whether you
   enjoyed doing it. In particular, tell us how this exercise could be
   improved.
 
   ...
