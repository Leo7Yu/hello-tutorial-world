package cn.leo.comparable;

import java.io.Serializable;

import lombok.Getter;

/** 
 * @author LeoYu 
 * @date 2016年11月9日 下午6:23:38 
 * 
 */
@Getter
public class Person implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;

    public Person(int age) {
        this.age=age;
    }
    
    public Person(){
    	
    }

}
