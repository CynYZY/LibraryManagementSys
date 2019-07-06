package com.cyn.peoplesystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.cyn.MainInterface;
import com.cyn.Static.Information;
import com.cyn.RButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PeopleInterface extends JPanel implements ActionListener{
    private JLabel label;
    private RButton back;
    private RButton btn_insertPeople;
    private RButton btn_info;
    private RButton btn_deletePeople;
    private RButton btn_updatePeople;

    /**
     * Create the panel.
     */
    public PeopleInterface() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        label = new JLabel("Membership Management System");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Bradley Hand ITC", Font.BOLD, 44));
        label.setBounds(295, 20, 800, 105);
        add(label);

        back = new RButton("Back");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        btn_insertPeople = new RButton("Enter new people");
        btn_insertPeople.setFont(new Font("宋体", Font.BOLD, 40));
        btn_insertPeople.setBounds(280, 195, 750, 80);
        add(btn_insertPeople);
        btn_insertPeople.addActionListener(this);

        btn_deletePeople= new RButton("Delete people ");
        btn_deletePeople.setFont(new Font("宋体", Font.BOLD, 40));
        btn_deletePeople.setBounds(280, 295, 750, 80);
        add(btn_deletePeople);
        btn_deletePeople.addActionListener(this);

        btn_updatePeople = new RButton("Update information");
        btn_updatePeople.setFont(new Font("宋体", Font.BOLD, 40));
        btn_updatePeople.setBounds(280, 395, 750, 80);
        add(btn_updatePeople);
        btn_updatePeople.addActionListener(this);

        btn_info = new RButton("Membership information ");
        btn_info.setFont(new Font("宋体", Font.BOLD, 40));
        btn_info.setBounds(280, 495, 750, 80);
        add(btn_info);
        btn_info.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == back) {
            MainInterface.PeopletoChoose();
        }else if(e.getSource() == btn_insertPeople){
            MainInterface.PeopletoInsertPeople();
        }else if(e.getSource() == btn_deletePeople) {
            MainInterface.PeopletoDeletePeople();
        }else if(e.getSource() == btn_updatePeople) {
            MainInterface.PeopletoUpdatePeople();
        }else if(e.getSource() == btn_info) {
            SearchInfo.setTextArea1();
            MainInterface.PeopletoSearchInfo();
        }

    }
}
