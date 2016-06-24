package it.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.junit.Test;

public class Solution {
	 public static int numDecodeins(String s){
		 int codeNum=0;
		 int len=s.length();
		 int[] num=new int[len];
		 for(int i=0;i<len;i++){
				num[i]=s.charAt(i)-'0';
			}
		 if(len==1&&num[0]==0)
			 return 0;
		 else{
			 codeNum=1;
			 for(int i=1;i<len;i++){
				if(num[i]==0){
					if(num[i-1]<7){
						codeNum++;
					}
				}
				else{    
					codeNum++;
				}
				if(num[i-1]>0&& num[i-1]<3&&num[i]<7){
					codeNum++;
				}
			 }
			 return codeNum;
    }
		 
	 }
	 public static boolean isSelfCrossing(int[] x) {
	       if(x.length!=4) return false;
	       if(x[0]==0||x[1]==0||x[2]==0||x[3]==0)
	    	   return false;
	       else{
		       if(x[0]>=x[2]&&x[1]<x[3]){
		    	   return true;
		       }else
		       return false;
	       }
	    }
	 
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	 	ListNode list=new ListNode(0);
	 	ListNode header=list;
//	 	list.val=l1.val+l2.val;
//	 	ListNode header=null;
	 	int num=0;
	 	while(l1!=null || l2!=null||num!=0){
	 		ListNode cur=new ListNode(0);
	 		int sum=(l1==null?0:l1.val)+(l2==null?0:l2.val)+num;
	 		cur.val=sum%10;
	 		list.next=cur;
	 		list=cur;
	 		num=sum/10;
	 		l1=l1==null?l1:l1.next;
	 		l2=l2==null?l2:l2.next;
	 		
	 	}
	 	
	 	return header.next;
   }
	 
	 public static String convert(String s, int numRows) {
		 Vector<String> vec=new Vector<String>();
		 StringBuilder sb=null;
		 if(numRows==0||s.length()==0){
			 return s;
		 }
		 int len=s.length();
		 int t=numRows*2-2;
		 
		 int k=0;
		 char[] c=new char[len];
		 for(int i=0;i<numRows;i++){
			 for(int j=i;j<len;j=j+t){
				 c[k++]=s.charAt(j);
				 if(i>0&&i<numRows-1&&j+t-2*i<len){
					 c[k++]=s.charAt(j+t-2*i);
				 }
			 }
		 }
		 return new String(c);
//	     
//		 StringBuilder sb=null;
//		 String[] ds=null;
//		 
//		 
//		 int len=s.length();
//		 if(numRows==0||len==0)return s;
//		 int a=len/(numRows+numRows-2);
//		 int b=len%(numRows+numRows-2);
//		 StringBuilder kong=null;
//		 
//		 if(b>numRows){
//			 a=(numRows-1)*a+b-numRows;
//		 }else{
//			 a=(numRows-1)*a+1;
//		 }
//		 for(int i=0;i<numRows;i++){
//			 for(int j=0;j<a/(numRows-2);j++){
//				 for(int k=0;k<numRows-2;i++){
//					 kong.append(" ");
//				 }
//				sb.append(s.charAt(0+j*(2*numRows-2))+kong.toString()); 
//			 }
//		 }
////		 for(int)
//		 return sb.toString();
	    }
	 
	 public int reverse(int x) {
	     if(x>Integer.MAX_VALUE||x<Integer.MIN_VALUE){
	    	 return 0;
	     }   
	     int sum=0;
	     while(x!=0){
	    	 int a=x%10;
	    	 sum=sum*10+a;
	    	 x=x/10;
	     }
	     if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE){
	    	 return 0;
	     }   
	     return sum;
	    }
	 
