package TechInterview;

import java.util.List;

/**
 * This class has solution for Bit Manipulation questions
 * from book Cracking the Coding Interview
 * @author JayOnCaffeine
 *
 */
public class BitManipulation {

	public boolean getBitFromNthPosition(int binum, int position) {
		return ((binum & (1 << position)) != 0);
	}

	public int updateBitOnNthPosition(int binum, int value, int position) {
		int mask = ~(1 << position);
		binum = binum & mask;
		return binum | (value << position);
	}

	public void printBinary(final int num) {
		System.out.println(Integer.toBinaryString(num));
	}

	public void printMessage(final Object msg) {
		System.out.println(msg);
	}

	public boolean isBinaryString(final String num) {
		for(Character digit : num.toCharArray()) {
			if(Integer.parseInt(digit.toString()) > 1) {
				return false;
			}
		}
		return true;
	}

	/*
	 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
	 * Write a method to insert M into N such that M starts at bit j and ends at bit i. 
	 * You can assume that the bits j through i have enough space to fit all of M.
	 */
	public void insertion(String N, String M, int i, int j) {
		int Nint = Integer.parseInt(N, 2);
		int Mint = Integer.parseInt(M, 2);
		if ( j > i && (j-i+1) == M.length()) {
			for(int k = M.length(); k > 0 && j >= i; k--) {
				if(getBitFromNthPosition(Mint, k-1)) {
					Nint = updateBitOnNthPosition(Nint, 1, j);
				} else {
					Nint = updateBitOnNthPosition(Nint, 0, j);
				}
				j--;
			}
			printBinary(Nint);
		} else {
			printMessage(" j should be greater than i ");
		}
	}

	/*
	 * Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, 
	 * print the binary representation. If the number cannot be represented accurately in binary 
	 * with at most 32 characters, print "ERROR:'
	 */
	public void binaryToString(double num) {
		StringBuffer result = new StringBuffer();
		result.append("0.");
		while(num > 0) {
			num = num * 2;
			byte bit = (byte) (num / 1);
			result.append(bit);
			if(bit != 0) {
				num = num - 1;
			}
			if(result.length() > 32) {
				printMessage("ERROR");
				return;
			}
		}
		printMessage(result.toString());
	}

	/*
	 * You have an integer and you can flip exactly one bit from a 0 to a 1. 
	 * Write code to find the length of the longest sequence of ls you could create.
	 */
	public void flipToWin(String num) {
		if(!isBinaryString(num)) {
			num = Integer.toBinaryString(Integer.parseInt(num));
		}

		int binum = Integer.parseInt(num, 2);

		List<String> flippedNumList = new java.util.ArrayList<String>();
		int flipped = 0;
		int iteration = 0;
		while(iteration < num.length()){
			int check0Flipped = 0;
			for(int i = 0; i < num.length(); i++) {
				if(num.charAt(i) == '0') {
					check0Flipped++;
					if(check0Flipped > flipped) {
						flippedNumList.add(Integer.toBinaryString(updateBitOnNthPosition(binum, 1, num.length() - i - 1)));
						flipped++;
						break;
					}
				}
			}
			iteration++;
		}
				
		int highestCount = 0;
		
		for(String flippedStr : flippedNumList) {
			int counter = 0;
			for(int i = 0; i < flippedStr.length(); i++) {
				if(flippedStr.charAt(i) == '1') {
					counter++;
				} else if(flippedStr.charAt(i) == '0') {
					if(counter > highestCount) {
						highestCount = counter;
					}
					counter = 0;
				}
				if(i == flippedStr.length()-1) {
					if(counter > highestCount) {
						highestCount = counter;
					}
					counter = 0;
				}
			}
		}
		
		printMessage(highestCount);
	}
	
	/*
	 * Given a positive integer, print the next smallest and the next largest number that
	 * have the same number of 1 bits in their binary representation.
	 */
	public void nextNumber(String num) {
		if(!isBinaryString(num)) {
			num = Integer.toBinaryString(Integer.parseInt(num));
		}
		
		int binum = Integer.parseInt(num, 2);
		
		int position = -1;
		
		// Find position of 0 bit which is next to 1 bit
		for(int i = num.length()-1; i >= 0; i--) {
			if(num.charAt(i) == '0') {
				position = num.length() - i - 1;	
			} else if(position != -1 && num.charAt(i) == '1') {
				break;
			}
		}
		
		if(position == -1) {
			printMessage("Unable to find next numbers");
			return;
		}
		
		int nxtSmallNum = updateBitOnNthPosition(binum, 1, position);
		nxtSmallNum = updateBitOnNthPosition(nxtSmallNum, 0, position + 1);
		
		if(position == 0) {
			// Find position of 0 bit which is next to 1 bit
			for(int i = num.length()-2; i >= 0; i--) {
				if(num.charAt(i) == '0') {
					position = num.length() - i - 1;	
				} else if(position != 0 && num.charAt(i) == '1') {
					break;
				}
			}
		}
		int nxtLargeNum = updateBitOnNthPosition(binum, 1, position);
		nxtLargeNum = updateBitOnNthPosition(nxtLargeNum, 0, position-1);
		
		printMessage(num + " small number " + nxtSmallNum);
		printMessage(num + " large number " + nxtLargeNum);
	}

	public static void main(String args[]) {
		final BitManipulation bm = new BitManipulation();
		bm.printMessage("==== Insertion ====");
		bm.insertion("10000000000", "10011", 2, 6);
		bm.insertion("10000000000000", "10010011", 1, 8);
		bm.insertion("1000000000011", "110010011", 2, 10);

		bm.printMessage("==== Binary To String ====");
		bm.binaryToString(.625);
		bm.binaryToString(.78);

		bm.printMessage("==== Flip To Win ====");
		bm.flipToWin("11011101111");
		bm.flipToWin("0000000000000000001");
		bm.flipToWin("1010101010101010101010");
		
		bm.printMessage("==== Next Number ====");
		bm.nextNumber("203");
		bm.nextNumber("999");
		bm.nextNumber("26");
	}
}
