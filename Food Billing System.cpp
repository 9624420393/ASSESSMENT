#include<Stdio.h>

void menu()
{
	printf("==================WELCOME TO RESTAURANT========================\n");
	
	printf("Sr.no       Item            Price\n");
	printf(" 1          Pizza            180/-\n");
	printf(" 2          Burger           100/-\n");
	printf(" 3          Dosa             120/-\n");
	printf(" 4          Idli             50/-\n");
	printf("\n");         
}

int main()
{
	int quantity;
	int choice;
	int total;
	int price;
	int repeat;
	int Bill;
	
	menu();
	do{
	
	printf("enter your choice:");
	scanf("%d",&choice);
	
	switch(choice)
	{
		case 1:
			price = 180;
                printf("Enter quantity for Pizza: ");
                scanf("%d", &quantity);
                total += price * quantity;
                
                break;
            case 2:
                price = 100;
                printf("Enter quantity for Burger: ");
                scanf("%d", &quantity);
                total += price * quantity;
                
                break;
            case 3:
                price = 120;
                printf("Enter quantity for Dosa: ");
                scanf("%d", &quantity);
                total += price * quantity;
            
                break;
            case 4:
                price = 50;
                printf("Enter quantity for Idli: ");
                scanf("%d", &quantity);
                total += price * quantity;
                
                break;
           
            default:
                printf("Invalid choice, please try again.\n");
        }
        
        printf("Amount:%d\n",total);
        printf("Do you want anything else:");
        scanf("%d",& repeat);
   }
        while( repeat == 1);
        {
        
        	printf("total bill:%d",total);
		}
	
        
	}
	

