import java.util.Iterator;
import java.util.Stack;

class Node{
   
   public int data;
   public Node next;
   
   public Node(int data){
      this.data = data;
      this.next = null;
   }

}



public class StackLinkedList{
   
   Node front;
   
   //operation push
   public void push(int data){
      /*
      The push operation is equivalent to the inserting a node at 
      the head of the list.

      */
	   Node toPush = new Node(data);
	   //starts new list(sort of)
	   if (this.front == null)
	   {
		   this.front = toPush;
	   }
	   else
	   {
		  //slides toPush to front and front to ToPush.next
		 toPush.next = this.front;
		 this.front = toPush;
	   }
   }
   
   
   //operation pop
   public void pop(){
      /*
      Pop is equivalent to deleting the node at the front
      */
	   //null check
	   if (this.front != null)
	   {
		   //unlinks this.front
		   this.front = this.front.next;
	   }
   }
   
   
   //operation peek
   public int peek(){
      /*
      Peek is equivalent to the pop operation
      but instead of removing the node, simply return the data
      */
	   //null check
	   if (this.front!= null) 
      {
          return this.front.data;  
      }
      else
      {
    	  //return if null
    	  return -1;
      }
   }
   
   
   //operation display
   public void print(){
	   //null check 
	   if (this.front != null) 
	   {
	   //reference node
	   Node current = this.front;
	   //create empty stack
	   Stack<Node> stk = new Stack<Node>();
	  //traverse list
	   while (current.next != null) 
	   {
		   //add to top 
		   stk.push(current);
		   //move to next
		   current = current.next;
	   }
	   //push last node
	   stk.push(current);
	   //create iterator
	   //Iterator<Node> itr = stk.iterator();
	   //walk stack with pretty printing
	   System.out.println("----------Stack----------");
	   stk.stream().forEach(S -> System.out.println(S.data));
	   System.out.println("-------------------------");
   }
	   else
	   {
		   //used for debugging of last s.print
		   System.out.println("Stack is empty");
	   }
   }
   
   
   
   
   //main
   public static void main(String[] args){
      
      StackLinkedList s = new StackLinkedList();
      s.push(10);
      s.push(20); 
      s.print();
      
      System.out.println("top of the stack: "+ s.peek());
      
      s.pop();
      s.print();
      
      s.push(90);
      s.print();
      
      s.pop();
      s.pop();
      s.pop();
      s.print();
   }
}