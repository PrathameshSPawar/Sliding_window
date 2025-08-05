//https://leetcode.com/problems/longest-repeating-character-replacement/
class Solution {
    public int characterReplacement2(String s, int k) {
        int n=s.length(),length=0,maxi=0;
        int left=0,right=0;
        int hash[]=new int[26];
        while(right<n) {
            char ch=s.charAt(right);
            hash[ch-'A']++;
            maxi=Math.max(maxi,hash[ch-'A']);
            //int len=right-left+1;
            while((right-left+1)-maxi > k) {
                char curr=s.charAt(left);
                hash[curr-'A']--;
                maxi=0;
                for(int i=0;i<26;i++) maxi=Math.max(maxi,hash[i]);
                left=left+1;
            }

            if((right-left+1)-maxi <=k) {
                length=Math.max(length,(right-left+1));
            }
            right++;
        }
        return length;
    }

    public int characterReplacement1(String s, int k) {
        int n=s.length(),length=0;
        for(int i=0;i<n;i++) {
            int hash[]=new int[26];
            int maxi=0;
            for(int j=i;j<n;j++) {
                char ch=s.charAt(j);
                hash[ch-'A']++;
                maxi=Math.max(maxi,hash[ch-'A']);
                int curr=j-i+1;
                if(curr-maxi<=k) {
                    length=Math.max(length,curr);
                } else {
                    break;
                }
            }
        }
        return length;
    }
}
