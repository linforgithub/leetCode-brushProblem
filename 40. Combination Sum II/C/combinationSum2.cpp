class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
     sort(candidates.begin(), candidates.end());
		set<vector<int>> exist;
		vector<int> item;
		vector<vector<int>> result;
		subWithDup(0, candidates, item, result, exist, 0, target);
		return result;
	}

	void subWithDup(int index, vector<int> &nums, vector<int> &item, vector<vector<int>> &result, set<vector<int>> &exist,int nowNum, int target){
		if (index >= nums.size()){
			return;
		}
		item.push_back(nums[index]);
		nowNum += nums[index];
		if (nowNum == target){
			if (exist.find(item) == exist.end()){
				result.push_back(item);
				exist.insert(item);
			}
		}
		else if (nowNum > target)
		{
			item.pop_back();
			nowNum -= nums[index];
			return;
		}
		subWithDup(index + 1, nums, item, result, exist, nowNum, target);
		item.pop_back();
		nowNum -= nums[index];
		subWithDup(index + 1, nums, item, result, exist, nowNum, target);
	}
};
