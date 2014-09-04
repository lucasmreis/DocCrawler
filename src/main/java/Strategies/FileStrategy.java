package Strategies;

import Engines.FileEngine;
import Models.CrawledDoc;
import Helpers.PathHelper;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
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
		List<Path> paths = new PathHelper().getValidPaths(Paths.get(path));
		return paths.stream()
				.filter(p -> p.toString().endsWith(".txt"))
				.map(p -> engine.getCrawledDoc(p.toString()))
				.collect(Collectors.toList());
	}
}
