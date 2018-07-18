class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int arr[256] = {-1};
        for(int i = 0; i < 256; i++)
            arr[i] = -1;
        int left = 0, j = 0;
        int result = 0;
        while(left < s.size() && j < s.size())
        {
            // 当前不存在该字符或者该字符在上一次判断子串的位置之前则继续将结果+1
            if(arr[s[j]] == -1 || arr[s[j]] < left)
            {
                // 判断当前最长子串的长度和上一次判断截取位置到当前位置的长度的大小
                result = max(result, j-left+1);
                // 记录当前字符所在的位置
                arr[s[j]] = j++;             
            }
            else
            {
                // 当前的字符已存在，记录当前字符所在的位置，下一次判断字符长度从该位置开始判断
                left = arr[s[j]] + 1;
            }
        }
        
        return result;
    }
};
