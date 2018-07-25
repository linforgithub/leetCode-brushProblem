class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int tmp = result;
		while(left < right){
			tmp = (right - left) * (height[left] > height[right] ? height[right] : height[left]);
			result = result > tmp ? result : tmp;
			if(height[left] > height[right]){
				right--;
			}else{
				left++;
			}
		}
		
		return result;
    }
}
