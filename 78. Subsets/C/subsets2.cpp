class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> item;
		vector<vector<int>> result;
		result.push_back(item);
		sub(0, nums, item, result);
		return result;
	}

	void sub(int index, vector<int> &nums, vector<int> &item, vector<vector<int>> &result){
		if (index >= nums.size()){
			return;
		}
		item.push_back(nums[index]);
		result.push_back(item);
		sub(index + 1, nums, item, result);
		item.pop_back();
		sub(index + 1, nums, item, result);
	}
};
