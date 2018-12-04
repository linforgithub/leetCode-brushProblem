class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        if (dungeon.size() == 0){
			return 0;
		}
		int row = dungeon.size();
		int column = dungeon[0].size();
		vector<vector<int>> bloods(row, vector<int>(column, 0));
		bloods[row - 1][column - 1] = max(1, 1 - dungeon[row - 1][column - 1]);
		for (int i = column - 2; i >= 0; i--){
			bloods[row - 1][i] = max(1, bloods[row - 1][i + 1] - dungeon[row - 1][i]);
		}
		for (int i = row - 2; i >= 0; i--){
			bloods[i][column - 1] = max(1, bloods[i + 1][column - 1] - dungeon[i][column - 1]);
		}
		for (int i = row - 2; i >= 0; i--){
			for (int j = column - 2; j >= 0; j--){
				int minBlood = min(bloods[i + 1][j], bloods[i][j + 1]);
				bloods[i][j] = max(1, minBlood - dungeon[i][j]);
			}
		}
		return bloods[0][0];
    }
};