//	 1、字符串为空
//	 2、字符串第一个数为符号
//	 3、找到第一个非空字符
//	 4、字符中间的空字符处理
//	 5、与整数的最大值最小值比较
	 public static int myAtoi(String str) {
		 if (str == null || str.length() == 0)
		        return 0;//
		    str = str.trim();
		    char firstChar = str.charAt(0);
		    int sign = 1, start = 0, len = str.length();
		    long sum = 0;
		    if (firstChar == '+') {
		        sign = 1;
		        start++;
		    } else if (firstChar == '-') {
		        sign = -1;
		        start++;
		    }
		    for (int i = start; i < len; i++) {
		        if (!Character.isDigit(str.charAt(i)))
		            return (int) sum * sign;
		        sum = sum * 10 + str.charAt(i) - '0';
		        if (sign == 1 && sum > Integer.MAX_VALUE)
		            return Integer.MAX_VALUE;
		        if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
		            return Integer.MIN_VALUE;
		    }

		    return (int) sum * sign;
	    }
	 
	 //回数
	 public static boolean isPalindrome(int x) {
		 if (x < 0)
	            return false;
	     
	        int len = 1;
	        while (x / len >= 10) {
	            len *= 10;
	       
	        }
	 
	        while (x != 0) {
	            int left = x / len;
	            int right = x % 10;
	 
	            if (left != right)
	                return false;
	            //remove the head and tail digit
	            x = (x % len) / 10;
	            len /= 100;
	        }
	 
		 return true;
		 
//		 if(x>=0&&x<=10) return true;
////		 System.out.println(x);
//	        int rx=Integer.reverse(x);
////	        System.out.println(rx);
//	        if(x>=Integer.MAX_VALUE||x<Integer.MIN_VALUE||rx>Integer.MAX_VALUE||rx<Integer.MIN_VALUE)
//	        	return false;
//	        if(rx-x==0) return true;
//	        return false;
	    }
	 
	 public static int maxArea(int[] height) {
	        int left=0;
	        int right=height.length-1;
	        int maxaere=0;
	        while(left<right){
	        	maxaere=Math.max(maxaere, Math.min(height[left],
	        			height[right])*(right-left));
	        	if(height[left]>height[right]){
	        		right--;
	        	}
	        	else left++;
	   	        }
	        return maxaere;
	    }
	 
	 public static List<List<Integer>> threeSum(int[] nums) {
//	        List<List<Integer>> res=new ArrayList<List<Integer>>(); 
//	        List<Integer> list=new LinkedList<Integer>();
//	        int len=nums.length;
//	        if(len<3) return null;
//	        for(int i=0;i<len-2;i++){
//	        	for(int j=i+1;j<len-1;j++){
//	        		for(int k=j+1;k<len;k++){
//	        			
//	    	         	if(nums[k]+nums[j]+nums[i]==0){
//	    	         		if(!list.isEmpty()) list.clear();
//	    	         		list.add(nums[i]);
//		    	        	list.add(nums[j]);
//	        				list.add(nums[k]);
//	        				res.add(list);
//	        				System.out.println(list);
//	        				
//	        				
//	        			}
//	        		}
//	        		
//	        	}
//	        }
//	        return res;
		 
		 List<List<Integer>> res=new ArrayList<List<Integer>>();
		 int len=nums.length;
		 if(len<3) return null;
		 Arrays.sort(nums);
//		 int left=0,right=0;
		 for(int i=0;i<len;i++){
			 int left=i+1;
			 int right=len-1;
			 
			 if(nums[i]>0) return res;
			 
			 if(i>0&&nums[i]==nums[i-1])continue;
			 //重复数字的剔除，这部分比较关键，少了这一个就会出现超时现象
			 
			 while(left<right){
				 int sum=nums[i]+nums[left]+nums[right];
				 if(sum==0){
					 List<Integer> list=new LinkedList<Integer>();
					 list.add(nums[i]);
					 list.add(nums[left]);
					 list.add(nums[right]);
//					 System.out.println(i+".."+list);
					 res.add(list);
//					 System.out.println(i+".."+res);
					 right--;
					 left++;
					 while(left<right &&nums[left]==nums[left-1]) left++;
					 while(left<right &&nums[right]==nums[right+1]) right--;
				 }
				 if(sum>0){
					 right--;
				 }
				 if(sum<0){
					 left++;
				 }
			 	}
			 
		 }
		 return res;
	    }
	 
	 public static void main(String[] msgn){
		 String str1="01";
		 String str2="4012";
		 int[] arr={0,0,0,-1,5,-5};
		 String str="A";
		 System.out.print(threeSum(arr));
//		 System.out.print(convert(str,4));
//		 System.out.print(isPalindrome(7));
//		 System.out.print(myAtoi("-2147483647"));
//		 System.out.print(numDecodeins(str2));
//		 System.out.print(isSelfCrossing(arr));
//		 System.out.print(compareVersion(str1,str2));
		 
	 }
}

