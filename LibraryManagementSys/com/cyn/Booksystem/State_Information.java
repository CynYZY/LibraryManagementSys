package com.cyn.Booksystem;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import com.cyn.MainInterface;
import com.cyn.RButton;
import com.cyn.Static.Information;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class State_Information extends JPanel implements ActionListener {
	private RButton back;
	private static JTextArea textArea;
	private static String info;
	private JLabel label;
	private static JTable LiarbryTable;
	private static JTableHeader jth;
	private static JScrollPane jsp;

	/**
	 * Create the panel.
	 */
	public State_Information() {
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

		label = new JLabel("State Information ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(425, 20, 500, 105);
		add(label);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(111, 125, 1050, 782);
		add(textArea);
		
		textArea.setEditable(false);
		
		//info = "BookID     CategotyID     Book Name      Category Name      Price     State    Borrower   Deadline\n";
		
	}
	
	public static void setTextArea() {
		/*info = "BookID     CategotyID     Book Name      Category Name      Price     State    Borrower   Deadline\n";
		
		for(int i = 0; i<Information.bookArray.size(); i++) {
			info = info+"  "+Information.bookArray.get(i).number+"          ";
			info = info+Information.bookArray.get(i).classnumber+"          ";
			info = info+Information.bookArray.get(i).name;
            for(int j = 0; j<(19-Information.bookArray.get(i).name.length()); j++) {
            	info = info +" ";
            }			
            info = info+"      "+Information.bookArray.get(i).classname+"       ";
            info = info+Information.bookArray.get(i).price+"        ";
            info = info+Information.bookArray.get(i).state;
            for(int j = 0; j<(9-Information.bookArray.get(i).state.length()); j++) {
            	info = info +" ";
            }		
            info = info+Information.bookArray.get(i).current+"      ";
            info = info+Information.bookArray.get(i).dateoff+"\n";
            
		}
		textArea.setText(info);
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = Information.JDBC_URL;
			Connection conn1 = DriverManager.getConnection(url, Information.username, Information.password);
			String num1="select*from"+" "+Information.Tto+";";
			PreparedStatement pstm = conn1.prepareStatement(num1);
			ResultSet Rs = pstm.executeQuery();
			int count = 0;//计算有多少条纪录
			while (Rs.next()) {
				count++;

			}
			Rs = pstm.executeQuery();
			//将查询获得的纪录数据，转换成适合生成Jtable的数据形式
			Object[][] info = new Object[count][8];
			count = 0;
			while (Rs.next()) {
				info[count][0] = Rs.getString("number");
				info[count][1] = Integer.valueOf(Rs.getInt("classnumber"));
				info[count][2] = Rs.getString("name");
				info[count][3] = Rs.getString("classname");
				info[count][4] = Integer.valueOf(Rs.getInt("price"));
				info[count][5] = Rs.getString("state");
				info[count][6] = Integer.valueOf(Rs.getInt("total"));
				count++;
			}
			String[] title = {"Number", "ClassNumber", "Name", "ClassName", "Price", "State", "Total"};//定义表头
			LiarbryTable = new JTable(info, title);//创建表
			jth = LiarbryTable.getTableHeader();//显示表头
			jsp.getViewport().add(LiarbryTable);//添加滚动条到table中

		} catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "Null date error", "error", JOptionPane.ERROR_MESSAGE);
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Null date source error", "error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.StateInfotoState();
		}
	}
}
