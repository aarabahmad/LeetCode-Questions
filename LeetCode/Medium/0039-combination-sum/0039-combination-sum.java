class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> ans, int[] candidates, int target, int index) {
        if(target<0) {
            return;
        }
        else if(target==0) {
            result.add(new ArrayList<>(ans));
        }
        else {
            for(int i=index;i<candidates.length;i++) {
                ans.add(candidates[i]);
                backtrack(result, ans, candidates, target-candidates[i], i);
                ans.remove(ans.size()-1);
            }
        }
    }
}