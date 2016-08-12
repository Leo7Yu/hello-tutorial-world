package cn.leo.generic;

import java.io.Serializable;

public class Fruit<T extends Object & Serializable> {
	
	public Fruit(){
		super();
	}
	
	public <L> Fruit(L info){
		
	}
	
	public <K,J> K getName(T myT,J myJ){
		K myK=null;
		return myK; 
	}
	
	public static void main(String[] args) {
		Fruit<String> fruit=new Fruit<>();
		
		Integer myName=fruit.getName("test",12);
		System.out.println(myName);
	}
}
