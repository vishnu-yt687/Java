import java.util.*;
class Solution {
    public int lengthOfLastWord(String s) {
        String[] c=s.split(" ");
        List<String> l1=new ArrayList<>(Arrays.asList(c));
        int len=l1.size();
        String s1=l1.get(len-1);
        return s1.length();
    }
}