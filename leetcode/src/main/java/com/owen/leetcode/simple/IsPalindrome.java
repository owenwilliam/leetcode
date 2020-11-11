package com.owen.leetcode.simple;

/**
 * 
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 示例 1: 输入: 121 输出: true 示例 2: 输入:
 * -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。 示例 3: 输入: 10
 * 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。 进阶: 你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class IsPalindrome
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(10));
	}

	public static boolean isPalindrome(int x)
	{
		int reInt = x;
		int res = 0;
		if (x < 0)
		{
			return false;
		}
		while (x != 0)
		{
			// 每次取末尾数字
			int tmp = x % 10;
			// 判断是否 大于 最大32位整数
			if (res > 214748364 || (res == 214748364 && tmp > 7))
			{
				return false;
			}
			// 判断是否 小于 最小32位整数
			if (res < -214748364 || (res == -214748364 && tmp < -8))
			{
				return false;
			}
			res = res * 10 + tmp;
			x /= 10;
		}

		if (res == reInt)
		{
			return true;
		}
		return false;
	}

}
