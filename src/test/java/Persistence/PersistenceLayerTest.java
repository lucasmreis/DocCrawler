package Persistence;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class PersistenceLayerTest extends TestCase {
	@Test
	public void testMustBuildCorrectInsertQuery() {
		CrawledDoc doc = CrawledDocBuilder.newCrawledDoc()
				.withAuthor("author")
				.withContent("content")
				.withDate(new DateTime(1982, 11, 17, 12, 00))
				.withLink("link")
				.withSource("source")
				.withTitle("title")
				.withId_document("IMPORTANT_ID")
				.create();

		PersistenceLayer db = new PersistenceLayer();
		String query = db.insertQuery(doc);

		assertThat(query).isEqualTo(
				"INSERT INTO `document` (`id_document`, `title`, `content`, `author`, `date`, `link`, `source`) " +
				"VALUES ( \"IMPORTANT_ID\", \"title\", \"content\", \"author\", \"1982-11-17\", \"link\", \"source\");"
		);
	}

	@Test
	public void testPersistenceHasToAddProperly() throws SQLException, ClassNotFoundException {
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