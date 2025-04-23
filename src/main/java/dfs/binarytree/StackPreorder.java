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

public class StackPreorder {

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
        // 스택은 선입후출이므로 right 먼저 넣고 left 나중에 넣음

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Node> stack = new ArrayList<>(); // stack 처럼 사용할것임

        stack.add(root);

        while(!stack.isEmpty()) {
            Node node = stack.get(stack.size()-1);
            stack.remove(stack.size() - 1);
            result.add(node.value); // visit

            // right
            if(node.right != null) {
                stack.add(node.right);
            }
            // left
            if(node.left != null) {
                stack.add(node.left);
            }
        }

        System.out.println(result);

    }

}
