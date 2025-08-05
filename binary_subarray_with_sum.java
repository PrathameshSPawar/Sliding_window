//https://leetcode.com/problems/binary-subarrays-with-sum/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //here we want to find sum==goal for this we apply simple mathematics in which we
        //first calculate for sum<=goal and further next we find sum<=goal-1 and 
        //Substract (sum<=goal-1) from (sum<=goal) which gives sum==goal
        int forN=helper(nums,goal);
        int forN1=helper(nums,goal-1);
        return forN-forN1;
    }

    public int helper(int[] nums, int goal) {
        if(goal<0) return 0;
        int left=0,right=0,count=0,sum=0,n=nums.length;
        while(right<n) {
            sum+=nums[right];
            while(sum>goal) {
                sum-=nums[left];
                left=left+1;
            }

            if(sum<=goal) {
                count += (right-left+1);
            }
            right++;
        }
        return count;
    }

    public int numSubarraysWithSum1(int[] nums, int goal) {
        int n=nums.length,sumCount=0;
        for(int i=0;i<n;i++) {
            int curr=0;
            for(int j=i;j<n;j++) {
                curr+=nums[j];
                if(curr==goal) sumCount++;
                if(curr>goal) break;
            }
            System.out.println(curr+" "+sumCount);
        }
        return sumCount;
    }
}
