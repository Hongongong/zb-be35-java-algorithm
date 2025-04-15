package recursive;

public class Fibonacci {

    public static int fibonacciFor(int n) {

        // 바로 종료
        if(n <= 1) return n;

        int prev = 0, current = 1;

        for(int i = 2; i <= n; i++) {
            int next = prev + current; // next = 1 2 3 5
            prev = current; // prev = 1 1 2 3
            current = next; //  current = 1 2 3 5
        }

        return current;

    }

    public static int fibonacciRecursive(int n) {

        // 종료 조건
        if(n <= 1) return n;

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);

    }

    public static void main(String[] args) {
        System.out.println(fibonacciFor(5));
        System.out.println(fibonacciRecursive(5));
    }

}
