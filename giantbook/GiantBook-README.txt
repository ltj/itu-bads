/**********************************************************************
 *  BADS 2012 assignment 1: GiantBook
 **********************************************************************/

Name1: Lars Toft Jacobsen
Email1: latj@diku.dk
Name2: (David Reuss - has left the course)
Email2: (dreu@itu.dk)
Group name: Algorythms

Operating system: Mac OS X
Compiler: javac 1.6.0_29
Text editor / IDE: TextMate

Optional: Total hours to complete assignment:


Please mark one of the following boxes with an X

[ ] Yes, to the best of our knowledge, our code works as it should.

[X] No, our solution does not work. (We will not get credit for this.)
Here's what doesn't work:

Failed to get the great idea to solve the non-isolation problem :(

/**********************************************************************
 * Simulation results 
 *
 * Fill out the following table with the results of your simulation.
 * I've entered my own results for the first line; you need to
 * replace those with your own values and fill out the rest of the
 * table. N is the input size. T is the number of times you have
 * performed every experiment. 
 * 
 * giant is the average number of rounds
 * needed until the giant component emerges.
 * nosingles and connect denote the events when the last individual
 * becomes connected, and when the entire network is connected.
 * (The standard deviation is given in parentheses after each
 * average).
 * You probably don't have time to run T=100 experiments for
 * N=10,000,000.
 * If your code isn't fast enough to produce a result, write "n/a" in
 * the corresponding entry.
 * *********************************************************************/


       N    T   giant (stddev)   nosingles (stddev)  connect (stddev)
 --------------------------------------------------------------------
     100: 100 	73.67 (6.78)    		-  			257.84 (61.27) 
    1000: 100	694.41 (15.27)			-			3794.72 (698.04)
   10000: 100	6938.55 (50.26) 		-			48284.23 (6837.25)
  100000: 100	69325.39 (162.71)		-			604626.92 (66333.68)			
 1000000: 100	693272.50 (510.70)		-			7193873.54 (592999.43)
10000000: 10	6930859.10 (1791.80)	-			84117802.10 (5895303.48)

/**********************************************************************
 * Algorithm analysis
 **********************************************************************/


Assuming we never run out of memory or heap space, if we let our
algorithm for detecting the emergence of a giant component run for 24
hours, it could compute the answer for

	  N = 
	egentlig er union og find  lg N operationer i Weighted Quick-Union, men
	eftersom der benyttes "path compression" er de tæt på at være konstant
	tid. Det fremgår af kørslerne at giant optræder ved ~0,693N runder.
	Under antagelsen af at find og union tilvæksten ~ >1 og at vi kan udføre
	10^9 "runder"pr sek (det er virkelig et guestimat) kan der på 24hr optræde
	en giant for N ~ (86400 * 10^9)/0,693 ~ 1,24675325 * 10^14

We've run the code using a quick-find implemention as well.
In 1 hour, the largest instance we could manage had

          N = n/a



/**********************************************************************
* Some network science 
* 
* Here we pretend to do a bit of network science using our system.
* We're a few decades too late to get our results published.
* Still, it's a valid example that illustrates how algorithms and
* computers are used in the (other) sciences.
**********************************************************************/

The occurence of a giant component happens at a time 
    [X] linear in the size of the network
    [ ] quadratic in the size of the network
    [ ] logarithmic in the size of the network
    [ ] something else, maybe ...

The whole network is connected at a time 
    [ ] linear in the size of the network
    [ ] quadratic in the size of the network
    [X] logarithmic in the size of the network
    [ ] something else, maybe ...

The last isolated individual becomes connected 
    [ ] around the time that the giant component emerges
    [X] around the time that the whole network becomes connected
    [ ] something else, maybe ...

Finally, was it important that I defined the giant component to be of
size N/2, or could I have used N/10? 9N/10? How did you find your
answer (thinking about it? making an experiment? reading an article?)

It could probably be any constant in relation to N (I thought about that...briefly)


/**********************************************************************
 *  List whatever help (if any) that you received, including help
 *  from TAs or fellow students. (Such help is allowed, but we want
 *  you to acknowledge it.)
 **********************************************************************/


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it. In particular, tell us how this exercise 
 *  could be improved.                                             
 **********************************************************************/

I'm quite the "team learner" so doing this in groups is an excellent idea (ahem..necessity).

