package com.owen.leetcode.simple;

import java.util.Map;

/*
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

 */
public class LongestCommonPrefix
{
    public static void main(String[] args)
	{
    	String[] strs = {"flower","folow","flight"};
		String result = longestCommonPrefix(strs);
		System.out.println(result);
	}
    
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length < 1) return "";
        String com = strs[0];
        for(int i = 1; i < strs.length; i++){
            int len = Math.min(strs[i].length(), com.length());
            int j;
            for(j = 0; j < len; j++)
                if(strs[i].charAt(j) != com.charAt(j)) break;
            if(j == 0) return "";
            com = com.substring(0, j);//对比字符串
        }
        return com;
    }
    
    public static String longestCommonPrefix2(String[] strs) {
        String pre = "";
        if(strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        pre = help(strs[0],strs[1]);
        if(pre==null){
            return "";
        }
        for (int i = 2; i < strs.length; i++) {
            pre = help(pre,strs[i]);
            if(pre==null){
                return "";
            }
        }
        return pre;
    }
    private static String help(String s1,String s2){
        int len = Math.min(s1.length(),s2.length());
        for (int i = len; i > 0; i--) {
            String t = s1.substring(0,i);
            if (t.equals(s2.substring(0,i))){
                return t;
            }
        }
        return null;
    }
   
    
    public int prefix(String[] strs, Map<String, Integer> map, int index)
    {
		for(int i = 0; i < strs.length; i++)
		{
			String str = strs[i];
			if(index < str.length())
			{
				String s = str.charAt(index) + "";
				if(map.containsKey(s))
				{
					Integer num = map.get(s) + 1;
					map.put(s, num);
				}
				else 
				{
					map.put(s, 1);
				}
			}
		}

    	return 0;
    }
}
