package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Good;
import info.GetSnack;

public class GoodDao
{
	private List<Good> goodList;
	private static GoodDao goodDao;

	public static GoodDao instance()
	{
		if (goodDao == null)
			goodDao = new GoodDao();
		return goodDao;
	}

	public GoodDao()
	{
		
//		addGood(new Good(1001,"北京方便面",0.35,0.5,10,24,14));
		GetSnack getSnack=new GetSnack();
		getSnack.getinfo();
		int n=getSnack.listSno.size();
		String [] s1=new String[n];
		String [] s2=new String[n];
		String [] s3=new String[n];
		String [] s4=new String[n];
		String [] s5=new String[n];
		String [] s6=new String[n];
		for(int i=0;i<n;i++){
			s1[i]=getSnack.listSno.get(i);
			s2[i]=getSnack.listSname.get(i);
			s2[i]=s2[i].replace(" ", "");
			s3[i]=getSnack.listBase_price.get(i);
			s4[i]=getSnack.listSprice.get(i);
			s5[i]=getSnack.listIn_num.get(i);
			s6[i]=getSnack.listSqty.get(i);
		}
		goodList = new ArrayList<Good>();
		for(int i=0;i<n;i++){
			addGood(new Good(s1[i],s2[i],Double.parseDouble(s3[i])
					,Double.parseDouble(s4[i]),Integer.parseInt(s5[i])-Integer.parseInt(s6[i]),
					Integer.parseInt(s5[i]),Integer.parseInt(s6[i])));
		}
	}

	public void addGood(Good good)
	{
		goodList.add(good);
	}
	public void removeGood(Good good)
	{
		goodList.remove(good);
	}

	private Object[] formatData(Good good)// "编号", "商品名", "进价", "售价", "已售","进货量","库存量"
	{
		Object[] result = new Object[7];
		result[0] = good.getId();
		result[1] = GoodDao.instance().getNamebyId(good.getId());
		result[2] = good.getbase_Price();
		result[3] = good.getsell_Price();
		result[4] = good.getNumSelled();
		result[5] = good.getNumSum();
		result[6] = good.getNumRest();
		return result;
	}

	public Object[][] getGoodData()
	{
		Object[][] result = new Object[GoodDao.instance().getGoodList().size()][7];
		if (goodList.size() > 0)
		{
//			result = new Object[goodList.size()][6];
			Good good;
			for (int i = 0; i < goodList.size(); i++)
			{
				good = goodList.get(i);
				result[i] = formatData(good);
			}
		} else
		{
			result[0][0] = "没有数据";
			result[0][1] = "没有数据";
			result[0][2] = 0;
			result[0][3] = 0;
			result[0][4] = 0;
			result[0][5] = 0;
			result[0][6] = 0;
		}
		return result;
	}

	public List<Good> getGoodList()
	{
		return goodList;
	}

	public String getNamebyId(String id) // 以商品ID为主键
	{
		for (Good good : goodList)
		{
			if (good.getId() == id)
				return good.getName();
		}
		return null;
	}

	public Good getGoodbyId(String id)// 以商品ID为主键
	{
		for(Good good : goodList)
		{
			if(good.getId()==id)
				return good;
		}
		return null;
	}
	public String getTypebyId(String id) // 以商品ID为主键
	{
		for (Good good : goodList)
		{
			if (good.getId() == id)
				return good.getType();
		}
		return null;
	}

}
