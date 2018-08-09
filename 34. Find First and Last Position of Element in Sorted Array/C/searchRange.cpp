class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int index = -1;
		int begin = 0;
		int end = nums.size() - 1;
		while (index == -1 && begin <= end)
		{
			int mid = (begin + end) / 2;
			if (target == nums[mid]){
				index = mid;
			}
			else if (target < nums[mid]){
				end = mid - 1;
			}
			else if (target > nums[mid])
			{
				begin = mid + 1;
			}
		}
		int left = index;
		int right = index;
		while (index != -1)
		{
			if (left > 0 && nums[left - 1] == target){
				left--;
			}
			else{
				break;
			}
		}
		while (index != -1)
		{
			if (right + 1 < nums.size() && nums[right + 1] == target){
				right++;
			}
			else{
				break;
			}
		}
		vector<int> result;
		result.push_back(left);
		result.push_back(right);
		return result;
    }
};
