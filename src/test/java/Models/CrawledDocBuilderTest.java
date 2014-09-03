package Models;

import junit.framework.TestCase;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CrawledDocBuilderTest extends TestCase {
	@Test
	public void testBuilderIsCreatingCrawlerDoc() {
		CrawledDoc created = CrawledDocBuilder.newCrawledDoc()
				.withContent("test content")
				.create();

		assertThat(created).isNotNull();
		assertThat(created).isOfAnyClassIn(CrawledDoc.class);
		assertThat(created.getContent()).isEqualTo("test content");
	}
}