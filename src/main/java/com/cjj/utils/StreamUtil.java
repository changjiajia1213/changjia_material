package com.cjj.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StreamUtil
 * @Description: 流的工具类
 * @author: changjiajia
 */
public class StreamUtil {
	// 按行读取文本文件
	public static List<String> readLine(InputStream ips) {
		List<String> list = new ArrayList<String>();
		// 读取文本文件
		String readLine;
		try {
			Reader reader = new InputStreamReader(ips, "utf-8");
			BufferedReader bf = new BufferedReader(reader);
			readLine = bf.readLine();
			while (readLine != null) {
				list.add(readLine);
				readLine = bf.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 
	 * @Title: close
	 * @Description: 关闭多个流对象
	 * @param autoCloseables
	 * @return: void
	 */
	public static void close(AutoCloseable... autoCloseables) {
		// 如果不为空
		if (autoCloseables != null) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @Title: readTextFile
	 * @Description: 按照字节流读取文件
	 * @param file
	 * @return
	 * @return: String
	 */
	public static String readTextFile(File file) {
		StringBuffer sb = new StringBuffer();
		InputStream ips = null;
		try {
			ips = new FileInputStream(file);
			byte[] b = new byte[1024];
			// 读取b.length个字节
			int read = ips.read(b);
			while (read != -1) {
				sb.append(new String(b));
				read = ips.read();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ips);
		}

		return sb.toString();
	}

	public static String readTextFile(String fileName) {
		return readTextFile(new File(fileName));
	}

	public static void writeTextFile(String content, File file) {
		// e:/aa/bb/aa.txt
		String parent = file.getParent();// e:/aa/bb
		// 父目录 文件夹
		File parentFile = new File(parent);
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		// 写到文件
		Writer fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw, fw);
		}

	}
}
