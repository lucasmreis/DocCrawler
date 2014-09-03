package Strategies;

import Engines.FileEngine;
import Models.CrawledDoc;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FileStrategyTest extends TestCase {
	String path = "./test-files-dir/";
	List<String> filenames = Arrays.asList(path + "test1.txt", path + "test2.txt");
	String contents = "Text to test.\nAnother line.";

	FileStrategy strategy;

	@Before
	public void setUp() throws IOException {
		createTestFiles();
		filenames.forEach(f -> assertThat(Files.exists(Paths.get(f))).isTrue());

		strategy = new FileStrategy(path, "1");
	}

	private void createTestFiles() throws IOException {
		java.nio.file.Files.createDirectory(Paths.get(path));
		for (String f : filenames)
		{
			java.nio.file.Files.write(Paths.get(f), contents.getBytes());
		}
	}

	@Test
	public void testFileStrategyIsWorking() {
		strategy.getCrawledDocs()
				.forEach(d -> {
					assertThat(d).isNotNull();
					assertThat(d).isOfAnyClassIn(CrawledDoc.class);
					assertThat(d.getContent()).isEqualTo(contents);
				});
	}

	@After
	public void tearDown() throws IOException {
		for (String f : filenames)
		{
			java.nio.file.Files.delete((Paths.get(f)));
		}
		java.nio.file.Files.delete(Paths.get(path));

		filenames.forEach(f -> assertThat(Files.notExists(Paths.get(f))));
		assertThat(Files.notExists(Paths.get(path)));
	}
}