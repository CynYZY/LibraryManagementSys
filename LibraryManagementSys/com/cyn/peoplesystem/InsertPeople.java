package com.cyn.peoplesystem;

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

public class InsertPeople extends JPanel implements ActionListener{
    private JLabel lb_firstname;
    private JLabel lb_middlename;
    private JLabel lb_lastname;
    private JLabel lb_birthday;
    private JLabel lb_gender;
    private JLabel lb_card_number;
    private JLabel lb_address;
    private JLabel lb_tel;
    private JTextField tf_firstname;
    private JTextField tf_middlename;
    private JTextField tf_lastname;
    private JTextField tf_birthday;
    private JTextField tf_gender;
    private JTextField tf_card_number;
    private JTextField tf_address;
    private JTextField tf_tel;
    private RButton back;
    private RButton btn_submit;

    /**
     * Create the panel.
     */
    public InsertPeople() {
        setBackground(new Color(255,220,220));
        setLayout(null);

        JLabel label = new JLabel("New people entry");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 40));
        label.setBounds(530, 0, 400, 105);
        add(label);

        lb_firstname = new JLabel("First Name:");
        lb_firstname.setFont(new Font("宋体", Font.BOLD, 30));
        lb_firstname.setBounds(250, 137, 220, 45);
        add(lb_firstname);

        tf_firstname = new JTextField();
        tf_firstname.setFont(new Font("宋体", Font.BOLD, 30));
        tf_firstname.setColumns(10);
        tf_firstname.setBounds(486, 127, 526, 65);
        add(tf_firstname);

        lb_middlename = new JLabel("Middle Name:");
        lb_middlename.setFont(new Font("宋体", Font.BOLD, 30));
        lb_middlename.setBounds(250, 207, 250, 45);
        add(lb_middlename);

        tf_middlename = new JTextField();
        tf_middlename.setFont(new Font("宋体", Font.BOLD, 30));
        tf_middlename.setColumns(10);
        tf_middlename.setBounds(486, 197, 526, 65);
        add(tf_middlename);

        lb_lastname = new JLabel("Last Name:");
        lb_lastname.setFont(new Font("宋体", Font.BOLD, 30));
        lb_lastname.setBounds(250, 277, 220, 45);
        add(lb_lastname);

        tf_lastname = new JTextField();
        tf_lastname.setFont(new Font("宋体", Font.BOLD, 30));
        tf_lastname.setColumns(10);
        tf_lastname.setBounds(486, 267, 526, 65);
        add(tf_lastname);

        lb_birthday = new JLabel("Date of birth:");
        lb_birthday.setFont(new Font("宋体", Font.BOLD, 30));
        lb_birthday.setBounds(210, 347, 280, 45);
        add(lb_birthday);

        tf_birthday = new JTextField();
        tf_birthday.setFont(new Font("宋体", Font.BOLD, 30));
        tf_birthday.setColumns(10);
        tf_birthday.setBounds(486, 337, 526, 65);
        add(tf_birthday);

        lb_gender = new JLabel("Gender:");
        lb_gender.setFont(new Font("宋体", Font.BOLD, 30));
        lb_gender.setBounds(250, 417, 194, 45);
        add(lb_gender);

        tf_gender= new JTextField();
        tf_gender.setFont(new Font("宋体", Font.BOLD, 30));
        tf_gender.setColumns(10);
        tf_gender.setBounds(486, 407, 526, 65);
        add(tf_gender);

        lb_card_number= new JLabel("Card Number:");
        lb_card_number.setFont(new Font("宋体", Font.BOLD, 30));
        lb_card_number.setBounds(250, 487, 250, 45);
        add(lb_card_number);

        tf_card_number = new JTextField();
        tf_card_number.setFont(new Font("宋体", Font.BOLD, 30));
        tf_card_number.setColumns(10);
        tf_card_number.setBounds(486, 477, 526, 65);
        add(tf_card_number);

        lb_address = new JLabel("Address:");
        lb_address.setFont(new Font("宋体", Font.BOLD, 30));
        lb_address.setBounds(250, 557, 194, 45);
        add(lb_address);

        tf_address = new JTextField();
        tf_address.setFont(new Font("宋体", Font.BOLD, 30));
        tf_address.setColumns(10);
        tf_address.setBounds(486, 547, 526, 65);
        add(tf_address);

        lb_tel = new JLabel("Phone Number:");
        lb_tel.setFont(new Font("宋体", Font.BOLD, 30));
        lb_tel.setBounds(210, 627, 300, 45);
        add(lb_tel);

        tf_tel = new JTextField();
        tf_tel.setFont(new Font("宋体", Font.BOLD, 30));
        tf_tel.setColumns(10);
        tf_tel.setBounds(486, 617, 526, 65);
        add(tf_tel);

        btn_submit = new    RButton("Submit");
        btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
        btn_submit.setBounds(573, 700, 251, 80);
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
            MainInterface.InserttoPeople();
        }else if(e.getSource() == btn_submit) {
            //����ύ��ť
            //�ж�¼����Ϣ�Ƿ��ͻ
            String firstname = tf_firstname.getText();
            String middlename = tf_middlename.getText();
            String lastname = tf_lastname.getText();
            String birthday = tf_birthday.getText();
            String gender = tf_gender.getText();
            String card_number = tf_card_number.getText();
            String address = tf_address.getText();
            String tel = tf_tel.getText();

            ///////////////////
            //添加函数尚未完成
            if(!TableOperate.isExist_people(card_number)) {
                TableOperate.insertPeople(firstname, middlename, lastname, birthday, gender, card_number, address,tel);
                tf_firstname.setText("");
                tf_middlename.setText("");
                tf_lastname.setText("");
                tf_birthday.setText("");
                tf_gender.setText("");
                tf_card_number.setText("");
                tf_address.setText("");
                tf_tel.setText("");
                JOptionPane.showMessageDialog(null, "New people added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Failed to add new people!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
