package Models;

import org.joda.time.DateTime;

import java.util.UUID;

public class CrawledDocBuilder {
	private String id_document;
	private String title;
	private String content;
	private String author;
	private DateTime date;
	private String link;
	private String source;

	private CrawledDocBuilder() {
	}

	public static CrawledDocBuilder newCrawledDoc() {
		return new CrawledDocBuilder();
	}

	public CrawledDocBuilder withId_document(String id_document) {
		this.id_document = id_document;
		return this;
	}

	public CrawledDocBuilder withTitle(String title) {
		this.title = title.substring(0, Math.min(title.length(), 799));
		return this;
	}

	public CrawledDocBuilder withContent(String content) {
		this.content = content.substring(0, Math.min(content.length(), 21799));
		return this;
	}

	public CrawledDocBuilder withAuthor(String author) {
		this.author = author.substring(0, Math.min(author.length(), 399));
		return this;
	}

	public CrawledDocBuilder withDate(DateTime date) {
		this.date = date;
		return this;
	}

	public CrawledDocBuilder withLink(String link) {
		this.link = link.substring(0, Math.min(link.length(), 799));
		return this;
	}

	public CrawledDocBuilder withSource(String source) {
		this.source = source.substring(0, Math.min(source.length(), 399));
		return this;
	}

	public CrawledDoc create() {
		if (id_document == null || id_document.isEmpty())
			id_document = String.valueOf(UUID.randomUUID()).substring(0, 31);
		return new CrawledDoc(id_document, title, content, author, date, link, source);
	}
}