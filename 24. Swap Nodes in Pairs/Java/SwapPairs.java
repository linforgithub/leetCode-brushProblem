/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        head = swapTwoNode(head);
        return head;
    }

    private ListNode swapTwoNode(ListNode node){
        if(node == null || node.next == null) {
            return node;
        }
        ListNode  tmp = node.next;
        node.next = tmp.next;
        tmp.next = node;
        if (node.next != null){
            node.next = swapTwoNode(node.next);
        }
        return tmp;
    }
}
