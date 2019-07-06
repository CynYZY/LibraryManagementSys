package com.cyn.Issuesystem;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.cyn.DataBase.TableOperate;
import com.cyn.MainInterface;
import com.cyn.RButton;
import com.cyn.Static.Information;

import javax.swing.JTextField;


public class ReturnBook extends JPanel implements ActionListener {
	private JLabel label;
	private RButton back;
	private RButton btn_return;
	private JLabel lb_classnumber;
	private JLabel lb_classname;
	private JTextField tf_number;
	private JLabel lb_today;
	private JTextField tf_today;
	private JTextField tf_card;
	private JTextField tf_classname;
	private JLabel lb_card;

	public String due = null;
	public Date due_day;
	public long delta = 0l;

	/**
	 * Create the panel.
	 */
	public ReturnBook() {
		setBackground(new Color(179, 145, 179));
		setLayout(null);

		back = new RButton("Back");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

		label = new JLabel("Return Book System ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 62, 450, 105);
		add(label);

		lb_card = new JLabel("Card Number:");
		lb_card.setFont(new Font("宋体", Font.BOLD, 35));
		lb_card.setBounds(220, 200, 283, 55);
		add(lb_card);

		tf_card = new JTextField();
		tf_card.setFont(new Font("宋体", Font.BOLD, 35));
		tf_card.setColumns(10);
		tf_card.setBounds(500, 200, 526, 75);
		add(tf_card);

		lb_classname = new JLabel("Category Name:");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(220, 300, 350, 55);
		add(lb_classname);

		tf_classname = new JTextField();
    	tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(500, 300, 526, 75);
		add(tf_classname);

		lb_classnumber = new JLabel("Book Code:");
		lb_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classnumber.setBounds(220, 400, 283, 55);
		add(lb_classnumber);

		tf_number = new JTextField();
		tf_number.setFont(new Font("宋体", Font.BOLD, 35));
		tf_number.setColumns(10);
		tf_number.setBounds(500, 400, 526, 75);
		add(tf_number);

		lb_today = new JLabel("Due date:");
		lb_today.setFont(new Font("宋体", Font.BOLD, 35));
		lb_today.setBounds(220, 500, 283, 55);
		add(lb_today);

		tf_today = new JTextField();
		tf_today.setFont(new Font("宋体", Font.BOLD, 35));
		tf_today.setColumns(10);
		tf_today.setBounds(500, 500, 526, 75);

		tf_today.setEditable(false);
		add(tf_today);

		btn_return = new RButton("Return ");
		btn_return.setFont(new Font("宋体", Font.BOLD, 35));
		btn_return.setBounds(557, 650, 251, 80);
		add(btn_return);
		btn_return.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user_id=tf_card.getText();
		String book_id=tf_number.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = Information.JDBC_URL;
			Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select dateoff from " + user_id + "customer where number='" + book_id + "'");
			while (rs.next()) {
				due = rs.getString("dateoff");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				due_day = simpleDateFormat.parse(due);
				System.out.println(due);
				stmt.execute("delete from " + user_id + "customer where number='" + book_id + "'");
				if (due != null) {
					Calendar due_time = Calendar.getInstance();
					Calendar actual_time = Calendar.getInstance();
					due_time.setTime(due_day);
					long time1 = due_time.getTimeInMillis();
					long time2 = actual_time.getTimeInMillis();
					delta = (time2 - time1) / (1000 * 60 * 60 * 24);
					System.out.println(delta);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			MainInterface.ReturentoUser();
		} else if (e.getSource() == btn_return) {
			tf_today.setText(due);
			if (delta <= 0) {
				TableOperate.returnBook_Update(tf_classname.getText(),tf_number.getText());
				JOptionPane.showMessageDialog(null, "Return Success!", "", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Over due!", "", JOptionPane.INFORMATION_MESSAGE);
				if (delta < 7) {
					TableOperate.returnBook_Update(tf_classname.getText(),tf_number.getText());
					JOptionPane.showMessageDialog(null, "Return Success!", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Please pay the fine, total $" + 2 * (delta - 7), "Fine payment", JOptionPane.INFORMATION_MESSAGE);
					TableOperate.returnBook_Update(tf_classname.getText(),tf_number.getText());
					JOptionPane.showMessageDialog(null, "Return Success!", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		}
	}
}
