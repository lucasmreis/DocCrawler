package Strategies;

import Models.CrawledDoc;

import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/3/14.
 */
public class FileStrategy implements IParsingStrategy {
	private String path;
	private int depth;

	public FileStrategy(String path, String depth)
	{
		this.path = path;
		this.depth = Integer.parseInt(depth);
	}

	public ArrayList<CrawledDoc> getCrawledDocs() {
		return null;
	}
}
