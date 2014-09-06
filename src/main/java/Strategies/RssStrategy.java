package Strategies;

import Models.CrawledDoc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.net.URL;
import java.io.InputStreamReader;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.sun.syndication.io.FeedException;

/**
 * Created by lucasmreis on 9/5/14.
 */
public class RssStrategy implements IConvertingStrategy {
	public ArrayList<CrawledDoc> getCrawledDocs() throws IOException, FeedException {
		URL feedUrl = null;
		feedUrl = new URL("http://rss.cnn.com/rss/cnn_topstories.rss");

		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(feedUrl));

		//ArrayList<SyndEntry> entries = feed.getCachedSyndFeed().getEntries();

		return new ArrayList<>();
	}
}
