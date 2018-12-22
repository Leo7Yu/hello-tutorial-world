package cn.leo.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File filePath = new File("/aliyun/upload/proxy/image/store/business/");
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		System.out.println("---");

		String url = "/aliyun/upload/proxy/image/store/business/" + System.currentTimeMillis() + ".txt";
		FileWriter fw = new FileWriter(url, true);
		BufferedWriter writer = new BufferedWriter(fw);
		writer.write("ssss\n");
		writer.write("12223332\n");
		writer.close();
		fw.close();

		BufferedReader reader = new BufferedReader(new FileReader(url));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}

}
