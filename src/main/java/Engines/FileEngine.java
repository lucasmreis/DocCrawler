package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by lucasmreis on 9/3/14.
 */
public class FileEngine {
	public CrawledDoc getCrawledDoc(String path) throws IOException {
		String contents;
		contents = Files
				.lines(Paths.get(path))
				.collect(Collectors.joining("\n"));

		return CrawledDocBuilder.newCrawledDoc()
				.withSource("Local File")
				.withLink(path)
				.withContent(contents)
				.withDate(new DateTime())
				.create();
	}
}
