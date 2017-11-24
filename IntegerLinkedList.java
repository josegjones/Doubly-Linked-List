class IntegerLinkedList
{
	private Node head;
	private Node tail;
	private Node previousNodeAddress;
	private int nodeCounter;
	
	//List info methods

	public boolean isEmpty()
	{
		if(nodeCounter == 0)
			return true;
		else
			return false;
	}

	public int getListSize()
	{
			return nodeCounter;
	}
		
	//inserting methods
	
	public void addNode(int data)
	{
		if(head == null)
		{
			Node newNode = new Node();
			
			newNode.data = data;
			head = newNode;
			tail = newNode;
			previousNodeAddress = head;
			nodeCounter++;
		}
		else
		{
			Node newNode = new Node();
			
			newNode.data = data;
			previousNodeAddress.next = newNode;
			newNode.previous = previousNodeAddress;
			tail = newNode;
			previousNodeAddress = newNode;
			nodeCounter++;
		}
	}
	
	
	public void insertHeadNode(int data)
	{
		if(head == null)
		{
			Node newNode = new Node();
			
			newNode.data = data;
			head = newNode;
			tail = newNode;
			previousNodeAddress = head;
			nodeCounter++;
			//System.out.println("Before using this method, you must use addNode() to create an initial node");			
		}
		else
		{
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = head;
			head = newNode;
			nodeCounter++;
		}
	}
	
	public void insertTailNode(int data)
	{
		if(isEmpty())
		{
			System.out.println("The list is empty! use the addNode() method first to start a list.");
		}
		else
		{
			addNode(data);
		}
	}
	
	public void insertInnerNode(int nodeIndex, int data)
	{
		if(nodeCounter < nodeIndex)
		{
			System.out.println("Your index is greater than the list size!");
		}
		else if(nodeIndex <= 1)
		{
			System.out.println("Your index might be to low or pointing to head. If pointing to head (1), try insertHeadNode() method.");
		}
		else
		{
			Node newNode = new Node();
			newNode.data = data;
			
			Node temporalPointer = traversingTheList(nodeIndex);
			
			Node previousNode = temporalPointer.previous;
			previousNode.next = newNode;
			newNode.previous = previousNode;
			newNode.next = temporalPointer;
			temporalPointer.previous = newNode;				
		}	
	}
	
	//Updating methods
	public void updateHeadNode(int data)
	{
		head.data = data;
	}
	
	public void updateTailNode(int data)
	{
		tail.data = data;
	}
	
	public void updateInnerNode(int nodeIndex, int data)
	{
		Node temporalPointer = traversingTheList(nodeIndex);
		
		temporalPointer.data = data;		
	}
	
	//Displaying Methods
	
	public void displayList()
	{
		if(head == null)
		{
			System.out.println("List is empty");
		}
		
		Node listNavigator = head;
		int nodeNumber = 1;
		
		while(listNavigator != null)
		{			
			System.out.println("Node: " + nodeNumber + " Data: " + listNavigator.data);
			
			listNavigator = listNavigator.next;
			nodeNumber++;			
		}
				
	}
	
	public void displayLastNode()
	{
			System.out.println("Last Node is #: " + nodeCounter + " Data: " + tail.data);
	}
	
	public void displayFirstNode()
	{
		System.out.println("First Node is #: 1" + " Data: " + head.data);
	}
	
	
	//Getting/Retrieving Methods
	
	public int getFirstNodeData()
	{
			return head.data;		
	}
	
	public int getLastNodeData()
	{
			return tail.data;		
	}
	
	public int getInnerNodeData(int nodeIndex)
	{
		if(nodeIndex > nodeCounter || nodeIndex <= 0)
		{
			System.out.println("This node doesn't exist in this list. Try another please!");
		}
		else if(nodeIndex == 1)
		{
			System.out.println("This is the first index. Use getFirstNodeData()");
		}
		else if(nodeIndex == nodeCounter)
		{
			System.out.println("This is the last index. Use getLastNodeData()");
		}
		else
		{
			Node temporalPointer = traversingTheList(nodeIndex);
			return temporalPointer.data;
		}

		return 0;	
	}
	
	//Deleting methods
	
	public void deleteInnerNode(int nodeIndex)
	{		
		if(nodeIndex <= 0 || nodeIndex > nodeCounter)
		{
			System.out.println("Your index does not exist int the list! Try another please");
		}
		else if(nodeIndex == 1)
		{
			System.out.println("You must use the method deleteHeadNode()!");
		}
		else if(nodeIndex == nodeCounter)
		{
			System.out.println("You must use the method deleteTailNode()!");
		}
		else
		{
			Node temporalPointer = traversingTheList(nodeIndex);
			
			Node nextNode = temporalPointer.next;
			Node previousNode = temporalPointer.previous;
			
			previousNode.next = nextNode;
			nextNode.previous = previousNode;
			
			temporalPointer.next = null;
			temporalPointer.previous = null;
			
			nodeCounter--;
		}
	}
	
	//Auxiliary methods
		
	//This method return the pointer to the node index given.
	
	public Node traversingTheList(int nodeIndex)
	{
		int listHalf = nodeCounter/2;
		
		if(nodeIndex <= listHalf)
		{
			Node temporalHead = head;
			
			for(int i = 1; i < nodeIndex; i++)
			{
				temporalHead = temporalHead.next;
			}
			
			return temporalHead;
			
		}else
		{
			int iterationsFromTail = nodeCounter - nodeIndex;
			Node temporalTail = tail;
			
			for(int i = 0; i < iterationsFromTail; i++)
			{
				temporalTail = temporalTail.previous;
			}
			
			return temporalTail;
			
		}
	}
}