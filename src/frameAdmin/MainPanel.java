package frameAdmin;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import listenerAdmin.TableListener;
import dao.BookDao;
import dao.CustomerDao;
import dao.GoodDao;
import dao.ProfitDao;

public class MainPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4090036947302273308L;
	private static MainPanel mainPanel;
	private DataTable table;
	private JScrollPane jscrolPane;
	private String dataType;
	int ID_Table;
	
	public static MainPanel instance()
	{
		if (mainPanel == null)
			mainPanel = new MainPanel();
		return mainPanel;
	}

	public MainPanel()
	{
		mainPanel = this;
		setOpaque(false); // 透明
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 20, 10));
		table = new DataTable(null, null,0);
		jscrolPane = new JScrollPane(); // 滚动条
		jscrolPane.setBorder(null);
		jscrolPane.setOpaque(false);
		jscrolPane.getViewport().setOpaque(false);
		add(jscrolPane);
		showOrder();
	}

	@Override
	public void paint(Graphics g)
	{
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/scrollpane.png"));
		Image img = icon.getImage();
		g.drawImage(img, jscrolPane.getX(), jscrolPane.getY(), jscrolPane.getWidth(), jscrolPane.getHeight(), this);
		super.paint(g);
	}

	public DataTable getTable()
	{
		return table;
	}

	public void showOrder()  //无需编辑，仅显示
	{
		dataType = "Order";
		ID_Table = 1;
		Object[] head = { "订单号","宿舍号", "手机号", "总消费" ,"是否处理","订单详情" };
		showData(BookDao.instance().getBookData(), head,1);
		JMenuItem detail = new JMenuItem(" 查看订单详情    ");
		JMenuItem deal = new JMenuItem(" 马上处理 ");
		JPopupMenu menu = new JPopupMenu();
		menu.add(detail);
		menu.add(deal);
		TableListener tableListener = new TableListener(menu);
		table.addMouseListener(tableListener);
		table.addMouseMotionListener(tableListener);
		detail.addActionListener(tableListener);
		deal.addActionListener(tableListener);
	}

	public void showStore()
	{
		ID_Table = 2;
		dataType = "Store";
		Object[] head = { "编号", "商品名", "进价", "售价", "已售","进货量","库存量" };
		showData(GoodDao.instance().getGoodData(), head, 2);
		JPopupMenu menu = new JPopupMenu();
//		JMenuItem edit_Price = new JMenuItem("    修改价格    ");
	
		JMenuItem add = new JMenuItem("  添加新商品    ");
		JMenuItem delete = new JMenuItem("   删除该商品    ");
//		menu.add(edit_Price);
		
		menu.add(add);
		menu.add(delete);
		TableListener tableListener = new TableListener(menu);
		table.addMouseListener(tableListener);
		table.addMouseMotionListener(tableListener);
//		table.addInputMethodListener(l);
		add.addActionListener(tableListener);
		delete.addActionListener(tableListener);
	}

	public void showProfit()
	{
		ID_Table = 3;
		dataType = "Profit";
		Object[] head = { "日期", "总销售额", "净利润" };
		showData(ProfitDao.instance().getProfitData(), head, 3);
		
	}

	public void showCustomer()
	{
		ID_Table = 4;
		dataType = "Customer";
		Object[] head = { "宿舍号", "手机号", "累计消费额" };
		showData(CustomerDao.instance().getCustomerData(), head, 4);
	}
	
	public void showData(Object[][] data, Object[] head, int id_Table)
	{
		table.removeAll();
		table = new DataTable(data, head,id_Table);
		jscrolPane.setViewportView(table);
	}

	public void refresh()
	{
		if (dataType.equals("Order"))
		{
			showOrder();
		} else if (dataType.equals("Store"))
		{
			showStore();
		} else if (dataType.equals("Profit"))
		{
			showProfit();
		}else if (dataType.equals("Customer"))
		{
			showCustomer();
		}
	}
}
