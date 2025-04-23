package dfs.binarytree;

import java.util.*;

/*
class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
 */

public class RecursivePreorder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 트리 노드 총 개수

        // 리스트에 노드 값들 넣기만함
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            nodes.add(new Node(i));
        }

        // 트리 구성

        Node root = nodes.get(0); // 최상단 노드 설정
        // 각 노드에 자식 노드 붙이기
        // (N-1) / 2 - 자식이 있는 노드의 수
        for(int current = 0; current <= (N-1) / 2; current++) {

            int left = 2 * current + 1;
            int right = 2 * current + 2;

            if(left < N) {
                nodes.get(current).left = nodes.get(left);
            }

            if(right < N) {
                nodes.get(current).right = nodes.get(right);
            }

        }

        // 트리 전위 순회

        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result); // 전위 순회 결과를 result에 담아옴

        System.out.println(result);

    }

    // 전위 순회 함수
    public static void preOrder(Node node, List<Integer> result) {

        // VLR
        if(node != null) {
            result.add(node.value); // visit
            preOrder(node.left, result); // left
            preOrder(node.right, result); // right
        }

    }

}
