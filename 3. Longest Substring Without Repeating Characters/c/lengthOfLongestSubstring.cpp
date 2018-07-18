class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        std::vector<char> vec;
        vec.resize(s.size());
        vec.assign(s.begin(), s.end());
        std::map<char,int> sMap;
        int result = 0;
        // 将第一个值加入map,并移除第一个值
        // 遍历剩余的字符,查看字符是否存在，存在则记录此次字符长度
        // 之后清空map,重新从第一个值开始查找
        while (vec.size() > 0)
        {
            sMap.clear();
            sMap[vec[0]] = 1;
            std::vector<char>::iterator k = vec.begin();
            vec.erase(k);
            for (int i = 0; i < vec.size(); i++){
                if (sMap[vec[i]] != NULL){
                    break;
                }
                sMap[vec[i]] = 1;
            }
            if (result < sMap.size()){
                result = sMap.size();
            }
            if (result > vec.size()){
                break;
            }
        }
        return result;
    }
};
