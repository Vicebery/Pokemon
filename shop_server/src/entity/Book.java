package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book
{
//	@SuppressWarnings("unused")
	private String bookID; // ������
//	private Customer customer; // �˿���Ϣ
	private String dormitoryId;
	private String phoneNumber;
	private String goodInfo; // ��Ʒ��Ϣ��
	private List<Good> goodList; // ����������Ʒ����
	private double basePrice; // �ö����ܽ���
	private double sumPrice; // �ö����ܼƼ۸�
	private Date bookTime; // ��������ʱ��
	private String IsHandle; // �����Ƿ���  //������boolean���ͣ���д����ʱ������쳣��

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

	public String getBookYearMonDay() // ��ȡ�������ɵ������գ��������������
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		if (this.getBookTime() != null)
			return formatter.format(this.getBookTime());
		else
			return null;
	}

	public String getBookID()
	{
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHMMSS-"); //�˷�������
//		return formatter.format(bookTime) + Integer.toString(dormitoryId); // ʱ��+�����=������
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
		goodList = new ArrayList<Good>();   //��ʵ������Ϊ��
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

	public double getSumPrice() // ���㵱ǰ����������Ʒ�ܼ�ֵ
	{
//		goodList = this.getGoodList();//�����ݿ����
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

	public String getGoodInfo() // ��ȡ��ǰ����������Ʒ��Ϣ
	{
		goodList = this.getGoodList();
		for (Good good : goodList)
		{
			goodInfo = good.getName() + "(" + good.getCount() + ")" + "--";
		}
		return goodInfo;
	}

	public double getBasePrice() // ��ȡ��ǰ����������Ʒ�ı���
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
