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
    void travel_tree(TreeNode* node, int &sum){
		if (!node)
		{
			return;
		}
		travel_tree(node->right, sum);
		sum += node->val;
		node->val = sum;
		travel_tree(node->left, sum);
	}
	TreeNode* convertBST(TreeNode* root) {
		int sum = 0;
		travel_tree(root, sum);
		return root;
	}
};
