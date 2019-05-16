class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return ;
        }
        int lastIndex = nums.length - 1;
        int last = nums[lastIndex];
        int less = last - nums[nums.length - 2];
        int tmp = last;
        if(less > 0){
            nums[nums.length - 1] = nums[nums.length - 2];
            nums[nums.length - 2] = last;
            return;
        }
        int changeIndex = -1;
        for(int i = nums.length - 3;i >= 0;i--){
            if(last - nums[i] > less){
                changeIndex = i;
                break;
            }
            last = nums[--lastIndex];
            less = last - nums[i];
        }
        if(changeIndex == -1){
            Arrays.sort(nums);
            return;
        }

        List<Integer> tmpList = new ArrayList<>();
        boolean change = true;
        for(int i = nums.length - 1; i > changeIndex;i--){
            tmp = nums[i];
            if (change && tmp > nums[changeIndex]){
                nums[i] = nums[changeIndex];
                nums[changeIndex] = tmp;
                tmpList.add(nums[i]);
                change = false;
                continue;
            }
            tmpList.add(tmp);
        }
        Collections.sort(tmpList);
        int begin = changeIndex + 1;
        for(int i = 0; i < tmpList.size();i++){
            nums[begin + i] = tmpList.get(i);
        }
    }
}
