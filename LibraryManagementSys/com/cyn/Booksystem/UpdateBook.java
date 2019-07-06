package com.cyn.Booksystem;

import javax.swing.JPanel;
import java.awt.Color;
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

public class UpdateBook extends JPanel implements ActionListener {
	private JTextField tf_old_number;
	private JTextField tf_new_number;
	private JLabel update;
	private JTextField tf_new_classnumber;
	private JTextField tf_old_classname;
	private JTextField tf_new_name;
	private JTextField tf_new_classname;
	private JTextField tf_new_price;
	private JTextField tf_new_state;
	private JLabel lb_old_number;
	private JLabel lb_old_classname;
	private JLabel label;
	private JLabel lb_new_number;
	private JLabel lb_new_classnumber;
	private JLabel lb_new_name;
	private JLabel lb_new_classname;
	private JLabel lb_new_price;
	private JLabel lb_new_state;
	private RButton btn_submit;
	private RButton back;

	/**
	 * Create the panel.
	 */
	public UpdateBook() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		label = new JLabel("Update Book Information");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(450, 20, 550, 105);
		add(label);
		
		lb_old_number = new JLabel("Book ID:");
		lb_old_number.setFont(new Font("宋体", Font.BOLD, 30));
		lb_old_number.setBounds(140, 120, 225, 45);
		add(lb_old_number);
		
		tf_old_number = new JTextField();
		tf_old_number.setFont(new Font("宋体", Font.BOLD, 30));
		tf_old_number.setColumns(10);
		tf_old_number.setBounds(298, 110, 252, 65);
		add(tf_old_number);

		lb_old_classname = new JLabel("Category Name:");
		lb_old_classname.setFont(new Font("宋体", Font.BOLD, 30));
		lb_old_classname.setBounds(550, 120, 380, 45);
		add(lb_old_classname);

		tf_old_classname = new JTextField();
		tf_old_classname.setFont(new Font("宋体", Font.BOLD, 30));
		tf_old_classname.setColumns(10);
		tf_old_classname.setBounds(798, 110, 342, 65);
		add(tf_old_classname);

		update = new JLabel("Update information");
		update.setFont(new Font("宋体", Font.BOLD, 30));
		update.setBounds(607, 195, 450, 45);
		add(update);

		lb_new_number = new JLabel("New Book ID:");
		lb_new_number.setFont(new Font("宋体", Font.BOLD, 30));
		lb_new_number.setBounds(200, 250, 250, 45);
		add(lb_new_number);

		tf_new_number = new JTextField();
		tf_new_number.setFont(new Font("宋体", Font.BOLD, 30));
		tf_new_number.setColumns(10);
		tf_new_number.setBounds(507, 240, 526, 65);
		add(tf_new_number);
		
		lb_new_classnumber = new JLabel("New Category ID:");
		lb_new_classnumber.setFont(new Font("宋体", Font.BOLD, 30));
		lb_new_classnumber.setBounds(200, 320, 350, 45);
		add(lb_new_classnumber);

		tf_new_classnumber = new JTextField();
		tf_new_classnumber.setFont(new Font("宋体", Font.BOLD, 30));
		tf_new_classnumber.setColumns(10);
		tf_new_classnumber.setBounds(507, 310, 526, 65);
		add(tf_new_classnumber);
		
		lb_new_name = new JLabel("New Book Name:");
		lb_new_name.setFont(new Font("宋体", Font.BOLD, 30));
		lb_new_name.setBounds(200, 390, 350, 45);
		add(lb_new_name);

		tf_new_name = new JTextField();
		tf_new_name.setFont(new Font("宋体", Font.BOLD, 30));
		tf_new_name.setColumns(10);
		tf_new_name.setBounds(507, 380, 526, 65);
		add(tf_new_name);
		
		lb_new_classname = new JLabel("New Category Name:");
		lb_new_classname.setFont(new Font("宋体", Font.BOLD, 30));
		lb_new_classname.setBounds(200, 460, 350, 45);
		add(lb_new_classname);

		tf_new_classname = new JTextField();
		tf_new_classname.setFont(new Font("宋体", Font.BOLD, 30));
		tf_new_classname.setColumns(10);
		tf_new_classname.setBounds(507, 450, 526, 65);
		add(tf_new_classname);

		lb_new_price = new JLabel("New Price: ");
		lb_new_price.setFont(new Font("宋体", Font.BOLD, 30));
		lb_new_price.setBounds(200, 530, 250, 45);
		add(lb_new_price);

		tf_new_price = new JTextField();
		tf_new_price.setFont(new Font("宋体", Font.BOLD, 30));
		tf_new_price.setColumns(10);
		tf_new_price.setBounds(507, 520, 526, 65);
		add(tf_new_price);
		
		lb_new_state = new JLabel("New Status: ");
		lb_new_state.setFont(new Font("宋体", Font.BOLD, 30));
		lb_new_state.setBounds(200, 600, 250, 45);
		add(lb_new_state);

		tf_new_state = new JTextField();
		tf_new_state.setFont(new Font("宋体", Font.BOLD, 30));
		tf_new_state.setColumns(10);
		tf_new_state.setBounds(507, 590, 526, 65);
		add(tf_new_state);
		
		back = new RButton("Back");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

		btn_submit = new RButton("Submit");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 30));
		btn_submit.setBounds(570, 670, 251, 65);
		add(btn_submit);
		btn_submit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			//������ذ�ť
			MainInterface.UpdatetoBook();
		}else if(e.getSource() == btn_submit) {
			//���������Ϣ�ύ��ť
			//����Ϣ
			String old_number = tf_old_number.getText();
			String old_classname = tf_old_classname.getText();
			//����Ϣ
			String number = tf_new_number.getText();
			String classnumber = tf_new_classnumber.getText();
			String name = tf_new_name.getText();
			String classname = tf_new_classname.getText();
			String price = tf_new_price.getText();
			String state = tf_new_state.getText();
			
			if(!TableOperate.search_bookstate(old_classname, old_number).equals("null")) {
				//ɾ�����鼮��Ϣ
				TableOperate.deleteBook(old_number, old_classname);
				//�������鼮��Ϣ
				TableOperate.insertBook(number, classnumber, name, classname, price, state, "1");
				tf_old_classname.setText("");
				tf_old_number.setText("");
				tf_new_number.setText("");
				tf_new_classnumber.setText("");
				tf_new_name.setText("");
				tf_new_classname.setText("");
				tf_new_price.setText("");
				tf_new_state.setText("");
				JOptionPane.showMessageDialog(null, "Updated information successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Update information failed!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
