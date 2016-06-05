package listenerAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import frameAdmin.MainPanel;

public class MenuListener implements ActionListener {

	private JButton jbtOrder, jbtStore, jbtProfit,jbtCustomer;

	public MenuListener(JButton jbtOrder, JButton jbtStore,JButton jbtProfit,JButton jbtCustomer) {
		this.jbtOrder = jbtOrder;
		this.jbtStore = jbtStore;
		this.jbtProfit = jbtProfit;
		this.jbtCustomer = jbtCustomer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtOrder) {
			MainPanel.instance().showOrder();
		} else if (e.getSource() == jbtStore) {
			MainPanel.instance().showStore();
		} else if (e.getSource() == jbtProfit) {
			MainPanel.instance().showProfit();
		}else if (e.getSource() == jbtCustomer) {
			MainPanel.instance().showCustomer();
		}
	}

}
