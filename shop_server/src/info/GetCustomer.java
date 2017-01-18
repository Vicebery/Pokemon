package info;

import java.util.ArrayList;

public class GetCustomer {
	public ArrayList<String> listDormitory=new ArrayList<String>();
	public ArrayList<String> listTel=new ArrayList<String>();
	public ArrayList<String> listAll_spending=new ArrayList<String>();
	public void getinfo(){
//		String tableSnack="snack";
//		String tableShopkeeper="shopkeeper";
		String tableShopper="shopper";
//		String tableOrdering="ordering";
//		String tableConsuming_records="consuming_records";
		int n;
		
		Query queryTel=new Query();
		queryTel.setTableName(tableShopper);
		String sqlCno="select telphone from "+tableShopper;
		queryTel.setSQL(sqlCno);
		listTel=queryTel.inputQueryResult();
		n=listTel.size();
		String[] telphone=new String[n];
		for(int i=0;i<n;i++){
			telphone[i]=listTel.get(i);
		}
		
		Query queryDormitory=new Query();
		queryDormitory.setTableName(tableShopper);
		for(int i=0;i<n;i++){
			String sqlDormitory="select dormitory_num from "+tableShopper
				+" where telphone ='"+telphone[i]+"'";
			queryDormitory.setSQL(sqlDormitory);
			listDormitory.addAll(queryDormitory.inputQueryResult());	
		}
		String [] dormitory=new String[n];
		for(int i=0;i<n;i++){
			dormitory[i]=listDormitory.get(i);
		}
		
		Query queryAll_spending=new Query();
		queryAll_spending.setTableName(tableShopper);
		for(int i=0;i<n;i++){
			String sqlAll_spending="select all_spending from "+tableShopper
				+" where telphone ='"+telphone[i]+"'";
			queryAll_spending.setSQL(sqlAll_spending);
			listAll_spending.addAll(queryAll_spending.inputQueryResult());	
		}
		String [] all_spending=new String[n];
		for(int i=0;i<n;i++){
			all_spending[i]=listAll_spending.get(i);
		}
	}
}
