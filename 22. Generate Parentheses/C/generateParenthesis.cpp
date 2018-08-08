class Solution {
public:
    vector<string> generateParenthesis(int n) {
     vector<string> result;
		generate("", n, n, result);
		return result;
	}

	void generate(string s, int left, int right, vector<string> &result){
		if (left == 0 && right == 0){
			result.push_back(s);
			return;
		}
		if (left > 0){
			generate(s + "(", left - 1, right, result);
		}
		if (left < right){
			generate(s + ")", left, right - 1, result);
		}
	}
};
