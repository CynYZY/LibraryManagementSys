package com.cyn.Booksystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.cyn.MainInterface;
import com.cyn.DataBase.TableOperate;
import com.cyn.RButton;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class InsertBook extends JPanel implements ActionListener{
	private JTextField tf_number;
	private JLabel lb_number;
	private JLabel lb_classnumber;
	private JLabel lb_name;
	private JLabel lb_classname;
	private JLabel lb_price;
	private JLabel lb_state;
	private JLabel lb_total;
	private JTextField tf_classnumber;
	private JTextField tf_name;
	private JTextField tf_classname;
	private JTextField tf_price;
	private JTextField tf_state;
	private JTextField tf_total;
	private RButton back;
	private RButton btn_submit;

	/**
	 * Create the panel.
	 */
	public InsertBook() {
		setBackground(new Color(255,220,220));
		setLayout(null);
		
		JLabel label = new JLabel("New book entry");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 0, 400, 105);
		add(label);
		
		lb_number = new JLabel("Book ID:");
		lb_number.setFont(new Font("宋体", Font.BOLD, 30));
		lb_number.setBounds(250, 137, 220, 45);
		add(lb_number);
		
		tf_number = new JTextField();
		tf_number.setFont(new Font("宋体", Font.BOLD, 30));
		tf_number.setColumns(10);
		tf_number.setBounds(486, 127, 526, 65);
		add(tf_number);
		
		lb_classnumber = new JLabel("Category ID:");
		lb_classnumber.setFont(new Font("宋体", Font.BOLD, 30));
		lb_classnumber.setBounds(250, 207, 250, 45);
		add(lb_classnumber);

		tf_classnumber = new JTextField();
		tf_classnumber.setFont(new Font("宋体", Font.BOLD, 30));
		tf_classnumber.setColumns(10);
		tf_classnumber.setBounds(486, 197, 526, 65);
		add(tf_classnumber);
		
		lb_name = new JLabel("Book name:");
		lb_name.setFont(new Font("宋体", Font.BOLD, 30));
		lb_name.setBounds(250, 277, 220, 45);
		add(lb_name);

		tf_name = new JTextField();
		tf_name.setFont(new Font("宋体", Font.BOLD, 30));
		tf_name.setColumns(10);
		tf_name.setBounds(486, 267, 526, 65);
		add(tf_name);

		lb_classname = new JLabel("Category name:");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 30));
		lb_classname.setBounds(210, 347, 280, 45);
		add(lb_classname);

		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 30));
		tf_classname.setColumns(10);
		tf_classname.setBounds(486, 337, 526, 65);
		add(tf_classname);
		
		lb_price = new JLabel("Price:");
		lb_price.setFont(new Font("宋体", Font.BOLD, 30));
		lb_price.setBounds(250, 417, 194, 45);
		add(lb_price);

		tf_price = new JTextField();
		tf_price.setFont(new Font("宋体", Font.BOLD, 30));
		tf_price.setColumns(10);
		tf_price.setBounds(486, 407, 526, 65);
		add(tf_price);
		
		lb_state = new JLabel("State:");
		lb_state.setFont(new Font("宋体", Font.BOLD, 30));
		lb_state.setBounds(250, 487, 194, 45);
		add(lb_state);

		tf_state = new JTextField();
		tf_state.setFont(new Font("宋体", Font.BOLD, 30));
		tf_state.setColumns(10);
		tf_state.setBounds(486, 477, 526, 65);
		add(tf_state);
		
		lb_total = new JLabel("Number:");
		lb_total.setFont(new Font("宋体", Font.BOLD, 30));
		lb_total.setBounds(250, 557, 194, 45);
		add(lb_total);

		tf_total = new JTextField();
		tf_total.setFont(new Font("宋体", Font.BOLD, 30));
		tf_total.setColumns(10);
		tf_total.setBounds(486, 547, 526, 65);
		add(tf_total);
		
		btn_submit = new RButton("Submit");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(573, 633, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		back = new RButton("Back");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			//������ذ�ť
			MainInterface.InserttoBook();
		}else if(e.getSource() == btn_submit) {
			//����ύ��ť
			//�ж�¼����Ϣ�Ƿ��ͻ
			String number = tf_number.getText();
			String classnumber = tf_classnumber.getText();
			String name = tf_name.getText();
			String classname = tf_classname.getText();
			String price = tf_price.getText();
			String state = tf_state.getText();
			String total = tf_total.getText();
			
			if(TableOperate.search_bookstate(classname, number).equals("null")) {
				//�����鼮��Ϣ
				TableOperate.insertBook(number, classnumber, name, classname, price, state, total);
				tf_number.setText("");
				tf_classnumber.setText("");
				tf_name.setText("");
				tf_classname.setText("");
				tf_price.setText("");
				tf_state.setText("");
				tf_total.setText("");
				JOptionPane.showMessageDialog(null, "New book added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Failed to add new book!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
