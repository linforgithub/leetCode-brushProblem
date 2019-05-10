class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int maxIndex = haystacks.length - needles.length;
        for(int i = 0;i <= maxIndex;i++){
            if(checkStr(haystacks, needles, i)){
                return i;
            }
        }
        return -1;
    }

    private boolean checkStr(char[] haystacks, char[] needles, int index){
        for(char c : needles){
            if(c != haystacks[index++]){
                return false;
            }
        }
        return true;
    }
}
