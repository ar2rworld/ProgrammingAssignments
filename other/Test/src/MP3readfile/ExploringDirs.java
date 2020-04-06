package MP3readfile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExploringDirs {
	static ArrayList<String> dirs;
	public static void main(String[] args) {
		try (Stream<Path> walk = Files.walk(Paths.get("C:\\data"))) {

			List<String> result = walk.filter(Files::isDirectory)
					.map(x -> x.toString()).collect(Collectors.toList());

			//result.forEach(System.out::println);
			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void getListOfFiles(String s) {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		System.out.println(dirs);
		try (Stream<Path> walk = Files.walk(Paths.get(s))) {

			List<String> result = walk.map(x -> x.toString())
					.filter(f -> f.endsWith(".mp3")).collect(Collectors.toList());

			result.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
