import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set1=new HashSet<>();
        for(Integer n:nums){
            if(set1.contains(n)){
                return true;
            }else{
                set1.add(n);
            }
        }return false;
    }
}