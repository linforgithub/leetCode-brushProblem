class Solution {
    public String convert(String s, int numRows) {
        List<String> list = new ArrayList<>();
		for(int i = 0;i < numRows;i++){
			list.add("");
		}
        if(s.length() <= numRows){
			return s;
		}
        if(numRows == 1){
			return s;
		}
		int index = 0;
		int status = 1;
		for(int i = 0;i < s.length();i++){
			list.set(index, list.get(index) + s.charAt(i));
			switch (status) {
			case 1:
				index++;
				status = index == numRows - 1 ? 2 : status;
				break;
			case 2:
				index--;
				status = index == 0 ? 1 : status;
				break;
			default:
				break;
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0;i < numRows;i++){
			result.append(list.get(i));
		}
        return result.toString();
    }
}
