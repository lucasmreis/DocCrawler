package Helpers;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PathHelperTest extends TestCase {
	String path = "./test-files-dir/";
	List<String> filenames = Arrays.asList(path + "test1.txt", path + "test2.txt", path + "test.pdf");
	String contents = "Text to test.\nAnother line.";

	@Before
	public void setUp() throws IOException {
		createTestFiles();
	}

	private void createTestFiles() throws IOException {
		java.nio.file.Files.createDirectory(Paths.get(path));
		for (String f : filenames)
		{
			java.nio.file.Files.write(Paths.get(f), contents.getBytes());
		}
	}

	@Test
	public void testCheckIfFilesAreCreated()
	{
		assertThat(filenames).hasSize(3);
		filenames.forEach(f -> assertThat(Files.exists(Paths.get(f))).isTrue());
	}

	@Test
	public void testHelperHasToRetriveAllPaths() throws IOException {
		PathHelper helper = new PathHelper();
		List<Path> paths = helper.getValidPaths(Paths.get(path));
		assertThat(paths).hasSize(3);

		String firstFile = (String)filenames.toArray()[0];
		assertThat(Paths.get(firstFile)).isIn(paths);
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