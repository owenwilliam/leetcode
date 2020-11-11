package com.owen.leetcode.simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 示例 1: 输入: 123 输出: 321  示例 2: 输入: -123
 * 输出: -321 示例 3: 输入: 120 输出: 21 注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 
 * 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse
{

	public static void main(String[] args)
	{
		System.out.println(reverse2(-123));

	}

	public static int reverse(int x)
	{
		try
		{
			String num = String.valueOf(x);
			char[] c = num.toCharArray();
			String reString = ""; // 倒序后的字符串
			int loop = c.length - 1; // 循环开始位置
			int end = 0; // 循环结束位置
			String mark = c[0] + "";

			if ("-".equals(mark))
			{
				end = end + 1;
			}

			String last = c[c.length - 1] + ""; // 最后一位数
			if ("0".equals(last))
			{
				loop = loop - 1;
			}

			for (int i = loop; i >= end; i--)
			{
				reString += c[i];
			}

			if (end > 0)
			{
				reString = "-" + reString;
			}

			if (!"".equals(reString))
			{

				Integer res = Integer.valueOf(reString);
				return res;
			}
			return 0;
		} catch (Exception e)
		{
			return 0;
		}

	}

	/**
	 * 较好的答案
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse2(int x)
	{
		int res = 0;
		while (x != 0)
		{
			// 每次取末尾数字
			int tmp = x % 10;
			// 判断是否 大于 最大32位整数
			if (res > 214748364 || (res == 214748364 && tmp > 7))
			{
				return 0;
			}
			// 判断是否 小于 最小32位整数
			if (res < -214748364 || (res == -214748364 && tmp < -8))
			{
				return 0;
			}
			res = res * 10 + tmp;
			x /= 10;
		}
		return res;
	}

}
