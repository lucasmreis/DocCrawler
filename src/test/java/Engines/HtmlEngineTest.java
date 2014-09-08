package Engines;

import Models.CrawledDoc;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HtmlEngineTest extends TestCase {
	@Test
	public void testHtmlEngineHasToWorkProperly() throws IOException {
		HtmlEngine engine = new HtmlEngine();
		CrawledDoc doc = engine.getCrawledDoc("http://lucasmreis.github.io/TestPageForCrawler/");

		assertThat(doc.getLink()).isEqualTo("http://lucasmreis.github.io/TestPageForCrawler/");
		assertThat(doc.getAuthor()).isEqualTo("Sample Author");
		assertThat(doc.getTitle()).isEqualTo("Sample Title");
		assertThat(doc.getContent()).isEqualTo("This document has only text on its body and a link.");
	}
}