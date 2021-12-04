//fcfs
#include<bits/stdc++.h>
using namespace std;

void findWaitingTime(int [], int [], int);
void findTurnAroundTime(int [], int [],int [], int);
void findAvg(int [], int n);


void findWaitingTime(int bt[], int wt[], int n)
{
	 wt[0]  = 0; 
	for(int i=1; i<n; i++)
	{
		 wt[i]  = wt[i-1] + bt[i-1];
	}
}


void findTurnAroundTime(int wt[], int bt[], int tat[], int n)
{
	for(int i=0; i<n ;i++)
		tat[i] = wt[i] + bt[i];
}

void findAvg(int process[], int bt[], int n)
{
	int wt[n],tat[n],sum=0;
 
   findWaitingTime(bt, wt, n);
   findTurnAroundTime(wt, bt, tat, n);
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
	int process[] = {1,2,3,4};
	int bt[] = {4,5,3,2};
	int n = sizeof(process)/ sizeof(process[0]);
	findAvg(process, bt, n);
	return 0;
}