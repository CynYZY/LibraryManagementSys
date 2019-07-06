package com.cyn;

import javax.swing.*;

import com.cyn.MainInterface;
import com.cyn.DataBase.TableOperate;
import com.cyn.Static.Information;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.security.PublicKey;

public class ChooseInterface extends JPanel implements ActionListener{


    private RButton back;
    private JLabel label;
    private JButton btn_book;
    private JButton btn_people;
    private JButton btn_issue;
    private static JLabel lb_manager;

    public ChooseInterface()
    {


        setLayout(null);



        back = new RButton("Back");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        label = new JLabel("Operation Interface ");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Bradley Hand ITC", Font.BOLD, 60));
        label.setBounds(370, 47, 650, 105);
        add(label);

        btn_book = new JButton("Book");
        btn_book.setFont(new Font("宋体", Font.BOLD, 40));
        btn_book.setBounds(150, 200, 300, 550);
        add(btn_book);
        btn_book.addActionListener(this);

        btn_people = new JButton("Membership ");
        btn_people.setFont(new Font("宋体", Font.BOLD, 40));
        btn_people.setBounds(500, 200, 300, 550);
        add(btn_people);
        btn_people.addActionListener(this);

        btn_issue = new JButton("Issue");
        btn_issue.setFont(new Font("宋体", Font.BOLD, 40));
        btn_issue.setBounds(850, 200, 300, 550);
        add(btn_issue);
        btn_issue.addActionListener(this);

        lb_manager = new JLabel("New label");
        lb_manager.setHorizontalAlignment(SwingConstants.CENTER);
        lb_manager.setFont(new Font("宋体", Font.BOLD, 28));
        lb_manager.setBounds(954, 0, 348, 56);
        add(lb_manager);

    }

    //�������Ͻǵ�ǰ����Ա
    public static void setManager() {
        lb_manager.setText("Manager:"+Information.manager);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            MainInterface.ChoosetoMain();
        }
        else if(e.getSource() ==btn_book )
        {
            MainInterface.ChoosetoBook();
        }
        else if(e.getSource() ==btn_people)
        {
            MainInterface.ChoosetoPeople();
        }
        else if(e.getSource() ==btn_issue)
        {
            MainInterface.ChoosetoUser();
        }
    }





}

