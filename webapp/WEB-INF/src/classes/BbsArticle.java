package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BbsArticle {
	private int intId = 0;
	private int intParentId = -1;
	private Date dateTime;
	private Date editDatetimeFormat;
	private long editDatetime;
	private String strAuthor = "";
	private String strSubject = "";
	private String strBody = "";
	private boolean blPswdSet = false;
	
	public int getId() { return this.intId; }
	public int getParentId() { return this.intParentId; }
	public Date getDateTime() { return this.dateTime; }
	public Date getEditDatetimeFormat () { return this.editDatetimeFormat; }
	public long getEditDatetime() { return this.editDatetime; }
	public String getAuthor() { return this.strAuthor; }
	public String getSubject() { return this.strSubject; }
	public String getBody() { return this.strBody; }
	public boolean getPswdSet() { return this.blPswdSet; }
	
	public void setId(int intIdArg) { this.intId = intIdArg; }
	public void setParentId(int intParentIdArg) { this.intParentId = intParentIdArg; }
	public void setDateTime(Date dateTimeArg) { this.dateTime = dateTimeArg; }
	public void setEditDateTimeFormat(Date editDatetimeFormatArg) { this.editDatetimeFormat = editDatetimeFormatArg; }
	public void setEditDatetime(long editDatetimeArg) { this.editDatetime = editDatetimeArg; }
	public void setAuthor(String strAuthorArg) { this.strAuthor = strAuthorArg; }
	public void setSubject(String strSubjectArg) { this.strSubject = strSubjectArg; }
	public void setBody(String strBodyArg) { this.strBody = strBodyArg; }
	public void setPswdSet(boolean blPswdSetArg) { this.blPswdSet = blPswdSetArg; }
	
	public boolean add(String strPswd) throws SessionTimeoutException, Exception {
		if(this.intParentId == -1) {
			throw new SessionTimeoutException();
		}
		boolean blResult = false;
		if(this.strAuthor != null && this.strSubject != null && this.strBody != null) {
			this.dateTime = new Date();
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
			Connection conn = ds.getConnection();
			String strSql = "INSERT INTO bbs (parent_id, date_time, author, subject, body, password, password_set) "
		              + "VALUES (?,?, ?, ?, ?, SHA2(?, 256), ?)";
			PreparedStatement pstmt = conn.prepareStatement(strSql);
				pstmt.setInt(1, this.intParentId);
				pstmt.setLong(2, this.dateTime.getTime());
				pstmt.setString(3, this.strAuthor);
				pstmt.setString(4, this.strSubject);
				pstmt.setString(5, this.strBody);
				pstmt.setString(6, strPswd);
				if(strPswd != null) { pstmt.setBoolean(7, true); }
				else { pstmt.setBoolean(7, false); }
				try {
					int rs = pstmt.executeUpdate();
					if (rs == 1) {
						blResult = true;
					}
				} catch (SQLException se) {
					throw new Exception(se.getMessage() + "\n" + strSql);
				}
			pstmt.close();
			conn.close();
		}
		return blResult;
	}
	
	public boolean load(int intIdArg, String strPswd)  throws Exception  {
		boolean blResult = false;
		this.intId = intIdArg;
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
		Connection conn = ds.getConnection();
		String strSql = "SELECT * FROM bbs WHERE id= ? AND password= SHA2(?, 256)";
		  PreparedStatement pstmt = conn.prepareStatement(strSql);
		  pstmt.setInt(1, intId);
		  pstmt.setString(2, strPswd);
		  try {
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					this.intParentId = rs.getInt("parent_id");
					this.dateTime = new java.util.Date(rs.getLong("date_time"));
					this.editDatetime = rs.getLong("edit_date_time");
					this.editDatetimeFormat = new java.util.Date(rs.getLong("edit_date_time"));
					this.strAuthor = rs.getString("author");
					this.strSubject = rs.getString("subject");
					this.strBody = rs.getString("body");
					blResult = true;
				}
		  } catch (SQLException se) {
			  throw new Exception(se.getMessage() + "\n" + strSql);
		  }
		pstmt.close();
		conn.close();
		return blResult;
	}
	
	public boolean delete(String strPswd) throws SessionTimeoutException, Exception {
		boolean blResult = false;
		if (this.intId == 0) {
			throw new SessionTimeoutException();
		}
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
		Connection conn = ds.getConnection();
		String strSql = "DELETE FROM bbs WHERE id=? AND password=?";
		  PreparedStatement pstmt = conn.prepareStatement(strSql);
		  pstmt.setInt(1, this.intId);
		  pstmt.setString(2, strPswd);
		  try {
			int rs = pstmt.executeUpdate();
			if (rs == 1) {
				blResult = true;
			}
		  } catch (SQLException se) {
			  throw new Exception(se.getMessage() + "\n" + strSql);
		  }
		pstmt.close();
		conn.close();
		return blResult;
	}

	public boolean update(String strPswd) throws SessionTimeoutException, Exception {
		boolean blResult = false;
		if (this.intId == 0) {
			throw new SessionTimeoutException();
		}
		if(this.strSubject != null && this.strBody != null) {
			this.dateTime = new Date();
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
			Connection conn = ds.getConnection();
			String strSql = "UPDATE bbs SET subject=?, body=?, edit_date_time=? WHERE id=? AND password=?";
			  PreparedStatement pstmt = conn.prepareStatement(strSql);
			  pstmt.setString(1, this.strSubject);
			  pstmt.setString(2, this.strBody);
			  pstmt.setLong(3, this.dateTime.getTime());
			  pstmt.setInt(4, this.intId);
			  pstmt.setString(5, strPswd);
			  try {
				  int rs = pstmt.executeUpdate();
				  if (rs == 1) {
					  blResult = true;
				  }
			  } catch (SQLException se) {
				  throw new Exception(se.getMessage() + "\n" + strSql);
			  }
			pstmt.close();
			conn.close();
		}
		return blResult;
	}
	
	public String getParentSubject() throws Exception {
		String strResult = "";
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jamyto2");
		Connection conn = ds.getConnection();
		String strSql = "SELECT * FROM bbs WHERE id= ?";
		  PreparedStatement pstmt = conn.prepareStatement(strSql);
		  pstmt.setInt(1, this.intParentId);
		  try {
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					strResult = rs.getString("subject");
				} else {
					throw new Exception("指定された記事がありません。");
				}
		  } catch (SQLException se) {
			  throw new Exception(se.getMessage() + "\n" + strSql);
		  }
		pstmt.close();
		conn.close();
		return strResult;
	}
}
