/*----------------------------Tic Tac Toe------------------------------*/
#include<stdio.h>
#include<stdlib.h>
// #include<conio.h>
#define SIZE 3
#define switch_turn() pl = (pl==1) ? 2 : 1

int display_ttt(void);
void insert(int,int);
int get_status(void);
void play_again(void);

char a[3][3];
int pl;		//player tag

int main()
{
	setbuf(stdout, NULL);
	int r,c,st;
	char ch;
	pl = 2;
	system("cls");
	display_ttt();
	while(1)
	{
		switch_turn();
		//Input position to insert
		printf("\nPlayer %d :- ",pl);
		printf("\nEnter row : ");
		scanf("%d",&r);
		printf("\nEnter column : ");
		scanf("%d",&c);
		//invalid input
		if(!(r>0 && r<=3) || !(c>0 && c<=3) || a[r-1][c-1] != '\0')
		{
			printf("\n\t\t\t!!INVALID INPUT\n");
			printf("\n\t\t\tContinue(y/n)? : ");
			fflush(stdin);
			scanf("%c",&ch);
			if(ch=='n' || ch=='N')
				exit(0);
			printf("Please enter valid(1,2 or3)row/column\n");
			getchar();
			display_ttt();
			getchar();
			switch_turn();  //as turn has already been switched
			continue;
		}
		//Inserting data to array
		insert(r,c);
		display_ttt();
		st = get_status();    //status of game
		/*-----Printing the final result-----*/
		if(st==1 || st == 2)
		{
			printf("\n\n\t\t\t!!CONGRATULATIONS!!");
			printf("\n\t\t\tPlayer %d wins the game",st);
			getchar();
			printf("\n\n\t\tWant to play again(y/n)? : ");
			fflush(stdin);
			scanf("%c",&ch);
			if(ch!='y' && ch!='Y')
				break;
			play_again();
		}
		else if(st == -1)
		{
			printf("\n\n\t\t\t\t!!!GAME OVER!!!\
				\n\t\t\t\t!!!No one wins !!");
			getchar();getchar();
			printf("\n\t\tTry again(y/n)? : ");
			fflush(stdin);
			scanf("%c",&ch);
			if(ch!='y' && ch!='Y')
				break;
			play_again();
		}/*End of if*/
	}/*End of while*/
	return 0;
}/*End of main()*/
/*--------------Function to display the Tic Tac Toe---------------*/
int display_ttt()
{
	int i,j,k,row=1,col,temp1,temp2;
	system("cls");
	printf("\n-----------------------------TIC TAC TOE--------------------------------------------\n\n");
	if(pl==2)printf("\n\t\t%c Player 1 : O \t  Player 2 : X\n\n",26);
	else if(pl==1)printf("\n\t\t  Player 1 : O \t%c Player 2 : X\n\n",26);
	for(i=0;i < (3*SIZE + 2);i++)	//3 columns and 2 vertical lines
	{
		//for center aligning the display
		printf("\t\t\t");
		col = 1;
		for(j=0;j < (3*SIZE + 2);j++)	//for horizontal travresal
		{
			if(i==SIZE || i==(2*SIZE+1)) //for horizontal border lines
			{
				if(j==0)  //incrementing row for first j only
					row++;
				if(j == col*SIZE + (col-1)) //intersection
				{
					printf("+");
					col++;
				}
				else
					printf("--");  //two dashes
			}
			else    //for non-border rows
			{
				//for vertical borders
				if(j == col*SIZE + (col-1))
				{
					printf("|");
					col++;
				}
				//for the box
				else if(i == SIZE/2 + (row-1)*(SIZE+1)) //central row of a box
				{
					//but this is working for middle row of first row only
					if(j == SIZE/2 + (col-1)*(SIZE+1)) //central column of a box
						//center of the box
						printf("%c ",a[row-1][col-1]);
					else //non central column
						printf("  ");
				}
				else
					printf("  "); //two spaces for non central rows
			}/*End of if*/
		} /*End of inner for loop */
		printf("\n");
	}/*End of outer for loop */
	return get_status();
}/*End of ttt()*/
/*-------------Function for inserting input to array---------------*/
void insert(int r,int c)
{
	if(pl==1)
		a[r-1][c-1] = 'O';
	else if(pl==2)
		a[r-1][c-1] = 'X';
}
int get_status()
{
	int i,j,fl=0;
	/*------Winning Condition-------*/
	for(i=0;i<3;i++)
	{
		//horizontal checking
		if(a[i][0] != '\0')
		{
			if(a[i][0] == a[i][1] && a[i][0] == a[i][2])
				return pl;
		}
		//vertical checking
		if(a[0][i] != '\0')
		{
			if(a[0][i] == a[1][i] && a[0][i] == a[2][i])
				return pl;
		}
	}
	//diagonal checking
	if(a[0][0] != '\0' && a[0][0] == a[1][1] && a[1][1] == a[2][2])
		return pl;
	if(a[0][2] != '\0' && a[0][2] == a[1][1] && a[1][1] == a[2][0])
		return pl;
	/*---------Game Over Condition---------*/
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			if(a[i][j] == '\0')
			{
				fl = 1;
				break;
			}
		}
	}
	if(fl==0)
		return -1;
	/*---------------------------*/
	return 0;
}/*End of get_status()*/
void play_again()
{
	int i,j;
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			a[i][j] = 0;
		}
	}
	pl = 2;
	
}