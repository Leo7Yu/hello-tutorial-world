package cn.leo.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.leo.jdk8.pojo.Artist;

public class StreamMain {

	public static void main(String[] args) {
		List<Artist> allArtists = createArtist();
		
		List<String> collected=Stream.of("a","b").map(string->string.toUpperCase()).collect(Collectors.toList());

		int total = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
		
		
		Optional<Artist> emptyOptional=Optional.empty();
		Artist artist1=emptyOptional.orElseGet(()->allArtists.get(0));
		
		
		Optional<Artist> optional=Optional.of(allArtists.get(0));
		
		System.out.println(emptyOptional.isPresent()+":"+optional.isPresent());
		
		allArtists.stream().forEach(artist -> {
			artist.setName("N" + System.currentTimeMillis());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			System.out.println(artist.getName());
		});

		long count = allArtists.stream().filter(artist -> artist.isFrom("shunyi")).count();

		System.out.println(count);
	}

	private static List<Artist> createArtist() {
		List<Artist> allArtists = new ArrayList<>();
		Artist artist = new Artist();
		artist.setOrigin("shunyi");
		allArtists.add(artist);
		artist = new Artist();
		artist.setOrigin("chaoyang");
		allArtists.add(artist);
		return allArtists;
	}

}
