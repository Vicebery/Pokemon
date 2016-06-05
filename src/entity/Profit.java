package entity;

import java.util.List;

public class Profit
{
	private String date;
	private List<Book> bookList;
	private double dateSumPrice;
	private double dateBasePrice;
	private double dateProfit;

	public Profit(String d, double dateSumPrice, double dateProfit)
	{
		this.date = d;
		this.dateSumPrice = dateSumPrice;
		this.dateProfit = dateProfit;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public List<Book> getBook()
	{
		return bookList;
	}

	public void setBook(List<Book> bookList)
	{
		this.bookList = bookList;
	}

	public double getDateBasePrice()
	{
//		dateBasePrice = 0;
//		for (Book book : bookList)
//		{
//			if (book.getBookYearMonDay() == date)
//				dateBasePrice += book.getBasePrice();
//		}
		return dateBasePrice;
	}

	public void setDateBasePrice(double dateBasePrice)
	{
		this.dateBasePrice = dateBasePrice;
	}

	public double getDateSumPrice()
	{
//		dateSumPrice = 0;
//		for (Book book : bookList)
//		{
//			if (book.getBookYearMonDay() == date)
//				dateSumPrice += book.getSumPrice();
//		}
		return dateSumPrice;
	}

	public void setDateSumPrice(double dateSumPrice)
	{
		this.dateSumPrice = dateSumPrice;
	}

	public double getDateProfit()
	{
		return dateProfit;
	}

	public void setDateprofit(double dateprofit)
	{
		this.dateProfit = dateprofit;
	}
}
