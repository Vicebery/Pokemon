package frameAdmin;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;


import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DataTable extends JTable //implements  TableCellEditor
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -251519594436074037L;

	int ID_Table;// 实现不同表格的是否可编辑

	@SuppressWarnings("serial")
	public DataTable(final Object[][] data, Object[] head, int id)
	{
		super(new DefaultTableModel(data, head)
		{
			public Class<?> getColumnClass(int column)
			{
				if (data.length > 0 && column < getRowCount() && getValueAt(0, column) != null)
					return getValueAt(0, column).getClass();
				return Object.class;
			}
		});
		this.ID_Table = id;
//		putClientProperty("terminateEditOnFocusLost", Boolean.FALSE);
		setRowHeight(30);
		setOpaque(false);
		setRowSorter(new TableRowSorter<TableModel>(getModel()));
		setFont(new Font("微软雅黑", Font.PLAIN, 24));
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		getTableHeader().repaint();
	}

	public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
	{
		Component c = super.prepareRenderer(renderer, row, column);
		boolean selected = false;
		for (int i : getSelectedRows())
		{
			if (row == i)
			{
				selected = true;
				break;
			}
		}
		if (c instanceof JComponent)
		{
			((JLabel) c).setHorizontalAlignment(JLabel.CENTER); // @@此处出现过异常，如果表格里的数据是boolean类型的话，会导致整个表格出现异常
			((JComponent) c).setOpaque(false);
			if (selected)
			{
				((JComponent) c).setOpaque(true);
			}
		}
		return c;
	}

	public JTableHeader getTableHeader()
	{
		JTableHeader tableHeader = super.getTableHeader();
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tableHeader.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		return tableHeader;
	}

	public boolean isCellEditable(int row, int column)
	{
		if (ID_Table == 2)
			return true;
		else
			return false;
	}

	//获取表格编辑后的值
//	@Override
//	public void addCellEditorListener(CellEditorListener arg0)
//	{
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void cancelCellEditing()
//	{
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Object getCellEditorValue()
//	{
//		// TODO Auto-generated method stub
//		return null;
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
//		
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
//	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4)
//	{
//		// TODO Auto-generated method stub
//		return null;
//	}
}