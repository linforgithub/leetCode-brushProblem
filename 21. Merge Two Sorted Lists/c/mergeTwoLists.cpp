/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1 == NULL && l2 == NULL){
            return NULL;
        }
        ListNode first = ListNode(0);
        ListNode* result = &first;
        while (l1 && l2)
        {
            ListNode* thisNode = NULL;
            if (l1->val > l2->val){
                thisNode = l2;
                l2 = l2->next;
            }else {
                thisNode = l1;
                l1 = l1->next;
            }
            result->next = thisNode;
            result = thisNode;
        }
        if (l1){
            result->next = l1;
        }else{
            result->next = l2;
        }
        return first.next;
    }
};
