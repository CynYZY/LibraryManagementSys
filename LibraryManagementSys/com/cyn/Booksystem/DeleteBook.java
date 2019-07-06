package com.cyn.Booksystem;

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

public class DeleteBook extends JPanel implements ActionListener{
    private JLabel label;
    private JTextField tf_bookid;
    private JTextField tf_classname;
    private JLabel lb_bookid;
    private JLabel lb_classname;
    private RButton btn_delete;
    private RButton back;

    /**
     * Create the panel.
     */
    public DeleteBook() {
        setBackground(new Color(206, 242, 255));
        setLayout(null);

        label = new JLabel("Delete Books");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 40));
        label.setBounds(542, 20, 294, 105);
        add(label);

        lb_bookid = new JLabel("Book ID:");
        lb_bookid.setFont(new Font("宋体", Font.BOLD, 35));
        lb_bookid.setBounds(361, 260, 194, 55);
        add(lb_bookid);

        tf_bookid = new JTextField();
        tf_bookid.setFont(new Font("宋体", Font.BOLD, 35));
        tf_bookid.setColumns(10);
        tf_bookid.setBounds(555, 250, 399, 75);
        add(tf_bookid);

        tf_classname = new JTextField();
        tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
        tf_classname.setColumns(10);
        tf_classname.setBounds(555, 431, 399, 75);
        add(tf_classname);

        lb_classname = new JLabel("Category Name:");
        lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
        lb_classname.setBounds(280, 441, 350, 55);
        add(lb_classname);

        btn_delete = new RButton("Delete");
        btn_delete.setFont(new Font("宋体", Font.BOLD, 35));
        btn_delete.setBounds(585, 637, 251, 80);
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
        if(e.getSource() == back) {
            MainInterface.DeleteBooktoBook();
        }else if(e.getSource() == btn_delete){
            //检查是否存在此bookid和classid
            String bookid = tf_bookid.getText();
            String classname = tf_classname.getText();
                /////////////////删除部分尚未完成/////////////////
                if(!TableOperate.search_bookstate(classname, bookid).equals("null")) {
                    //ɾ�����鼮��Ϣ
                    TableOperate.deleteBook(bookid, classname);
                tf_bookid.setText("");
                tf_classname.setText("");
                JOptionPane.showMessageDialog(null, "Delete successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Delete unsuccessfully!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
