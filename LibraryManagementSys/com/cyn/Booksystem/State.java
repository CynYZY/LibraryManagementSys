package com.cyn.Booksystem;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.cyn.Issuesystem.BorrowBook_Information;
import com.cyn.MainInterface;
import com.cyn.DataBase.TableOperate;
import com.cyn.RButton;
import com.cyn.Static.Information;

import javax.swing.JTextField;

public class State extends JPanel implements ActionListener{
	private JLabel label;
	private RButton back;
	private JTextField tf_classname;
	private JLabel lb_classname;
	private RButton btn_search;

	/**
	 * Create the panel.
	 */
	public State() {
		setBackground(new Color(185, 213, 152));
		setLayout(null);
		
		back = new RButton("Back");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("Library Status Query ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(425, 20, 650, 105);
		add(label);
		
		lb_classname = new JLabel("Category Name:");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(225, 330, 350, 55);
		add(lb_classname);
		
		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(502, 320, 526, 75);
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
			MainInterface.StatetoManager();
		}else if(e.getSource() == btn_search) {
			
			String classname = tf_classname.getText();
			
			Information.search_classname = classname;
			
			//��ѯ����ͼ����Ϣ
			//�ж��Ƿ���ڲ�ѯ���
			if(TableOperate.isExist_Table(classname+"book")) {
				JOptionPane.showMessageDialog(null, "Search information successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
				TableOperate.search_classname(tf_classname.getText());
				if(classname.contentEquals("nature")) {
					Information.Tto = "naturebook";
					BorrowBook_Information.setTextArea();
				}
				else if(classname.contentEquals("science")) {
					Information.Tto = "sciencebook";
					BorrowBook_Information.setTextArea();
				}
				MainInterface.StatetoStateInfo();
				State_Information.setTextArea();
				tf_classname.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "Failed ton find information!", "Error", JOptionPane.ERROR_MESSAGE);
			}		
		}
	}
}
