package Strategies;

import Engines.HtmlEngine;
import Models.CrawledDoc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
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
		docs.addAll(getCrawledDocsDepth(this.url, this.depth, engine));
		return docs;
	}

	private ArrayList<CrawledDoc> getCrawledDocsDepth(String url, int depth, HtmlEngine engine) throws IOException {
		if (depth < 0) return new ArrayList<>();

		ArrayList<CrawledDoc> docs = new ArrayList<>();
		docs.add(engine.getCrawledDoc(url));

		if (depth > 0) {
			Document page = Jsoup.connect(url).get();
			Elements links = page.select("a[href]");
			for (Element e : links) {
				String href = e.attr("abs:href");
				if (href.substring(href.length() - 4).equals("html"))
					docs.addAll(getCrawledDocsDepth(href, depth - 1, engine));
			}
		}
		return docs;
	}
}
