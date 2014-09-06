package Strategies;

import Engines.RssEngine;
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
	private String url;

	public RssStrategy(String url) {
		this.url = url;
	}

	public ArrayList<CrawledDoc> getCrawledDocs() throws IOException, FeedException {
		URL feedUrl = new URL(url);

		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(feedUrl));

		ArrayList<SyndEntry> entries = (ArrayList<SyndEntry>) feed.getEntries();

		ArrayList<CrawledDoc> docs = new ArrayList<>();
		RssEngine engine = new RssEngine();
		for (int i = 0; i < 10; i++)
		{
			docs.add(engine.getCrawledDoc(entries.get(i)));
		}
		return docs;
	}
}
