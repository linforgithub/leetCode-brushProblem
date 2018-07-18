class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<char> vec;
        vec.resize(s.size());
        vec.assign(s.begin(), s.end());
        int result = 0;
        set<char> cSet;
        while (vec.size() > 0)
        {
            cSet.clear();
            cSet.insert(vec[0]);
            vector<char>::iterator k = vec.begin();
            vec.erase(k);
            for (int i = 0; i < vec.size(); i++){
                if (cSet.find(vec[i]) != cSet.end()){
                    break;
                }
                cSet.insert(vec[i]);
            }
            if (result < cSet.size()){
                result = cSet.size();
            }
            if (result > vec.size()){
                break;
            }
        }
        return result;
    }
};
