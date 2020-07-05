import java.util.*;

public class Solution429 {

    public static void main(String[] args) {
        Node n5 = new Node(5, null);
        Node n6 = new Node(6, null);
        ArrayList<Node> l3 = new ArrayList<>();
        l3.add(n5);
        l3.add(n6);
        Node n3 = new Node(3, l3);
        Node n2 = new Node(2, null);
        Node n4 = new Node(4, null);

        ArrayList<Node> l1 = new ArrayList<>();
        l1.add(n3);
        l1.add(n2);
        l1.add(n4);
        Node n1 = new Node(1, l1);
        System.out.println(new Solution429().levelOrder(n1));
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> listOut = new ArrayList<>();
        if (root == null) {
            return listOut;
        }
        Queue<Node> queue = new LinkedList<>();
        List<Node> tempList = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    tempList.addAll(node.children);
                }
            }
            listOut.add(list);
            queue.addAll(tempList);
            tempList.clear();
        }
        return listOut;
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
