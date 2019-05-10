class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<String> strStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        String[] symbols = new String[]{"()", "[]", "{}"};
        String c;
        int index;
        int strIndex;
        for(int i = 0;i < s.length();i++){
            c = String.valueOf(s.charAt(i));
            for(index = 0;index < symbols.length;index++) {
                strIndex = symbols[index].indexOf(c);
                if (strIndex > -1) {
                    if(strIndex == 0){
                        strStack.push(c);
                        indexStack.push(index);
                    }else if(strStack.size() > 0 && index == indexStack.pop()){
                        strStack.pop();
                    }else{
                        return false;
                    }
                    break;
                }
            }
            if(index == symbols.length){
                return false;
            }
        }
        if(strStack.size() == 0){
            return true;
        }
        return false;
    }
}
