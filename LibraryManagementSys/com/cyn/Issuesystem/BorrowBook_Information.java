package com.cyn.Issuesystem;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import com.cyn.Book;
import com.cyn.MainInterface;
import com.cyn.DataBase.TableOperate;
import com.cyn.RButton;
import com.cyn.Static.Information;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BorrowBook_Information extends JPanel implements ActionListener {
	private RButton back;
	private static JTextArea textArea;
	private static String info;
	private JTextField tf_number;
	private JLabel lb_number;
	private JButton btn_borrow;
	private JLabel lb_dateoff;
	private static JTextField tf_dateoff;
	private static JTable LiarbryTable;
	private static JTableHeader jth;
	private static JScrollPane jsp;


	/**
	 * Create the panel.
	 */
	public BorrowBook_Information() {
		setBackground(new Color(210, 235, 230));
		setLayout(null);


		jsp = new JScrollPane();//设置滚动条
		jsp.setBounds(152, 142, 1000, 782);
		add(jsp);

		back = new RButton("Return");//返回按钮
		back.setFont(new Font("宋体", Font.PLAIN, 24));
		back.setBounds(0, 0, 120, 82);
		add(back);
		back.addActionListener(this);

//		textArea = new JTextArea();
//		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
//		textArea.setBounds(152, 142, 1111, 782);
//		add(textArea);
//
//		textArea.setEditable(false);

		lb_number = new JLabel("Book number:");
		lb_number.setFont(new Font("宋体", Font.BOLD, 24));
		lb_number.setBounds(152, 39, 185, 55);
		add(lb_number);

		tf_number = new JTextField();
		tf_number.setFont(new Font("宋体", Font.BOLD, 35));
		tf_number.setColumns(10);
		tf_number.setBounds(317, 29, 226, 75);
		add(tf_number);

		btn_borrow = new JButton("Borrow books");
		btn_borrow.setFont(new Font("宋体", Font.BOLD, 24));
		btn_borrow.setBounds(926, 26, 251, 80);
		add(btn_borrow);
		btn_borrow.addActionListener(this);

		lb_dateoff = new JLabel("Issue Time:");
		lb_dateoff.setFont(new Font("宋体", Font.BOLD, 24));
		lb_dateoff.setBounds(550, 39, 185, 55);
		add(lb_dateoff);


		tf_dateoff = new JTextField();
		tf_dateoff.setFont(new Font("宋体", Font.BOLD, 35));
		tf_dateoff.setColumns(10);
		tf_dateoff.setBounds(679, 29, 226, 75);
		add(tf_dateoff);


//		info = "图书编号     分类编号     图书名称                分类名称      价格     状态     获取人     终止日期\n";

	}

	public static void setTextArea() {
//		info = "图书编号     分类编号     图书名称                分类名称      价格     状态     获取人     终止日期\n";
//
//		for (int i = 0; i < Information.bookArray.size(); i++) {
//			info = info + "  " + Information.bookArray.get(i).number + "          ";
//			info = info + Information.bookArray.get(i).classnumber + "          ";
//			info = info + Information.bookArray.get(i).name;
//			for (int j = 0; j < (19 - Information.bookArray.get(i).name.length()); j++) {
//				info = info + " ";
//			}
//			info = info + "      " + Information.bookArray.get(i).classname + "        ";
//			info = info + Information.bookArray.get(i).price + "      ";
//			info = info + Information.bookArray.get(i).state;
//			for (int j = 0; j < (9 - Information.bookArray.get(i).state.length()); j++) {
//				info = info + " ";
//			}
//			info = info + Information.bookArray.get(i).current;
//			for (int j = 0; j < (6 - Information.bookArray.get(i).current.length()); j++) {
//				info = info + " ";
//			}
//			info = info + "     " + Information.bookArray.get(i).dateoff + "\n";
//
//		}
//		textArea.setText(info);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = Information.JDBC_URL;
			Connection conn1 = DriverManager.getConnection(url, Information.username, Information.password);
			String num1 = "select*from" + " " + Information.Tto + ";";
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

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Null date error", "error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Null date source error", "error", JOptionPane.ERROR_MESSAGE);
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			//点击返回按钮
			MainInterface.BorrowInfotoBorrow();
		}
		if (e.getSource() == btn_borrow) {
			//点击借书按钮
			//先判定是否有此书
			if (TableOperate.search_bookname(Information.search_classname, tf_number.getText()).equals("null")) {
				JOptionPane.showMessageDialog(null, "Error information input", "Failed to borrow book!", JOptionPane.ERROR_MESSAGE);
				tf_number.setText("");
				tf_dateoff.setText("");
			} else {
				//判定此书是否已被借出
				if (TableOperate.search_bookstate(Information.search_classname, tf_number.getText()).equals("in")) {

					//issue time
					String s_day1 = tf_dateoff.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date d1 = null;
					try {
						d1 = sdf.parse(s_day1);
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					Calendar c1 = Calendar.getInstance();
					if (d1!=null) {
						c1.setTime(d1);
						c1.add(Calendar.MONTH, +1);
						java.util.Date d2 = c1.getTime();
						String s_day2 = sdf.format(d2);
						TableOperate.borrowBook_Update(Information.search_classname, tf_number.getText(), Information.cardnumber, s_day1, s_day2);
						tf_number.setText("");
						tf_dateoff.setText("");
						MainInterface.BorrowInfotoBorrow();
						MainInterface.BorrowtoUser();
					}

				}
				else {
					JOptionPane.showMessageDialog(null, "This book is borrow to:" + TableOperate.search_bookdateoff(Information.search_classname, tf_number.getText()), "Failed to borrow!", JOptionPane.ERROR_MESSAGE);
					tf_number.setText("");
					tf_dateoff.setText("");
				}
			}
		}
	}
}
