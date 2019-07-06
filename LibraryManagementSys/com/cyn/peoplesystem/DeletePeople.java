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

public class DeletePeople extends JPanel implements ActionListener{
    private JLabel label;
    private JTextField tf_card_number;
    private JLabel lb_card_number;
    private RButton btn_delete;
    private RButton back;

    /**
     * Create the panel.
     */
    public DeletePeople() {
        setBackground(new Color(206, 242, 255));
        setLayout(null);

        label = new JLabel("Delete People");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 40));
        label.setBounds(542, 20, 294, 105);
        add(label);

        lb_card_number = new JLabel("Card Number:");
        lb_card_number.setFont(new Font("宋体", Font.BOLD, 35));
        lb_card_number.setBounds(300, 260, 250, 55);
        add(lb_card_number);

        tf_card_number = new JTextField();
        tf_card_number.setFont(new Font("宋体", Font.BOLD, 35));
        tf_card_number.setColumns(10);
        tf_card_number.setBounds(555, 250, 399, 75);
        add(tf_card_number);


        btn_delete = new RButton("Delete");
        btn_delete.setFont(new Font("宋体", Font.BOLD, 35));
        btn_delete.setBounds(585, 450, 251, 80);
        add(btn_delete);
        btn_delete.addActionListener(this);

        back = new RButton("Back");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String card_number = tf_card_number.getText();
        if(e.getSource() == back) {
            MainInterface.DeletePeopletoPeople();
        }else if(e.getSource() == btn_delete){
            //检查是否存在此card_number
            if(TableOperate.isExist_people(card_number)) {
                //ɾ�����鼮��Ϣ
                TableOperate.deletePeople(card_number);
                tf_card_number.setText("");
                JOptionPane.showMessageDialog(null, "Delete successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Delete unsuccessfully!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
