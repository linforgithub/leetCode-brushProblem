class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
		vector<vector<int>> result;
		int all_set = 1 << nums.size();
		for (int i = 0; i < all_set; i++){
			vector<int> item;
			for (int j = 0; j < nums.size(); j++){
				if (i & (1 << j)){
					item.push_back(nums[j]);
				}
			}
			result.push_back(item);
		}
		return result;
	}
};
