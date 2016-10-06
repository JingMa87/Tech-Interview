package TechInterview;

/**
 * Given a linkedlist, find if the linkedlist is a palindrome.
 * 
 * Input: Generic linkedlist of any size
 * 
 * Output: If the linkedlist is a palindrome, isPalindrome returns true.
 * Otherwise, isPalindrome returns false.
 * 
 */
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
	 * Allows one PalindromeFinder to check multiple lists for palindromes
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
		//Stores the first half of the linkedlist into the stack
		while(i < (list.size() / 2)) {
			stack.push(list.get(i));
			i++;
		}
		//Deals with cases where there is an odd number of elements in the original linkedlist
		if(!isEven)
			i++;
		
		//Attempts to match each element remaining in the list to each element stored in the stack
		while(i < list.size()) {
			//If the element in the list does not match the element in the stack, then exit the loop
			if(!(list.get(i).equals(stack.pop())))
				break;
			//If the loop has reached the end of the list without any mismatches, then the list is a palindrome
			if(i == list.size() - 1)
				return true;
			
			i++;
		}
		//If at any point the previous while loop breaks, then the list is not a palindrome, and return false.
		return false;
	}



	public static void main(String[] args) {
		/*
		 * Tests:
		 * evenPalin (first print statement) should be true (tests lists of even sizes)
		 * oddPalin (second print statement) should be true (tests lists of odd sizes)
		 * notPalin (third print statement) should be false (tests lists that aren't palindromes)
		 * empty (fourth print statement) should be false (tests lists that are empty)
		 */
		SinglyLinkedList<Integer> evenPalin = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> oddPalin = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> notPalin = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> empty= new SinglyLinkedList<>();
		
		//Adds the first set of elements to the linkedlist
		for(int i = 1; i < 6; i++) {
			evenPalin.add(i);
			oddPalin.add(i);
			notPalin.add(i);
		}
		
		//Adds an extra element for the odd list
		oddPalin.add(0);
		
		//Adds the remaining half of the elements to the linked list
		//notPalin has elements shifted up by one in order to have it not be a palindrome
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