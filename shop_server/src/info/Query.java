package info;

import java.sql.*;
import java.util.ArrayList;

public class Query {
	String tableName="";
	String SQL;
	public Query(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void setTableName(String s){
		tableName=s.trim();
	}
	public void setSQL(String SQL){
		this.SQL=SQL.trim();
	}
	public ArrayList<String> inputQueryResult(){
		Connection con;
		Statement sql;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();	//字符串泛型集合
		try {
//			String uri="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pokemon_store";
			String uri="jdbc:sqlserver://192.168.16.222:1433;DatabaseName=pokemon_store";
			String id="admin";
			String password="admin";
			con=DriverManager.getConnection(uri,id,password);
			sql=con.createStatement();
			rs=sql.executeQuery(SQL);
			while(rs.next()){
				String s1=rs.getString(1);
				list.add(s1);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}
	
	public ArrayList<String> inputQueryResult3(){
		Connection con;
		Statement sql;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();	//字符串泛型集合
		try {
//			String uri="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pokemon_store";
			String uri="jdbc:sqlserver://192.168.16.222:1433;DatabaseName=pokemon_store";
			String id="admin";
			String password="admin";
			con=DriverManager.getConnection(uri,id,password);
			sql=con.createStatement();
			rs=sql.executeQuery(SQL);
			String s1="";
			while(rs.next()){
				s1+="["+rs.getString(1);
				s1+="-"+rs.getString(2);
				if(rs.getString(2).replace(" ", "").length()>=8)
					s1+="-"+rs.getString(3)+"]";
				else s1+="--"+rs.getString(3)+"]";
				s1=s1.replaceAll(" +","");	
			}
			s1=s1.replace('-', ' ');
			s1=s1.replaceAll("]","] ");
			list.add(s1);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}
	
	public void inputQueryResult2(){
		Connection con;
		Statement sql;
		ResultSet rs;
		try {
//			String uri="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pokemon_store";
			String uri="jdbc:sqlserver://192.168.16.222:1433;DatabaseName=pokemon_store";
			String id="admin";
			String password="admin";
			con=DriverManager.getConnection(uri,id,password);
			DatabaseMetaData metaData=con.getMetaData();
			ResultSet rs1=metaData.getColumns(null, null, tableName, null);
			int 字段个数=0;
			while (rs1.next()) {
				字段个数++;
			}
			String[] s=new String[字段个数];
			sql=con.createStatement();
			rs=sql.executeQuery(SQL);
			while(rs.next()){
				for(int k=1;k<=字段个数;k++){
					s[k-1]=rs.getString(k);
					System.out.print(s[k-1]+"\t");
				}
				System.out.println("");
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
