package TechInterview;

public class Test {

    public static int stringToInt(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int value = 0;
        for (int i = 0; i < len; i++) {
            int sq = 1;
            for (int j = 0; j < len - 1 - i; j++)
                sq = sq * 10;
            value += (arr[i] - '0') * sq;
        }
        return value;
    }

    public static void main(String[] args) {
        String s = "092842";
        System.out.println(stringToInt(s));
    }
}