class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
		if (triangle.size() == 1){
			return triangle[0][0];
		}
		if (triangle.size() == 0){
			return 0;
		}
        vector<int> resultList;
		int lastNum = triangle.size() - 1;
		for (int j = 0; j < triangle[lastNum].size(); j++){
			resultList.push_back(triangle[lastNum][j]);
		}
		for (int i = lastNum - 1; i > 0; i--){
			for (int j = 0; j < triangle[i].size(); j++){
				resultList[j] = triangle[i][j] + min(resultList[j], resultList[j + 1]);
			}
		}
		return triangle[0][0] + min(resultList[0], resultList[1]);
    }
};
