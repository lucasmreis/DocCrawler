package Strategies;

import Models.CrawledDoc;
import junit.framework.TestCase;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

public class GmailStrategyTest extends TestCase {
	@Test
	public void testGmailStrategyHasToAccessDummyAccount() throws Exception {
		GmailStrategy strategy = new GmailStrategy("testusertestuser854", "qwerQWER");
		ArrayList<CrawledDoc> docs = strategy.getCrawledDocs();

		assertThat(docs.get(0).getAuthor().substring(0, 15))
				.isEqualTo("Equipe do Gmail");
//		assertThat(StringEscapeUtils.unescapeHtml4(docs.get(0).getContent().substring(0, 3)))
//				.isEqualTo("Olá,");
	}
}