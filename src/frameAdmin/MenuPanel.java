package frameAdmin;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import listenerAdmin.MenuListener;

public class MenuPanel extends JPanel {
	/**
	 * MenuPanel
	 */
	private static final long serialVersionUID = -2703153422697822701L;
	private static MenuPanel menuPanel;

	public static MenuPanel instance() {
		if (menuPanel == null)
			menuPanel = new MenuPanel();
		return menuPanel;
	}

	public MenuPanel() {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 15));
		setPreferredSize(new Dimension(200, 600));

		ImageButton jbtOrder,jbtStore,jbtProfit,jbtCustomer;
		jbtOrder = new ImageButton("menu", "订单管理", 18);
		jbtStore = new ImageButton("menu", "库存管理", 18);
		jbtProfit = new ImageButton("menu", "利润分析", 18);
		jbtCustomer = new ImageButton("menu","客户信息",18);

		jbtOrder.setPreferredSize(new Dimension(180, 70));
		jbtStore.setPreferredSize(new Dimension(180, 70));
		jbtProfit.setPreferredSize(new Dimension(180, 70));
		jbtCustomer.setPreferredSize(new Dimension(180, 70));
		
		MenuListener menuListener = new MenuListener(jbtOrder,jbtStore, jbtProfit,jbtCustomer);
		jbtOrder.addActionListener(menuListener);
		jbtStore.addActionListener(menuListener);
		jbtProfit.addActionListener(menuListener);
		jbtCustomer.addActionListener(menuListener);

		add(jbtOrder);
		add(jbtStore);
		add(jbtProfit);
		add(jbtCustomer);
	}
}