package frameAdmin;

import java.awt.Font;


import javax.swing.*;


public class BookInfoDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7228765492296653353L;
	private static BookInfoDialog bookInfoDialog;
	private JTextArea jBookInfo;
	
	public static BookInfoDialog instance() {
		if (bookInfoDialog == null)
			bookInfoDialog = new BookInfoDialog();
		return bookInfoDialog;
	}

	public BookInfoDialog() {
		super(MainFrameAdmin.instance(), "订单详情", true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		
		bookInfoDialog = this;
		jBookInfo = new JTextArea();
		jBookInfo.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		jBookInfo.setEditable(false);
		jBookInfo.setVisible(true);

		add(jBookInfo);
	}

	public void open(String bookInfo) {	
		if(bookInfo==null)
			bookInfo = " 无法读取数据  ！";
		jBookInfo.setText(bookInfo);
		setVisible(true);
	}
}

