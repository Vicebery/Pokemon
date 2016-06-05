package entity;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
	public String dormitoryId; // �����
	public String phoneNumber; // �ֻ���
	private List<Book> bookList;
	private double sumCost; // �ۼ����ѽ��

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

	public double getSumCost() // ����ù˿���ʷ���ѽ��
	{
//		sumCost = 0;                              //�˴������ö��������������ܺͣ����ڶ�������û�г�ʼ������û���κ�����
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
