* Assignment: Gorilla
** Student info:
   - Group name: Algorythms && Lord of the Code
   - Name1: Lars Toft Jacobsen
   - Email1: latj@itu.dk
   - Name2: Alexander Kirk Jørgensen
   - Email2: akir@itu.dk
   - Compiler: 
   - Text editor / IDE: TextMate / Notepad++

** Assignment info:
   Mark one of the following boxes with an X

   [X] Yes, to the best of our knowledge, everything works as it
   should. In particular, here is the test client for vector
   operations (length, angle) that our code has passed:


   	// test client
	public static void main(String[] args) {
		
		// test vector methods
		int[] t1 = {1, 0};
		int[] t2 = {0, 1};
		StdOut.println("vl: "+vectorLength(t1));
		StdOut.println("va: "+vectorAngle(t1, t2));
		
		ArrayList<Profile> speciesCol = new ArrayList<Profile>();
		
		// read sequences from file, compute a profile for each and
		// store the result in the 'species' array 
		In in = new In(args[0]);
		while(in.hasNextLine()) {
			String line = in.readLine();
			String spec = line.substring(1, line.indexOf(" "));
			String seq = in.readLine()+in.readLine()+in.readLine();
			int[] pro = computeProfile(seq); 
			speciesCol.add(new Profile(spec, seq, pro));
		}
		
		Profile[] species = speciesCol.toArray(new Profile[0]);
		
		for(Profile animal1 : species) {
			double closest = 1.0;
			for(Profile animal2 : species) {
				if(animal1.name.equals(animal2.name)) continue;
				
				double dist = vectorAngle(animal1.profile, animal2.profile);
				if (dist < closest) {
					animal1.relative = animal2.name;
					closest = dist;
				}
			}
		}
		
		for(int i=0; i < species.length; i++) {
			for(int j = i+1; j < species.length; j++) {
				double sim = vectorAngle(species[i].profile, species[j].profile);
				StdOut.println(species[i].name + " and " + species[j].name + " similarity (angle): " + sim);
			}
		}
		
		for(Profile animal : species) {
			StdOut.println("Closest relative to " + animal.name + " is " + animal.relative);
		}
		
	}



   [ ] No, our solution does not work. (We will not get credit for this.)
   In particular, 

   ... (explain what doesn't work)

   - Total hours to complete the assignment (optional): ...


   RESULTS

   The two most alike species are: 
   Human and Gorilla similarity (angle): 0.0583044919951858

   The two most different species are: 
   Deer and Lamprey similarity (angle): 0.5564230793753697

   All species in order of similarity with humans:

   Human and Gorilla similarity (angle): 0.0583044919951858
   Human and Spider similarity (angle): 0.15801033472119083
   Human and Pig similarity (angle): 0.21928123144257836
   Human and Gull similarity (angle): 0.25268266801448164
   Human and Horse similarity (angle): 0.25770133435471126
   Human and Deer similarity (angle): 0.29975071698450895
   Human and Cow similarity (angle): 0.31356373579964325
   Human and Trout similarity (angle): 0.34591564037603756
   Human and Rockcod similarity (angle): 0.3849176598079635
   Human and Sea-Cucumber similarity (angle): 0.46203803544685706
   Human and Lamprey similarity (angle): 0.4727446988922648


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
