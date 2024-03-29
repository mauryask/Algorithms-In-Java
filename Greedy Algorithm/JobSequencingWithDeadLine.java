/*
* Job Sequencing with Deadline
* Standard Greedy Problem
********
* T(n) : O(n*n)
* S(n) : O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class JobSequencingWithDeadLine
{
	static class Jobs
	{
		int deadline;
		int profit;
		char jobId;
		
		Jobs(char jobId, int deadline, int profit)
		{
			this.deadline = deadline;
			this.profit = profit;
			this.jobId = jobId;
		}
	}
	
	/* Finding max dedaline */
	
	static int findMax(List<Jobs> jobs, int n)
	{
		int maxDeadline = Integer.MIN_VALUE;
		for(Jobs j: jobs)
		  maxDeadline = Math.max(j.deadline, maxDeadline);
		return maxDeadline;
	}
	
	static void jobSequence(List<Jobs> jobs, int n)
	{
		/*
		* Finding max deadline 
		* you have to finish as many jobs as possible 
		* within this deadline
		**************
		* The purpose of maxDeadline is: 
		* Since each job takes 1 unit time to be completed 
		* so maximum possible number of jobs that can be performed
		* will be equal to maxDeadline if deadline
		*/
		
		int maxDeadline = findMax(jobs, n);
         
		Jobs gantChart[] = new Jobs[maxDeadline];
		
		/*
		* Sorting the job list
		* based on profit in descending order
		*/
		
		Collections.sort(jobs, (a,b)->{
			return b.profit - a.profit;
		});
				
		for(int i=0; i<n; i++)
		{
		   int jobDeadLine = jobs.get(i).deadline;
		   int jobProfit = jobs.get(i).profit;
		   
		   /*
		   * For each job check for a valid 
		   * empty slot to put it
		   * if slot found break
		   */
		   
		   for(int j = jobDeadLine-1; j>=0; j--)
		   {
			   if(gantChart[j] == null)
			   {
				   gantChart[j] = jobs.get(i);
				   break;
			   }
		   }
		}

	   /* Printing the job sequence */
       for(Jobs j : gantChart)
		   out.print(j.jobId+" ");		   
	}
	
	public static void main(String [] args)
	{	
		List<Jobs> jobs = new ArrayList<>();
				/* jobId, deadLine, profit*/	
		jobs.add(new Jobs('a',2,100));
		jobs.add(new Jobs('b',1,19));
		jobs.add(new Jobs('c',2,27));
		jobs.add(new Jobs('d',1,25));
		jobs.add(new Jobs('e',3,15));
		
		jobSequence(jobs, jobs.size());
	}
} 