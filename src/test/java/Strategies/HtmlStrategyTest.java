package Strategies;

import Models.CrawledDoc;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class HtmlStrategyTest extends TestCase {
	@Test
	public void testHtmlStrategyHasToWorkDepth1() throws Exception {
		HtmlStrategy strategy = new HtmlStrategy("http://lucasmreis.github.io/TestPageForCrawler/", "1");
		ArrayList<CrawledDoc> docs = strategy.getCrawledDocs();
		assertThat(docs.size()).isEqualTo(2);
	}

	@Test
	public void testHtmlStrategyHasToWorkDepth2() throws Exception {
		HtmlStrategy strategy = new HtmlStrategy("http://lucasmreis.github.io/TestPageForCrawler/", "2");
		ArrayList<CrawledDoc> docs = strategy.getCrawledDocs();
		assertThat(docs.size()).isEqualTo(3);
	}
}