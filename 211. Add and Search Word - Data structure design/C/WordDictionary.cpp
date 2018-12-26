#include<vector>
#include<algorithm>
#include<sstream>
#include<set>
#include<string>
#include<map>
#define TRIE_MAX_CHAR_NUM 26
using namespace std;


struct TrieNode
{
	TrieNode *child[TRIE_MAX_CHAR_NUM];
	bool is_end;
	TrieNode() : is_end(false){
		for (int i = 0; i < TRIE_MAX_CHAR_NUM; i++)
		{
			child[i] = 0;
		}
	}
};

class WordDictionary {
public:
	/** Initialize your data structure here. */
	WordDictionary() {

	}
	~WordDictionary(){
		for (int i = 0; i < node_vec.size(); i++)
		{
			delete node_vec[i];
		}
	}

	/** Adds a word into the data structure. */
	void addWord(string word) {
		TrieNode *ptr = &_root;
		for (int i = 0; i < word.length(); i++)
		{
			int pos = word[i] - 'a';
			if (!ptr->child[pos])
			{
				ptr->child[pos] = newNode();
			}
			ptr = ptr->child[pos];
		}
		ptr->is_end = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	bool search(string word) {
		return search_trie(&_root, word.c_str());
	}

	bool search_trie(TrieNode * node, const char *word){
		if (*word == '\0'){
			return node->is_end;
		}
		if (*word == '.')
		{
			for (int i = 0; i < TRIE_MAX_CHAR_NUM; i++){
				if (node->child[i] && search_trie(node->child[i], word + 1))
				{
					return true;
				}
			}
		}
		else
		{
			int pos = *word - 'a';
			if (node->child[pos] && search_trie(node->child[pos], word + 1))
			{
				return true;
			}
		}
		return false;
	}
private:
	TrieNode* newNode(){
		TrieNode *node = new TrieNode();
		node_vec.push_back(node);
		return node;
	}
	vector<TrieNode*> node_vec;
	TrieNode _root;
};

/**
* Your WordDictionary object will be instantiated and called as such:
* WordDictionary obj = new WordDictionary();
* obj.addWord(word);
* bool param_2 = obj.search(word);
*/
