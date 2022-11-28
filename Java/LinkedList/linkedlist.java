import java.io.*;
import java.util.ArrayList; 

// Java program to implement 
// a Singly Linked List 
public class linkedlist { 

	Node head; // head of list 

	// Linked list Node. 
	// This inner class is made static 
	// so that main() can access it 
	static class Node { 

		int data; 
		Node next; 

		// Constructor 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	// **************INSERTION************** 

	// Method to insert a new node 
	public static linkedlist insert(linkedlist list, int data) 
	{    
		// Create a new node with given data 
		Node new_node = new Node(data);
		// then make the new node as head 
		if (list.head == null)
		{
			list.head = new_node;
		
		}
		else // Else traverse till the last node
		{
			Node current = list.head;
			while (current.next != null)
			{
				current = current.next;
			}
			current.next = new_node;// Insert the new_node at last node 
		}
		return list;
	} 

	// **************TRAVERSAL************** 

	// Method to print the linkedlist. 
	public static void printList(linkedlist list) 
	{ 
		// Traverse through the linkedlist 
			// Print the data at current node 
			// Go to next node
		Node current = list.head;
		System.out.println("------Nodes-----");
		while (current.next != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);
        }

	// **************DELETION BY KEY************** 

	// Method to delete a node in the linkedlist by KEY 
	public static linkedlist deleteByKey(linkedlist list, int key) 
	{ 
		// Store head node 

		// 
		// CASE 1: 
		// If head node itself holds the key to be deleted 
		if (list.head.data == key)
		{
			list.head = list.head.next;
			System.out.println(key + " found and deleted at head"); // Display the message 
			return list;	// Return the updated List 
		}
			
			

		

		// 
		// CASE 2: 
		// If the key is somewhere other than at head 
		// 
		Node previous = null;
		Node current = list.head;
		// If currNode does not hold key 
		// continue to next node 
		while (current.data != key && current.next != null)
		{
			previous = current;
			current = current.next;
		}
		if (current.data == key)
		{
			previous.next = current.next;
			System.out.println(key + " found and deleted"); 
			return list;
		}

		

		// If the key was present, it should be at currNode 
		// Therefore the currNode shall not be null 
			// Since the key is at currNode 
			// Unlink currNode from linked list 
			// Display the message 
			

		// 
		// CASE 3: The key is not present 
		// 
		else 
		{
			System.out.println("Key not found");
			return list;
		}
		// If key was not present in linked list 
		// currNode should be null 
			// Display the message 

		// return the List
	} 

	// **************DELETION AT A POSITION************** 

	// Method to delete a node in the linkedlist by POSITION 
	public static linkedlist deleteAtPosition(linkedlist list, int index) 
	{ 
		// Store head node 

		// 
		// CASE 1: 
		// If index is 0, then head node itself is to be deleted 
			// Display the message 
		if (index == 0)
		{
			list.head = list.head.next;
			System.out.println(index + " position element deleted"); 
			return list;// Return the updated List 
		}
			

			

		// 
		// CASE 2: 
		// If the index is greater than 0 but less than the size of linkedlist
		
		Node previous = null;
		Node current = list.head;
		//Find the total list of the list
		int length = 0 ;
		while(current.next != null) 
		{
			current=current.next;
			length++;
		}
		if (index > length)
		{
			System.out.println("Index greater than length");
			return list;
		}
		length=0;
		current = list.head;
		while (current.next != null && length != index)
		{
			previous = current;
			current = current.next;
			length++;
		}
		previous.next = current.next;
		// Count for the index to be deleted, 
		// keep track of the previous node 
		// as it is needed to change currNode.next 
				// Since the currNode is the required position 
				// Unlink currNode from linked list 
				// Display the message 
				System.out.println(index + " position element deleted"); 
				

				return list;
	} 
        private static linkedlist removeDuplicates(linkedlist list)
        {
        	
	
	         ArrayList <Integer>AL = new ArrayList();
	         Node current = list.head;
	         Node previous = null;
	         while (current.next != null)
	         {
	        	if (AL.contains(current.data)!=true)
	        	{
	        		AL.add(current.data);
	        	}
	        	 current = current.next;
	         }
	         if (AL.contains(current.data)!=true)
	         {
	         AL.add(current.data);
	         }
	         current = list.head;
        	 linkedlist returnList = new linkedlist();
	         AL.forEach(element -> returnList.insert(returnList, element));
	         return returnList;
        }

	// **************MAIN METHOD************** 

	// method to create a Singly linked list with n nodes 
	public static void main(String[] args) 
	{ 
		/* Start with the empty list. */
		linkedlist list = new linkedlist(); 

		// 
		// ******INSERTION****** 
		// 

		// Insert the values 
		list = insert(list, 1); 
		list = insert(list, 2); 
		list = insert(list, 3); 
		list = insert(list, 4); 
		list = insert(list, 5); 
		list = insert(list, 6); 
		list = insert(list, 7); 
		list = insert(list, 8); 

		// Print the linkedlist 
		printList(list); 

		// 
		// ******DELETION BY KEY****** 
		// 

		// Delete node with value 1 
		// In this case the key is ***at head*** 
		deleteByKey(list, 1); 

		// Print the linkedlist 
		printList(list); 

		// Delete node with value 4 
		// In this case the key is present ***in the middle*** 
		deleteByKey(list, 4); 

		// Print the linkedlist 
		printList(list); 

		// Delete node with value 10 
		// In this case the key is ***not present*** 
		deleteByKey(list, 10); 

		// Print the linkedlist 
		printList(list); 

		// 
		// ******DELETION AT POSITION****** 
		// 

		// Delete node at position 0 
		// In this case the key is ***at head*** 
		deleteAtPosition(list, 0); 

		// Print the linkedlist 
		printList(list); 

		// Delete node at position 2 
		// In this case the key is present ***in the middle*** 
		deleteAtPosition(list, 2); 

		// Print the linkedlist 
		printList(list); 

		// Delete node at position 10 
		// In this case the key is ***not present*** 
		deleteAtPosition(list, 10); 

		// Print the linkedlist 
		printList(list); 
                
                // Build a list with duplicates
                linkedlist duplicates = new linkedlist();
                duplicates = insert(duplicates, 1);
                duplicates = insert(duplicates, 1);
                duplicates = insert(duplicates, 1);
                duplicates = insert(duplicates, 2);
                duplicates = insert(duplicates, 3);
                duplicates = insert(duplicates, 3);
                duplicates = insert(duplicates, 4);
                // Print list with duplicates
                printList(duplicates);
                // Remove duplicates
                duplicates = removeDuplicates(duplicates);
                // Print list without duplicates
                printList(duplicates);
	} 
} 
