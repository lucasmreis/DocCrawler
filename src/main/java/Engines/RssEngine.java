package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import com.sun.syndication.feed.synd.SyndEntry;
import org.apache.commons.lang3.StringEscapeUtils;
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
				.withContent(StringEscapeUtils.escapeHtml4(entry.getDescription().getValue().toString()))
				.withDate(new DateTime())
				.create();
	}

//	private String FirstContentValue(ArrayList<SyndContentImpl> contents, String type)
//	{
//		String noContents = "< no contents >";
//		if (contents.isEmpty()) return noContents;
//		for (SyndContentImpl c : contents)
//		{
//			if (c.getType().contains(type)) return c.getValue().toString();
//		}
//		return noContents;
//	}
}
