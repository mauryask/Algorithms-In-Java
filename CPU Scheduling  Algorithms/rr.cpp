//rr
#include<bits/stdc++.h>
using namespace std;

void findAvg(int [], int, int [], int);
void findWaitingTime(int [], int, int [], int[], int);
void findTurnAroundTime(int [], int [], int , int []);


void findTurnAroundTime(int bt[], int wt[], int n, int tat[])
{
	for(int i=0; i<n; i++)
	{
		tat[i]= bt[i]+wt[i];
	}
}

void findWaitingTime(int process[],int n,int bt[],int wt[],int quantum)
{
	int rt[n];
	for(int i=0; i<n ; i++)
	  rt[i] = bt[i];
  
  int t= 0;
  
  while(1)
  {
	  bool done = true;
	  for(int i=0; i<n ; i++)
	  {
		  if(rt[i]>0)
		  {
			  done = false; //process is not yet completetd
			  if(rt[i]> quantum)
			  {
				  t = t+quantum;
				  rt[i] -= quantum;
			  }
			  else
			  {
				  t = t+rt[i]; //execute for its quantum
				  wt[i] = t - bt[i];
				  rt[i] = 0;
			  }
		  }
	  }
	  
	  if(done == true) //all the process are completed
	  break;
  }

}

void findAvg(int process[], int n, int bt[], int quantum)
{
	int wt[n], tat[n], sum=0;
	findWaitingTime(process, n, bt, wt,quantum);
	findTurnAroundTime(bt, wt, n, tat);
	cout<<"\nProcess "<<"  Burst Time  "<< "  Waiting Time "<< "  Turn Around Time\n";
   for(int i=0; i<n ; i++)
   {
	   sum = sum + wt[i];
	   cout<<" "<<process[i]<<"\t\t"<<bt[i]<<"\t\t"<<wt[i]<<"\t\t"<<tat[i]<<"\n";
   }
   
   cout<<"\nThe Average Waiting Time: "<< (float)sum/(float)n<<"\n";
}

int main()
{
	
	int process[]  = {1,2,3};
	int n =  sizeof(process)/ sizeof(process[0]);
	int burst_time[] = {24,3,3};
	int quantum = 4;
	findAvg(process,n, burst_time, quantum);
	return 0;
}
