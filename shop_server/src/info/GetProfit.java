package info;

import java.util.ArrayList;

public class GetProfit {
	public ArrayList<String> listDay=new ArrayList<String>();
	public ArrayList<String> listDayIncome=new ArrayList<String>();
	public ArrayList<String> listDayProfit=new ArrayList<String>();
	public void getinfo(){
//		String tableSnack="snack"; 
//		String tableShopkeeper="shopkeeper";
//		String tableShopper="shopper";
//		String tableOrdering="ordering";
//		String tableConsuming_records="consuming_records";
		String tableDayProfit="dayProfit";
		int n;
		
		Query queryDay=new Query();
		queryDay.setTableName(tableDayProfit);
		String sqlDay="select theday from "+tableDayProfit;
		queryDay.setSQL(sqlDay);
		listDay=queryDay.inputQueryResult();
		n=listDay.size();
		String[] day=new String[n];
		for(int i=0;i<n;i++){
			day[i]=listDay.get(i);
		}
		
		Query queryIncome=new Query();
		queryIncome.setTableName(tableDayProfit);
		for(int i=0;i<n;i++){
			String sqlIncome="select dayIncome from "+tableDayProfit
					+" where theday ='"+day[i]+"'";
			queryIncome.setSQL(sqlIncome);
			listDayIncome.addAll(queryIncome.inputQueryResult());
		}
		String [] dayIncome=new String[n];
		for(int i=0;i<n;i++){
			dayIncome[i]=listDayIncome.get(i);
		}
		
		Query queryDayProfit=new Query();
		queryDayProfit.setTableName(tableDayProfit);
		for(int i=0;i<n;i++){
			String sqlDayProfit="select dayProfit from "+tableDayProfit
					+" where theday ='"+day[i]+"'";
			queryDayProfit.setSQL(sqlDayProfit);
			listDayProfit.addAll(queryDayProfit.inputQueryResult());
		}
		String[] dayProfit=new String[n];
		for(int i=0;i<n;i++){
			dayProfit[i]=listDayProfit.get(i);
		}
	}
}
