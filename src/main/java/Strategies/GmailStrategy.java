package Strategies;

import Models.CrawledDoc;

import java.util.ArrayList;

/**
 * Created by lucasmreis on 9/7/14.
 */
public class GmailStrategy implements IConvertingStrategy{
	private String username;
	private String password;

	public GmailStrategy(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public ArrayList<CrawledDoc> getCrawledDocs() throws Exception {
		
		return null;
	}
}
