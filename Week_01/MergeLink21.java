public class MergeLink21 {


    public static void main(String... argv) {
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode root = new MergeLink21().mergeTwoLists(l1, l2);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    /**
     * 与归并排序的写法一致
     * 时间复杂度O(n + m)，空间复杂度O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode move = new ListNode(-1);
        ListNode head = move;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }
        if (l1 != null) {
            move.next = l1;
        } else if (l2 != null) {
            move.next = l2;
        }
        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
