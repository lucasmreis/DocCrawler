package App;

import Models.CrawledDoc;
import Persistence.PersistenceLayer;
import Strategies.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/3/14.
 */
public class Application {
	public static void main(String [] args) {
		IConvertingStrategy strategy;
		switch (args[0]) {
			case "file":
				strategy = new FileStrategy(args[1], args[2]);
				break;
			case "rss":
				strategy = new RssStrategy(args[1]);
				break;
			case "gmail":
				strategy = new GmailStrategy(args[1], args[2]);
				break;
			case "html":
				strategy = new HtmlStrategy(args[1], args[2]);
				break;
			case "twitter":
				strategy = new TwitterStrategy(args[1]);
				break;
			default:
				System.out.println("Invalid source: " + args[0]);
				return;
		}
		PersistenceLayer db = new PersistenceLayer();
		ArrayList<String> ids = null;
		try {
			ids = crawlAndSave(strategy, db);
			System.out.println("Crawled!\nDocuments inserted:");
			ids.forEach(i -> System.out.println(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> crawlAndSave(IConvertingStrategy strategy, PersistenceLayer db) throws Exception {
		ArrayList<String> ids = new ArrayList<>();

		ArrayList<CrawledDoc> docs;

		docs = strategy.getCrawledDocs();

		for (CrawledDoc doc : docs)
		{
			ids.add(db.Add(doc));
		}
		return ids;
	}
}