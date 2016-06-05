package listenerAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import addInfo.AddRecord;
import addInfo.InsertSnack;
import dao.GoodDao;
import entity.Good;
import frameAdmin.MainPanel;
import info.GetSnack;
import info.Query;
import updateInfo.UpdateLink;
import frameAdmin.AddGoodDialog;

public class AddGoodListener implements ActionListener
{
	@SuppressWarnings({ "unused", "rawtypes" })
	private JComboBox jcbGoodType, jcbPackingType;
	private JTextField jtfGoodName, jtfBasePrice, jtfSellPrice, jtfShipment;// ��Ʒ�������ۣ��ۼۣ�������
	private JButton cancel, ensure;

	public AddGoodListener(JTextField jtfGoodName, @SuppressWarnings("rawtypes") JComboBox jcbGoodType,
			@SuppressWarnings("rawtypes") JComboBox jcbPackingType, JTextField jtfBasePrice, JTextField jtfSellPrice,
			JTextField jtfShipment, JButton cancel, JButton ensure)
	{
		this.jtfGoodName = jtfGoodName;
		this.jcbGoodType = jcbGoodType;
		this.jcbPackingType = jcbPackingType;
		this.jtfBasePrice = jtfBasePrice;
		this.jtfSellPrice = jtfSellPrice;
		this.jtfShipment = jtfShipment;
		this.cancel = cancel;
		this.ensure = ensure;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == cancel)
		{
			AddGoodDialog.instance().dispose();
		} else if (e.getSource() == ensure)
		{
			if (jtfGoodName.getText().equals("") || jtfBasePrice.getText().equals("")
					|| jtfSellPrice.getText().equals("") || jtfShipment.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "�뽫��Ϣ��д������");
				return;
			} else
			{
				// @@��ӵ����ݿ� UNDO
				// InsertSnack insertSnack=new InsertSnack();
				// insertSnack.insertSnack(jtfGoodName.getText(), (String)
				// jcbGoodType.getSelectedItem(),(String)
				// jcbPackingType.getSelectedItem(),
				// jtfBasePrice.getText(),
				// jtfSellPrice.getText(),jtfShipment.getText());

				GetSnack getSnack = new GetSnack();
				getSnack.getinfo();
				int n = getSnack.listSno.size();
				String sno = "0" + String.valueOf(n + 1);
				String sname = jtfGoodName.getText();
				String skind = (String) jcbGoodType.getSelectedItem();
				String spacking = (String) jcbPackingType.getSelectedItem();
				String base_price = jtfBasePrice.getText();
				String sprice = jtfSellPrice.getText();
				String in_num = jtfShipment.getText();
				String sqty = jtfShipment.getText();
				System.out
						.println(sname + " " + skind + " " + spacking + " " + base_price + " " + sprice + " " + in_num);
				UpdateLink updateLink = new UpdateLink();
				String message = "�����ɹ�";
				updateLink.setSQL("insert into snack values('" + sno + "','" + sname + "','" + skind + "','" + spacking
						+ "'," + base_price + "," + sprice + "," + in_num + "," + sqty + ")");
				String backMess = updateLink.UpdateInfo();
				if (!backMess.equals(message))
					message = backMess;
				JOptionPane.showMessageDialog(null, message);

				// @@��ӵ����ݿ� UNDO
				GoodDao.instance().addGood(new Good(sno, sname, Double.parseDouble(base_price),   
						Double.parseDouble(sprice), 0, Integer.parseInt(in_num), Integer.parseInt(sqty))); //��ӵ�������
				AddGoodDialog.instance().dispose(); // �Ի�����ʧ
				MainPanel.instance().refresh(); // ˢ��������
			}
		}

	}

}
