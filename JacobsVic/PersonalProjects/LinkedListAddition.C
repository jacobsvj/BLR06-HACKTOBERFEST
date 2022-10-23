#include<stdio>
#include<conio>
#include<alloc>
#include<stdlib>
void display();
struct link
{
	int data;
	struct link *next;
};
typedef struct link node;

void main()
{
	node *ptr,*start,*temp;
	char ch,ch2;
	int choice,ch1,pos,i;
	clrscr();
	ptr=(node*)malloc(sizeof(node));
	start=ptr;
	printf("\n Enter data :- ");
	scanf("%d",&ptr->data);
	printf("\n Do you want to add more nodes ??? (Y/N)");
	fflush(stdin);
	scanf("%c",&ch);
	while(ch=='y'||ch=='Y')
	{
		ptr->next=(node*)malloc(sizeof(node));
		ptr=ptr->next;
		printf("\n Enter the data :-  ");
		scanf("%d",&ptr->data);
		printf("\n Do you want to add more nodes ??? (Y/N)");
		fflush(stdin);
		scanf("%c",&ch);
	}
	ptr->next=NULL;
	display();
	printf("\n You can perform the following functions on the current linked list \n");
	Again:
	printf("\n1.Add more nodes to specific position");
	printf("\n2.Delete a node from the linked list");
	printf("\n3.Exit Current program\n");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:
			{
			  printf("\n Choose a position where you want to add nodes");
			  printf("\n1.At position 1\n2.Any Specific position\n3.At the end of the list\n");
			  scanf("%d",&ch1);
			  switch(ch1)
			  {
			  case 1:temp=(node*)malloc(sizeof(node));
				 printf("\n Enter data :- ");
				 scanf("%d",&temp->data);
				 temp->next=start;
				 start=temp;
				 printf("\n After adding node , the elements are = \n");
				 display();
				 break;
			  case 2:
				 printf("\n Enter the position in which you want to insert the node");
				 scanf("%d",&pos);
				 for(i=1;i<=pos-2;i++)
				 {
				 ptr=ptr->next;
				 }
				 temp=(node*)malloc(sizeof(node));
				 printf("\n Enter data :- ");
				 scanf("%d",&temp->data);
				 temp->next=ptr->next;
				 ptr->next=temp;
				 printf("\n After adding nodes the elements are- \n");
				 display();
				 break;
			  case 3:while(ptr!=NULL)
				{
					ptr=ptr->next;
				}
				 temp=(node*)malloc(sizeof(node));
				 printf("\n Enter data :- ");
				 scanf("%d",&temp->data);
				 ptr->next=temp;
				 temp->next=NULL;
				 printf("\n After adding nodes the elements are - \n");
				 display();
				 break;
			  default:printf("\n Wrong choice ");
			 }
			break;
			}
		case 2:printf("\n Under Progress \n");
			break;
		case 3:exit(0);
		default:printf("\n Wrong entry ");
		}
		printf("\n Do you want to edit the list further :-  (Y/N)");
		scanf("%c",&ch2);
		if(ch2=='y'||ch2=='Y')
		{
		goto Again;
		}
		else
		{
		exit(0);
		}

	getch();
}
void display()
{
	node *ptr,*start,*temp;
	printf("\n The elements in the linked list are  :- \n");
	ptr=start;
	while(ptr!=NULL)
	{
		printf("%d\t",ptr->data);
		ptr=ptr->next;
	}
}
