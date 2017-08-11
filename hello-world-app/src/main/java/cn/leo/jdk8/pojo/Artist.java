package cn.leo.jdk8.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artist {
	private String name;
	private List<String> merbers;
	private String origin;
	
	public boolean isFrom(String origin){
		return this.origin.equals(origin);
	}
}
