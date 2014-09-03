package Strategies;

import Engines.FileEngine;
import Models.CrawledDoc;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by lucasmreis on 9/3/14.
 */
public class FileStrategy implements IConvertingStrategy {
	private String path;
	private int depth;

	public FileStrategy(String path, String depth)
	{
		this.path = path;
		this.depth = Integer.parseInt(depth);
	}

	public List<CrawledDoc> getCrawledDocs() throws IOException {
		FileEngine engine = new FileEngine();
		List<Path> paths = getValidPaths(Paths.get(path));
		return paths.stream()
				.filter(p -> p.endsWith(".txt"))
				.map(p -> engine.getCrawledDoc(p.toString()))
				.collect(Collectors.toList());
	}

	private List<Path> getValidPaths(Path path) throws IOException {
		List<Path> paths = new ArrayList<Path>();
		DirectoryStream dir = Files.newDirectoryStream(path);
		for (Object o : dir)
		{
			Path p = (Path)o;
			if (Files.isDirectory(p)) paths.addAll(getValidPaths(p));
			else paths.add(p);
		}
		return paths;
	}
}
