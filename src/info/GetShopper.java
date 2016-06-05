package info;

import java.util.ArrayList;

public class GetShopper {
	public ArrayList<String> listAll_spending=new ArrayList<String>();
	public ArrayList<String> listTel=new ArrayList<String>();
	public void getinfo(){
		String tableShopper="shopper";
		int n;
		Query queryTel=new Query();
		queryTel.setTableName(tableShopper);
		String sqlTel="select telphone from "+tableShopper;
		queryTel.setSQL(sqlTel);
		listTel=queryTel.inputQueryResult();
		n=listTel.size();
		String [] tel=new String[n];
		for(int i=0;i<n;i++){
			tel[i]=listTel.get(i);
		}
		
		Query queryAll_spending=new Query();
		queryAll_spending.setTableName(tableShopper);
		for(int i=0;i<n;i++){
			String sqlAll_spending="select all_spending from "+tableShopper
				+" where telphone ='"+tel[i]+"'";
			queryAll_spending.setSQL(sqlAll_spending);
			listAll_spending.addAll(queryAll_spending.inputQueryResult());
		}
		String [] all_spending=new String[n];
		for(int i=0;i<n;i++){
			all_spending[i]=listAll_spending.get(i);
		}
	}
}
