package Strategies;

import Models.CrawledDoc;
import junit.framework.TestCase;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class HtmlStrategyTest extends TestCase {
	@Test
	public void testHtmlStrategyHasToWorkProperly() throws Exception {
		HtmlStrategy strategy = new HtmlStrategy("http://lucasmreis.github.io/TestPageForCrawler/", "0");
		CrawledDoc doc = strategy.getCrawledDocs().get(0);

		assertThat(doc.getLink()).isEqualTo("http://lucasmreis.github.io/TestPageForCrawler/index.html");
		assertThat(doc.getAuthor()).isEqualTo("Sample Author");
		assertThat(doc.getTitle()).isEqualTo("Sample Title");
		assertThat(doc.getContent()).isEqualTo("This document has only text on its body and a link.");
	}
}