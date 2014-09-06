package Engines;

import Models.CrawledDoc;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import junit.framework.TestCase;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class RssEngineTest extends TestCase {
	@Test
	public void testRssEngineHasToWorkProperly() {
		SyndEntry entry = new SyndEntryImpl();
		entry.setAuthor("author");
		entry.setLink("link");
		entry.setTitle("title");

		SyndContent content = new SyndContentImpl();
		content.setType("text/plain");
		content.setValue("contents\ncontents");
		entry.setContents(Arrays.asList(content));
		entry.setDescription(content);


		RssEngine engine = new RssEngine();

		CrawledDoc doc = engine.getCrawledDoc(entry);

		assertThat(doc).isNotNull();
		assertThat(doc.getId_document()).isNotNull();
		assertThat(doc.getId_document()).isNotEmpty();
		assertThat(doc.getTitle()).isEqualTo("title");
		assertThat(doc.getLink()).isEqualTo("link");
		assertThat(doc.getAuthor()).isEqualTo("author");
		assertThat(StringEscapeUtils.unescapeHtml4(doc.getContent())).isEqualTo("contents\ncontents");
	}
}