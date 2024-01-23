//WAP to make multiplication of 2-D matrix//

#include<stdio.h>
void mul(int[2][2],int[2][2]);
int main()
{
	////// INPUT OF MATRIX-1//////
	
	int a[2][2],b[2][2],i,j;
	printf("-------------------matrix-1-------------------\n");
	for(i=0;i<2;i++)
	{
		for(j=0;j<2;j++)
		{
			printf("enter the elements");
			scanf("%d",&a[i][j]);
		}
	}
	
	////// REPRESENTS THE GIVEN INPUT IN MATRIX FORM////
	
	for(i=0;i<2;i++)
	{
		for(j=0;j<2;j++)
		{
			printf(" %d ",a[i][j]);
		}
		printf("\n");
	}
	
	//////INPUT OF MATRIX-2////////
	
	printf("--------------------matrix:2----------------------\n");
	for(i=0;i<2;i++)
	{
		for(j=0;j<2;j++)
		{
			printf("enter the elements");
			scanf("%d",&b[i][j]);
		}
	}
	
	//////REPRESENTS THE MATRIX FORM////////
	
	for(i=0;i<2;i++)
	{
		for(j=0;j<2;j++)
		{
			printf(" %d ",b[i][j]);
		}
		printf("\n");
	}
	
	//FUNCTION CALL////
	
	mul(a,b);
	return 0;
}
void mul(int a[2][2],int b[2][2])
{
	//// RESULTANT MATRIX////
	
	int c[2][2],i,j,k;
	for(i=0;i<2;i++)
	{
		for(j=0;j<2;j++)
		{
			c[i][j]=0;
			for(k=0;k<2;k++)
			{
				c[i][j]=c[i][j]+a[i][k]*b[k][j];
			}
		}
	}
	
	//////OUTPUT OF THE GIVEN INPUT OF 2-D MATRIX MULTIPLICATION///////
	
	printf("------------- result----------\n");
	for(i=0;i<2;i++)
	{
		for(j=0;j<2;j++)
		{
			printf(" %d ",c[i][j]);
		}
	   	printf("\t \n");
	}
	
}
