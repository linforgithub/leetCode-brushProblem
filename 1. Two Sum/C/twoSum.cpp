class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> hasNums;
        vector<int> result;
        for (int i = 0; i<nums.size(); i++){
            int thisNum = nums.at(i);
            int less = target - thisNum;
            vector<int>::iterator ret;
            ret = std::find(hasNums.begin(), hasNums.end(), less);
            if (ret != hasNums.end()){
                int index = distance(hasNums.begin(), ret);
                result.push_back(index);
                result.push_back(i);
            }
            else
            {
                hasNums.push_back(thisNum);
            }
        }
        return result;
    }
};
