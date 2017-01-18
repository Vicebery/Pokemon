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
	private JTextField jtfGoodName, jtfBasePrice, jtfSellPrice,jtfShipment;//��Ʒ�������ۣ��ۼۣ�������
	Box baseBox,box1,box2,box3,box4,box5,box6,box7;

	public static AddGoodDialog instance()
	{
		if (addGoodDialog == null)
			addGoodDialog = new AddGoodDialog();
		return addGoodDialog;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddGoodDialog() {
		super(MainFrameAdmin.instance(), "�����Ʒ", true);
		setLayout(new FlowLayout());
		setBounds(900, 300, 300, 300);
		addGoodDialog = this;

		JLabel jlbGoodName = new JLabel("�� Ʒ �� ��");
		jlbGoodName.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		JLabel jlbGoodType = new JLabel("��Ʒ���ͣ�");
		jlbGoodType.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		JLabel jlbPackingType = new JLabel("��װ���ͣ�");
		jlbPackingType.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		JLabel jlbBasePrice = new JLabel("��    ��  ��");
		jlbBasePrice.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		JLabel jlbSellPrice = new JLabel("��    ��  ��");
		jlbSellPrice.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		JLabel jlbShipment = new JLabel("�� �� �� ��");
		jlbShipment.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		JButton ensure = new JButton("<html><b><font size=5>ȷ��</font></b>");
		JButton cancel = new JButton("<html><b><font size=5>ȡ��</font></b>");
		jtfGoodName = new JTextField(10);
		jcbGoodType = new JComboBox();
		jcbGoodType.addItem("��");
		jcbGoodType.addItem("��");
		jcbPackingType = new JComboBox();
		jcbPackingType.addItem("��װ");
		jcbPackingType.addItem("ƿװ");
		jcbPackingType.addItem("��װ");
		jcbPackingType.addItem("Ͱװ");
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
