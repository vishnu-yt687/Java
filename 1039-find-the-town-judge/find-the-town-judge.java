class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) return -1;
        
        int[] trustScores = new int[n + 1];
        
        for (int[] relationship : trust) {
            int a = relationship[0];
            int b = relationship[1];
            trustScores[a]--;
          
            trustScores[b]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}