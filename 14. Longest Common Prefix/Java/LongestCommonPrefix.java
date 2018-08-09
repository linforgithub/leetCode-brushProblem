class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
    		return "";
    	}
        String result = "";
    	result = sub(0,strs.length - 1, strs);
    	return result;
    }
    
    public static String sub(int left, int right, String[] strs){
    	int mid = (left+ right) / 2;
    	String result = strs[mid];
    	if(left < right){
    		String leftStr = sub(left, mid, strs);
    		String rightStr = sub(mid + 1, right, strs);
    		if(leftStr.length() > 0 && rightStr.length() > 0){
    			return compare(leftStr, rightStr);
    		}else{
    			return "";
    		}
    	}
    	return result;
    }
    
    public static String compare(String s1, String s2){
    	int index = -1;
    	while(index + 1 < s1.length() && index + 1 < s2.length() &&  
    			s1.charAt(index + 1) == s2.charAt(index + 1)){
    		index++;
    	}
    	return index != -1 ? s1.substring(0, index + 1) : "";
    }
}
