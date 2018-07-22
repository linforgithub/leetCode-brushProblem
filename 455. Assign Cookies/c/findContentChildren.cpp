class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
		sort(s.begin(), s.end());
        int result = 0;
		if (s.size() == 0){
			return result;
		}
		int index = 0;
		for (int i = 0; i < g.size(); i++){
			while (index < s.size())
			{
				if (g[i] <= s[index++]){
					result++;
					break;
				}
			}
		}
		return result;
    }
};
