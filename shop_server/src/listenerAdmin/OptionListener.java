package listenerAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

//import frameAdmin.BookRoomDialog;
//import frameAdmin.ConfigDialog;
//import frameAdmin.MainPanel;
//import frameAdmin.TakeRoomDialog;
import frameAdmin.LoginFrameAdmin;
import frameAdmin.MainFrameAdmin;
import frameAdmin.MainPanel;
import info.GetDayProfit;
import info.GetShopkeeper;
import info.GetShopper;
import info.GetSnack;
import info.Query;
import updateInfo.UpdateLink;

public class OptionListener implements ActionListener
{
	JButton jbtStore;
	JButton jbtSearch;
	JButton jbtRefresh;
	JButton jbtAdmin;
	JButton jbtExit;

	public OptionListener(JButton jbtStore, JButton jbtSearch,JButton jbtRefresh, JButton jbtAdmin, JButton jbtExit)
	{
		super();
		this.jbtStore = jbtStore;
		this.jbtSearch = jbtSearch;
		this.jbtRefresh = jbtRefresh;
		this.jbtAdmin = jbtAdmin;
		this.jbtExit = jbtExit;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == jbtStore)
		{
			MainPanel.instance().showOrder();
		} else if (e.getSource() == jbtSearch)
		{
//			System.out.println("145");
			//搜索
		} else if (e.getSource() == jbtRefresh)
		{
			//刷新数据库以及界面
			 //1.刷新数据库零食信息
			GetSnack getSnack=new GetSnack();
			getSnack.getinfo();
			int n=getSnack.listSno.size();	//待刷新的零食数量
			String [] sqty=new String[n];
			String [] sno=new String[n];
			String [] sprice=new String[n];
			String [] base_price=new String[n];
			String [] snum=new String[n];
			for(int i=0;i<n;i++){
				sno[i]=getSnack.listSno.get(i);
				sqty[i]=getSnack.listSqty.get(i);//零食当前库存量
				base_price[i]=getSnack.listBase_price.get(i);
				sprice[i]=getSnack.listSprice.get(i);
			}
			
			ArrayList<String> listSnum=new ArrayList<String>();
			Query querySnum=new Query();
			String tableNameOrdering="Ordering";
			querySnum.setTableName(tableNameOrdering);
			for(int i=0;i<n;i++){
				String sqlSnum="select snum from "+tableNameOrdering+" where sno ='"
						+sno[i]+"'";
				querySnum.setSQL(sqlSnum);
				listSnum=querySnum.inputQueryResult();
				int sum=0;
				for(int j=0;j<listSnum.size();j++){
					sqty[i]=String.valueOf(Integer.parseInt(sqty[i])-Integer.parseInt(listSnum.get(j)));
					sum=sum+Integer.parseInt(listSnum.get(j));
				}
				snum[i]=String.valueOf(sum);
			}
			UpdateLink updateLink1=new UpdateLink();
			String message1="操作成功";
			for(int i=0;i<n;i++){
				updateLink1.setSQL("update snack set sqty ="+sqty[i]+" where sno ='"+sno[i]+"'");
				String backMess1=updateLink1.UpdateInfo();
				if(!backMess1.equals(message1)){
					message1=backMess1;
					break;
				}
			}
//			JOptionPane.showMessageDialog(null, message1);
			 //2.刷新数据库零食信息
			GetShopkeeper getShopkeeper=new GetShopkeeper();
			getShopkeeper.getinfo();
			int m=getShopkeeper.listUsername.size();	//待刷新的店主数量
			String [] username=new String[m];
			String [] income=new String[m];
			String [] base_cost=new String[m];
			String [] profit=new String[m];
			for(int i=0;i<m;i++){
				username[i]=getShopkeeper.listUsername.get(i);
				income[i]=getShopkeeper.listIncome.get(i);
				base_cost[i]=getShopkeeper.listBase_cost.get(i);
				profit[i]=getShopkeeper.listProfit.get(i);
			}
			for(int j=0;j<m;j++){
				for(int i=0;i<n;i++){
					income[j]=String.valueOf(Double.parseDouble(income[j])+
							Double.parseDouble(sprice[i])*Double.parseDouble(snum[i]));
					base_cost[j]=String.valueOf(Double.parseDouble(base_cost[j])+
							Double.parseDouble(base_price[i])*Double.parseDouble(snum[i]));
		
				}
				profit[j]=String.valueOf(Double.parseDouble(income[j])-Double.parseDouble(base_cost[j]));
			}
			
			UpdateLink updateLink2=new UpdateLink();
			String message2="操作成功";
			for(int i=0;i<m;i++){
				updateLink2.setSQL("update shopkeeper set income ="+income[i]
						+",base_cost ="+base_cost[i]+",profit ="+profit[i]+
						" where username ='"+username[i]+"'");
				String backMess2=updateLink2.UpdateInfo();
				if(!backMess2.equals(message2)){
					message2=backMess2;
					break;
				}
			}
//			JOptionPane.showMessageDialog(null, message2);
			 //3.刷新数据库购物者信息
			GetShopper getShopper=new GetShopper();
			getShopkeeper.getinfo();
			int p=getShopper.listTel.size();//待刷新的消费者数量
			String [] tel=new String[p];
			String [] all_spending=new String[p];
			for(int i=0;i<p;i++){
				tel[i]=getShopper.listTel.get(i);
				all_spending[i]=getShopper.listAll_spending.get(i);
			}
			ArrayList<String> listSpending=new ArrayList<String>();
			Query querySpending=new Query();
			String tableConsuming_records="consuming_records";
			querySpending.setTableName(tableConsuming_records);
			for(int i=0;i<p;i++){
				String sqlSpending="select spending from "+tableConsuming_records
						+" where telphone ='"+tel[i]+"'";
				querySpending.setSQL(sqlSpending);
				listSpending=querySpending.inputQueryResult();
				double sum=0;
				for(int j=0;j<listSpending.size();j++){
					sum=sum+Double.parseDouble(listSnum.get(j));
				}
				all_spending[i]=String.valueOf(sum);
			}
			UpdateLink updateLink3=new UpdateLink();
			String message3="操作成功";
			for(int i=0;i<p;i++){
				updateLink3.setSQL("update shopper set all_spending ="+all_spending[i]
						+" where telphone ='"+tel[i]+"'");
				String backMess3=updateLink3.UpdateInfo();
				if(!backMess3.equals(message3)){
					message3=backMess3;
					break;
				}
			}
//			JOptionPane.showMessageDialog(null, message3);
			//4.刷新数据库日利润统计
			GetDayProfit getDayProfit=new GetDayProfit();
			getDayProfit.getinfo();
			int r=getDayProfit.listTheDay.size();//待刷新天数
			String [] theDay=new String[n];
			String [] dayIncome=new String[n];
			String [] dayBase_cost=new String[n];
			String [] dayProfit=new String[n];
			for(int i=0;i<r;i++){
				theDay[i]=getDayProfit.listTheDay.get(i);
				dayIncome[i]=getDayProfit.listDayIncome.get(i);
				dayBase_cost[i]=getDayProfit.listDayBase_cost.get(i);
				dayProfit[i]=getDayProfit.listDayProfit.get(i);
			}
			  //dayIncome=sprice*snum,
			double temp1=0;
			double temp2=0;
			for(int i=0;i<n;i++){
				temp1=temp1+Double.parseDouble(sprice[i])*Double.parseDouble(snum[i]);
				temp2=temp2+Double.parseDouble(base_price[i])*Double.parseDouble(snum[i]);
			}
			  //获取当前日期比较是否包含在theDay中，若包含，则update，若不包含，则insert
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(new Date());
			int year=calendar.get(Calendar.YEAR);
			int month=calendar.get(Calendar.MONTH)+1;
			int day=calendar.get(Calendar.DAY_OF_MONTH);
			String Day=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
			boolean flag=false;
			for(int i=0;i<r;i++){
				if(theDay[i].equals(Day))
					flag=true;
			}
			if(flag){
				UpdateLink updateLink4=new UpdateLink();
				String message4="操作成功";
				updateLink4.setSQL("update dayProfit set dayIncome ="+String.valueOf(temp1)
						+",dayBase_cost ="+String.valueOf(temp2)+",dayProfit ="+String.valueOf(temp1-temp2)
						+" where theDay ='"+Day+"'");
				String backMess4=updateLink4.UpdateInfo();
				if(!backMess4.equals(message4)){
					message4=backMess4;
				}
				JOptionPane.showMessageDialog(null, message4);
			}
			else{
				UpdateLink updateLink5=new UpdateLink();
				String message5="操作成功";
				updateLink5.setSQL("insert into dayProfit values('"+Day+"',"+String.valueOf(temp1)
						+","+String.valueOf(temp2)+","+String.valueOf(temp1-temp2)+")");
				String backMess5=updateLink5.UpdateInfo();
				if(!backMess5.equals(message5)){
					message5=backMess5;
				}
				JOptionPane.showMessageDialog(null, message5);
			}
			//刷新数据库以及界面
		} else if (e.getSource() == jbtAdmin)
		{
			LoginFrameAdmin.instance().open();
			MainFrameAdmin.instance().dispose();
		} else if (e.getSource() == jbtExit)
		{
			System.exit(0);
		}
	}
}
