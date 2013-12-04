package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseController {
	   private static DatabaseController instance = null;
	   private String host,username,password,database;
	   private Integer port = 3306;
	   private PreparedStatement pstmt = null;
	   Connection con = null;
	   
	   protected DatabaseController() {}
	   
	   public static DatabaseController getInstance() {
	      if(instance == null) {
	         instance = new DatabaseController();
	      }
	      return instance;
	   }
	   
	   public DatabaseController OpenConnection() {
		   try {
			   con = DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.port+"/"+this.database, this.username, this.password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return instance;
	   }
	   
	   public void closeConnection() {
		   try {
			   	this.con.close();
			} catch (SQLException e) {
			}
	   }
	   
	   public ResultSet runQuery(String query) {
			Statement st = null;
			ResultSet rs = null;
			try {
				if(con == null) return null;
				st = this.con.createStatement();
				rs = st.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
	   }
	   
	   public void startPreparedStatement(String Query) {
		   try {
				con.prepareStatement(Query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	   
	   public void pstmtSetNull(int id, int type) {
		    try {
		    	pstmt.setNull(id, type);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	   
	   public void pstmtSetString(int id, String string) {
		    try {
		    	pstmt.setString(id, string);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	   
	   public void pstmtSetInt(int id, int integer) {
		    try {
		    	pstmt.setInt(id, integer);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	   
	   public void runPreparedStatement() {
			try {
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	   
	   public DatabaseController setDatabase(String Database) {
		   this.database = Database;
		   return instance;
	   }
	   
	   public DatabaseController setHost(String Host) {
		   this.host = Host;
		   return instance;
	   }
	   
	   public DatabaseController setUser(String Username) {
		   this.username = Username;
		   return instance;
	   }
	   
	   public DatabaseController setPassword(String Password) {
		   this.password = Password;
		   return instance;
	   }
	   
	   public DatabaseController setPort(Integer port) {
		   this.port = port;
		   return instance;
	   }
	   
	   public String debug(){
		   return "host : "+host+", username : "+username+", password : "+password+", database : "+database;
	   }
}
