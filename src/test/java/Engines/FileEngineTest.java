package Engines;

import Models.CrawledDoc;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class FileEngineTest extends TestCase {
	private final String filename = "./test-file.txt";
	private final String contents = "text to test.";

	private FileEngine engine;

	@Before
	public void setUp() throws IOException {
		createTestFile();

		assertThat(Files.exists(Paths.get(filename))).isTrue();

		engine = new FileEngine(filename);
	}

	private void createTestFile() throws IOException {
		java.nio.file.Files.write(Paths.get(filename), contents.getBytes());
	}

	@Test
	public void testFileEngineGetCrawledDocMustWorkWithDummyTextFile() throws Exception {
		CrawledDoc actual = engine.getCrawledDoc();

		assertThat(actual).isNotNull();
		assertThat(actual).isOfAnyClassIn(CrawledDoc.class);
		assertThat(actual.getContent()).isEqualTo(contents);
	}

	@After
	public void tearDown() throws IOException {
		java.nio.file.Files.delete(Paths.get(filename));

		assertThat(Files.notExists(Paths.get(filename))).isTrue();
	}
}