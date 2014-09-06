package Strategies;

import Engines.FileEngine;
import Models.CrawledDoc;
import Helpers.PathHelper;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
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

	public ArrayList<CrawledDoc> getCrawledDocs() throws IOException {
		FileEngine engine = new FileEngine();
		ArrayList<Path> paths = null;
		paths = new PathHelper().getValidPaths(Paths.get(path));

		ArrayList<CrawledDoc> docs = new ArrayList<>();
		for (Path p : paths)
		{
			if (p.toString().endsWith(".txt")) // TODO: worst way of solving it!
				docs.add(engine.getCrawledDoc(p.toString()));
		}
		return docs;
	}
}
