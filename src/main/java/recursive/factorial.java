package recursive;

public class factorial {

    // 팩토리얼(재귀함수)
    public static int factorialRecursice(int n) {

        if(n == 1) return 1;

        return n * factorialRecursice(n - 1);

    }

    // 팩토리얼(반복문)
    public static int factorialFor(int n) {

        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(factorialFor(5));
        System.out.println(factorialRecursice(5));
    }

}
