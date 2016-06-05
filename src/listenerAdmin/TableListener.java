package listenerAdmin;

import java.awt.Component;
import java.awt.event.*;
import java.sql.*;
import java.util.EventObject;
import java.util.Vector;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import dao.GoodDao;
import entity.Good;
import frameAdmin.AddGoodDialog;
import frameAdmin.BookInfoDialog;
import frameAdmin.DataTable;
import frameAdmin.MainPanel;

public class TableListener extends MouseAdapter implements ActionListener//,TableCellEditor
{
	private DataTable table;
	private JPopupMenu menu;
//	String value;
//	//@@表格编辑后的值得获取
//	@SuppressWarnings("rawtypes")
//	protected transient Vector listeners;
//	protected transient String originalValue;
//	protected transient boolean editing;
//	//@@
	
	public TableListener(JPopupMenu menu)
	{
		this.table = MainPanel.instance().getTable();
		this.menu = menu;
	}

	public void mousePressed(MouseEvent e)
	{
		if (table.getSelectedRow() < 0)
		{
			int modifiers = e.getModifiers();
			modifiers -= MouseEvent.BUTTON3_MASK;
			modifiers |= MouseEvent.BUTTON1_MASK;
			MouseEvent ne = new MouseEvent(e.getComponent(), e.getID(), e.getWhen(), modifiers, e.getX(), e.getY(),
					e.getClickCount(), false);
			table.dispatchEvent(ne);
		}
	}

	public void mouseReleased(MouseEvent e)
	{
		if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0 && !e.isControlDown() && !e.isShiftDown())
		{
			menu.show(table, e.getX(), e.getY());
		}
	}

	// @Override
	public void actionPerformed(ActionEvent e)
	{
//		//@@
//		listeners = new Vector();
//		//@@
		if (table.getSelectedRow() < 0)
			return;
		String strAction = ((JMenuItem) e.getSource()).getText().trim();
		if (strAction.equals("查看订单详情"))
		{
			String bookInfo = getValue(table.getSelectedRow(),5);
			bookInfo=bookInfo.replace("] ", "\n");
			bookInfo=bookInfo.replace(' ', '\t');
			bookInfo=bookInfo.replace("[", " ");
			bookInfo=" 编号\t零食名称\t                   购买数量\n"+bookInfo;
			BookInfoDialog.instance().open(bookInfo);
			return ;
			// } else if (strAction.equals("修改价格")) //表格直接修改
			// {
			//
			// } else if (strAction.equals("修改库存"))
			// {
			//
		} else if (strAction.equals("马上处理"))
		{
			setValue(table.getSelectedRow(), 4);
			String telephone = getValue(table.getSelectedRow(), 2);
			// 订单数据库删除 UNDO
			delOrder dOrder = new delOrder();
			dOrder.setDatabaseName("pokemon_store");
			dOrder.setSQL("delete from ordering where telphone=" + telephone);
			@SuppressWarnings("unused")
			String message = dOrder.deleteOrder();
			return ;
		} else if (strAction.equals("添加新商品"))
		{
			AddGoodDialog.instance().open(false);
			return;
		} else if (strAction.equals("删除该商品"))
		{
			GoodDao goodDao = GoodDao.instance();// 界面上删除
			for (int row : table.getSelectedRows())
			{
				Good good = goodDao.getGoodbyId(getValue(row, 0));
				if (good == null)
					return;
				goodDao.removeGood(good);
			}
			removeSelectedRows();
			// UNDO
			// 数据库内部删除
			//

		}
	}

	private String ReturnChangeValue(ActionEvent e)//返回界面上的修改值
	{
		String changedInfo = new String();
//		e.ge
		return changedInfo;
	}
	
	private String getValue(int row, int column)
	{
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		return tableModel.getValueAt(row, column).toString();
	}

	private void setValue(int row, int column)
	{
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setValueAt("是", row, column);
	}

	// private String getSelectedValue(int column)
	// {
	// if (table.getSelectedRow() < 0)
	// return null;
	// DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	// return tableModel.getValueAt(table.getSelectedRow(), column).toString();
	// }

	@SuppressWarnings("unused")
	private void removeSelectedRow()
	{
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.removeRow(table.getSelectedRow());
	}

	private void removeSelectedRows()
	{
		if (table.getSelectedRow() < 0)
			return;
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		boolean isEndSelect = false;
		if (table.getSelectedRows()[table.getSelectedRows().length - 1] == tableModel.getRowCount() - 1)
		{
			isEndSelect = true;
		}
		while (table.getSelectedRow() >= 0)
		{
			tableModel.removeRow(table.getSelectedRow());
		}
		if (isEndSelect && tableModel.getRowCount() > 0)
		{
			tableModel.removeRow(tableModel.getRowCount() - 1);
		}
		if (tableModel.getRowCount() <= 0)
		{
			MainPanel.instance().refresh();
		}
	}

	class delOrder
	{
		String databaseName = "";
		String SQL, message = "";

		public delOrder()
		{
			try
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (Exception e)
			{
			}
		}

		public void setSQL(String SQL)
		{
			this.SQL = SQL;
		}

		public void setDatabaseName(String s)
		{
			databaseName = s;
		}

		public String deleteOrder()
		{
			Connection con = null;
			Statement sql = null;
			try
			{
//				String uri = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pokemon_store";
				String uri="jdbc:sqlserver://192.168.16.222:1433;DatabaseName=pokemon_store";
				String id = "admin";
				String password = "admin";
				con = DriverManager.getConnection(uri, id, password);
				sql = con.createStatement();
				sql.execute(SQL);
				message = "操作成功";
				con.close();
			} catch (SQLException e)
			{
				// TODO: handle exception
				message = e.toString();
			}
			return message;
		}
	}

//	//获取表格编辑后的值
//	@Override
//	public void addCellEditorListener(CellEditorListener l)
//	{
//		// TODO Auto-generated method stub
//		listeners.addElement(l);
//	}
//
//	@Override
//	public void cancelCellEditing()
//	{
//		// TODO Auto-generated method stub
//		fireEditingCanceled();
//		editing = false;
//	}
//	protected void fireEditingCanceled()
//	{
////		setValue(originalValue);
//		ChangeEvent ce = new ChangeEvent(this);
//		for (int i = listeners.size() - 1; i >= 0; i--)
//		{
//			((CellEditorListener) listeners.elementAt(i)).editingCanceled(ce);
//		}
//	}
//	@Override
//	public String getCellEditorValue()
//	{
//		// TODO Auto-generated method stub
//		return value;
//	}
//
//	@Override
//	public boolean isCellEditable(EventObject anEvent)
//	{
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void removeCellEditorListener(CellEditorListener l)
//	{
//		// TODO Auto-generated method stub
//		listeners.removeElement(l);
//	}
//
//	@Override
//	public boolean shouldSelectCell(EventObject anEvent)
//	{
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean stopCellEditing()
//	{
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
//	{
//		// TODO Auto-generated method stub
//		return null;
//	}
}
