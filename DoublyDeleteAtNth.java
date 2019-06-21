import java.util.*;
class Node{
	int data;
	Node previous;
	Node next;
	static Node head;
}

class Operations{
	public static void insert(int x){
		Node node = new Node();
		node.data=x;
		node.next=null;
		if(Node.head==null){
			node.previous=null;
			Node.head=node;
		}
		else{
			Node temp=Node.head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=node;
			node.previous=temp;
		}
	}
	public static void traverse(){
		Node temp=Node.head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	public static void delete(int pos){
		Node temp = Node.head;
		if(Node.head.next==null){
			Node.head=null;
		}
		else{
			for(int i=0;i<pos;i++)
			temp=temp.next;
			if(temp.previous==null){
				Node.head=Node.head.next;
				Node.head.previous=null;
			}
			else{
				temp.previous.next=temp.next;
			}
			if(temp.next==null){
				temp.previous.next=null;
			}
			else{
				temp.next.previous=temp.previous;
			}
		}
		temp=null;
	}
}

class DoublyDeleteAtNth{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		Node.head=null;
		int ans;
		do{
			System.out.print("Enter a value to insert : ");
			int x= Integer.parseInt(sc.nextLine());
			Operations.insert(x);
			System.out.print("Do you want to insert more (0/1)?");
			ans = Integer.parseInt(sc.nextLine());
		}
		while(ans==1);	
		System.out.print("Link list : ");	
		Operations.traverse();
		do{
			System.out.print("Enter the position to delete : ");
			int pos = Integer.parseInt(sc.nextLine());
			Operations.delete(pos-1);
			System.out.print("Link list : ");	
			Operations.traverse();
			if(Node.head==null){
				System.out.println("Node List is empty");
				ans=0;
			}
			else{
				System.out.print("Do you want to delete more (0/1)?");
				ans = Integer.parseInt(sc.nextLine());
			}
		}	
		while(ans==1);
	}
}