package Models;

/**
 * Created by lucasmreis on 9/2/14.
 */
import org.joda.time.DateTime;

public class CrawledDoc {
	private String id_document;
	private String title;
	private String content;
	private String author;
	private DateTime date;
	private String link;
	private String source;

	public CrawledDoc(
			String id_document,
			String title,
			String content,
			String author,
			DateTime date,
			String link,
			String source)
	{
		this.id_document = id_document;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.link = link;
		this.source = source;
	}

	public String getId_document() {
		return id_document;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public DateTime getDate() {
		return date;
	}

	public String getLink() {
		return link;
	}

	public String getSource() {
		return source;
	}
}
