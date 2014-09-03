package Strategies;

import Models.CrawledDoc;

import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/3/14.
 */
public interface IParsingStrategy {
	public ArrayList<CrawledDoc> getCrawledDocs();
}
