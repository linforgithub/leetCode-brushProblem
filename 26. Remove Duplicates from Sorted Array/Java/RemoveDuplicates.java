class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        if(nums.length == 2){
            if(nums[0] == nums[1]){
                return 1;
            }else{
                return 2;
            }
        }
        int low = 0;
        int high = 1;
        while (high < nums.length){
            if(nums[low] != nums[high]){
                if(high - low != 1){
                    nums[low + 1] = nums[high];
                }
                low += 1;
                high += 1;
            }else {
                high += 1;
            }
        }
        return low + 1;
    }
}
