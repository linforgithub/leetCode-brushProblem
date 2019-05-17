class Solution {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int result = 0;
        int leftHeight = height[0];
        int tmp = 0;
        int nextHeight = 0;
        int nextHeightIndex = 0;
        for(int i = 0;i < height.length;i++){
            leftHeight = height[i];
            tmp = 0;
            nextHeight = 0;
            nextHeightIndex = i;
            if(leftHeight != 0){
                for(int j = i + 1;j < height.length;j++){
                    if(height[j] > nextHeight){
                        nextHeight = height[j];
                        nextHeightIndex = j;
                    }
                    if(leftHeight <= height[j]){
                        break;
                    }
                }
                leftHeight = nextHeight > leftHeight ? leftHeight : nextHeight;
                for(int j = i + 1;j < nextHeightIndex;j++) {
                    result += leftHeight - height[j];
                }
                if(nextHeightIndex != i){
                    i = nextHeightIndex - 1;
                }
            }
        }
        return result;
    }
}
