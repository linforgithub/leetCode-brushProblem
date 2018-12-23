/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& nums, int begin, int end){
		if (begin > end){
			return NULL;
		}
		//根节点
		int mid = (begin + end) / 2;
		TreeNode* midNode = new TreeNode((nums[mid]));
		midNode -> left = buildTree(nums, begin, mid - 1);
		midNode -> right = buildTree(nums, mid + 1, end);
		return midNode;
	}
	TreeNode* sortedArrayToBST(vector<int>& nums) {
		if (nums.size() == 0){
			return NULL;
		}
		return buildTree(nums, 0, nums.size() - 1);
	}
};
