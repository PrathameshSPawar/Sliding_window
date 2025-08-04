https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
class Solution {
    public int numberOfSubstrings(String s) {
        int alpha[]=new int[3];
        Arrays.fill(alpha,-1);
        int n=s.length(),right=0,length=0;
        while(right<n) {
            int ch=s.charAt(right)-'a';
            alpha[ch]=right;
            if(alpha[0]!=-1 && alpha[1]!=-1 && alpha[2]!=-1) {
                length+=Math.min(alpha[0],Math.min(alpha[1],alpha[2]))+1;
            }
            right++;
        }
        return length;
    }

    public int numberOfSubstrings1(String s) {
        int n=s.length();
        int length=0;
        //HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            HashSet<Character> set=new HashSet<>();
            for(int j=i;j<n;j++) {
                char ch=s.charAt(j);
                set.add(ch);
                if(set.size()==3) {
                    length+=n-j;
                    break;
                }
            }
        }
        return length;
    }
}
