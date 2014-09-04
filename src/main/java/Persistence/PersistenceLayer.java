package Persistence;

import Models.CrawledDoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lucasmreis on 9/4/14.
 */
public class PersistenceLayer {
	public String Add(CrawledDoc doc) throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/crawler";
		String username ="root";
		String password = "root";

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query = insertQuery(doc);

		//dbCon = DriverManager.getConnection(dbURL, username, password);



		return null; // TODO: return id_document if successful.
	}

	public String insertQuery(CrawledDoc doc)
	{
		return "INSERT INTO `document` (" +
				"`id_document`, " +
				"`title`, " +
				"`content`, " +
				"`author`, " +
				"`date`, " +
				"`link`, " +
				"`source`) " +
				"VALUES ( \"" +
				doc.getId_document() + "\", \"" +
				doc.getTitle() + "\", \"" +
				doc.getContent() + "\", \"" +
				doc.getAuthor() + "\", \"" +
				doc.getDate().toString("yyyy-MM-dd") + "\", \"" +
				doc.getLink() + "\", \"" +
				doc.getSource() + "\");";
	}
}
