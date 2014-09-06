package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import com.sun.syndication.feed.synd.SyndEntry;

/**
 * Created by lucasmreis on 9/5/14.
 */
public class RssEngine {
	public CrawledDoc getCrawledDoc(SyndEntry entry)
	{
		return null;
//				CrawledDocBuilder.newCrawledDoc()
//				.withSource("Rss Feed")
//				.withAuthor(entry.getAuthor())
//				.withLink(entry.getUri().toString())
//				.withTitle(entry.getTitle())
//				.withContent(entry.getContents())
	}
}
