package Strategies;

import Models.CrawledDoc;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

public class GmailStrategyTest extends TestCase {
	@Test
	public void testGmailStrategyHasToAccessDummyAccount() throws Exception {
		GmailStrategy strategy = new GmailStrategy("testusertestuser854", "1234!@#$qwerQWER");
		ArrayList<CrawledDoc> docs = strategy.getCrawledDocs();

		assertThat(docs.get(0).getAuthor()).isEqualTo("Equipe do Gmail");
		assertThat(docs.get(0).getContent().substring(0, 3)).isEqualTo("Olá,");
	}
}