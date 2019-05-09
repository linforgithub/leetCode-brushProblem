class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        // 先排序
        Arrays.sort(nums);
        // 双重循环，固定两个数
        int l ,r;
        List<Integer> group;
        Set<List<Integer>> set = new HashSet<>();
        int temp;
        for(int i = 0; i < nums.length - 3;i++){
            for(int j = i + 1;j < nums.length - 2;j++){
                l = j + 1;
                r = nums.length - 1;
                while (l < r){
                    temp = nums[i] + nums[j] + nums[l] + nums[r];
                    if(temp == target) {
                        group = new ArrayList<>();
                        group.add(nums[i]);
                        group.add(nums[j]);
                        group.add(nums[l]);
                        group.add(nums[r]);
                        set.add(group);
                        l++;
                        r--;
                    }else if(temp > target){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }
        result.addAll(set);
        return result;
    }
}
