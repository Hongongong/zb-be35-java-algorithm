package recursive;

public class hanoi {

    public static void hanoi(int n, char from, char to, char temp) {

        System.out.println("[함수 시작] n : " + n + ", from : " + from + ", to : "+ to + ", temp : " + temp);

        if(n == 1) {
            System.out.println("원반 " + n + "을 " + from + "에서 " + to + "로 이동");
            return;
        }

        hanoi(n-1, from, temp, to);

        System.out.println("[함수 중간] n : " + n + ", from : " + from + ", to : "+ to + ", temp : " + temp);
        System.out.println("원반 " + n + "을 " + from + "에서 " + to + "로 이동");

        hanoi(n-1, temp, to, from);

    }

    public static void main(String[] args) {

        hanoi(3, 'A', 'C', 'B');

    }

}
