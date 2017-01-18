package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Customer;
import info.GetCustomer;

public class CustomerDao
{
	private List<Customer> customerList; // 所有顾客集合
	private static CustomerDao customerDao;

	public static CustomerDao instance()
	{
		if (customerDao == null)
			customerDao = new CustomerDao();
		return customerDao;
	}

	public CustomerDao()
	{
//		customerList = new ArrayList<Customer>();
//		addCustomer(new Customer("A2004","13545264414", 1185.6));
		GetCustomer getCustomer=new GetCustomer();
		getCustomer.getinfo();
		int n=getCustomer.listTel.size();
		String [] s1=new String[n];
		String [] s2=new String[n];
		String [] s3=new String[n];
		for(int i=0;i<n;i++){
			s1[i]=getCustomer.listDormitory.get(i);
			s2[i]=getCustomer.listTel.get(i);
			s3[i]=getCustomer.listAll_spending.get(i);
		}
		customerList = new ArrayList<Customer>();
		for(int i=0;i<n;i++){
			addCustomer(new Customer(s1[i], s2[i] , Double.parseDouble(s3[i])));
		}
	}

	public void addCustomer(Customer customer)
	{
		customerList.add(customer);
	}

	private Object[] formatData(Customer customer)
	{
		Object[] result = new Object[3];
		result[0] = CustomerDao.instance().getDormitoryIdbyPhoneNumber(customer.phoneNumber);
		result[1] = customer.phoneNumber;
		result[2] = customer.getSumCost();

		return result;
	}

	public Object[][] getCustomerData()
	{
		Object[][] result = new Object[CustomerDao.instance().getCustomerList().size()][3];
//		Object[][] result = new Object[1][3];
		if (customerList.size() > 0)
		{
//			result = new Object[customerList.size()][3];  
			Customer customer;
			for (int i = 0; i < customerList.size(); i++)
			{
				customer = customerList.get(i);
				result[i] = formatData(customer);
			}
		} else
		{
			result[0][0] = "没有数据";
			result[0][1] = "没有数据";
			result[0][2] = 0;
		}
		return result;
	}

	public List<Customer> getCustomerList()
	{
		return customerList;
	}

	public String getDormitoryIdbyPhoneNumber(String phoneNumber) // 以手机号唯一确定宿舍号
	{
		for (Customer customer : customerList)
		{
			if (customer.phoneNumber == phoneNumber)
				return customer.dormitoryId;
		}
		return null;
	}
}
