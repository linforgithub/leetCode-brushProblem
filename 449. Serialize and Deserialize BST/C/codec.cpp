/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    void BST_preorder(TreeNode *node, std::string &data){
		if (!node){
			return;
		}
		stringstream ss;
		ss << node->val;
		string tmp;
		ss >> tmp;
		data += tmp;
		data += '#';
		BST_preorder(node->left, data);
		BST_preorder(node->right, data);
	}

	// Encodes a tree to a single string.
	string serialize(TreeNode* root) {
		string result;
		BST_preorder(root, result);
		return result;
	}

	void BST_insert(TreeNode *node, TreeNode *insert_node){
		if (insert_node->val < node->val){
			if (node->left){
				BST_insert(node->left, insert_node);
			}
			else{
				node->left = insert_node;
			}
		}
		else{
			if (node->right){
				BST_insert(node->right, insert_node);
			}
			else{
				node->right = insert_node;
			}
		}
	}

	// Decodes your encoded data to tree.
	TreeNode* deserialize(string data) {
		if (data.length() == 0)
		{
			return NULL;
		}

		std::vector<TreeNode *> node_vec;
		string tmp;
		for (int i = 0; i < data.length(); i++){
			if (data[i] == '#')
			{
				stringstream ss;
				ss << tmp;
		        int val;
                ss >> val;
				node_vec.push_back(new TreeNode(val));
				tmp = "";
				continue;
			}
			tmp += data[i];
		}
		for (int i = 1; i < node_vec.size(); i++){
			BST_insert(node_vec[0], node_vec[i]);
		}
		return node_vec[0];
	}
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));
