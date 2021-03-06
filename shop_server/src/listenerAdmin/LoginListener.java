package listenerAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.AccountDao;
import frameAdmin.ImageButton;
import frameAdmin.LoginFrameAdmin;
import frameAdmin.MainFrameAdmin;

public class LoginListener extends MouseAdapter implements ActionListener
{

	private JTextField jtfUserName;
	private JPasswordField jpfPassword;
	private ImageButton ensure;
	private ImageButton cancel;

	public LoginListener(JTextField jtfUserName, JPasswordField jpfPassword, ImageButton ensure, ImageButton cancel)
	{
		this.jtfUserName = jtfUserName;
		this.jpfPassword = jpfPassword;
		this.ensure = ensure;
		this.cancel = cancel;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == jtfUserName || e.getSource() == jpfPassword || e.getSource() == ensure)
		{
			if (jtfUserName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "请输入用户名！", "提示", JOptionPane.ERROR_MESSAGE);

			} else if (jpfPassword.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(null, "请输入密码！", "提示", JOptionPane.ERROR_MESSAGE);
			} else if (AccountDao.instance().check(jtfUserName.getText(), String.valueOf(jpfPassword.getPassword())))
			{
				LoginFrameAdmin.instance().setVisible(false); // 登陆窗消失
				MainFrameAdmin.instance().open(); // 主窗体出现
			} else
			{
				JOptionPane.showMessageDialog(null, "用户名或密码错误！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == cancel)
		{
			System.exit(0);
		}
	}
}
