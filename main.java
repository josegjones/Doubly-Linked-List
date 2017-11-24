class main {

	
	public static void main(String args[])
	{
	
		IntegerLinkedList myList = new IntegerLinkedList();
		
		for(int i = 0; i < 12; i++)
		{
			myList.addNode(i);
		}
		
		myList.displayList();
		System.out.println("--------------------------");
		
			
		System.out.println("Data at node 14: " + myList.getInnerNodeData(14));	
			

		
		myList.deleteInnerNode(5);
		
		myList.displayList();
		System.out.println("--------------------------");
		
		myList.insertHeadNode(20);
		myList.displayList();
		System.out.println("--------------------------");
		
		myList.insertInnerNode(5,200);
		myList.displayList();
		System.out.println("--------------------------");
		
		myList.insertTailNode(300);
		myList.displayList();
		System.out.println("--------------------------");
		
		myList.insertHeadNode(300);
		myList.displayList();
		System.out.println("--------------------------");
		
	}	
}