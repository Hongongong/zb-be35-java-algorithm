package sort.selection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSortMain2 {

    // 선택 정렬 메소드
    public static void selectionSort(int[] arr) {

        int size = arr.length;

        for(int i = 0; i < size - 1; i++) {

            System.out.println("[Round " + (i + 1) + "]");
            System.out.println("Round 시작 : " + Arrays.toString(arr));
            System.out.println();

            // 이번 라운드 최소값 index 저장하기위함
            int minIndex = i;

            // 라운드 시작 인덱스 다음 요소부터 값 비교
            for(int j = i + 1; j < size; j++) {
                // 최소값 발견하면
                if(arr[j] < arr[minIndex]) {
                    minIndex = j; // 최소값 index 변경
                }
            }

            // 이번 라운드 최소값과 자리 변경
            System.out.println("교환 : ( arr[" + i + "] = " + arr[i] + " ) <-> ( 최소값 = " + arr[minIndex] + " )");

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("교환 후 : " + Arrays.toString(arr));
            System.out.println();


            System.out.println("Round 종료 : " + Arrays.toString(arr));
            System.out.println();

        }

    }

    public static void main(String[] args) {

        int[] arr = {3, 7, 5, 4, 2, 1, 0};

        System.out.println("정렬 전 : " + Arrays.toString(arr));
        System.out.println();

        selectionSort(arr);
        System.out.println("정렬 후 : " + Arrays.toString(arr));

    }

}
