package Strategies;

import java.util.ArrayList;
import Models.CrawledDoc;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class RssStrategyTest extends TestCase {
	@Test
	public void testRssStrategyHasToWorkWithSampleRss() throws Exception {
		IConvertingStrategy strategy = new RssStrategy("http://www.rss-specifications.com/blog-feed.xml");
		ArrayList<CrawledDoc> docs = strategy.getCrawledDocs();

		CrawledDoc firstDoc = docs.get(0);

		assertThat(firstDoc.getTitle()).isEqualTo("Do CEOs Use Social Media?");
		assertThat(firstDoc.getLink()).isEqualTo("http://www.rss-specifications.com/blog.htm#1840");
		assertThat(firstDoc.getDate()).isEqualTo(new DateTime(2014, 9, 19, 9+1, 0, 0)); // + 1 por TimeZone
	}
}