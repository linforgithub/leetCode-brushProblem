class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() < 2){
			return 0;
		}
		int index = 1;
		int maxIndex = nums[0];
		int jumMaxIndex = nums[0];
		int jump = 1;
		while (index < nums.size() && jumMaxIndex < nums.size())
		{
			if (index > jumMaxIndex){
				jump++;
				jumMaxIndex = maxIndex;
			}
			if (maxIndex < index + nums[index]){
				maxIndex = index + nums[index];
			}
			if (jumMaxIndex >= nums.size() - 1){
				return jump;
			}
			index++;
		}
		return jump;
    }
};
