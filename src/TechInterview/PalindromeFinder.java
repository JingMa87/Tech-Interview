package TechInterview

public class PalindromeFinder<E> {
	
	private SinglyLinkedList<E> list;
	private boolean isEven;
	private StackLinkedList<E> stack;
	
	public PalindromeFinder(SinglyLinkedList<E> list) {
		this.list = list;
		stack = new StackLinkedList<E>();
		
		//Checks if the linkedlist has an even number of nodes
		if(list.size() % 2 != 0)
			isEven = false;
		else
			isEven = true;
	}
	
	/*
	 * Method to change the linkedlist that needs to be checked.
	 * Helps to prevent from having to create multiple PalindromeFinders
	 */
	public void changeLinkedList(SinglyLinkedList<E> list) {
		this.list = list;
		stack = new StackLinkedList<E>();
		
		if((list.size() % 2) != 0)
			isEven = false;
		else
			isEven = true;
	}
	
	/*
	 * Uses a stack to store the first half of the linkedlist.
	 * Then, compares the stored elements with the second half of the linkedlist.
	 * @return boolean true if the linkedlist is a palindrome, false otherwise.
	 */
	public boolean isPalindrome() {
		int i = 0;
		while(i < (list.size() / 2)) {
			stack.push(list.get(i));
			i++;
		}
		//Deals with cases where there is an odd number of elements in the original linkedlist
		if(!isEven)
			i++;
		
		//Attempts to match each element remaining in the list to each element stored in the stack
		while(i < list.size()) {
			if(!(list.get(i).equals(stack.pop())))
				break;
			if(i == list.size() - 1)
				return true;
			
			i++;
		}
		
		return false;
	}



	public static void main(String[] args) {
		/*
		 * Tests
		 * evenPalin (first print statement) should be true
		 * oddPalin (second print statement) should be true
		 * notPalin (third print statement) should be false
		 */
		SinglyLinkedList<Integer> evenPalin = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> oddPalin = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> notPalin = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> empty= new SinglyLinkedList<>();
		
		for(int i = 1; i < 6; i++) {
			evenPalin.add(i);
			oddPalin.add(i);
			notPalin.add(i);
		}
		
		oddPalin.add(0);
		
		for(int i = 5; i > 0; i--) {
			evenPalin.add(i);
			oddPalin.add(i);
			notPalin.add(i+1);
		}
		PalindromeFinder<Integer> palinFinder = new PalindromeFinder<>(evenPalin);
		System.out.println(palinFinder.isPalindrome());
		
		palinFinder.changeLinkedList(oddPalin);
		System.out.println(palinFinder.isPalindrome());
		
		palinFinder.changeLinkedList(notPalin);
		System.out.println(palinFinder.isPalindrome());
		
		palinFinder.changeLinkedList(empty);
		System.out.println(palinFinder.isPalindrome());
	}
}
