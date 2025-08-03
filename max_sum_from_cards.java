//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0;
        for(int i=0;i<=k-1;i++) leftSum+=cardPoints[i];
        System.out.print(leftSum);

        int n=cardPoints.length;
        int rightSum=0,maxAns=leftSum,lastI=n-1;
        for(int i=k-1;i>=0;i--) {
            leftSum=leftSum-cardPoints[i];
            rightSum=rightSum+cardPoints[lastI--];
            maxAns=Math.max(maxAns,leftSum+rightSum);
        }
        return maxAns;   
    }
}
