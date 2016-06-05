package entity;

public class Good // "���", "��Ʒ��", "����", "�ۼ�", "����","������","�����"
{
	private String id; //���
	private String name; //��Ʒ��
	private String type; //��Ʒ��������
	private int count; // �ͻ��������Ʒ����
	private double base_price; // ����
	private double sell_price; // �ۼ�
	private int numSelled;// ����
	private int numRest;// �����
	private int numSum;// ������
//	private static int autoId;

	public Good(String id, String name, double b_price, double s_price, int numSelled, int numSum, int numRest)
	{
		this.id = id;
		this.name = name;
		this.base_price = b_price;
		this.sell_price = s_price;
		this.setNumSelled(numSelled);
		this.setNumSum(numSum);
		this.numRest = numRest;
	}
//	public Good(String name, String type, int count, double b_price, double s_price, int numSelled, int numRest,
//			int numSum)
//	{
//		this.id = ++autoId;
//		this.name = name;
//		this.type = type;
//		this.setCount(count);
//		this.base_price = b_price;
//		this.sell_price = s_price;
//		this.setNumSelled(numSelled);
//		this.numRest = numRest;
//		this.setNumSum(numSum);
//	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public double getsell_Price()
	{
		return sell_price;
	}

	public double getbase_Price()
	{
		return base_price;
	}

	public void setsell_Price(double price)
	{
		this.sell_price = price;
	}

	public void setbase_Price(double price)
	{
		this.base_price = price;
	}

	public int getNumRest()
	{
		return numRest;
	}

	public void setNumRest(int numRest)
	{
		this.numRest = numRest;
	}

//	public String toString()
//	{
//		return name + " (���� " + sell_price + " Ԫ)";
//	}

	public int getNumSum()
	{
		return numSum;
	}

	public void setNumSum(int numSum)
	{
		this.numSum = numSum;
	}

	public int getNumSelled()
	{
		return numSelled;
	}

	public void setNumSelled(int numSelled)
	{
		this.numSelled = numSelled;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}
	
}
