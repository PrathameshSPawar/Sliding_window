//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0,right=0,length=0,n=s.length();
        while(right<n) {
            char ch=s.charAt(right);
            if(map.containsKey(ch) && map.get(ch)>=left) {
                int ind=map.get(ch);
                left=ind+1;
            }
            int curr=right-left+1;
            length=Math.max(length,curr);
            map.put(ch,right);
            right++;
        }
        return length;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n=s.length(),maxi=0;
        for(int i=0;i<s.length();i++) {
            int alpha[]=new int[255];
            Arrays.fill(alpha,0);
            for(int j=i;j<n;j++) {
                char ch=s.charAt(j);
                if(alpha[ch]==1) break;

                int length=j-i+1;
                maxi=Math.max(maxi,length);
                alpha[ch]=1;
            }
        }
        return maxi;
    }
}
