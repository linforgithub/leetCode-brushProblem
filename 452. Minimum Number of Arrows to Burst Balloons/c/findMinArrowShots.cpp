bool mySort(const pair<int, int> &a, const pair<int, int> &b){
    return a.first < b.first;
}
class Solution {
public:
    int findMinArrowShots(vector<pair<int, int>>& points) {
        if (points.size() == 0){
			return 0;
		}
		sort(points.begin(), points.end(), mySort);
		int num = 1;
		int first = points[0].first;
		int end = points[0].second;
		for (int i = 1; i < points.size(); i++){
			if (end >= points[i].first){
				first = points[i].first;
				if (end > points[i].second){
					end = points[i].second;
				}
			}
			else
			{
				first = points[i].first;
				end = points[i].second;
				num++;
			}
		}
		return num;
    }
};
