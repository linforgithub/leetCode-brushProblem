/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        head = swapNode(head, k, new Stack<ListNode>());
        return head;
    }

    private ListNode swapNode(ListNode node, int n, Stack<ListNode> stack){
        if(node == null || n == 0) {
            return node;
        }
        ListNode tmp = node;
        int index = n;
        while (index > 0 && temp != null){
            index--;
            stack.push(tmp);
            tmp = tmp.next;
        }
        ListNode newNode;
        if(index == 0){
            node = stack.pop();
            node.next = tmp;
            newNode = node;
            while (stack.size() > 0){
                newNode.next = stack.pop();
                newNode = newNode.next;
                newNode.next = tmp;
            }
            tmp = swapNode(tmp, n, stack);
            newNode.next = tmp;
        }
        return node;
    }
}
