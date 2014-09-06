package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import org.joda.time.DateTime;

/**
 * Created by lucasmreis on 9/5/14.
 */
public class RssEngine {
	public CrawledDoc getCrawledDoc(SyndEntry entry)
	{
		return CrawledDocBuilder.newCrawledDoc()
				.withSource("Rss Feed")
				.withAuthor(entry.getAuthor())
				.withLink(entry.getLink())
				.withTitle(entry.getTitle())
				.withContent(((SyndContentImpl)entry.getContents().get(0)).getValue())
						.withDate(new DateTime())
						.create();
	}
}
