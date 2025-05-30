package Solutions;

import java.util.Arrays;

public class 이진트리탐색_전위_중위_후위 {
    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5,6,7};
        String[] result = new String[3];
        result[0] = preOrder(nodes, 0).trim();
        result[1] = inOrder(nodes, 0).trim();
        result[2] = postOrder(nodes, 0).trim();
        System.out.println(Arrays.toString(result));
    }

    public static String preOrder(int[] nodes, int index){
        if(index >= nodes.length) return "";
        return nodes[index] + " " + preOrder(nodes, 2 * index + 1) + preOrder(nodes, 2 * index + 2);
    }

    public static String inOrder(int[] nodes, int index){
        if(index >= nodes.length) return "";
        return inOrder(nodes, 2 * index + 1) + nodes[index] + " " + inOrder(nodes, 2 * index + 2);
    }

    public static String postOrder(int[] nodes, int index){
        if(index >= nodes.length) return "";
        return postOrder(nodes, 2 * index + 1) + postOrder(nodes, 2 * index + 2) + nodes[index] + " ";
    }
}
