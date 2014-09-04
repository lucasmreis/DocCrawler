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
	public String Add(CrawledDoc doc) throws SQLException, ClassNotFoundException {
		String dbURL = "jdbc:mysql://localhost:3306/crawler";
		String username ="newuser";
		String password = "password";

		Connection dbCon;
		Statement stmt;
		int rs;

		String insertQuery = insertQuery(doc);

		Class.forName("com.mysql.jdbc.Driver");

		dbCon = DriverManager.getConnection(dbURL, username, password);
		stmt = dbCon.prepareStatement(insertQuery);
		rs = stmt.executeUpdate(insertQuery);

		String result = (rs > 0) ? doc.getId_document() : null;

		stmt.close();
		dbCon.close();
		return result;
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
