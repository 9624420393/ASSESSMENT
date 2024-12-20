//Write a program to demonstrate a Rock Paper Scissor Game///

#include<iostream>
#include<stdlib.h>
#include<string>
#include<ctime>

using namespace std;

// A function is created for computer //
// logic is built to generate a random number///
int Computer_choice()
{
	int move;
	srand(time(0));
	move=(rand()%3)+1;
	return move;
}

// A class is created to perform operation//
class Game{
	
	private:
		string name;
		int round;
		int user_choice;
		int user_count;
		int computer_score;
		
	public:
		// Input Userr details//
		void Userinput()
		{
			
			cout<<"-----------------------------NAME:------------------------------------"<<endl;
			cout<<endl;
			
			cout<<"Enter Your Name:";
			cin>>name;
			cout<<endl;
			
			cout<<"----------------------------ROUNDS:-------------------------------------"<<endl;
			cout<<endl;
			cout<<"----------------------How Many Rounds You Want To Play?------------"<<endl;
			cin>>round;
			cout<<endl;
			
			cout<<"----------------------GAME:---------------------------"<<endl;
			cout<<endl;
			
			
		}
		
		// A function is created for userchoice and winner for each round//
		void play()
		{
			
			for(int i=0;i<=round;i++)
			{
				cout<<"Round:"<<i<<round<<endl;
				cout<<endl;
				
				cout<<name<<"score:="<<user_count<<endl;
				cout<<endl;
				
				cout<<"Computer Score:="<<computer_score<<endl;
				cout<<endl;
				
				
				cout<<"1)ROCK"<<endl;
				cout<<"2)PAPER"<<endl;
				cout<<"3)SCISSOR"<<endl;
				cout<<endl;
				
				cout<<"ENTER YOUR CHOICE";
				cin>>user_choice;
				
			
			
			int computer_choice= Computer_choice();
			cout<<endl;
			cout<<"Computer Choice:"<<computer_choice<<endl;
			
			// conditions for winner///
			if(user_choice==1 && computer_choice==3 || user_choice==2 && computer_choice==1 || user_choice==3 && computer_choice== 2)
			{
				cout<<endl;
				cout<<"YOU WIN";
				cout<<endl;
				user_count++;
				
			}
			else if(user_choice==1 && computer_choice==2 || user_choice==2 && computer_choice==3|| user_choice==3 && computer_choice== 1)
			{
				cout<<endl;
				cout<<"COMPUTER WIN";
				cout<<endl;
				computer_score++;
			}
			else
			{
			   cout<<endl;
			   cout<<"DRAW"<<endl;
			  	
			}
			
			cout<<endl;
			
			/// pause is used to pause the system for a while///
			system("pause");
	
			}
		}
		
		// A function for getting final result outcome for winner///
		void winner()
		{
			if(user_count < computer_score)
			{
				cout<<"Computer Won"<<endl;
			}
			else if(user_count > computer_score)
			{
				cout<<"You Won "<<endl;
			}
			else
			{
				cout<<"Draw"<<endl;
			}
		}
    
    };



int main()
{
	// object of game class//
	Game obj;
	obj.Userinput();
	obj.play();
	obj.winner();
	
}
