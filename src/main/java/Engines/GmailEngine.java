package Engines;

import Models.CrawledDoc;
import Models.CrawledDocBuilder;
import org.apache.commons.lang3.StringEscapeUtils;
import org.joda.time.DateTime;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import java.io.IOException;

/**
 * Created by lucasmreis on 9/7/14.
 */
public class GmailEngine {
	public CrawledDoc getCrawledDoc(Message message) throws MessagingException, IOException {
		return CrawledDocBuilder.newCrawledDoc()
				.withSource("Gmail")
				.withAuthor(message.getFrom()[0].toString())
				.withTitle(message.getSubject())
				.withDate(new DateTime(message.getSentDate()))
				.withContent(StringEscapeUtils.escapeHtml4(getText(message)))
				.create();
	}

	private String getText(Part p) throws MessagingException, IOException {
		if (p.isMimeType("text/*")) {
			String s = (String)p.getContent();
			return s;
		}

		if (p.isMimeType("multipart/alternative")) {
			// prefer html text over plain text
			Multipart mp = (Multipart)p.getContent();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) {
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) {
					if (text == null)
						text = getText(bp);
					continue;
				} else if (bp.isMimeType("text/html")) {
					String s = getText(bp);
					if (s != null)
						return s;
				} else {
					return getText(bp);
				}
			}
			return text;
		} else if (p.isMimeType("multipart/*")) {
			Multipart mp = (Multipart)p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getText(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}

		return null;
	}
}
