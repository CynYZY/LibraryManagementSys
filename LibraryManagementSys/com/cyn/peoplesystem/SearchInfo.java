package com.cyn.peoplesystem;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import com.cyn.Book;
import com.cyn.DataBase.TableOperate;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.cyn.MainInterface;

import com.cyn.RButton;
import com.cyn.Static.Information;


public class SearchInfo extends JPanel implements ActionListener {
    private RButton back;
    private static JTextArea textArea;
    private JLabel label;
    private static String info;
    private static JScrollPane jsp;
    private static JTable LiarbryTable;
    private static JTableHeader jth;


    /**
     * Create the panel.
     */
    public SearchInfo() {
        setBackground(new Color(146, 156, 100));
        setLayout(null);

        jsp = new JScrollPane();//设置滚动条
        jsp.setBounds(152, 142, 1000, 782);
        add(jsp);

        back = new RButton("Back");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        label = new JLabel("Personal information ");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 40));
        label.setBounds(410, 20, 550, 105);
        add(label);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setEditable(false);
        textArea.setBounds(111, 125, 1050, 782);
        add(textArea);
    }

    public static void setTextArea1()

    {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = Information.JDBC_URL;
            Connection conn1 = DriverManager.getConnection(url, Information.username, Information.password);
            String num1 = "select * from People;";
            PreparedStatement pstm = conn1.prepareStatement(num1);
            ResultSet Rs = pstm.executeQuery();
            int count = 0;//计算有多少条纪录
            while (Rs.next()) {
                count++;

            }
            Rs = pstm.executeQuery();
            //将查询获得的纪录数据，转换成适合生成Jtable的数据形式
            Object[][] info = new Object[count][8];
            count = 0;
            while (Rs.next()) {
                info[count][0] = Rs.getString("firstname");
                info[count][1] = Rs.getString("middlename");
                info[count][2] = Rs.getString("lastname");
                info[count][3] = Rs.getString("birthday");
                info[count][4] = Rs.getString("gender");
                info[count][5] = Rs.getString("card_number");
                info[count][6] = Rs.getString("address");
                info[count][7] = Rs.getString("tel");

                count++;
            }
            String[] title = {"FirstName", "middleName", "LastName", "Birthday", "Gender", "CardNumber", "Address","PhoneNumber"};//定义表头
            LiarbryTable = new JTable(info, title);//创建表
            jth = LiarbryTable.getTableHeader();//显示表头
            jsp.getViewport().add(LiarbryTable);//添加滚动条到table中

        } catch (
                ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Null date error", "error", JOptionPane.ERROR_MESSAGE);
        } catch (
                SQLException e) {
            JOptionPane.showMessageDialog(null, "Null date source error", "error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    public void actionPerformed (ActionEvent e){
        // TODO Auto-generated method stub
        if (e.getSource() == back) {
            MainInterface.SearchInfotoPeople();
        }
    }

}