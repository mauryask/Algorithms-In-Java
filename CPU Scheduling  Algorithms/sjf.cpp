//sjf
#include<bits/stdc++.h>
using namespace std;

struct Process 
{
	int pid;
	int bt;
	int art;
};

void findWaitingTime(Process [], int , int []);
void findTurnAroundTime(Process [], int ,int [], int[]);
void findAvgTime(Process [], int);

void findTurnAroundTime(Process proc[], int n , int wt[], int tat[])
{
	for(int i=0; i<n; i++)
	  tat[i] = proc[i].bt +  wt[i];
}

void findWaitingTime(Process proc[], int n , int wt[])
{
	    int rt[n];
	    for(int i=0; i<n; i++)
		rt[i] =  proc[i].bt; //burst times of processes
	
		int complete = 0; //number of processes completed
		int t=0; //arrival time 
		int minm = INT_MAX; //the minimum burst time
		int shortest = 0; //index of minimum burst time
		int finish_time; 
		bool check = false; //set true if smallest burst found 
		
		
		while(complete != n) //if process are remaining (not completed)
		{
			for(int j= 0  ; j< n; j++)
			{
				 if((proc[j].art <= t) && (rt[j] < minm) && rt[j] > 0)
				 {
					 minm = rt[j];
					 shortest = j;
					 check = true;
				 }
			}
		
			if(check == false) //if check false then try again
			{
				t++;
			    continue;
			}
			
			
			//dcrementing the remaining time
			rt[shortest]--;
			minm = rt[shortest];
			
			if(minm == 0) //set again minm to max_int
				minm = INT_MAX;
				
				//if the process get completly executed
				if(rt[shortest] == 0)
				{
					complete++;
					check = false;
					finish_time = t+1;
								
				//calcilating waiting time
				wt[shortest]  = finish_time - proc[shortest].bt - proc[shortest].art;
				if(wt[shortest]  < 0) //if process just came and scheduled then 
					wt[shortest]=0;
				}
				
				//increment time
				t++;
	}
	
}


void findAvgTime(Process proc[], int n)
{
 int wt[n],tat[n],total_wt=0;
 
   findWaitingTime(proc, n , wt);
   findTurnAroundTime(proc,n,wt,tat);
   cout<<"\nProcess "<<"  Burst Time  "<< "  Waiting Time "<< "  Turn Around Time\n";
   for(int i=0; i<n ; i++)
   {
	   total_wt = total_wt + wt[i];
	   cout<<" "<<proc[i].pid<<"\t\t"<<proc[i].bt<<"\t\t"<<wt[i]<<"\t\t"<<tat[i]<<"\n";
   }
   
   cout<<"\nThe Average Waiting Time: "<< (float)total_wt/(float)n<<"\n";
}

int main()
{
	Process proc [] =  {{1,5,1}, {2,3,1}, {3,6,2},{4,5,3}};
	int n  = sizeof(proc)/sizeof(proc[0]);
	findAvgTime(proc,n);
	return 0;
}