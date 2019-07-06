package com.cyn.Issuesystem;

import javax.swing.JPanel;

import com.cyn.MainInterface;
import com.cyn.DataBase.TableOperate;
import com.cyn.Static.Information;
import com.cyn.RButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UserInterface extends JPanel implements ActionListener{
	private RButton back;
	private JLabel label;
	private RButton btn_return;
	private RButton btn_borrow;
	private RButton btn_prolong;
	private RButton btn_personal;

	/**
	 * Create the panel.
	 */
	public UserInterface() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		back = new RButton("Back");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("Issue Interface ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Bradley Hand ITC", Font.BOLD, 44));
		label.setBounds(455, 47, 450, 105);
		add(label);
		
		btn_borrow = new RButton("Borrow Books");
		btn_borrow.setFont(new Font("宋体", Font.BOLD, 35));
		btn_borrow.setBounds(280, 195, 750, 80);
		add(btn_borrow);
		btn_borrow.addActionListener(this);
		
		btn_return = new RButton("Return Books ");
		btn_return.setFont(new Font("宋体", Font.BOLD, 35));
		btn_return.setBounds(280, 295, 750, 80);
		add(btn_return);
		btn_return.addActionListener(this);
		
		btn_personal = new RButton("Issue Information");
		btn_personal.setFont(new Font("宋体", Font.BOLD, 35));
		btn_personal.setBounds(280, 395, 750, 80);
		add(btn_personal);
		btn_personal.addActionListener(this);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.UsertoChoose();
		}else if(e.getSource() == btn_borrow){
			MainInterface.UsertoBorrow();
		}else if(e.getSource() == btn_return) {
			MainInterface.UsertoReturn();
		} else if(e.getSource() == btn_personal) {
			//TableOperate.search_personal(Information.user);
			MainInterface.UsertoPersonal();
		}
		
	}
}
