/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
        	return null;
        }
        if(lists.length == 1){
        	return lists[0];
        }
        ListNode result = mergeList(lists,0,lists.length - 1);
        return result;
    }
    
    public ListNode mergeList(ListNode[] lists, int left, int right){
		int mid = (left + right) / 2;
		if(left < right){
			ListNode l1 = mergeList(lists, left, mid);
			ListNode l2 = mergeList(lists, mid + 1, right);
			return mergeTwoLists(l1, l2);
		}
		return lists[left];
	}
    
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
