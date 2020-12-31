package com.ss.sf.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.sf.lms.domain.Author;

public class AuthorDAO extends BaseDAO {

	public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("Insert into tbl_author Values (?, ?)", new Object[] { author.getAuthorId(), author.getAuthorName() });
	}

	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("Update tbl_author Set authorName = ? Where authorId = ?",
				new Object[] { author.getAuthorName(), author.getAuthorId() });
	}

	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("Delete From tbl_author Where authorId = ?", new Object[] {author.getAuthorId()});
	}

	public Author getAuthor(int authorId) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement("Select * From tbl_author Where authorId = ?");
		pstmt.setInt(1,  authorId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new Author(rs.getInt("authorId"), rs.getString("authorName"));
		}else{
			return null;
		}
	}
	
	public List<Author> readAuthors() throws SQLException, ClassNotFoundException {
		List<Author> authorList = new ArrayList<Author>();
		pstmt = getConnection().prepareStatement("Select * From tbl_author");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			authorList.add(new Author(rs.getInt("authorId"), rs.getString("authorName")));
		}
		return authorList;
	}
	
	public List<Author> readAuthorsByName(String authorName) throws SQLException, ClassNotFoundException {
		List<Author> authorList = new ArrayList<Author>();
		pstmt = getConnection().prepareStatement("Select * From tbl_author Where authorName  = ? ");
		pstmt.setString(1, "authorName");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			authorList.add(new Author(rs.getInt("authorId"), rs.getString("authorName")));
		}
		return authorList;
	}

}