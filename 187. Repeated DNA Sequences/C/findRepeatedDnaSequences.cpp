class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        map<string, int> word_map;
		vector<string> result;
		for (int i = 0; i < s.length(); i++){
			string word = s.substr(i, 10);
			if (word_map.find(word) != word_map.end()){
				word_map[word] += 1;
			}
			else
			{
				word_map[word] = 1;
			}
		}
		map<string, int>::iterator it;
		for (it = word_map.begin(); it != word_map.end(); it++){
			if (it->second > 1){
				result.push_back(it->first);
			}
		}
		return result;
    }
};
