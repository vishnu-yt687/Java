class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> l1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
                if(l1.contains(nums[i])){
                    return true;
                }
                l1.add(nums[i]);
                if(l1.size()>k){
                    l1.remove(nums[i-k]);
                }
            }
             return false;
    }
}