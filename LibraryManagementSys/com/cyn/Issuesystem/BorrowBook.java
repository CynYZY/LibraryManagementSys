package com.cyn.Issuesystem;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.cyn.MainInterface;
import com.cyn.DataBase.TableOperate;
import com.cyn.RButton;
import com.cyn.Static.Information;

import javax.swing.JTextField;

public class BorrowBook extends JPanel implements ActionListener{
	private JLabel label;
	private RButton back;
	private JTextField tf_peoplename;
	private JLabel lb_peoplename;
	private JTextField tf_classname;
	private JLabel lb_classname;
	private RButton btn_search;

	/**
	 * Create the panel.
	 */
	public BorrowBook() {
		setBackground(new Color(153, 204, 204));
		setLayout(null);
		
		back = new RButton("Back");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("Borrowing System");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 62, 450, 105);
		add(label);

		lb_peoplename = new JLabel("Membership card number:");
		lb_peoplename.setFont(new Font("宋体", Font.BOLD, 35));
		lb_peoplename.setBounds(145, 250, 650, 55);
		add(lb_peoplename);

		tf_peoplename = new JTextField();
		tf_peoplename.setFont(new Font("宋体", Font.BOLD, 35));
		tf_peoplename.setColumns(10);
		tf_peoplename.setBounds(602, 230, 526, 75);
		add(tf_peoplename);
		
		lb_classname = new JLabel("Category Name:");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(235, 430, 350, 55);
		add(lb_classname);
		
		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(602, 420, 526, 75);
		add(tf_classname);
		
		btn_search = new RButton("Search");
		btn_search.setFont(new Font("宋体", Font.BOLD, 35));
		btn_search.setBounds(558, 567, 251, 80);
		add(btn_search);
		btn_search.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.BorrowtoUser();
		}else if(e.getSource() == btn_search) {
			Information.cardnumber=tf_peoplename.getText();
			String peoplename = tf_peoplename.getText();
			Information.search_peoplename = peoplename;
			String classname = tf_classname.getText();
			Information.search_classname = classname;

			//��ѯ����ͼ����Ϣ
			if(TableOperate.isExist_people(peoplename)&&TableOperate.getcount(peoplename)&&TableOperate.isExist_Table(classname+"book")) {
                //TableOperate.newCustomer(peoplename);

				TableOperate.search_classname(tf_classname.getText());
				if(classname.contentEquals("nature")) {
					Information.Tto = "naturebook";
					BorrowBook_Information.setTextArea();
				}
				else if(classname.contentEquals("science")) {
					Information.Tto = "sciencebook";
					BorrowBook_Information.setTextArea();
				}
				MainInterface.BorrowtoBorrowInfo();	
				BorrowBook_Information.setTextArea();
				tf_peoplename.setText("");
				tf_classname.setText("");
			}
			else if(!TableOperate.isExist_people(peoplename))
			{
				JOptionPane.showMessageDialog(null, "Can't find the people!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(!TableOperate.getcount(peoplename))
			{
				JOptionPane.showMessageDialog(null, "You can't borrow more than three!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Please enter the right categoty!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
