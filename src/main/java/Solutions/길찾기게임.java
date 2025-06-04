package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길찾기게임 {
    public static class Node {
        int x; int y; int num;
        Node left; Node right;
        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static Node makeBT(int[][] nodeInfo) {

        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i++) {
            nodes[i] = new Node(nodeInfo[i][0], nodeInfo[i][1], i + 1);
        }
        Arrays.sort(nodes, (a, b) -> {
            if(a.y == b.y){
                return Integer.compare(a.x, b.x);
            }
            return b.y - a.y;
        });

        Node root = nodes[0];
        for(int i = 1 ; i < nodes.length; i++){
            Node parent = root;
            while(true){
                if(nodes[i].x < parent.x){
                    if(parent.left == null){
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if(parent.right == null){
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        return nodes[0];
    }

    private static void preOrder(Node curr, List<Integer> answer){
        if(curr == null){
            return;
        }
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    private static void postOrder(Node curr, List<Integer> answer){
        if(curr == null){
            return;
        }
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public static void main(String[] args) {
        int[][] nodeInfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        Node root = makeBT(nodeInfo);
        System.out.println(root.num + " " + root.x + " " + root.y + " " + root.left + " " + root.right);
        List<Integer> preOrder = new ArrayList<>();
        preOrder(root, preOrder);
        List<Integer> postOrder = new ArrayList<>();
        postOrder(root, postOrder);
        int[][] answer = new int[2][nodeInfo.length];
        answer[0] = preOrder.stream().mapToInt(i -> i).toArray();
        answer[1] = postOrder.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.deepToString(answer));
    }
}
