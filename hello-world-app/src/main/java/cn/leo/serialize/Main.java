package cn.leo.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.leo.comparable.Person;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person person = new Person(10);
		ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream("/aliyun/mytest"));
		fileOutput.writeObject(person);
		fileOutput.flush();
		fileOutput.close();

		ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream("/aliyun/mytest"));
		Person newPerson = (Person) fileInput.readObject();
		System.out.println(newPerson.getAge());
		fileInput.close();

	}
}
