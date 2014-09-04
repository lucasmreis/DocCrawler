package Persistence;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersistenceLayerTest extends TestCase {
	@Test
	public void testPersistenceHasToAddProperly() {
		CrawledDoc doc = CrawledDocBuilder.newCrawledDoc()
				.withAuthor("author")
				.withContent("content")
				.withDate(DateTime.now())
				.withLink("link")
				.withSource("source")
				.withTitle("title")
				.withId_document("IMPORTANT_ID")
				.create();

		PersistenceLayer db = new PersistenceLayer();
		String actual = db.Add(doc);

		assertThat(actual).isEqualTo(doc.getId_document());
	}
}