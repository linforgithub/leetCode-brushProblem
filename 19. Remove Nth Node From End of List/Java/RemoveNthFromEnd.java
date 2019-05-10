/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int index = 0;
        ListNode nowParent = head;
        ListNode tmp = head.next;
        while(tmp != null){
            if(index >= n){
                nowParent = nowParent.next;
            }
            index++;
            tmp = tmp.next;
        }
        if(nowParent != null && index >= n){
            nowParent.next = nowParent.next.next;
        }else if(index == n - 1){
            return head.next;
        }
        return head;
    }
}
