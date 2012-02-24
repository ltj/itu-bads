/**********************************************************************
 *  Programming assignment: Mining for Nobel
 **********************************************************************/

Name1: Lars Toft Jacobsen
Email1: latj@itu.dk
Name2: Alexander Kirk Jørgensen
Email2: akir@itu.dk
Group name: Algorythms && Lord of the Code

Operating system: Mac OS X / Windows 7
Text editor / IDE: TextMate / Notepad++

Optional: Total hours to complete assignment:


Please mark one of the following boxes with an X

[X] Yes, to the best of our knowledge, our N^3 log N solution works as
it should.

[ ] No, our solution does not work. (We will not get credit for this.)
Here's what doesn't work:



/**********************************************************************
 * Consider your exhaustive search implementation.
 *
 * Let N denote the number of input values.
 *
 * Estimate the number of comparisons by looking at the code. 
 * Use tilde notation.
 * (Don't forget  the comparisons in the condition of your for loops!)
 * 
 * Perform experimental running time analysis using the Stopwatch
 * class from Sedgewick and Wayne, Algorithms 4th edition.
 *
 * Estimate the largest N you can process based on your theoretical
 * and practical analyses.
 **********************************************************************/

Number of comparisons performed as a function of N:  ~N^4

Experiments:

 N          time (seconds)
------------------------------
4		0.001
352		2.996

[ ] Yes, our experiments are consistent with our theoretical analysis

[X] No, they are not. Instead, it looks more as if ....
The number of comparisons is (N^4)/5, since N^4 = ~15e+9 if N = 324.
This is assuming 1 comparison every nanosecond.


Largest values of N in given time limit
---------------------------------------
1 minute: 740
1 day:    4.559
1 year:   19.927

/**********************************************************************
 * Results
 **********************************************************************/

Number of 4-tuples in constants.csv that sum to 0 found by 
our exhaustive search implementation:    19 individual, 528 similar
our N^3 log N implementation:            19 individual, 528 similar.
(optional) our N^2 log N implementation: ...


/**********************************************************************
 * More numbers!
 *
 * This part is completely optional. Please help making this exercise
 * better by providing even more important-looking constants.
 * Remember that we need the natural logarithm, rounded to the nearest
 * power of 2^(-20). Do it like this:
 *
 *   private static final double rounding = 9.5367431640625E-7;
 *
 *   private static  double round(double value) {
 *	  return ((int) (value / rounding)) * rounding;
 *      }
 *   ...
 *   double ln_value = round(Math.log( the_original_value ))); 
 *   ...
 *
 * Use the format below, with the original value in parentheses.
 *
 * If I find your suggestions sufficiently entertaining I'll
 * put them in the next version of  this exercise.
 * If you want to be credited, please tell me by which name
 * here: .......
 ******************************************************************/

international telephone dial code for Antarctica (672) , 6.510257720947266
... , ...



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
