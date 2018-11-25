
int hash_map[1048576] = { 0 };

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> result;
		if (s.length() < 10){
			return result;
		}
		for (int i = 0; i < 1048576; i++){
			hash_map[i] = 0;
		}
		int char_map[128] = { 0 };
		char_map['A'] = 0;
		char_map['C'] = 1;
		char_map['G'] = 2;
		char_map['T'] = 3;
		int key = 0;
		for (int i = 9; i >= 0; i--){
			key = (key << 2) + char_map[s[i]];
		}
		hash_map[key] = 1;
		for (int i = 10; i < s.length(); i++){
			key = key >> 2;
			key = key | (char_map[s[i]] << 18);
			hash_map[key]++;
		}
		for (int i = 0; i < 1048576; i++){
			if (hash_map[i] > 1){
				result.push_back(changeIntToDNA(i));
			}
		}
		return result;
    }
    
    string changeIntToDNA(int DNA){
		static const char DNA_CHAR[] = { 'A', 'C', 'G', 'T' };
		string str;
		for (int i = 0; i < 10; i++)
		{
			str += DNA_CHAR[DNA & 3];
			DNA = DNA >> 2;
		}
		return str;
	}
};
