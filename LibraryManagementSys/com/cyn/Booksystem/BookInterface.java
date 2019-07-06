package com.cyn.Booksystem;

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


public class BookInterface extends JPanel implements ActionListener{
    private JLabel label;
    private RButton back;
    private RButton btn_insertBook;
    private RButton btn_state;
    private RButton btn_deleteBook;
    private RButton btn_updateBook;

    /**
     * Create the panel.
     */
    public BookInterface() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        label = new JLabel("Book Management System");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Bradley Hand ITC", Font.BOLD, 44));
        label.setBounds(300, 20, 800, 105);
        add(label);

        back = new RButton("Back");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        btn_insertBook = new RButton("Enter new books");
        btn_insertBook.setFont(new Font("宋体", Font.BOLD, 40));
        btn_insertBook.setBounds(280, 195, 750, 80);
        add(btn_insertBook);
        btn_insertBook.addActionListener(this);

        btn_deleteBook= new RButton("Delete book ");
        btn_deleteBook.setFont(new Font("宋体", Font.BOLD, 40));
        btn_deleteBook.setBounds(280, 295, 750, 80);
        add(btn_deleteBook);
        btn_deleteBook.addActionListener(this);

        btn_updateBook = new RButton("Update information");
        btn_updateBook.setFont(new Font("宋体", Font.BOLD, 40));
        btn_updateBook.setBounds(280, 395, 750, 80);
        add(btn_updateBook);
        btn_updateBook.addActionListener(this);

        btn_state = new RButton("Collection status ");
        btn_state.setFont(new Font("宋体", Font.BOLD, 40));
        btn_state.setBounds(280, 495, 750, 80);
        add(btn_state);
        btn_state.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == back) {
            MainInterface.BooktoChoose();
        }else if(e.getSource() == btn_insertBook){
            MainInterface.BooktoInsertBook();
        }else if(e.getSource() == btn_deleteBook) {
            MainInterface.BooktoDeleteBook();
        }else if(e.getSource() == btn_updateBook) {
            MainInterface.BooktoUpdate();
        }else if(e.getSource() == btn_state) {
            MainInterface.BooktoState();
        }

    }
}
