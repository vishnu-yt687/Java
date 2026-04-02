class Solution {
    public boolean halvesAreAlike(String s) {
        int mid=s.length()/2;
        int count=0;
        for(int i=0;i<mid;i++){
            if(isoval(s.charAt(i))){
                count++;
                }
                }
                for(int i=mid;i<s.length();i++){
                    if(isoval(s.charAt(i))){
                        count--;
                        }
                        }
                        return (count==0);
                        }
                        public static boolean isoval(char c){
                            char letter=Character.toLowerCase(c);
                            if(letter=='a' || letter=='e' || letter=='i' || letter=='o' || letter=='u'){
                                return true;
                                }
                                return false;
                                }
                                }