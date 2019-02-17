class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		map<string, vector<string>> graph;
		graph[beginWord] = vector<string>();
		wordList.push_back(beginWord);
		for (int i = 0; i < wordList.size(); i++){
			graph[wordList[i]] = vector<string>();
		}
		for (int i = 0; i < wordList.size(); i++){
			for (int j = i + 1; j < wordList.size(); j++){
				if (canChange(wordList[i], wordList[j])){
					graph[wordList[i]].push_back(wordList[j]);
					graph[wordList[j]].push_back(wordList[i]);
				}
			}
		}
		queue<pair<string, int>> Q;
		set<string> visit;
		Q.push(make_pair(beginWord, 1));
		while (!Q.empty())
		{
			string node = Q.front().first;
			int step = Q.front().second;
			Q.pop();
			if (node == endWord){
				return step;
			}
			const vector<string> &neighbors = graph[node];
			for (int i = 0; i < neighbors.size(); i++){
				if (visit.find(neighbors[i]) == visit.end()){
					Q.push(make_pair(neighbors[i], step + 1));
					visit.insert(neighbors[i]);
				}
			}
		}
		return 0;
	}

	bool canChange(string &word1, string &word2){
		int diff = 0;
		for (int i = 0; i < word1.length(); i++){
			if (word1[i] != word2[i]){
				++diff;
			}
		}
		return diff == 1;
	}
};
