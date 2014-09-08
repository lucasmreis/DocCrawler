package Strategies;

import Engines.HtmlEngine;
import Models.CrawledDoc;

import Models.CrawledDocBuilder;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.ArrayList;
import java.util.Optional;

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
		HtmlEngine engine = new HtmlEngine();
		ArrayList<CrawledDoc> docs = new ArrayList<>();
		docs.add(engine.getCrawledDoc(this.url));
		return docs;
	}
}
