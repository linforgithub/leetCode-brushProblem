class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < nums.length - 2;i++){
        	int left = i + 1;
        	int right = nums.length - 1;
        	while(left < right){
        		int sum = nums[i] + nums[left] + nums[right];
        		if(sum == 0){
        			List<Integer> list = new ArrayList<>();
        			list.add(nums[i]);
        			list.add(nums[left]);
        			list.add(nums[right]);
                    result.add(list);
        			while(left < right && nums[left] == nums[left+1]){
        				left++;
        			}
        			while(left < right && nums[right] == nums[right-1]){
        				right--;
        			}
        			left++;
        			right--;
        		}else if(sum < 0){
        			left++;
        		}else{
        			right--;
        		}
        	}
            
        	while(i < nums.length - 1 && nums[i] == nums[i + 1]){
        		i++;
        	}
        }
        return result;
    }
}
