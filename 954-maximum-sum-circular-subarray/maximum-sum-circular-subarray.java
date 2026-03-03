class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int csum=0,cmsum=0,tsum=0;
        int maxsum=Integer.MIN_VALUE;
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            csum=Math.max(nums[i],csum+nums[i]);
            maxsum=Math.max(csum,maxsum);
            cmsum=Math.min(nums[i],cmsum+nums[i]);
            minsum=Math.min(cmsum,minsum);
            tsum+=nums[i];
        }
        if(maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,tsum-minsum);
    }
}