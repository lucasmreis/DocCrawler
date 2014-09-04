package App;

import Models.CrawledDoc;
import Strategies.FileStrategy;
import Strategies.IConvertingStrategy;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/3/14.
 */
public class Application {
	public static void main(String [] args) {
		IConvertingStrategy strategy;
		if (args[0].equals("file"))
			strategy = new FileStrategy(args[1], args[2]);
		else {
			System.out.println("Invalid source: " + args[0]);
			return;
		}
		ArrayList<String> ids = crawlAndSave(strategy);
		System.out.println("Crawled!\nDocuments inserted:");
		ids.forEach(i -> System.out.println(i));
	}

	public static ArrayList<String> crawlAndSave(IConvertingStrategy strategy)
	{
		try {
			ArrayList<CrawledDoc> docs;

			docs = strategy.getCrawledDocs();

			// pequeno teste: digitar gradle run -Pargs="file ./ 1"
			System.out.println(docs.get(0).getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}