struct BSTNode {
	int val;
	int leftNum;
	BSTNode *left;
	BSTNode *right;
	BSTNode(int x) : val(x), leftNum(0), left(NULL), right(NULL) {}
};
class Solution {
public:
    void BST_insert(BSTNode *node, BSTNode *insert_node, int &count){
		if (insert_node->val <= node->val){
			node->leftNum++;
			if (node->left){
				BST_insert(node->left, insert_node, count);
			}
			else{
				node->left = insert_node;
			}
		}
		else{
			count += node->leftNum + 1;
			if (node->right){
				BST_insert(node->right, insert_node, count);
			}
			else{
				node->right = insert_node;
			}
		}
	}

	vector<int> countSmaller(vector<int>& nums) {
		vector<int> result;
		if (nums.size() == 0){
			return result;
		}
		BSTNode firstNode(nums[nums.size() - 1]);
		for (int i = 0; i < nums.size(); i++)
		{
			result.push_back(0);
		}
		for (int i = nums.size() - 2; i >= 0; i--){
			int count = 0;
			BST_insert(&firstNode, new BSTNode(nums[i]), count);
			result[i] = count;
		}
		return result;
	}
};
