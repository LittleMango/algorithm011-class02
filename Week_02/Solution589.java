import java.util.ArrayList;
import java.util.List;

public class Solution589 {

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
        System.out.println(new Solution589().preorder(n1));
    }

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    preorder(node, list);
                }
            }
        }
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
