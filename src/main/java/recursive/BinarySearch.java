package recursive;



public class BinarySearch {

    public static int binarySearchFor(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;

    }

    public static int binarySearchRecursive(int[]arr, int target, int left, int right) {

        // 종료 조건
        if(left > right) {
            return -1; // 반환
        }

        int mid = (right + left) / 2;

        if(arr[mid] == target) {
            return mid; // target 값 찾으면 인덱스 반환
        } // target 찾아야만 재귀함수 끝남
        else if(arr[mid] > target) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
        else {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }

    }

    public static void main(String[] args){

        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 9;

        // 단순 반복문(while문) 사용
        System.out.println(binarySearchFor(arr, target));
        // 재귀 함수 사용
        System.out.println(binarySearchRecursive(arr, target, 0, arr.length - 1));

    }

}
