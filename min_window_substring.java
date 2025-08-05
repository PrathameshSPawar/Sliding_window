//https://leetcode.com/problems/minimum-window-substring/
class Solution {
    public String minWindow(String s, String t) {
        int left=0,right=0,n1=s.length(),n2=t.length();
        int count=0,minLen=(int)1e9,startInd=-1;
        int hash[]=new int[255];

        for(int i=0;i<n2;i++) {
            hash[t.charAt(i)]++;
        }
        while(right<n1) {
            char ch=s.charAt(right);
            if(hash[ch]>0) count++;
            hash[ch]--;

            while(count==n2) {
                if((right-left+1)<minLen) {
                    minLen=(right-left+1);
                    startInd=left;
                }

                char chleft=s.charAt(left);
                hash[chleft]++;
                if(hash[chleft]>0) count--;
                left=left+1;
            }

            right=right+1;
        }
        if(startInd==-1) return "";
        return s.substring(startInd,startInd+minLen);
    }
}
