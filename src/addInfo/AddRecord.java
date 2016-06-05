package addInfo;

import java.sql.*;

public class AddRecord {
	String databaseName="pokemon_store";
	String tableName="";
	String sno="";
	String sname="";
	String skind="";
	String spacking="";
	double base_price=0;
	double sprice=0;
	int in_num=0;
	int sqty=0;
	public AddRecord(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(ClassNotFoundException e){
			System.out.print(e);
		}
	}
	public void setTableName(String s){
		tableName=s.trim();
	}
	public void setSnack(String sno1,String sname1,String skind1,String spacking1,
			double base_price1,double sprice1,int in_num1,int sqty1){
		sno=sno1;
		sname=sname1;
		skind=skind1;
		spacking=spacking1;
		base_price=base_price1;
		sprice=sprice1;
		in_num=in_num1;
		sqty=sqty1;
	}
	public String addSnack(){
		String str="";
		Connection con;
		PreparedStatement sql;
		try {
//			String uri="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pokemon_store";
			String uri="jdbc:sqlserver://192.168.16.222:1433;DatabaseName=pokemon_store";
			String id="";
			String password="";
			con=DriverManager.getConnection(uri,id,password);
			String insertCondition="insert into snack values(?,?,?,?,?,?,?,?)";
			sql=con.prepareStatement(insertCondition);
			if(sno.length()>0){
				sql.setString(1, sno);
				sql.setString(2, sname);
				sql.setString(3, skind);
				sql.setString(4, spacking);
				sql.setDouble(5, base_price);
				sql.setDouble(6, sprice);
				sql.setInt(7, in_num);
				sql.setInt(8, sqty);
				int m=sql.executeUpdate();
				if(m!=0){
					str="对表中添加"+m+"条记录成功";
				}
				else
					str="添加记录失败";
			}
			else{
				str="必须要有编号";
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			str="没有提供添加的数据或"+e;
		}
		return str;
	}
}
