class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
        
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            used[i] = true;
            tempList.add(nums[i]);

            backtrack(result, tempList, used, nums);

            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}