package info;

import java.util.ArrayList;

public class GetDayProfit {
	public ArrayList<String> listTheDay=new ArrayList<String>();
	public ArrayList<String> listDayIncome=new ArrayList<String>();
	public ArrayList<String> listDayBase_cost=new ArrayList<String>();
	public ArrayList<String> listDayProfit=new ArrayList<String>();
	public void getinfo(){
		String tableDayProfit="dayProfit";
		int n;
		Query queryTheDay=new Query();
		queryTheDay.setTableName(tableDayProfit);
		String sqlTheDay="select theDay from "+tableDayProfit;
		queryTheDay.setSQL(sqlTheDay);
		listTheDay=queryTheDay.inputQueryResult();
		n=listTheDay.size();
		String [] theDay=new String[n];
		for(int i=0;i<n;i++){
			theDay[i]=listTheDay.get(i);
		}
		
		Query queryDayIncome=new Query();
		queryDayIncome.setTableName(tableDayProfit);
		for(int i=0;i<n;i++){
			String sqlDayIncome="select dayIncome from "+tableDayProfit
				+" where theDay ='"+theDay[i]+"'";
			queryDayIncome.setSQL(sqlDayIncome);
			listDayIncome.addAll(queryDayIncome.inputQueryResult());
		}
		String [] dayIncome=new String[n];
		for(int i=0;i<n;i++){
			dayIncome[i]=listDayIncome.get(i);
		}
		
		Query queryDayBase_cost=new Query();
		queryDayBase_cost.setTableName(tableDayProfit);
		for(int i=0;i<n;i++){
			String sqlDayBase_cost="select dayBase_cost from "+tableDayProfit
				+" where theDay ='"+theDay[i]+"'";
			queryDayBase_cost.setSQL(sqlDayBase_cost);
			listDayBase_cost.addAll(queryDayBase_cost.inputQueryResult());
		}
		String [] dayBase_cost=new String[n];
		for(int i=0;i<n;i++){
			dayBase_cost[i]=listDayBase_cost.get(i);
		}
		
		Query queryDayProfit=new Query();
		queryDayProfit.setTableName(tableDayProfit);
		for(int i=0;i<n;i++){
			String sqlDayProfit="select dayIncome from "+tableDayProfit
				+" where theDay ='"+theDay[i]+"'";
			queryDayProfit.setSQL(sqlDayProfit);
			listDayProfit.addAll(queryDayProfit.inputQueryResult());
		}
		String [] dayProfit=new String[n];
		for(int i=0;i<n;i++){
			dayProfit[i]=listDayProfit.get(i);
		}
	}
}
