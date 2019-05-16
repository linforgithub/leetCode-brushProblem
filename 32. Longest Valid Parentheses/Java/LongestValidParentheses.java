class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        int max = 0;
        List<Integer> indexs = new ArrayList<>();
        char[] tmp = new char[s.length()];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                indexs.add(i);
                tmp[i] = '1';
                continue;
            }
            if(indexs.size() > 0){
                tmp[indexs.get(indexs.size() - 1)] = '0';
                tmp[i] = '0';
                indexs.remove(indexs.size() - 1);
            }else{
                tmp[i] = '1';
            }
        }
        for(int i = 0;i < s.length();i++){
            if(tmp[i] == '0'){
                max++;
                continue;
            }
            if(max > result){
                result = max;
            }
            max = 0;
        }
        result = max > result ? max : result;
        return result;
    }
}
