class Solution {
    public int myAtoi(String str) {
        long result = 0;
        StringBuilder sb = new StringBuilder();
        str = str.trim();
        int index = 0;
        int base = 1;
        boolean haveNumber = false;
        boolean haveSign = false;
        while(index < str.length()){
        	boolean isNumber = str.charAt(index) >= '0' && str.charAt(index) <= '9';
        	if(isNumber){
        		haveNumber = true;
        		sb.append(str.charAt(index));
        	}else if(!haveNumber && !haveSign && (str.charAt(index) == '-' || str.charAt(index) == '+')){
        		base = str.charAt(index) == '-' ? -1 : 1;
        		haveSign = true;
        	}else{
        		break;
        	}
        	index++;
        }
        if(sb.length() > 0){
        	try {
            	result = Long.valueOf(sb.toString());
			} catch (Exception e) {
				return base > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
        }else{
        	return 0;
        }
        if(result > Integer.MAX_VALUE){
        	return base > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
		
        return (int) result * base;
    }
}
