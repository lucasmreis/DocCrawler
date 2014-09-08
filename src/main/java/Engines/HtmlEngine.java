package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by lucasmreis on 9/7/14.
 */
public class HtmlEngine {
	public CrawledDoc getCrawledDoc(String url) throws IOException {
		Document page = Jsoup.connect(url).get();

		Optional<String> author = page.getElementsByTag("meta").stream()
				.filter(e -> e.attr("name").equals("author"))
				.map(e -> e.attr("content"))
				.findFirst();

		return CrawledDocBuilder.newCrawledDoc()
				.withSource("Html")
				.withTitle(page.title())
				.withAuthor(author.isPresent() ? author.get() : "< no author >")
				.withLink(page.baseUri())
				.withContent(page.body().text())
				.withDate(DateTime.now())
				.create();
	}
}
