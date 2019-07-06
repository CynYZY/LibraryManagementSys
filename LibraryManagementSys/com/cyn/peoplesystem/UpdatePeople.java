package com.cyn.peoplesystem;

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

public class UpdatePeople extends JPanel implements ActionListener{
    private JTextField tf_old_card;
    private JLabel update;
    private JTextField tf_new_firstname;
    private JTextField tf_new_middlename;
    private JTextField tf_new_lastname;
    private JTextField tf_new_birthday;
    private JTextField tf_new_gender;
    private JTextField tf_new_card;
    private JTextField tf_new_address;
    private JTextField tf_new_tel;
    private JLabel lb_old_card;
    private JLabel label;
    private JLabel lb_new_firstname;
    private JLabel lb_new_middlename;
    private JLabel lb_new_lastname;
    private JLabel lb_new_birthday;
    private JLabel lb_new_gender;
    private JLabel lb_new_card;
    private JLabel lb_new_address;
    private JLabel lb_new_tel;

    private RButton btn_submit;
    private RButton back;

    /**
     * Create the panel.
     */
    public UpdatePeople() {
        setBackground(new Color(230, 230, 250));
        setLayout(null);
        setSize(1200,800);

        label = new JLabel("Update People Information");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 40));
        label.setBounds(425, 20, 550, 105);
        add(label);

        lb_old_card = new JLabel("Card Number:");
        lb_old_card.setFont(new Font("宋体", Font.BOLD, 30));
        lb_old_card.setBounds(140, 120, 225, 45);
        add(lb_old_card);

        tf_old_card = new JTextField();
        tf_old_card.setFont(new Font("宋体", Font.BOLD, 30));
        tf_old_card.setColumns(10);
        tf_old_card.setBounds(400, 110, 252, 65);
        add(tf_old_card);

        update = new JLabel("Update information");
        update.setFont(new Font("宋体", Font.BOLD, 30));
        update.setBounds(607, 195, 450, 45);
        add(update);

        lb_new_firstname = new JLabel("New First Name:");
        lb_new_firstname.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_firstname.setBounds(180, 250, 350, 45);
        add(lb_new_firstname);

        tf_new_firstname = new JTextField();
        tf_new_firstname.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_firstname.setColumns(10);
        tf_new_firstname.setBounds(507, 240, 526, 65);
        add(tf_new_firstname);

        lb_new_middlename = new JLabel("New Middle Name:");
        lb_new_middlename.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_middlename.setBounds(180, 320, 350, 45);
        add(lb_new_middlename);

        tf_new_middlename = new JTextField();
        tf_new_middlename.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_middlename.setColumns(10);
        tf_new_middlename.setBounds(507, 310, 526, 65);
        add(tf_new_middlename);

        lb_new_middlename = new JLabel("New Last Name:");
        lb_new_middlename.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_middlename.setBounds(180, 390, 350, 45);
        add(lb_new_middlename);

        tf_new_lastname = new JTextField();
        tf_new_lastname.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_lastname.setColumns(10);
        tf_new_lastname.setBounds(507, 380, 526, 65);
        add(tf_new_lastname);

        lb_new_birthday = new JLabel("New Date of Birth:");
        lb_new_birthday.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_birthday.setBounds(180, 460, 500, 45);
        add(lb_new_birthday);

        tf_new_birthday = new JTextField();
        tf_new_birthday.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_birthday.setColumns(10);
        tf_new_birthday.setBounds(507, 450, 526, 65);
        add(tf_new_birthday);

        lb_new_gender = new JLabel("New Gender: ");
        lb_new_gender.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_gender.setBounds(180, 530, 350, 45);
        add(lb_new_gender);

        tf_new_gender = new JTextField();
        tf_new_gender.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_gender.setColumns(10);
        tf_new_gender.setBounds(507, 520, 526, 65);
        add(tf_new_gender);

        lb_new_card = new JLabel("New Card Number: ");
        lb_new_card.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_card.setBounds(180, 600, 350, 45);
        add(lb_new_card);

        tf_new_card = new JTextField();
        tf_new_card.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_card.setColumns(10);
        tf_new_card.setBounds(507, 590, 526, 65);
        add(tf_new_card);

        lb_new_address = new JLabel("New Address: ");
        lb_new_address.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_address.setBounds(180, 670, 350, 45);
        add(lb_new_address);

        tf_new_address = new JTextField();
        tf_new_address.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_address.setColumns(10);
        tf_new_address.setBounds(507, 660, 526, 65);
        add(tf_new_address);

        lb_new_tel = new JLabel("New Phone Number: ");
        lb_new_tel.setFont(new Font("宋体", Font.BOLD, 30));
        lb_new_tel.setBounds(180, 740, 350, 45);
        add(lb_new_tel);

        tf_new_tel = new JTextField();
        tf_new_tel.setFont(new Font("宋体", Font.BOLD, 30));
        tf_new_tel.setColumns(10);
        tf_new_tel.setBounds(507, 730, 526, 65);
        add(tf_new_tel);

        back = new RButton("Back");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        btn_submit = new RButton("Submit");
        btn_submit.setFont(new Font("宋体", Font.BOLD, 30));
        btn_submit.setBounds(570, 800, 251, 65);
        add(btn_submit);
        btn_submit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == back) {
            //������ذ�ť
            MainInterface.UpdatePeopletoPeople();
        }else if(e.getSource() == btn_submit) {
            //���������Ϣ�ύ��ť
            //����Ϣ
            String old_card = tf_old_card.getText();
            //����Ϣ
            String firstname = tf_new_firstname.getText();
            String middlename = tf_new_middlename.getText();
            String lastname = tf_new_lastname.getText();
            String birthday = tf_new_birthday.getText();
            String gender = tf_new_gender.getText();
            String card= tf_new_card.getText();
            String address = tf_new_address.getText();
            String tel= tf_new_tel.getText();

            ///////////////修改尚未完成////////////////
            if(TableOperate.isExist_people(old_card)) {
                //ɾ�����鼮��Ϣ
                TableOperate.deletePeople(old_card);
                //�������鼮��Ϣ
                TableOperate.insertPeople(firstname, middlename,lastname, birthday, gender, card, address,tel);
                tf_old_card.setText("");
                tf_new_firstname.setText("");
                tf_new_middlename.setText("");
                tf_new_lastname.setText("");
                tf_new_birthday.setText("");
                tf_new_gender.setText("");
                tf_new_card.setText("");
                tf_new_address.setText("");
                tf_new_tel.setText("");
                JOptionPane.showMessageDialog(null, "Updated information successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Update information failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
