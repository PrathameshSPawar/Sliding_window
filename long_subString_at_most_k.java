//https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM
import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		int left=0,right=0,length=0,n=str.length();
		HashMap<Character,Integer> map=new HashMap<>();
		while(right<n) {
			char ch=str.charAt(right);
			int val=map.getOrDefault(ch,0);
			map.put(ch,val+1);
			if(map.size()>k) {
				char cha=str.charAt(left);
				int curr=map.get(cha);
				curr--;
				if(curr==0) {
					map.remove(cha);
				} else {
					map.put(cha,curr);
				}
				left++;
			}

			if(map.size()<=k) {
				int currL=right-left+1;
				length=Math.max(length,currL);
			}
			right++;
		}
		return length;
	}

	public static int kDistinctChars1(int k, String str) {
		// Write your code here
		int n=str.length();
		int length=0;
		for(int i=0;i<n;i++) {
			HashSet<Character> set=new HashSet<>();
			for(int j=i;j<n;j++) {
				char ch=str.charAt(j);
				set.add(ch);
				if(set.size()>k) {
					break;
				}

				if(set.size()<=k) {
					int curr=j-i+1;
					length=Math.max(length,curr);
				}
			}
		}
		return length;
	}

}
