package frameAdmin;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import listenerAdmin.OptionListener;

public class OptionPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1613590806361203632L;
	private static OptionPanel optionPanel;

	static public OptionPanel instance()
	{
		if (optionPanel == null)
			optionPanel = new OptionPanel();
		return optionPanel;
	}

	public OptionPanel()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		setSize(1366, 150);
		setOpaque(false);
		optionPanel = this;
		ImageButton jbtStore = new ImageButton("store");
		ImageButton jbtSearch = new ImageButton("search");
		ImageButton jbtRefresh = new ImageButton("refresh");
		ImageButton jbtAdmin = new ImageButton("admin");
		ImageButton jbtExit = new ImageButton("exit");
		
		jbtStore.setToolTipText("仓库管理");
		jbtSearch.setToolTipText("搜索");
		jbtRefresh.setToolTipText("　刷新仓库　");
		jbtAdmin.setToolTipText("　账户管理　");
		jbtExit.setToolTipText("　退出　");
		
		jbtStore.setPreferredSize(new Dimension(80, 80));
		jbtSearch.setPreferredSize(new Dimension(80, 80));
		jbtRefresh.setPreferredSize(new Dimension(80, 80));
		jbtAdmin.setPreferredSize(new Dimension(80, 80));
		jbtExit.setPreferredSize(new Dimension(80, 80));

		OptionListener optionListener = new OptionListener(jbtStore,jbtSearch,jbtRefresh, jbtAdmin,jbtExit);
		jbtStore.addActionListener(optionListener);
		jbtSearch.addActionListener(optionListener);
		jbtRefresh.addActionListener(optionListener);
		jbtAdmin.addActionListener(optionListener);
		jbtExit.addActionListener(optionListener);
		
		add(jbtStore);
		add(jbtSearch);
		add(jbtRefresh);
		add(jbtAdmin);
		add(jbtExit);
	}
}
