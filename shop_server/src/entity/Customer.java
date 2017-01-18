package entity;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
	public String dormitoryId; // 宿舍号
	public String phoneNumber; // 手机号
	private List<Book> bookList;
	private double sumCost; // 累计消费金额

	public Customer(String dor, String pnum, double cost)
	{
		this.dormitoryId = dor;
		this.phoneNumber = pnum;
		this.setSumCost(cost);
	}

	public List<Book> getBook()
	{
		bookList = new ArrayList<Book>();
		return bookList;
	}

	public void setBook(List<Book> bookList)
	{
		this.bookList = bookList;
	}

	public double getSumCost() // 计算该顾客历史消费金额
	{
//		sumCost = 0;                              //此处不能用订单集合来计算总和，由于订单集合没有初始化，并没有任何数据
//		for (Book book : bookList)
//		{
//			if (this.dormitoryId == book.getDormitoryId())
//				sumCost += book.getSumPrice();
//		}
		return sumCost;
	}

	public void setSumCost(double sumCost)
	{
		this.sumCost = sumCost;
	}

}
