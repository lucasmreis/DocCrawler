package Strategies;

import Models.CrawledDoc;

import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/7/14.
 */
public class HtmlStrategy implements IConvertingStrategy {
	private String url;
	private int depth;

	public HtmlStrategy(String url, String depth) {
		this.url = url;
		this.depth = Integer.parseInt(depth);
	}

	public ArrayList<CrawledDoc> getCrawledDocs() throws Exception {
		return null;
	}
}
