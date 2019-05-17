class Solution {
    public int firstMissingPositive(int[] nums) {
        int tmp = 0;
        for(int i = 0;i < nums.length;i++){
            tmp = nums[i];
            while(tmp != i + 1 && tmp < nums.length + 1 && tmp > 0){
                tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
                if(nums[i] == tmp){
                    break;
                }
                tmp = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
