class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int maxLength = 0;
        Map<String, List<Integer>> wordIndexs = new HashMap<>();
        Map<Integer, String> indexWords = new HashMap<>();
        int del = 0;
        String tmp = null;
        for(String str : words){
            if(wordIndexs.get(str) != null){
                continue;
            }
            del = 0;
            maxLength += str.length();
            int index = s.indexOf(str);
            if(index < 0){
                return new ArrayList<>();
            }
            wordIndexs.put(str, new ArrayList<>());
            while (index >= 0){
                wordIndexs.get(str).add(index + del);
                indexWords.put(del + index, str);
                tmp = s.substring(del + index + 1);
                del += index + 1;
                index = tmp.indexOf(str);
            }
        }
        int maxResult = s.length() - words.length;
        if(maxResult < 0){
            return new ArrayList<>();
        }
//        System.out.println(s.length());
        List<Integer> result = new ArrayList<>(checkStr(maxResult + 1, new ArrayList<>(Arrays.asList(words)), maxLength, wordIndexs, indexWords));
        return result;
    }

    private Set<Integer> checkStr(int maxResult, List<String> words, int maxLength, Map<String, List<Integer>> wordIndexs, Map<Integer, String> indexWords){
        Set<Integer> result = new HashSet<>();

//        int index = -1;
        String tmp;
        int max = words.size();
        List<String> delWords = new ArrayList<>();
        int index = 0;
        for(Map.Entry<Integer, String> entry : indexWords.entrySet()){
            tmp = entry.getValue();
            index = entry.getKey() + tmp.length();
            delWords.add(tmp);
            words.remove(tmp);
            while (indexWords.get(index) != null && words.contains(indexWords.get(index))){
                tmp = indexWords.get(index);
                delWords.add(tmp);
                words.remove(tmp);
                index += tmp.length();
            }
            if(words.size() == 0){
                result.add(entry.getKey());
            }
            words.addAll(delWords);
            delWords.clear();
            if(result.size() == maxResult){
                return result;
            }
        }
        return result;
    }
}
