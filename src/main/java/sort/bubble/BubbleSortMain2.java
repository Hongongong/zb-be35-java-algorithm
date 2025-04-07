package sort.bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSortMain2 {

    // 버블 정렬 메소드
    private static void bubbleSort(int[] arr) {

        int size = arr.length;
        boolean swapped; // 정렬 끝난지 확인하기 위한 변수

        for(int i = 0; i < size; i++) {

            System.out.println("[Round " + (i + 1) + "]");
            System.out.println("Round 시작 : " + Arrays.toString(arr));

            swapped = false; // 교환시 true 되게

            int roundCount = 0;

            // 한 패스마다 비교 횟수 1씩 줄음
            for(int j = 0; j < size - 1 - i; j++) {

                // arr[j]가 arr[j+1]보다 크면
                if(arr[j] > arr[j + 1]) {

                    System.out.println("교환 " + ++roundCount + " 번째 : " + arr[j] + " <-> " + arr[j+1]);

                    // 자리 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // 한번이라도 교환 했으면 true

                    System.out.println("교환 후 : " + Arrays.toString(arr));
                    System.out.println();

                }

            }

            // 이미 정렬 완성되있는 경우
            if(!swapped) break; // 더이상 정렬하지 않고 종료 (버블 정렬 조금이라도 짧게 수행하기위함)

            System.out.println("Round 종료 : " + Arrays.toString(arr));
            System.out.println();

        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 7, 5, 4, 2, 1, 0};

        System.out.println("정렬 전 : " + Arrays.toString(arr));
        System.out.println();

        bubbleSort(arr);
        System.out.println();
        System.out.println("정렬 후 : " + Arrays.toString(arr));

    }

}
