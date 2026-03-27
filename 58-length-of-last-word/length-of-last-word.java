import java.util.*;
class Solution {
    public int lengthOfLastWord(String s) {
        String[] c=s.split(" ");
        return c[c.length-1].length();
    }
}