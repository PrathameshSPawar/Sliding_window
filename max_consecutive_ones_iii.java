//https://leetcode.com/problems/max-consecutive-ones-iii/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length,zeros=0,length=0;
        int left=0,right=0;
        while(right!=n) {
            if(nums[right]==0) {
                zeros++;
            }
            if(zeros>k) {
                if(nums[left]==0) {
                    zeros--;
                }
                left++;
            }
            if(zeros<=k) {
                int curr=right-left+1;
                length=Math.max(length,curr);
            }
            right++;
        }
        return length;
    }
    public int longestOnes2(int[] nums, int k) {
        int n=nums.length,zeros=0,length=0;
        int left=0,right=0;
        while(right!=n) {
            if(nums[right]==0) {
                zeros++;
            }
            while(zeros>k) {
                if(nums[left]==0) {
                    zeros--;
                }
                left++;
            }
            int curr=right-left+1;
            length=Math.max(length,curr);
            right++;
        }
        return length;
    }
    public int longestOnes1(int[] nums, int k) {
        int length=0,n=nums.length;
        for(int i=0;i<n;i++) {
            int zeros=0;
            for(int j=i;j<n;j++) {
                //if(zeros>k) break;

                if(nums[j]==0) {
                    zeros++;
                }

                if(zeros<=k) {
                    int curr=j-i+1;
                    length=Math.max(length,curr);
                } else {
                    break;
                }            
            }
        }
        return length;
    }
}
