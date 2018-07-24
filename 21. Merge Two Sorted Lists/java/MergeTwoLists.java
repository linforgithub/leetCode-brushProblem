/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
			return null;
		}
        ListNode tmpHead = new ListNode(0);
        ListNode result = new ListNode(0);
        tmpHead.next = result;
        while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		result.val = l1.val;
        		l1 = l1.next;
        		result.next = new ListNode(0);
        		result = result.next;
        	}else{
        		result.val = l2.val;
        		l2 = l2.next;
        		result.next = new ListNode(0);
        		result = result.next;
        	}
        }
        if(l1 != null){
        	result.val = l1.val;
        	result.next = l1.next;
        }else{
        	result.val = l2.val;
        	result.next = l2.next;
        }
        
        return tmpHead.next;
    }
}
