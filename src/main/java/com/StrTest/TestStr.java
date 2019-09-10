package com.StrTest;

/**
 * @Version 1.0
 * @Since JDK1.7
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/5/29 17:15
 */
public class TestStr {
	public static void main(String[] args) {
		String str = "abc";
		String str1 = "abc";
		String str2 = new String("abc");
		System.out.println(str == str1);
		System.out.println(str1 == "abc");
		System.out.println(str2 == "abc");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2.intern());
		System.out.println(str2 == str2.intern());
		System.out.println(str1.hashCode() == str2.hashCode());
	}
}
