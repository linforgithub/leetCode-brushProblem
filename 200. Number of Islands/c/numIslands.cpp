class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
		if (grid.size() == 0 || grid[0].size() == 0)
		{
			return 0;
		}
		int x = grid.size();
		int y = grid[0].size();
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		int land = 0;
		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++){
				if (grid[i][j] == '1'){
					grid[i][j] = '0';
					land++;
					search(dx, dy, i, j, grid);
				}
			}
		}
		return land;
	}
	void search(int dx[], int dy[], int x, int y, vector<vector<char>>& grid){
		for (int i = 0; i < 4; i++){
			int newx = dx[i] + x;
			int newy = dy[i] + y;
			if (newx < 0 || newx >= grid.size() ||
				newx < 0 || newy >= grid[newx].size()){
				continue;
			}
			if (grid[newx][newy] == '0'){
				continue;
			}
			grid[newx][newy] = '0';
			search(dx, dy, newx, newy, grid);
		}
	}
};
