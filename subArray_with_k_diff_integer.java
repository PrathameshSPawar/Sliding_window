//https://leetcode.com/problems/subarrays-with-k-different-integers/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int num=helper(nums,k);
        int num_1=helper(nums,k-1);
        return num-num_1;
    }

    public int helper(int nums[],int k) 
    {
        if(k<0) return 0;
        int n=nums.length;
        int left=0,right=0,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<n) {
            int val=map.getOrDefault(nums[right],0);
            map.put(nums[right],++val);
            while(map.size()>k) {
                int get=map.get(nums[left]);
                if(get-1==0) map.remove(nums[left]);
                else map.put(nums[left],--get);
                left+=1;
            }

            if(map.size()<=k) {
                int len=right-left+1;
                count+=len;
            }
            right+=1;
        }
        return count;
    }

    public int subarraysWithKDistinct1(int[] nums, int k) {
        int count=0,n=nums.length;
        for(int i=0;i<n;i++) {
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<n;j++) {
                int curr=map.getOrDefault(nums[j],0);
                map.put(nums[j],++curr);
                if(map.size()>k) {
                    break;
                }

                if(map.size()==k) count++;
            }
        }
        return count;
    }
}
