package frameAdmin;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.JTextField;

import listenerAdmin.AddGoodListener;


//import listener.AddRoomListener;

public class AddGoodDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AddGoodDialog addGoodDialog;
	@SuppressWarnings("rawtypes")
	private JComboBox jcbGoodType,jcbPackingType;
	private JTextField jtfGoodName, jtfBasePrice, jtfSellPrice,jtfShipment;//商品名，进价，售价，进货量
	Box baseBox,box1,box2,box3,box4,box5,box6,box7;

	public static AddGoodDialog instance()
	{
		if (addGoodDialog == null)
			addGoodDialog = new AddGoodDialog();
		return addGoodDialog;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddGoodDialog() {
		super(MainFrameAdmin.instance(), "添加商品", true);
		setLayout(new FlowLayout());
		setBounds(900, 300, 300, 300);
		addGoodDialog = this;

		JLabel jlbGoodName = new JLabel("商 品 名 ：");
		jlbGoodName.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		JLabel jlbGoodType = new JLabel("商品类型：");
		jlbGoodType.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		JLabel jlbPackingType = new JLabel("包装类型：");
		jlbPackingType.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		JLabel jlbBasePrice = new JLabel("进    价  ：");
		jlbBasePrice.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		JLabel jlbSellPrice = new JLabel("售    价  ：");
		jlbSellPrice.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		JLabel jlbShipment = new JLabel("进 货 量 ：");
		jlbShipment.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		JButton ensure = new JButton("<html><b><font size=5>确定</font></b>");
		JButton cancel = new JButton("<html><b><font size=5>取消</font></b>");
		jtfGoodName = new JTextField(10);
		jcbGoodType = new JComboBox();
		jcbGoodType.addItem("吃");
		jcbGoodType.addItem("喝");
		jcbPackingType = new JComboBox();
		jcbPackingType.addItem("袋装");
		jcbPackingType.addItem("瓶装");
		jcbPackingType.addItem("盒装");
		jcbPackingType.addItem("桶装");
		jtfBasePrice = new JTextField(10);
		jtfSellPrice = new JTextField(10);
		jtfShipment = new JTextField(10);

		AddGoodListener addGoodListener = new AddGoodListener(jtfGoodName,
				jcbGoodType, jcbPackingType, jtfBasePrice, jtfSellPrice, jtfShipment, cancel, ensure);
		jtfGoodName.addActionListener(addGoodListener);
		jtfBasePrice.addActionListener(addGoodListener);
		jtfSellPrice.addActionListener(addGoodListener);
		jtfShipment.addActionListener(addGoodListener);
		ensure.addActionListener(addGoodListener);
		cancel.addActionListener(addGoodListener);

		box1 = Box.createHorizontalBox();
		box1.add(jlbGoodName);
		box1.add(jtfGoodName);
		box2 = Box.createHorizontalBox();
		box2.add(jlbGoodType);
		box2.add(jcbGoodType);
		box3 = Box.createHorizontalBox();
		box3.add(jlbPackingType);
		box3.add(jcbPackingType);
		box4 = Box.createHorizontalBox();
		box4.add(jlbBasePrice);
		box4.add(jtfBasePrice);
		box5 =Box.createHorizontalBox();
		box5.add(jlbSellPrice);
		box5.add(jtfSellPrice);
		box6 = Box.createHorizontalBox();
		box6.add(jlbShipment);
		box6.add(jtfShipment);
		box7 = Box.createHorizontalBox();
		box7.add(cancel);
		box7.add(ensure);
		baseBox = Box.createVerticalBox();
		baseBox.add(box1);

		baseBox.add(box2);
		baseBox.add(box3);
		baseBox.add(box4);
		baseBox.add(box5);
		baseBox.add(box6);
		baseBox.add(box7);
		add(baseBox);

	}

	public void open(boolean batch)
	{
		setVisible(true);
	}
}
