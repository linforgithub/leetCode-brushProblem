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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode tmp_Head(0);
        ListNode* result = &tmp_Head;
        int needAddNum = 0;
        while (l1 || l2 || needAddNum)
        {
            int num1 = l1 ? l1->val : 0;
            int num2 = l2 ? l2->val : 0;
            int num = num1  + num2 + needAddNum;
            needAddNum = num > 9 ? 1 : 0;
            result->next = new ListNode(num % 10);
            result = result->next;
            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;
        }
        return tmp_Head.next;
    }
};
