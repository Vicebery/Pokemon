package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book
{
//	@SuppressWarnings("unused")
	private String bookID; // 订单号
//	private Customer customer; // 顾客信息
	private String dormitoryId;
	private String phoneNumber;
	private String goodInfo; // 商品信息单
	private List<Good> goodList; // 订单所含商品集合
	private double basePrice; // 该订单总进价
	private double sumPrice; // 该订单总计价格
	private Date bookTime; // 订单生成时间
	private String IsHandle; // 订单是否处理  //不能是boolean类型，在写入表格时会出现异常。

	public Book(String b_ID, String dormitoryID, String phoneNum, double sumPrice, String isHandle, String goodInfo)
	{
		this.setBookID(b_ID);
		this.setDormitoryId(dormitoryID);
		this.setPhoneNumber(phoneNum);
		this.sumPrice = sumPrice;
		this.setGoodInfo(goodInfo);
		this.IsHandle = isHandle;

//		this.bookTime = new Date();
	}

	public Date getBookTime()
	{
		return bookTime;
	}

	public String getBookYearMonDay() // 获取订单生成的年月日，用做日利润分析
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		if (this.getBookTime() != null)
			return formatter.format(this.getBookTime());
		else
			return null;
	}

	public String getBookID()
	{
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHMMSS-"); //此方案舍弃
//		return formatter.format(bookTime) + Integer.toString(dormitoryId); // 时间+宿舍号=订单号
		return bookID;
	}

	public void setBookID(String bookID)
	{
		this.bookID = bookID;
	}

	public String getIsHandle()
	{
		return IsHandle;
	}

	public List<Good> getGoodList()
	{
		goodList = new ArrayList<Good>();   //不实例化则为空
		return goodList;
	}

	public void setGoodList(List<Good> goodList)
	{
		this.goodList = goodList;
	}

	public void setSumPrice(double sumPrice)
	{
		this.sumPrice = sumPrice;
	}

	public double getSumPrice() // 计算当前订单所含商品总价值
	{
//		goodList = this.getGoodList();//由数据库计算
//		sumPrice = 0;
//		for (Good good : goodList)
//		{
//			sumPrice += good.getsell_Price();
//		}
		return sumPrice;
	}

	public void setGoodInfo(String goodInfo)
	{
		this.goodInfo = goodInfo;
	}

	public String getGoodInfo() // 获取当前订单所含商品信息
	{
		goodList = this.getGoodList();
		for (Good good : goodList)
		{
			goodInfo = good.getName() + "(" + good.getCount() + ")" + "--";
		}
		return goodInfo;
	}

	public double getBasePrice() // 获取当前订单所含商品的本价
	{
		goodList = this.getGoodList();
		basePrice = 0;
		for (Good good : goodList)
		{
			basePrice += good.getbase_Price();
		}
		return basePrice;
	}

	public void setBasePrice(double basePrice)
	{
		this.basePrice = basePrice;
	}

	public String getDormitoryId()
	{
		return dormitoryId;
	}

	public void setDormitoryId(String dormitoryId)
	{
		this.dormitoryId = dormitoryId;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

}
