class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums[0] == 0 && nums.size() > 1){
			return false;
		}
		if (nums.size() == 1){
			return true;
		}
		int index = 2;
		int maxIndex = nums[0] + 1;
		while (index < nums.size() && maxIndex < nums.size())
		{
			if (maxIndex < index + nums[index - 1]){
				maxIndex = index + nums[index - 1];
			}
            if (maxIndex == index + nums[index - 1] && nums[index - 1] == 0){
				return false;
			}
			index++;
		}
		if (maxIndex >= nums.size()){
			return true;
		}
        return false;
    }
};
