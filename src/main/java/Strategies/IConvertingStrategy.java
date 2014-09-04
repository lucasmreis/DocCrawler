package Strategies;

import Models.CrawledDoc;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/3/14.
 */
public interface IConvertingStrategy {
	public ArrayList<CrawledDoc> getCrawledDocs() throws IOException;
}
