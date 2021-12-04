//prsh
#include<bits/stdc++.h>
using namespace std;

void sortProcess(int [], int [], int [], int);
void findWaitingTime(int [], int [] , int);
void findTurnAroundTime(int [], int [], int [], int);
void findAvg(int [], int [], int [], int n);

void findWaitingTime(int bt[], int wt[], int  n)
{
	wt[0] = 0;
	for(int i=1; i<n ; i++)
	{
		wt[i] = wt[i-1] +bt[i-1];
	}
}


void findTurnAroundTime(int bt[], int wt[], int tat[], int n)
{
	for(int i=0; i<n ; i++)
	{
		tat[i] = wt[i] +bt[i];
	}
}

//sorting the process according to their priority
void sortProcess(int proc[],int pri[], int bt[], int n)
{
	int pos,temp;
	for(int i=0; i<n; i++)
	{
		pos = i;
		for(int j = i+1; j<n; j++)
		{
			if(pri[j]< pri[pos])
				pos = j;
		}
		
		temp = pri[i];
		pri[i] = pri[pos];
		pri[pos] = temp;
		
		temp = bt[i];
		bt[i] = bt[pos];
		bt[pos] = temp;
		
		temp = proc[i];
		proc[i] = proc[pos];
		proc[pos] = temp;
	}
}

void findAvg(int process[], int pri[], int bt[], int n)
{
	int sum = 0,wt[n],tat[n];
	
	findWaitingTime(bt, wt, n);
	findTurnAroundTime(bt, wt, tat, n);
	
	cout<<"\nProcess "<<"  Burst Time  "<<"      Priority " <<"    Waiting Time "<< "    Turn Around Time\n";
	for(int i=0; i<n ; i++)
	{
		sum = sum + wt[i];
		cout<<" "<<process[i]<<"\t\t"<<bt[i]<< "\t\t"<<pri[i] <<"\t\t"<<wt[i]<<"\t\t"<<tat[i]<<"\n";
	}
	
    cout<<"\nThe Average Waiting Time: "<< (float)sum/(float)n<<"\n";
}

int main()
{
	int process[] = {1,2,3,4,5};
	int priority[] = {3,1,4,5,2};
	int burst_time [] = {10,1,2,1,5};
	
	int n = sizeof(process)/ sizeof(process[0]);
	
	sortProcess(process,priority,burst_time,n);
	
	findAvg(process, priority, burst_time, n);

	
	return 0;
}