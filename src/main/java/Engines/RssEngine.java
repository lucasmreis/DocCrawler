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
				.withDate(new DateTime(entry.getPublishedDate()))
				.create();
	}