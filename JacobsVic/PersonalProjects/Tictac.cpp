#include<iostream>
#include<conio>
#include<stdlib>
int x,y,i,j,e,f,k,u,r,count;
int a[3][3];
char *player1,*player2;

void p1()
{
	Againone:
	cout<<" Input by player 1"<<endl;;
	cout<<" Enter the co-ordinates \n";
	cin>>x;
	cin>>y;
	if(a[x][y]!=0)
	{
		cout<<" Wrong input. Co ordinates already occupied \n";
		cout<<"Enter your values again..... \n";
		cout<<"press any key to enter the values again...... \n";
		getch();
		clrscr();
		goto Againone;
	}
	else
	{
		a[x][y]=1;
	}
	x=0;y=0;
}
void p2()
{
	Againtwo:
	cout<<" Input by player 2"<<endl;
	cout<<" Enter the co-ordinates \n";
	cin>>x;
	cin>>y;
	if(a[x][y]!=0)
	{
		cout<<" Wrong input. Co ordinates already occupied \n";
		cout<<"Enter your values again..... \n";
		cout<<" Press a key to enter values again...... \n";
		getch();
		clrscr();
		goto Againtwo;
	}
	else
	{
		a[x][y]=2;
	}
	x=0;y=0;
}
void display()
{
	cout<<"\n\n\n\t\t\t";
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			cout<<a[i][j]<<"\t";
		}
		cout<<endl<<"\t\t\t";
	}
}
int compare(int q)
{
       if(a[0][0]==q)
       {
		if(a[1][0]==q)
		{
			if(a[2][0]==q)
			{
				return(5);
			}
		}
		if(a[0][1]==q)
		{
			if(a[0][2]==q)
			{
				return(5);
			}
		}
		if(a[1][1]==q)
		{
			if(a[2][2]==q)
			{
				return(5);
			}
		}
       }
       if((a[0][1]==q)&&(a[1][1]==q)&&(a[2][1]==q))
       {
		return(5);
       }
       if(a[0][2]==q)
       {
		if(a[1][1]==q)
		{
			if(a[2][0]==q)
			{
				return(5);
			}
		}
		if(a[1][2]==q)
		{
			if(a[2][2]==q)
			{
				return(5);
			}
		}
       }
       if((a[1][0]==q)&&(a[1][1]==q)&&(a[1][2]==q))
       {
		return(5);
       }
       if((a[2][0]==q)&&(a[2][1]==q)&&(a[2][2]==q))
       {
		return(5);
	}
	return 0;
}
int draw()
{
	for(k=0;k<3;k++)
	{
		for(u=0;u>3;u++)
		{
			if(a[k][j]!=0)
			{
				count++;
			}
		}
	}
	if(count==9)
	{
		return(5);
	}
	return 0;

}


void main()
{
	clrscr();
	restart:
	cout<< " Welcome to tic-tac-toe "<<endl;
	for(int m=0;m<3;m++)
	{
		for(int n=0;n<3;n++)
		{
			a[m][n]=0;
		}
	}
	cout<<"Enter first player's name \n"<<endl;
	cin>>player1;
	cout<<" Enter Second player's name \n";
	cin>>player2;
	cout<<" Thanks for the info . \n";
	cout<<" Press any key to start the game ....... \n";
	getch();
	clrscr();
	cout<<" Tic-tac-toe\n\n";
	int l=1;
	while(l>0)
	{

		display();
		r=draw();
		if(r==5)
		{
		       cout<<" Game draw "<<endl;
		       goto xyz;
		}
		cout<<"\n\n";
		p1();
	       e=compare(1);
	       if(e==5)
	       {
			display();
			cout<<"Player 1  wins!!! "<<endl;

			goto xyz;
	       }
	       clrscr();
	       display();
		r=draw();
		if(r==5)
		{
		       cout<<" Game draw "<<endl;
		       goto xyz;
		}
	       cout<<"\n\n";
		p2();
	       f=compare(2);
	       if(f==5)
	       {
			display();
			cout<<"Player 2 wins !!!"<<endl;

			goto xyz;
	       }
	       clrscr();
	       e=0;f=0;
	}
	xyz:
	cout<<" Press any key to continue..... "<<endl;
	getch();
	clrscr();
	cout<<"Thanks for playing "<<endl;
	cout<<"Do you want to play again ??  (Y/N)"<<endl;
	char cha;
	cin>>cha;
	if(cha=='y'||cha=='Y')
	 {
		goto restart;
	 }
	 else
	 {
		cout<<" Press any key to exit ...... "<<endl;
		getch();
		exit(0);
	 }
}
