package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import org.joda.time.DateTime;
import twitter4j.Status;

/**
 * Created by lucasmreis on 9/8/14.
 */
public class TwitterEngine {
	public CrawledDoc getCrawledDoc(Status status)
	{
		return CrawledDocBuilder.newCrawledDoc()
				.withSource("Twitter")
				.withAuthor(status.getUser().getName())
				.withTitle("< no title >")
				.withLink("https://twitter.com/" +
						status.getUser().getScreenName() + "/status/" +
						Long.toString(status.getId()))
				.withContent(status.getText())
				.withDate(new DateTime(status.getCreatedAt()))
				.create();
	}
}
