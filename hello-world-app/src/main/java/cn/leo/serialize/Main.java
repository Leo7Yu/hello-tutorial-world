package cn.leo.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Map<String,Integer> map=new HashMap<>();
		map.put("leo", 29);
		map.put("yanyan", 22);
		
		ObjectOutputStream fileOutput=new ObjectOutputStream(new FileOutputStream("/data/mytest"));
		fileOutput.writeObject(map);
		fileOutput.flush();
		fileOutput.close();
		
		ObjectInputStream fileInput=new ObjectInputStream(new FileInputStream("/data/mytest"));
		@SuppressWarnings("unchecked")
		Map<String,Integer> newMap=(Map<String, Integer>) fileInput.readObject();
		System.out.println(newMap.get("leo"));
		fileInput.close();
		
	}
}
