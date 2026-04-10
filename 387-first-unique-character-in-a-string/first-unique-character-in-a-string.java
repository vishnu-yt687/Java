class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> m1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            m1.put(ch,m1.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
           if(m1.get(s.charAt(i))==1){
                return i;
           }
        }
        return -1;
    }
}