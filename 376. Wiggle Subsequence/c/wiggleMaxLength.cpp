class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        if (nums.size() < 2){
			return nums.size();
		}
        int index = 1;
		int result = 1;
		
		int status = 0;

		while (index < nums.size())
		{
			switch (status)
			{
			case 0:
				if (nums[index] > nums[index - 1]){
					status = 1;
                    result = 2;
				}
				else if (nums[index] < nums[index - 1])
				{
					status = 2;
                    result = 2;
				}
				break;
			case 1:
				if (nums[index] < nums[index - 1]){
					status = 2;
					result++;
				}
				break;
			case 2:
				if (nums[index] > nums[index - 1]){
					status = 1;
					result++;
				}
				break;
			}
			index++;
		}
        return result;
    }
};
