package practicePackage2;

import java.util.Scanner;

public class queue 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MAIN MENU");
		System.out.println("1 Insert");
		System.out.println("2 Delete");
		System.out.println("3 Display");
		System.out.println("Press any other key to exit");
		while(true) {
		System.out.print("Enter choice");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		sc.close();
		switch(ch) {
		case 1:push();
			   break;
		case 2: pop();
			   break;
		case 3: disp();
			    break;
		default: System.exit(0);
		}
	}
		
	}
		static void push() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter item to be inserted:");
			int item=sc.nextInt();
			sc.close();
			if(GlobalV.rear==-1) 
				GlobalV.front=GlobalV.rear=0;
			else if(GlobalV.rear==99) {
				System.out.println("Overflow");
				return;
			}
			else
				GlobalV.rear++;
			GlobalV.q[GlobalV.rear]=item;
			System.out.println("Insertion successful");
			disp();
			return;
			}
		
		static void pop() {
			if(GlobalV.front==-1)
			{
				System.out.println("Underflow");
				return;
			}
			else {
				System.out.println("Element deleted is:"+GlobalV.q[GlobalV.front]);
				GlobalV.front++;
				
			}
		}

		static void disp() {
			if(GlobalV.front==-1 || GlobalV.front>GlobalV.rear)
			{
				System.out.println("Queue is already empty");
				return;
			}
			else {
				System.out.println("The queue is ");
				for(int i=GlobalV.front;i<=GlobalV.rear;i++)
					System.out.println(GlobalV.q[i]);
			}
		}
	}


