package com.cyn.Issuesystem;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.cyn.MainInterface;
import com.cyn.RButton;
import com.cyn.Static.Information;

public class PersonalInformation extends JPanel implements ActionListener{
	private RButton back;
	private static JTextArea textArea;
	private JLabel label;
	private static String info;
	private JTextField tf_card;
	private JLabel lb_card;
	private RButton btn_search;
	private static JTable LiarbryTable;
	private static JTableHeader jth;
	private static JScrollPane jsp;

	/**
	 * Create the panel.
	 */
	public PersonalInformation() {
		setBackground(new Color(146, 156, 100));
		setLayout(null);
		jsp=new JScrollPane();//设置滚动条
		jsp.setBounds(152,142,1000,782);
		add(jsp);
		
		back = new RButton("Back");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("Personal Information ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(165, 20, 500, 105);
		add(label);

		lb_card = new JLabel("Card Number:");
		lb_card.setFont(new Font("宋体", Font.BOLD, 35));
		lb_card.setBounds(675, 35, 400, 55);
		add(lb_card);

		tf_card = new JTextField();
		tf_card.setFont(new Font("宋体", Font.BOLD, 35));
		tf_card.setColumns(10);
		tf_card.setBounds(930, 35, 100, 75);
		add(tf_card);

		btn_search = new RButton("Search");
		btn_search.setFont(new Font("宋体", Font.BOLD, 30));
		btn_search.setBounds(1100, 35, 180, 80);
		add(btn_search);
		btn_search.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBounds(111, 125, 1050, 782);
		textArea.setLineWrap(true);
		add(textArea);
		
		//info = "Book ID           Category Name            Book Name            Deadline\n";

	}

	public static void setTextArea(String card) {
		/*info = "Book ID           Category Name            Book Name            Deadline\n";
		
		for(int i = 0; i<Information.bookArray.size(); i++) {
			info = info+"  "+Information.bookArray.get(i).number+"                 ";
			info = info+Information.bookArray.get(i).classname;
            for(int j = 0; j<(24-Information.bookArray.get(i).classname.length()); j++) {
            	info = info +" ";
            }	
			info = info+Information.bookArray.get(i).name;
            for(int j = 0; j<(30-Information.bookArray.get(i).name.length()); j++) {
            	info = info +" ";
            }			
            info = info+"      "+Information.bookArray.get(i).dateoff+"        ";
		}
		textArea.setText(info);
		 */

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = Information.JDBC_URL;
			Connection conn1 = DriverManager.getConnection(url, Information.username, Information.password);
			String num1 = "select * from "+card+"customer;";
			PreparedStatement pstm = conn1.prepareStatement(num1);
			ResultSet Rs = pstm.executeQuery();
			int count = 0;//计算有多少条纪录
			while (Rs.next()) {
				count++;

			}
			Rs = pstm.executeQuery();
			//将查询获得的纪录数据，转换成适合生成Jtable的数据形式
			Object[][] info = new Object[count][5];
			count = 0;
			while (Rs.next()) {
				info[count][0] = Rs.getString("card");
				info[count][1] = Rs.getString("number");
				info[count][2] = Rs.getString("classname");
				info[count][3] = Rs.getString("dateon");
				info[count][4] = Rs.getString("dateoff");

				count++;
			}
			String[] title = {"CardNumber", "BookID", "CategoryName", "DateOn", "DateOff"};//定义表头
			LiarbryTable = new JTable(info, title);//创建表
			jth = LiarbryTable.getTableHeader();//显示表头
			jsp.getViewport().add(LiarbryTable);//添加滚动条到table中

		} catch (
				ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Null date error", "error", JOptionPane.ERROR_MESSAGE);
		} catch (
				SQLException e) {
			JOptionPane.showMessageDialog(null, "Null date source error", "error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.PersonaltoUser();
		}
		else if(e.getSource() == btn_search)
		{
			String card = tf_card.getText();
			setTextArea(card);
		}
	}
}
