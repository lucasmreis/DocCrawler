package Strategies;

import Models.CrawledDoc;

import java.io.IOException;
import java.util.List;

/**
 * Created by lucasmreis on 9/3/14.
 */
public interface IConvertingStrategy {
	public List<CrawledDoc> getCrawledDocs() throws IOException;
}
