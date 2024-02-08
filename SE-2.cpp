//Event management system//

#include<iostream>
#include<string>
#include <math.h>
using namespace std;
// base class EventManagement is created//
class EventManagement{

	private:
		string name;
		string eventname;
		int Num_Server;
		int guest;
		int min;
		double TotalFoodCost;
		double AvgCost;
		double TotalCost;
		double DepositAmount;
		double CostofoneServer;
		
	public:	
	      /// user input to manage event////
		void UserInput()
		{
			cout<<"================Event Management System=================="<<endl;
			cout<<endl;
			
			cout<<"Enter The Name Of Event:"<<endl;
			cin>>eventname;
			
			cout<<"Enter The First and Last name:"<<endl;
			cin>>name;
			
			cout<<"Enter number of guest:"<<endl;
			cin>>guest;
			
			cout<<"Enter The Number Of Minutes in the Event:"<<endl;
			cin>>min;
		
		}
		
		/// cost estimation to be evaluated for party thrower//
		void CostOfEvent()
		{
			double cost1,cost2;
			
			cout<<"===========Event Estimation :"<<name<<"================"<<endl;
			
			Num_Server=ceil(guest/20.0);
			cost1=(min/60)*18.50;
			cost2=(min%60)*.40;
			CostofoneServer=cost1+cost2;
			TotalFoodCost=guest*20.70;
			AvgCost=TotalFoodCost/guest;
			TotalCost=TotalFoodCost+(CostofoneServer*Num_Server);
			DepositAmount=TotalCost*.25;
		}
		
		//// output of entire estimation /////
		void display()
		{
			cout<<"Number Of Server: "<<Num_Server<<endl;
			cout<<"The Cost for Servers: "<<CostofoneServer<<endl;
			cout<<"The Cost For Food Is: "<<TotalFoodCost<<endl;
			cout<<"Average Cost per Person:"<<AvgCost<<endl;
			cout<<"Total Cost Is: "<<TotalCost<<endl;
			cout<<"Please deposite a 25% deposite to reserve the event"<<endl;
			cout<<"The Deposit needed is: "<<DepositAmount;
		}
		
};

int main()
{
	// object class//
	EventManagement obj;
	
	obj.UserInput();
	obj.CostOfEvent();
	obj.display();
	return 0;
}
