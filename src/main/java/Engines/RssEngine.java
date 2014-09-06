package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import org.joda.time.DateTime;

import java.util.Optional;

/**
 * Created by lucasmreis on 9/5/14.
 */
public class RssEngine {
	public CrawledDoc getCrawledDoc(SyndEntry entry)
	{
		Optional<SyndContent> content = entry.getContents().stream()
				.filter(c -> ((SyndContentImpl)c).getType().equals("text/plain"))
				.findFirst();

		return CrawledDocBuilder.newCrawledDoc()
				.withSource("Rss Feed")
				.withAuthor(entry.getAuthor())
				.withLink(entry.getLink())
				.withTitle(entry.getTitle())
				.withContent(content.isPresent() ? content.get().getValue() : "< no contents >")
				.withDate(new DateTime())
				.create();
	}
}
