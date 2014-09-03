import org.joda.time.DateTime;

public class CrawledDocBuilder {
	private String id_document;
	private String title;
	private String content;
	private String author;
	private DateTime date;
	private String link;
	private String source;

	public CrawledDocBuilder setId_document(String id_document) {
		this.id_document = id_document;
		return this;
	}

	public CrawledDocBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public CrawledDocBuilder setContent(String content) {
		this.content = content;
		return this;
	}

	public CrawledDocBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public CrawledDocBuilder setDate(DateTime date) {
		this.date = date;
		return this;
	}

	public CrawledDocBuilder setLink(String link) {
		this.link = link;
		return this;
	}

	public CrawledDocBuilder setSource(String source) {
		this.source = source;
		return this;
	}

	public CrawledDoc createCrawledDoc() {
		return new CrawledDoc(id_document, title, content, author, date, link, source);
	}
}