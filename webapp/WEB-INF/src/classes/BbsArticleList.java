package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BbsArticleList {
	private Connection connList;
	//private Statement stmtList;
	private PreparedStatement pstmt;
	private ResultSet rsList;
	private BbsArticle article = new BbsArticle();
	
	private int intLimit = 0;
	private int intPage = 1;
	private int intParentId = 0;
	
	public void setLimit(int intLimitArg) {this.intLimit = intLimitArg;}
	public void setPage(int intPageArg) {this.intPage = intPageArg;}
	public void setParentId(int intParentIdArg) {this.intParentId = intParentIdArg;}


	public void makeList() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
		this.connList = ds.getConnection();
		//this.stmtList = this.connList.createStatement();
		String strSql = "SELECT * FROM bbs WHERE parent_id=? ORDER BY id";
		if(this.intLimit != 0) {
			strSql = strSql + " LIMIT " + (this.intPage - 1) * this.intLimit + ", " + this.intLimit;
		}
		this.pstmt = this.connList.prepareStatement(strSql);
			pstmt.setInt(1, this.intParentId);
		try {
			//this.rsList = stmtList.executeQuery(strSql);
			this.rsList = pstmt.executeQuery();
		} catch (SQLException se) {
			throw new Exception(se.getMessage() + "\n" + strSql);
		}
	}
	
	public boolean next() throws Exception {
		boolean blResult = false;
		if(this.rsList.next()) {
			this.article.setId(this.rsList.getInt("id"));
			this.article.setDateTime(new Date(this.rsList.getLong("date_time")));
			this.article.setEditDatetime(this.rsList.getLong("edit_date_time"));
			this.article.setAuthor(this.rsList.getString("author"));
			this.article.setSubject(this.rsList.getString("subject"));
			this.article.setBody(this.rsList.getString("body"));
			this.article.setPswdSet(this.rsList.getBoolean("password_set"));
			blResult = true;
		} else {
			this.connList.close();
		}
		return blResult;
	}
	
	public BbsArticle getArticle() {
		return this.article;
	}
	
	public int getLastPage() throws Exception {
		int intResult = 0;
		if(this.intLimit != 0) {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
			Connection conn = ds.getConnection();
			String strSql = "SELECT COUNT(*) FROM bbs WHERE parent_id =?";
			PreparedStatement pstmt = conn.prepareStatement(strSql);
				pstmt.setInt(1, 0);
			try {
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					int intRowCount = rs.getInt(1);
					intResult = (intRowCount -1) / this.intLimit +1;
				}
			} catch (SQLException se) {
				throw new Exception(se.getMessage() + "\n" + strSql);
			}
			pstmt.close();
			conn.close();
		}
		return intResult;
	}
	
	public int getPageFromId(int intIdArg) throws Exception {
		int intPageOfId = 0;
		if(this.intLimit != 0) {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
			Connection conn = ds.getConnection();
			String strSql = "SELECT COUNT(*) FROM bbs WHERE id <=?";
			PreparedStatement pstmt = conn.prepareStatement(strSql);
				pstmt.setInt(1, intIdArg);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int intRowCount = rs.getInt(1);
			intPageOfId = (intRowCount -1) / this.intLimit +1;
			pstmt.close();
			conn.close();
		}
		return intPageOfId;
	}
	
	public void search(String strSearch) throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
		this.connList = ds.getConnection();
		String strSql = "SELECT * FROM bbs WHERE author LIKE ? OR subject LIKE ? OR body LIKE ?";
		this.pstmt = this.connList.prepareStatement(strSql);
			pstmt.setString(1, "%" + strSearch + "%");
			pstmt.setString(2, "%" + strSearch + "%");
			pstmt.setString(3, "%" + strSearch + "%");
		try {
			this.rsList = pstmt.executeQuery();
		} catch (SQLException se) {
			throw new Exception(se.getMessage() + "\n" + strSql);
		}
	}
	
}
