package cn.leo.jdk8.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album {
	private String name;
	private List<Track> tracks;
	private List<String> musicians;
}
