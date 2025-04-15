package greedy;

import java.io.*;

public class CoinChangeGreedy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int amount = Integer.parseInt(br.readLine());

        int[] coins = {500, 100, 50, 10};
        int count = 0;

        // 동전 500원 부터 한개씩 돌면서 몫 구해서 count에 더하고 amount 나머지 값으로 설정
        for(int coin : coins) {
            count += amount / coin;
            amount = amount % coin;
        }

        System.out.println(count);

    }

}
