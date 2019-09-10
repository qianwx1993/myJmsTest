package com.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * @Version 1.0
 * @Since JDK1.7
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/5/29 14:15
 */
public class FileStreamTest {
	public static void main(String[] args) {
		//test1();
		test2();
	}

	/**
	 * test.txt，文本编码为ANSI
	 * test.txt文本内容为：321爱就像蓝天白云，晴空万里，突然暴风雨！
	 */
	public static void test1(){
		File file = new File("D:\\WorkSpace\\exerciseIDEA\\teamWorkSpace\\forotc-github\\" +
				"myJmsTest\\src\\main\\resources\\test.txt");

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte bytes[]=new byte[1024];

			int len = fileInputStream.read(bytes);

			//此处只读取了文件的前4个字节
			System.out.println("文件内容："+new String(bytes,0,1));
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	public static void test2(){
		File file = new File("D:\\WorkSpace\\exerciseIDEA\\teamWorkSpace\\forotc-github\\" +
				"myJmsTest\\src\\main\\resources\\test.txt");

		try {
			FileReader fileReader = new FileReader(file);
			char[] chars = new char[1024];
			int hasread=-1;
			//hasread表示文本中的字符数
			while ((hasread=fileReader.read(chars))!=-1){
				System.out.println("文件内容是："+new String(chars,0,5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
