package addInfo;

import javax.swing.JOptionPane;

import info.Query;

public class InsertSnack {
	public void insertSnack(String sname, String skind, String spacking, String base_price, String sprice,
			String in_num)
	{
		AddRecord addRecord = new AddRecord();
		String tableName = "Snack";
		addRecord.setTableName(tableName);
		Query query = new Query();
		query.setTableName(tableName);
		int no = query.inputQueryResult().size();
		addRecord.setSnack(String.valueOf(no + 1), sname, skind, spacking, Double.parseDouble(base_price),
				Double.parseDouble(sprice), Integer.parseInt(in_num), Integer.parseInt(in_num));
		String message = addRecord.addSnack();
		JOptionPane.showMessageDialog(null, message);
	}
}
