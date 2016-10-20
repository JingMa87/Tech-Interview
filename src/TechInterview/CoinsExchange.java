package TechInterview;

public class CoinsExchange {

    /**
     * Given an in infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
     * write code to calculate the number of ways of representing n cents.
     */

    static int changeCoins(int n) {
        return changeCoinsWithCount(n, 4);
    }

    static int changeCoinsWithCount(int amount, int countOfcoins) {

        if (amount == 0)
            return 1;
        if (amount < 0 || countOfcoins == 0)
            return 0;
        else
            return changeCoinsWithCount(amount, countOfcoins - 1) + changeCoinsWithCount(amount - firstDenomination(countOfcoins), countOfcoins);
    }

    static int firstDenomination(int countOfCoins) {
        switch (countOfCoins) {
            case 1:
                return 1;
            case 2:
                return 5;
            case 3:
                return 10;
            case 4:
                return 25;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

        System.out.println(changeCoins(100));

    }
}