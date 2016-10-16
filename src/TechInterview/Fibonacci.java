package forhacktoberfest;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * Cracking the Code Interview
 * My solutions of how to generate the nth Fibonacci number.
 * Here are three different solutions to find this number
 */

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibStream(35));
        System.out.println(fib(35));
        System.out.println(iterFib(35));

    }

    // basic algorithm without cache

    public static int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);

    }

    // iterative algorithm without cache

    public static int iterFib(int n) {

        return iter(1, 0, n);

    }

    private static int iter(int a, int b, int count) {

        if (count == 0) return b;
        return iter(a + b, a, count - 1);

    }

    //  solution with stream api

    public static long fibStream(int n) {

        return LongStream.generate(new FibonacciSupplier())
                .skip(n - 1)
                .findFirst().getAsLong();

    }

    private static class FibonacciSupplier implements LongSupplier {

        private long prev = 0L;
        private long next = 1L;

        @Override
        public long getAsLong() {
            long current = next;
            next = prev + current;
            prev = current;
            return current;
        }

    }
}
