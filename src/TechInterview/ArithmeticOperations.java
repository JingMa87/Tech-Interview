package TechInterview;

public class ArithmeticOperations {
	
	/**
	 * Used for subtract and divide
	 * @param a 	the value to find the inverse of
	 * @return int	the additive inverse of the given value
	 */
	private static int inverse(int a) {
		//The inverse of 0 is 0
		if(a == 0) {
			return a;
		}
		
		int temp = a;
		int posOrNeg;
		int result = 0;
		
		//If a is positive, then the value of the additive inverse will be negative
		if(temp > 0) {
			posOrNeg = -1;
		}
		//If a is negative, then the value of the additive inverse will be positive
		else {
			posOrNeg = 1;
		}
		
		/*
		 * temp increments towards zero, starting from a
		 * result increments in the same direction, starting from zero
		 * When temp = 0, result = |a|, but with the opposite sign
		 */
		while(temp != 0) {
			result += posOrNeg;
			temp += posOrNeg;
		}
		
		return result;
	}
	
	/**
	 * Subtracts the subtrahend from the minuend
	 * @param minuend		the number to be subtracted from
	 * @param subtrahend	the number to subtract
	 * @return	int			the difference
	 */
	public static int subtract(int minuend, int subtrahend) {
		//Subtraction is essentially adding the additive inverse of the second number
		int neg = inverse(subtrahend);
		return minuend + neg;
	}
	
	/**
	 * Divides the first value by the second value
	 * @param dividend		the value to divide from
	 * @param divisor		the value to divide by
	 * @return	int			the quotient
	 * @throws IllegalArgumentException	
	 */
	public static int divide(int dividend, int divisor) throws IllegalArgumentException {
		int quotient = 0;
		int value = dividend;
		int temp = divisor;
		boolean positiveDividend = true;
		boolean positiveDivisor = false;
		
		//Cannot divide by zero
		if(temp == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		//Dividing zero by any number will equal zero
		else if(value == 0) {
			return 0;
		}
		//If the dividend is negative, set it positive and make positiveDividend false
		if(value < 0) {
			value = inverse(value);
			positiveDividend = false;
		}
		//If the divisor is positive, set it negative and make positiveDivisor true 
		if(temp > 0) {
			temp = inverse(temp);
			positiveDivisor = true;
		}
		
		/*
		 * In each iteration of the loop, value is reduced by |divisor|
		 * Also, quotient is incremented
		 * When value <= 0, quotient will be the number of times that 
		 * |divisor| can be subtracted from value 
		 */
		while(value + temp >= 0) {
			quotient++;
			value += temp;
		}
		
		/*
		 * If both of the signs of the dividend and the divisor are the same, 
		 * the quotient is positive
		 */ 
		if(positiveDividend == positiveDivisor) {
			if(quotient < 0) {
				quotient = inverse(quotient);
			}
		}
		/*
		 * If both of the signs of the dividend and the divisor are different, 
		 * the quotient is negative
		 */
		else {
			if(quotient > 0) {
				quotient = inverse(quotient);
			}
		}
		return quotient;
	}
	
	/**
	 * Multiplies the multiplicand by the multiplier
	 * @param multiplier		the number to multiply
	 * @param multiplicand		the number that gets multiplied
	 * @return	int 			the product
	 */
	public static int multiply(int multiplicand, int multiplier) {
		int product = 0;
		int value = multiplicand;
		
		//If the multiplicand is negative, set it to be positive
		if(value < 0) {
			value = inverse(value);
		}
		
		//Multiplication can be seen as repetitive addition
		for(int i = 0; i < value; i++) {
			product += multiplier;
		}
		
		/*
		 * If the signs of the multiplicand and the multiplier are the same,
		 * then the product should be positive
		 */
		if(multiplicand < 0 && multiplier < 0) {
			product = inverse(product);
		}
		/*
		 * If the signs of the multiplicand and the multiplier are different,
		 * then the product should be negative
		 */
		else if(multiplicand < 0 && multiplier > 0) {
			product = inverse(product);
		}
		return product;
	}
	
	/**
	 * Used for testing that each of the functions works.
	 * @param args
	 */
	public static void main(String[] args) {
		//Testing multiply
		System.out.print("0 * 4 = ");
		System.out.println(multiply(0, 4));
		System.out.print("4 * 0 = ");
		System.out.println(multiply(4, 0));
		System.out.print("0 * 0 = ");
		System.out.println(multiply(0, 0));
		System.out.print("2 * 5 = ");
		
		System.out.println(multiply(2, 5));
		System.out.print("7 * -9 = ");
		
		System.out.println(multiply(7, -9));
		System.out.print("-7 * 9 = ");
		System.out.println(multiply(-7, 9));
		System.out.print("-7 * -9 = ");
		System.out.println(multiply(-7, -9));
		
		//Testing divide
		System.out.print("0 / 2 = ");
		System.out.println(divide(0, 2));
		try {
			System.out.print("7 / 0 = ");
			System.out.println(divide(7, 0));
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid input.");
		}
		
		System.out.print("4 / 3 = ");
		System.out.println(divide(4, 3));
		
		System.out.print("10 / -5 = ");
		System.out.println(divide(10, -5));
		System.out.print("-10 / 5 = ");
		System.out.println(divide(-10, 5));
		System.out.print("-10 / -5 = ");
		System.out.println(divide(-10, -5));

		//Testing subtract
		System.out.print("7 - 0 = ");
		System.out.println(subtract(7, 0));
		System.out.print("0 - 7 = ");
		System.out.println(subtract(0, 7));
		System.out.print("0 - 0 = ");
		System.out.println(subtract(0, 0));
		
		System.out.print("4 - 3 = ");
		System.out.println(subtract(4, 3));
		System.out.print("2 - 5 = ");
		System.out.println(subtract(2, 5));
		
		System.out.print("6 - -5 = ");
		System.out.println(subtract(6, -5));
		System.out.print("-6 - 5 = ");
		System.out.println(subtract(-6, 5));
		System.out.print("-6 - -5 = ");
		System.out.println(subtract(-6, -5));
		
	}
}
