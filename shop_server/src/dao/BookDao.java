package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Good;
import info.GetOrder;

public class BookDao
{
	private List<Book> bookList; // ���ж�������
	private List<Good> goodList; // ��������������Ʒ����
	private static BookDao bookDao;

	public static BookDao instance()
	{
		if (bookDao == null)
			bookDao = new BookDao();
		return bookDao;
	}

	public List<Book> getBookList()
	{
		return bookList;
	}

	public List<Good> getGoodList()
	{
		return goodList;
	}

	public void setGoodList(List<Good> goodList)
	{
		this.goodList = goodList;
	}

	public BookDao()
	{
		GetOrder getOrder=new GetOrder();
		getOrder.getinfo();
		int n=getOrder.listCno.size();
		String [] s1=new String[n];
		String [] s2=new String[n];
		String [] s3=new String[n];
		String [] s4=new String[n];
		String [] s5=new String[n];
//		int k=0;
		for(int i=0;i<n;i++){
			s1[i]=getOrder.listCno.get(i);
			s2[i]=getOrder.listTel.get(i);
			s3[i]=getOrder.listDormitory.get(i);
			s4[i]=getOrder.listSpending.get(i);
			s5[i]=getOrder.listSno_Snum.get(i);
		}

		bookList = new ArrayList<Book>();
//		for (int i = 0; i < 20; i++)
//			addBook(new Book("0001", "2004" , "13545264414", 50.0, "��", "֥ʿ����"));
//			addBook(new Book("0002", "2005" , "13545264415", 50.0, "��", "֥ʿ����"));
//			addBook(new Book("0003", "2004" , "13545264414", 50.0, "��", "֥ʿ����"));
//			addBook(new Book("0004", "2005" , "13545264415", 50.0, "��", "֥ʿ����"));
//			addBook(new Book("0005", "2004" , "13545264414", 50.0, "��", "֥ʿ����")); //�ӵ������н��治����������//�ѽ��������boolean���Ͳ���������ʾ
		int count=1;
		for(int i=0;i<n;i++){
			if(getOrder.listSno_Snum.get(i)=="")
				continue;
			addBook(new Book(String.valueOf(count++), s3[i] , s2[i], Double.valueOf(s4[i]), "��", s5[i]));
		}
	}

	public void addBook(Book book)
	{
		bookList.add(book);
	}

	private Object[] formatData(Book book)
	{
		Object[] result = new Object[6];

		result[0] = book.getBookID(); // ������,Ψһ
		result[1] = BookDao.instance().getDormitorybyId(book.getBookID()); // �����
		result[2] = BookDao.instance().getPhoneNumbyId(book.getBookID()); // �ֻ���
		result[3] = BookDao.instance().getSumPricebyId(book.getBookID()); // ��������Ʒ�ܼ�ֵ
		result[4] = BookDao.instance().getIsHandlebyId(book.getBookID()); // �Ƿ��Ѵ���
		result[5] = BookDao.instance().getGoodInfobyId(book.getBookID()); // ��������Ʒ��Ϣ

		return result;
	}

	public Object[][] getBookData()
	{
		// Object[][] result = new
		// Object[BookDao.instance().getBookList().size()][6];
		Object[][] result = new Object[1][6];
		if (bookList.size() > 0)
		{
			result = new Object[bookList.size()][6];
			Book book;
			for (int i = 0; i < bookList.size(); i++)
			{
				book = bookList.get(i);
				result[i] = formatData(book);
			}
		} else
		{
			result[0][0] = "û������";
			result[0][1] = 0;
			result[0][2] = "û������";
			result[0][3] = 0;
			result[0][4] = "û������";
			result[0][5] = "û������";
		}
		return result;
	}

	public Book getBookbyId(String bookId)
	{
		for (Book book : bookList)
		{
			if (book.getBookID() == bookId)
				return book;
		}
		return null;
	}

	public String getDormitorybyId(String bookId)
	{
		for (Book book : bookList)
		{
			if (book.getBookID() == bookId)
				return book.getDormitoryId();
		}
		return null;
	}

	public String getPhoneNumbyId(String bookId)
	{
		for (Book book : bookList)
		{
			if (book.getBookID() == bookId)
				return book.getPhoneNumber();
		}
		return null;
	}

	public double getSumPricebyId(String bookId)
	{
		for (Book book : bookList)
		{
			if (book.getBookID() == bookId)
				return book.getSumPrice();
		}
		return 0;
	}

	public String getGoodInfobyId(String bookId)
	{
		for (Book book : bookList)
		{
			if (book.getBookID() == bookId)
				return book.getGoodInfo();
		}
		return null;
	}

	public String getIsHandlebyId(String bookId)
	{
		for (Book book : bookList)
		{
			if (book.getBookID() == bookId)
				return book.getIsHandle();
		}
		return null;
	}
}
