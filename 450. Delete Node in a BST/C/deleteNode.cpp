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
    void deleteNode(TreeNode* parent, TreeNode* node) {
		if (node->val < parent->val){
			if (node->left && !node->right)
			{
				parent->left = node->left;
			}
			else if (!node->left && node->right)
			{
				parent->left = node->right;
			}
			else
			{
				parent->left = NULL;
			}
		}
		else if (node->val > parent->val)
		{
			if (node->left && !node->right)
			{
				parent->right = node->left;
			}
			else if (!node->left && node->right)
			{
				parent->right = node->right;
			}
			else
			{
				parent->right = NULL;
			}
		}
	}
	TreeNode* BST_search(TreeNode* node, int key, TreeNode* &parent) {
		while (node)
		{
			if (node->val == key){
				break;
			}
			parent = node;
			if (key < node->val)
			{
				node = node->left;
			}
			else{
				node = node->right;
			}
		}
		return node;
	}

	TreeNode* find_successor(TreeNode* node, TreeNode*&parent){
		parent = node;
		TreeNode *ptr = node->right;
		while (ptr->left)
		{
			parent = ptr;
			ptr = ptr->left;
		}
		return ptr;
	}

	TreeNode* deleteNode(TreeNode* root, int key) {
		TreeNode* parent = NULL;
		TreeNode* node = BST_search(root, key, parent);
		if (!node){
			return root;
		}
		if (node->left && node->right){
			TreeNode* successor = find_successor(node, parent);
			deleteNode(parent, successor);
			node->val = successor->val;
			return root;
		}
		if (parent){
			deleteNode(parent, node);
			return root;
		}
		if (node->left){
			root = node->left;
		}
		else
		{
			root = node->right;
		}
		return root;
	}
};
