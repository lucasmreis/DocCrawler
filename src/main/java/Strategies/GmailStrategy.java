package Strategies;

import Engines.GmailEngine;
import Models.CrawledDoc;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
		Properties prop = new Properties();
		prop.setProperty("mail.store.protocol", "imaps");
		Session session = Session.getInstance(prop, null);
		Store store = session.getStore();
		store.connect("imap.gmail.com", this.username + "@gmail.com", this.password);
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);
		Message[] messages = inbox.getMessages();

		GmailEngine engine = new GmailEngine();
		ArrayList<CrawledDoc> docs = new ArrayList<>();
		for (Message message : messages) {
			docs.add(engine.getCrawledDoc(message));
		}
		return docs;
	}
}
