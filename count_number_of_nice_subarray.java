//https://leetcode.com/problems/count-number-of-nice-subarrays/
//Same question like 10(binary count)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }

    public int helper(int nums[],int k) {
        if(k<0) return 0;
        int left=0,right=0,n=nums.length,sum=0,length=0;
        while(right<n) {
            sum+=nums[right]%2;
            while(sum>k) {
                sum-=nums[left]%2;
                left++;
            }

            if(sum<=k) {
                length+=(right-left+1);
            }
            right++;
        }
        return length;
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        int length=0,n=nums.length;
        for(int i=0;i<n;i++) {
            int count=0;
            for(int j=i;j<n;j++) {
                if(nums[j]%2==1) {
                    count++;
                }

                if(count==k) {
                    length++;
                }
            }
        }
        return length;
    }
}
