//producer consumer problem
#include<bits/stdc++.h>
using namespace std;
int mutex = 1; //this semaphore provides mutual exclusion
int full =0; //ful buffers
int empty =3; //empty  buffers
int x= 0;

void producer();
void consumer();
int wait(int);
int signal(int);
 
void producer()
{
	mutex = wait(mutex);
	full = signal(full);
	empty = wait(empty);
	x++;
	cout<<"\nProducer produces the item: "<<x<<"\n";
	mutex = signal(mutex);
}

void consumer()
{
	mutex = wait(mutex);
	full = wait(full);
	empty = signal(empty);
	cout<<"\nConsumer consumed: "<< x<<"\n";
	x--;
	mutex = signal(mutex);
}

int wait(int S)
{
	return --S;
}

int signal(int S)
{
	return ++S;
}	

int main()
{
 int n;
 cout<< "\nPress 1: Produce"<<"\n2: Consume"<<"\n3: Exit"<<"\n";
 while(1)
 {
	 cout<<"\nEnter your choice: ";
	 cin>>n;
	 switch(n)
	 {
		 case 1:
		  if(mutex == 1 && empty!=0)
			  producer();
		  else
			  cout<<"\nBuffer is full!"<<"\n";
		  break;
		  
		  case 2:
		   if(mutex == 1 && full!=0)
			   consumer();
		    else
			  cout<<"\nBuffer is empty!"<<"\n";
		   break;
		   
		    case 3:
		    exit(0);
			break;
			
			default:
			cout<<"\nInvalid choice!";
			exit(0);
			break;
	 }
 }
 return 0;
}
