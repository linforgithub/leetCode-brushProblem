class Solution {
public:
    string removeKdigits(string num, int k) {
        if (k >= num.length()){
			return "0";
		}
		vector<int> nums;
		string result = "";
		for (int i = 0; i < num.length(); i++){
			int number = num[i] - '0';
			while (nums.size() != 0 && nums[nums.size() - 1] > number && k > 0){
				nums.pop_back();
				k--;
			}
			if (number != 0 || nums.size() != 0){
				nums.push_back(number);
			}
		}
		while (nums.size() != 0 && k > 0)
		{
			nums.pop_back();
			k--;
		}
		for (int i = 0; i < nums.size(); i++){
			result.append(1, '0' + nums[i]);
		}
		if (result == ""){
			result = "0";
		}
		return result;
    }
};
