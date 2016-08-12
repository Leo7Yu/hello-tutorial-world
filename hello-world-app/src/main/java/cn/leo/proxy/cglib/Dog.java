package cn.leo.proxy.cglib;

public class Dog implements IAnimal {

	@Override
	public String active(String activeName) {
		System.out.println("dog do:"+activeName);
		return activeName+" have done.";
	}

}
