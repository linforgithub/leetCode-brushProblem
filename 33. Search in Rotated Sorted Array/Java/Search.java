class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 ||
                (target < nums[0] && target > nums[nums.length - 1])){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                if((nums[mid] > nums[low] && target >= nums[low]) ||
                        nums[mid] < nums[low]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] >= nums[low] ||
                        (nums[mid] < nums[low] && target <= nums[high])){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
