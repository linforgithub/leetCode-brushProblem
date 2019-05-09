class Solution {
    private Map<String, String> numToStr = new HashMap<>();;

    public List<String> letterCombinations(String digits) {
        numToStr.put("2", "abc");
        numToStr.put("3", "def");
        numToStr.put("4", "ghi");
        numToStr.put("5", "jkl");
        numToStr.put("6", "mno");
        numToStr.put("7", "pqrs");
        numToStr.put("8", "tuv");
        numToStr.put("9", "wxyz");

        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        generate(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void generate(List<String> result, StringBuilder sb, String digits, int index){
        if(index == digits.length()){
            result.add(sb.toString());
            return ;
        }
        String thisStr = numToStr.get(String.valueOf(digits.charAt(index)));
        for(int i = 0;i < thisStr.length();i++){
            sb.append(thisStr.charAt(i));
            generate(result, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
