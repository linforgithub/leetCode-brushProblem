class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
    	String[] roman = new String[]{"I","V","X","L","C","D","M"};
    	int index = 7;
    	int base = 1000;
    	while (num > 0 && index >= 0) {
        	int remainder = num / base;
        	num = num % base;
        	base = base / 10;
        	if(remainder == 0){
    			index -= 2;
        		continue;
        	}
        	if(remainder < 4){
        		for(int i = 0;i < remainder;i++){
        			result.append(roman[index - 1]);
        		}
        	}else if(remainder == 4){
        		result.append(roman[index - 1]).append(roman[index]);
        	}else if(remainder == 9){
        		result.append(roman[index - 1]).append(roman[index + 1]);
        	}else{
        		result.append(roman[index]);
        		for(int i = 0;i < remainder % 5;i++){
        			result.append(roman[index - 1]);
        		}
        	}
			index-=2;
		}
    	
    	return result.toString();
    }
}
