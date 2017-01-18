package info;

import java.util.ArrayList;

public class GetSnack {
	public ArrayList<String> listSno=new ArrayList<String>();
	public ArrayList<String> listSname=new ArrayList<String>();
	public ArrayList<String> listBase_price=new ArrayList<String>();
	public ArrayList<String> listSprice=new ArrayList<String>();
	public ArrayList<String> listIn_num=new ArrayList<String>();
	public ArrayList<String> listSqty=new ArrayList<String>();
	public void getinfo(){
		String tableSnack="snack";
//		String tableShopkeeper="shopkeeper";
//		String tableShopper="shopper";
//		String tableOrdering="ordering";
//		String tableConsuming_records="consuming_records";
		int n;
		
		Query querySno=new Query();
		querySno.setTableName(tableSnack);
		String sqlSno="select sno from "+tableSnack;
		querySno.setSQL(sqlSno);
		listSno=querySno.inputQueryResult();
		n=listSno.size();
		String [] sno=new String[n];
		for(int i=0;i<n;i++){
			sno[i]=listSno.get(i);
		}
		
		Query querySname=new Query();
		querySname.setTableName(tableSnack);
		for(int i=0;i<n;i++){
			String sqlSname="select sname from "+tableSnack
				+" where sno ='"+sno[i]+"'";
			querySname.setSQL(sqlSname);
			listSname.addAll(querySname.inputQueryResult());
		}
		String [] sname=new String[n];
		for(int i=0;i<n;i++){
			sname[i]=listSname.get(i);
		}
		
		Query queryBase_price=new Query();
		queryBase_price.setTableName(tableSnack);
		for(int i=0;i<n;i++){
			String sqlBase_price="select base_price from "+tableSnack
				+" where sno ='"+sno[i]+"'";
			queryBase_price.setSQL(sqlBase_price);
			listBase_price.addAll(queryBase_price.inputQueryResult());
		}
		String [] base_price=new String[n];
		for(int i=0;i<n;i++){
			base_price[i]=listBase_price.get(i);
		}
		
		Query querySprice=new Query();
		querySprice.setTableName(tableSnack);
		for(int i=0;i<n;i++){
			String sqlSprice="select sprice from "+tableSnack
				+" where sno ='"+sno[i]+"'";
			querySprice.setSQL(sqlSprice);
			listSprice.addAll(querySprice.inputQueryResult());
		}
		String [] sprice=new String[n];
		for(int i=0;i<n;i++){
			sprice[i]=listSprice.get(i);
		}
		
		Query queryIn_num=new Query();
		queryIn_num.setTableName(tableSnack);
		for(int i=0;i<n;i++){
			String sqlIn_num="select in_num from "+tableSnack
				+" where sno ='"+sno[i]+"'";
			queryIn_num.setSQL(sqlIn_num);
			listIn_num.addAll(queryIn_num.inputQueryResult());
		}
		String [] in_num=new String[n];
		for(int i=0;i<n;i++){
			in_num[i]=listIn_num.get(i);
		}
		
		Query querySqty=new Query();
		querySqty.setTableName(tableSnack);
		for(int i=0;i<n;i++){
			String sqlSqty="select sqty from "+tableSnack
				+" where sno ='"+sno[i]+"'";
			querySqty.setSQL(sqlSqty);
			listSqty.addAll(querySqty.inputQueryResult());
		}
		String [] sqty=new String[n];
		for(int i=0;i<n;i++){
			sqty[i]=listSqty.get(i);
		}
	}
}
