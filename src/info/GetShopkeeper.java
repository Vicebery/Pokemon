package info;

import java.util.ArrayList;

public class GetShopkeeper {
	public ArrayList<String> listUsername=new ArrayList<String>();
	public ArrayList<String> listIncome=new ArrayList<String>();
	public ArrayList<String> listBase_cost=new ArrayList<String>();
	public ArrayList<String> listProfit=new ArrayList<String>();
	public void getinfo(){
		String tableShopkeeper="shopkeeper";
		int n;
		
		Query queryUsername=new Query();
		queryUsername.setTableName(tableShopkeeper);
		String sqlUsername="select username from "+tableShopkeeper;
		queryUsername.setSQL(sqlUsername);
		listUsername=queryUsername.inputQueryResult();
		n=listUsername.size();
		String [] username=new String[n];
		for(int i=0;i<n;i++){
			username[i]=listUsername.get(i);
		}
		
		Query queryIncome=new Query();
		queryIncome.setTableName(tableShopkeeper);
		for(int i=0;i<n;i++){
			String sqlInocme="select income from "+tableShopkeeper
				+" where username ='"+username[i]+"'";
			queryIncome.setSQL(sqlInocme);
			listIncome.addAll(queryIncome.inputQueryResult());
		}
		String [] income=new String[n];
		for(int i=0;i<n;i++){
			income[i]=listIncome.get(i);
		}
		
		Query queryBase_cost=new Query();
		queryBase_cost.setTableName(tableShopkeeper);
		for(int i=0;i<n;i++){
			String sqlBase_cost="select base_cost from "+tableShopkeeper
				+" where username ='"+username[i]+"'";
			queryBase_cost.setSQL(sqlBase_cost);
			listBase_cost.addAll(queryBase_cost.inputQueryResult());
		}
		String [] base_cost=new String[n];
		for(int i=0;i<n;i++){
			base_cost[i]=listBase_cost.get(i);
		}
		
		Query queryProfit=new Query();
		queryProfit.setTableName(tableShopkeeper);
		for(int i=0;i<n;i++){
			String sqlProfit="select profit from "+tableShopkeeper
				+" where username ='"+username[i]+"'";
			queryProfit.setSQL(sqlProfit);
			listProfit.addAll(queryProfit.inputQueryResult());
		}
		String [] profit=new String[n];
		for(int i=0;i<n;i++){
			profit[i]=listProfit.get(i);
		}
	}
}
