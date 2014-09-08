package Strategies;

import Models.CrawledDoc;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class HtmlStrategyTest extends TestCase {
	@Test
	public void testHtmlStrategyHasToWorkProperly() throws Exception {
		HtmlStrategy strategy = new HtmlStrategy("http://lucasmreis.github.io/TestPageForCrawler/", "2");
		ArrayList<CrawledDoc> docs = strategy.getCrawledDocs();
		assertThat(docs.size()).isEqualTo(3);
	}
}