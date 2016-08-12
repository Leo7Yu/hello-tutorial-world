package cn.leo.proxy.cglib;

public class Person {

	public String active(String activeName){
		System.out.println("person do:"+activeName);
		return activeName+" have done.";
	}
}
