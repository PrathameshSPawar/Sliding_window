//https://leetcode.com/problems/fruit-into-baskets/
class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,right=0,length=0,n=fruits.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<n) {
            int value=map.getOrDefault(fruits[right],0);
            map.put(fruits[right],value+1);
            if(map.size()>2) {
                int currV=map.get(fruits[left]);
                currV-=1;
                if(currV==0) {
                    map.remove(fruits[left]);
                }else {
                    map.put(fruits[left],currV);
                }
                left+=1;
            }

            if(map.size()<=2) {
                int currL=right-left+1;
                length=Math.max(length,currL);
            }
            right++;
        }
        return length;        
    }

    public int totalFruit1(int[] fruits) {
        int n=fruits.length,length=0;
        for(int l=0;l<n;l++) {
            HashSet<Integer> set=new HashSet<>();
            for(int r=l;r<n;r++) {
                set.add(fruits[r]);
                if(set.size()>2) {
                    break;
                }

                int curr=r-l+1;
                length=Math.max(length,curr);
            }
        }
        return length;
    }
}
