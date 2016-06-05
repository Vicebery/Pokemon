package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Profit;
import info.GetProfit;

public class ProfitDao
{
	private List<Profit> profitList; // 日利润集合
	private static ProfitDao profitDao;

	public static ProfitDao instance()
	{
		if (profitDao == null)
			profitDao = new ProfitDao();
		return profitDao;
	}

	public ProfitDao()
	{
		GetProfit getProfit=new GetProfit();
		getProfit.getinfo();
		int n=getProfit.listDay.size();
		String [] s1=new String[n];
		String [] s2=new String[n];
		String [] s3=new String[n];
		for(int i=0;i<n;i++){
			s1[i]=getProfit.listDay.get(i);
			s2[i]=getProfit.listDayIncome.get(i);
			s3[i]=getProfit.listDayProfit.get(i);
		}
		profitList = new ArrayList<Profit>();
		for(int i=0;i<n;i++){
			addProfit(new Profit(s1[i], Double.parseDouble(s2[i]), Double.parseDouble(s3[i])));
		}

	}

	public void addProfit(Profit profit)
	{
		profitList.add(profit);
	}

	private Object[] formatData(Profit profit)
	{
		Object[] result = new Object[3];
		result[0] = profit.getDate();
		result[1] = ProfitDao.instance().getDateSumPricebyDate(profit.getDate());
		result[2] = ProfitDao.instance().getDateProfitbyDate(profit.getDate());

		return result;
	}

	public Object[][] getProfitData()
	{
		Object[][] result = new Object[ProfitDao.instance().getProfitList().size()][3];
		int i = 0;
		for (Profit profit : profitList)
		{
			result[i] = formatData(profit);
			i++;
		}
		return result;
	}

	public List<Profit> getProfitList()
	{
		return profitList;
	}

	public Profit getProfitbyDate(String date) // 以日期为主键，来唯一确定利润的相关项
	{
		for (Profit profit : profitList)
		{
			if (profit.getDate() == date)
				return profit;
		}
		return null;
	}

	public double getDateSumPricebyDate(String date)
	{
		for (Profit profit : profitList)
		{
			if (profit.getDate() == date)
				return profit.getDateSumPrice();
		}
		return 0;
	}

	public double getDateBasePricebyDate(String date)
	{
		for (Profit profit : profitList)
		{
			if (profit.getDate() == date)
				return profit.getDateBasePrice();
		}
		return 0;
	}

	public double getDateProfitbyDate(String date)
	{
		for (Profit profit : profitList)
		{
			if (profit.getDate() == date)
				return profit.getDateProfit();
		}
		return 0;
	}
}
