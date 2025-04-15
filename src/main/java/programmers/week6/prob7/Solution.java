package programmers.week6.prob7;


public class Solution {

    public static int solution(int n) {

        // 이중 for문으로 풀이
        // return solutionFor(n);

        // 재귀함수로 풀이
        return solutionRecursive(n,1 ,0);

    }

    // 이중 for문 풀이
    public static int solutionFor(int n) {

        int count = 0;
        for(int i = n; i >= 1; i--) {

            int sum = i;
            if(sum == n) count++;

            for(int j = i - 1; j >= 1; j--) {
                sum += j;
                if(sum == n) {
                    count++;
                    break;
                }
            }
        }

        return count;

    }

    // 재귀함수 풀이
    /*
     *이 함수의 기본 아이디어:
     * 1. 만약 누적합(sum)이 target과 정확히 같다면, 1가지 경우를 찾은 것이므로 1을 반환합니다.
     * 2. 만약 누적합(sum)이 target을 초과하면, 그 경로는 실패이므로 0을 반환합니다.
     * 3. 만약 현재 수(current)가 target보다 커지면 더 이상 더해도 target에 도달할 수 없으므로 0을 반환합니다.
     * 4. 그렇지 않다면, 현재 수를 포함하는 경우와 포함하지 않는 경우로 나눠서 경우의 수를 재귀적으로 구합니다.
     */
    public static int solutionRecursive(int target, int current, int sum) {

        System.out.println();
        System.out.println("[함수 시작]");
        System.out.println("target : " + target + ", current : " + current + ", sum : " + sum);

        // 기저조건 1: 누적합이 target과 정확히 일치하면, 유효한 경우 1가지
        if(sum == target) {
            System.out.println("[기저 조건 false 함수 종료] : sum == target");
            System.out.println("target : " + target + ", current : " + current + ", sum : " + sum);
            System.out.println();
            return 1;
        }
        // 기저조건 2: 누적합이 target을 초과하면, 이 경로는 실패 → 0 반환
        if(sum > target) {
            System.out.println("[기저 조건 false 함수 종료] : sum > target");
            System.out.println("target : " + target + ", current : " + current + ", sum : " + sum);
            System.out.println();
            return 0;
        }
        // // 기저조건 3: 현재 수(current)가 target보다 크면, 더 이상 탐색할 필요가 없음 → 0 반환
        if(current > target) {
            System.out.println("[기저 조건 false 함수 종료] : current > target ");
            System.out.println("target : " + target + ", current : " + current + ", sum : " + sum);
            System.out.println();
            return 0;
        }

        // 총 경우의 수
        int count = 0;

        System.out.println("[재귀 전 경우의 수] return count = " + count);

        // 시작점을 다양하게 하기 위한 선택:
        // 아직 아무 숫자도 누적하지 않은 경우(sum이 0)에는
        // 현재 수를 건너뛰고 다음 숫자부터 시작하는 경우를 고려합니다.
        if(sum == 0) {
            count += solutionRecursive(target, current + 1, 0);
        }

        // 현재 수(current)를 누적합에 포함하고, 다음 숫자부터 연속해서 더하는 경우를 계산합니다.
        count += solutionRecursive(target, current + 1, sum + current);

        System.out.println("[정상 함수 종료] return count = " + count);
        System.out.println("target : " + target + ", current : " + current + ", sum : " + sum);
        System.out.println();

        return count;

    }

    public static void main(String[] args) {

        System.out.println(solution(15));
    }
}