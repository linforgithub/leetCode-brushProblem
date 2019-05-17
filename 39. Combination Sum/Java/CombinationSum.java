class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> group, int[] candidates, int target, int nowIndex){
        for(int i = nowIndex;i < candidates.length;i++){
            if(target - candidates[i] > 0){
                group.add(candidates[i]);
                dfs(result, group, candidates, target - candidates[i], i);
                group.remove(group.size() - 1);
            }else if(target - candidates[i] == 0){
                group.add(candidates[i]);
                result.add(new ArrayList<>(group));
                group.remove(group.size() - 1);
            }else{
                continue ;
            }
        }
    }
}
