package Strategies;

import Engines.TwitterEngine;
import Models.CrawledDoc;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/8/14.
 */
public class TwitterStrategy implements IConvertingStrategy {
	private String searchQuery;

	public TwitterStrategy(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public ArrayList<CrawledDoc> getCrawledDocs() throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("JMWYgebyxVxopVQgZPIc42wvE")
				.setOAuthConsumerSecret("QMXyJMhXuQfi0TPLiPKQLm5rxY2BUQUMaSklO1L5IYrFB7iLCw")
				.setOAuthAccessToken("2511073098-RKUO3pZzeeapLctVbMGCUm9EQuLCWXtDQqQE7CL")
				.setOAuthAccessTokenSecret("zZkkFhd5cmfed2oy81oulv5blgl11hNGMgAZ0tk6uremJ");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		Query query = new Query(this.searchQuery);
		QueryResult result = twitter.search(query);

		TwitterEngine engine = new TwitterEngine();
		ArrayList<CrawledDoc> docs = new ArrayList<>();
		for (Status status : result.getTweets())
		{
			docs.add(engine.getCrawledDoc(status));
		}
		return docs;
	}
}
