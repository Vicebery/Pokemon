package info;

import java.util.ArrayList;

public class GetOrder {
	public ArrayList<String> listCno = new ArrayList<String>();
	public ArrayList<String> listTel = new ArrayList<String>();
	public ArrayList<String> listDormitory = new ArrayList<String>();
	public ArrayList<String> listSpending = new ArrayList<String>();
	public ArrayList<String> listSno_Snum = new ArrayList<String>();
	public void getinfo(){
		//String tableSnack="snack";
		//String tableShopkeeper="shopkeeper";
		String tableShopper="shopper";
		String tableOrdering="ordering";
		String tableConsuming_records="consuming_records";
		int n;
		
		Query queryCno=new Query();
		queryCno.setTableName(tableConsuming_records);
		String sqlCno="select cno from "+tableConsuming_records;
		queryCno.setSQL(sqlCno);
		listCno=queryCno.inputQueryResult();
		n=listCno.size();
		String[] cno=new String[n];
		for(int i=0;i<n;i++){
			cno[i]=listCno.get(i);
		}
		
		Query queryTel=new Query();
		queryTel.setTableName(tableConsuming_records);
		for(int i=0;i<n;i++){
			String sqlTel="select telphone from "+tableConsuming_records
				+" where cno ='"+cno[i]+"'";
			queryTel.setSQL(sqlTel);
			listTel.addAll(queryTel.inputQueryResult());	
		}
		String [] telphone=new String[n];
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
		String[] dormitory=new String[n];
		for (int i = 0; i < n; i++) {
			dormitory[i]=listDormitory.get(i);
		}
		
		Query querySpending=new Query();
		querySpending.setTableName(tableConsuming_records);
		for(int i=0;i<n;i++){
			String sqlSpending="select spending from "+tableConsuming_records
					+" where cno ='"+cno[i]+"'";
			querySpending.setSQL(sqlSpending);
			listSpending.addAll(querySpending.inputQueryResult());
		}
		String[] spending=new String[n];
		for (int i = 0; i < n; i++) {
			spending[i]=listSpending.get(i);
		}
		
		Query querySno_snum=new Query();
		querySno_snum.setTableName(tableOrdering);
		for (int i = 0; i < n; i++) {
			String sqlSno_snum="select sno,sname,snum from "+tableOrdering
					+" where telphone ='"+telphone[i]+"'";
			querySno_snum.setSQL(sqlSno_snum);
			listSno_Snum.addAll(querySno_snum.inputQueryResult3());
		}
		String[] sno_snum=new String[n];
		for(int i=0;i<n;i++){
			sno_snum[i]=listSno_Snum.get(i);
		}
	}
}
