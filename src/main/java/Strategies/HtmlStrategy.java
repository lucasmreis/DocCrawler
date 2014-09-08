package Strategies;

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
		Document page = Jsoup.connect(this.url).get();

		Optional<String> author = page.getElementsByTag("meta").stream()
				.filter(e -> e.attr("name").equals("author"))
				.map(e -> e.attr("content"))
				.findFirst();

		CrawledDoc doc = CrawledDocBuilder.newCrawledDoc()
				.withSource("Html")
				.withTitle(page.title())
				.withAuthor(author.isPresent() ? author.get() : "< no author >")
				.withLink(page.baseUri())
				.withContent(page.body().text())
				.withDate(DateTime.now())
				.create();

		ArrayList<CrawledDoc> docs = new ArrayList<>();
		docs.add(doc);
		return docs;
	}
}
