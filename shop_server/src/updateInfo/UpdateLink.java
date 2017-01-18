package updateInfo;

import java.sql.*;

public class UpdateLink {
	String databaseName="pokemon_store";
	String SQL,message="";
	public UpdateLink(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setSQL(String SQL){
		this.SQL=SQL;
	}
	public String UpdateInfo(){
		Connection con=null;
		Statement sql=null;
		try {
//			String uri="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pokemon_store";
			String uri="jdbc:sqlserver://192.168.16.222:1433;DatabaseName=pokemon_store";
			String id="admin";
			String passwd="admin";
			con=DriverManager.getConnection(uri,id,passwd);
			sql=con.createStatement();
			sql.execute(SQL);
			message="²Ù×÷³É¹¦";
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.toString();
		}
		return message;
	}
}
