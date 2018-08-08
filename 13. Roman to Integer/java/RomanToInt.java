class Solution {
    public int romanToInt(String s) {
        int result = 0;
    	int[] nums = new int[]{1,5,10,50,100,500,1000};
    	String roman = "IVXLCDM";
    	int strIndex = 0;
    	while (strIndex < s.length()) {
        	int index = roman.indexOf(s.charAt(strIndex));
        	if(strIndex + 1 < s.length() && index + 1 < roman.length() && roman.charAt(index + 1) == s.charAt(strIndex + 1)){
        		result = result + (nums[index + 1] - nums[index]);
        		strIndex += 1;
        	}else if(strIndex + 1 < s.length() && index + 2 < roman.length() && roman.charAt(index + 2) == s.charAt(strIndex + 1)){
        		result = result + (nums[index + 2] - nums[index]);
        		strIndex += 1;
        	}else{
        		result += nums[index];
        	}
        	strIndex++;
		}
    	
    	return result;
    }
}
