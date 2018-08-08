class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        set<vector<int>> exist;
		vector<int> item;
		vector<vector<int>> result;
        
		sort(nums.begin(), nums.end());
		result.push_back(item);
		subWithDup(0, nums, item, result,exist);
		return result;
	}

	void subWithDup(int index, vector<int> &nums, vector<int> &item, vector<vector<int>> &result, set<vector<int>> &exist){
		if (index >= nums.size()){
			return;
		}
		item.push_back(nums[index]);
		if (exist.find(item) == exist.end()){
			result.push_back(item);
			exist.insert(item);
		}
		subWithDup(index + 1, nums, item, result, exist);
		item.pop_back();
		subWithDup(index + 1, nums, item, result, exist);
	}
};
