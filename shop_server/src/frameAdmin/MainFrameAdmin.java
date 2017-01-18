package frameAdmin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrameAdmin extends JFrame implements Runnable
{
	/**
	 * MainFrame
	 */
	private static final long serialVersionUID = -5988513125942516733L;
	private static MainFrameAdmin mainFrameAdmin;

	public static MainFrameAdmin instance() // 单例对象
	{
		if (mainFrameAdmin == null)
			mainFrameAdmin = new MainFrameAdmin();
		return mainFrameAdmin;
	}

	public MainFrameAdmin()
	{
		setTitle("宿舍商店销售后台管理");
		mainFrameAdmin = this;
		setUndecorated(true);
		// setAlwaysOnTop(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setMinimumSize(new Dimension(1024, 768));

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		 container.add(new OptionPanel(), BorderLayout.NORTH);
		 container.add(new MenuPanel(), BorderLayout.WEST);
		 container.add(new MainPanel(), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/icon2.png")).getImage());

		((JPanel) this.getContentPane()).setOpaque(false);
		BackgroundPanel background = new BackgroundPanel(); //
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	}

	public void open()
	{
		setVisible(true);
		LoginFrameAdmin.instance().setVisible(false);
		LoginFrameAdmin.getLoginDialog().setVisible(false);
	}

	@Override
	public void run()
	{
		instance();
	}
}
