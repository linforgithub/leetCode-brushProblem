class Solution {
    public String longestPalindrome(String s) {
        int i = 0;
		int index;
		String result = "";
		if(s.length() > 0){
			result = s.charAt(0) + "";
		}
		String tmp = "";
		while(i < s.length() - 1){
			index = 1;
			int start = i;
			int end = i;
			if(s.charAt(i) == s.charAt(i + 1)){
                end = i + 1;
				while(i - index >= 0 && i + index < s.length() - 1){
					start = i - index;
					end = i + index + 1;
					if(s.charAt(start) == s.charAt(end)){
						index++;
					}else{
						index--;
						start += 1;
						end -= 1;
						break;
					}
				}
				if(i - index < 0){
					index--;
				}
				tmp = s.substring(start, end + 1);
			}
			if(tmp.length() > result.length()){
				result = tmp.toString();
			}
			if(i > 0 && s.charAt(i - 1) == s.charAt(i + 1)){
				while(i - index >= 0 && i + index < s.length()){
					start = i - index;
					end = i + index;
					if(s.charAt(i - index) == s.charAt(i + index)){
						index++;
					}else{
						index--;
						start += 1;
						end -= 1;
						break;
					}
				}
				if(i - index < 0){
					index--;
				}
				tmp = s.substring(start, end + 1);
			}
			if(tmp.length() > result.length()){
				result = tmp.toString();
			}
			i++;
		}
        return result;
    }
}
