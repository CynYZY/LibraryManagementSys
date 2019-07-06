package com.cyn;

import com.cyn.Booksystem.*;
import com.cyn.DataBase.TableOperate;
import com.cyn.Issuesystem.*;
import com.cyn.Static.Information;
import com.cyn.peoplesystem.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainInterface extends JFrame implements ActionListener{

	public static JPanel contentPane;
	public static BackgroundPanel bgp;
	//Book
	public static BookInterface bookJPanel = new BookInterface();
	public static InsertBook insertbookJPanel = new InsertBook();
	public static DeleteBook deletebookJPanel = new DeleteBook();
	public static UpdateBook updatebookJPanel = new UpdateBook();
	public static State stateJPanel = new State();
	public static State_Information stateInfoJPanel = new State_Information();
	//People
	public static PeopleInterface peopleJPanel = new PeopleInterface();
	public static InsertPeople insertpeopleJPanel = new InsertPeople();
	public static DeletePeople deletepeopleJPanel = new DeletePeople();
	public static UpdatePeople updatepeopleJPanel = new UpdatePeople();
	public static SearchInfo searchInfoPeopleJPanel=new SearchInfo();
	//Issue
	public static UserInterface userJPanel = new UserInterface();
	public static BorrowBook borrowJPanel = new BorrowBook();
	public static BorrowBook_Information borrowInfoJPanel = new BorrowBook_Information();
	public static ReturnBook returnJPanel = new ReturnBook();

	public static PersonalInformation personalJPanel = new PersonalInformation();
	/////////////////////////////////////////////////////////////////////////////
	public static ChooseInterface chooseJPanel = new ChooseInterface();
	//�����洰��
	private JTextField tf_user;
	private JPasswordField tf_password;
	private JLabel label_user;
	private JLabel label_password;
	//private JRadioRButton rb_customer;
	//private JRadioRButton rb_manager;
	private RButton btn_login;
	//private JRButton btn_register;
	//private JRButton btn_changePassword;
	private static boolean flage_book = false;
	private static boolean flage_people = false;
	private static boolean flage_insertbook = false;
	private static boolean flage_updatebook = false;
	private static boolean flage_state = false;
	private static boolean flage_stateInfo = false;
	private static boolean flage_user = false;
	private static boolean flage_borrow = false;
	private static boolean flage_borrowInfo = false;
	private static boolean flage_return = false;

	private static boolean flage_personal = false;
	//////////////////////////////////////////
	private static boolean flage_choose = false;
	private static boolean flage_deletebook = false;
	private static boolean flage_insertpeople = false;
	private static boolean flage_deletepeople = false;
	private static boolean flage_updatepeople = false;
	private static boolean flage_searchpeople = false;

	private boolean flage = false;
	private static Container container;
	private JLabel label;

	//设置背景图片



	public MainInterface() {
		init();
	}

//
//	@Override
//	public void paintComponents(Graphics graphics) {
//		super.paintComponents(graphics);
//		ImageIcon image=new ImageIcon(getClass().getResource("img1.jpg"));
//		JLabel Label=new JLabel(image);
//		image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_FAST));
//		image.paintIcon(this,graphics,0,0);
//
//	}

	public void init() {

//		try {
//			bg = ImageIO.read(new File("image/img1.jpg"));
//		}catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	    container = this.getContentPane();
		contentPane=(JPanel)this.getContentPane();
		/****************************************设置背景*******************************/

		ImageIcon img=new ImageIcon("C:\\Users\\Cynth\\Desktop\\C1G1\\LibraryManageSystem-master3\\LibraryManageSystem-master3\\LibraryManageSystem-master\\src\\com\\Image\\img3.jpg");
		bgp=new BackgroundPanel(img.getImage());
		bgp.setBounds(0,0,img.getIconWidth(),img.getIconHeight());




		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 1300, 1000);
		setResizable(false);
		setLocation(200,80);
//
//		ImageIcon img=new ImageIcon("img1.jpg/");
//		JLabel image=new JLabel(img);
//		this.getLayeredPane().add(image,new Integer(Integer.MIN_VALUE));
//		image.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
//		container.setLayout(new BorderLayout());
//		((JPanel)container).setOpaque(false);


		bgp.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.add(bgp);
		bgp.setLayout(null);



		//�˺������
		tf_user = new JTextField();
		tf_user.setFont(new Font("宋体", Font.BOLD, 35));
		tf_user.setBounds(465, 278, 526, 75);
		bgp.add(tf_user);
		tf_user.setColumns(10);

		//���������
		tf_password = new JPasswordField();
		tf_password.setFont(new Font("宋体", Font.BOLD, 35));
		tf_password.setColumns(10);
		tf_password.setBounds(465, 387, 526, 75);
		bgp.add(tf_password);

		//�û�����ǩ
		label_user = new JLabel("Username:");
		label_user.setFont(new Font("宋体", Font.BOLD, 35));
		label_user.setBounds(225, 290, 350, 48);
		bgp.add(label_user);

		//�����ǩ
		label_password = new JLabel("Password:");
		label_password.setFont(new Font("宋体", Font.BOLD, 35));
		label_password.setBounds(225, 400, 350, 48);
		bgp.add(label_password);

       /*
      rb_customer = new JRadioRButton("Ordinary users");
      rb_customer.setSelected(true);
      rb_customer.setFont(new Font("宋体", Font.BOLD, 30));
      rb_customer.setBackground(Color.WHITE);
      rb_customer.setBounds(300, 515, 350, 37);
      contentPane.add(rb_customer);

      //������Ա��ѡ��ť
      rb_manager = new JRadioRButton("Management");
      rb_manager.setFont(new Font("宋体", Font.BOLD, 30));
      rb_manager.setBackground(Color.WHITE);
      rb_manager.setBounds(750, 515, 350, 37);
      contentPane.add(rb_manager);
      //��ѡ�ť��ӵ�һ����ť��
      RButtonGroup bg=new RButtonGroup();// ��ʼ����ť��
      bg.add(rb_customer);// ��ͨ�û����밴ť��
      bg.add(rb_manager);// ������Ա���밴ť��
        */

		//��¼��ť
		btn_login = new RButton("Sign in ");
		btn_login.setBackground(Color.LIGHT_GRAY);
		btn_login.setFont(new Font("宋体", Font.BOLD, 35));
		btn_login.setBounds(380, 634, 600, 48);
		bgp.add(btn_login);
		btn_login.addActionListener(this);



      /*
      btn_changePassword = new JRButton("Change Password");
      btn_changePassword.setFont(new Font("宋体", Font.BOLD, 22));
      btn_changePassword.setBackground(Color.LIGHT_GRAY);
      btn_changePassword.setBounds(1000, 370, 280, 48);
      contentPane.add(btn_changePassword);*/

		label = new JLabel("Library Management System ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 40));
		label.setBounds(350, 80, 700, 105);
		bgp.add(label);
		//btn_changePassword.addActionListener(this);
	}




	//�л����ں���
	//Choose->Book
	public static void ChoosetoBook() {
		if(!flage_book) {
			chooseJPanel.setVisible(false);
			container.add(bookJPanel);
			flage_book = true;
		}else {
			chooseJPanel.setVisible(false);
			bookJPanel.setVisible(true);
		}
	}
	//Book->choose
	public static void BooktoChoose() {
		bookJPanel.setVisible(false);
		chooseJPanel.setVisible(true);
	}

	//Book->Insert
	public static void BooktoInsertBook() {
		if(!flage_insertbook) {
			bookJPanel.setVisible(false);
			container.add(insertbookJPanel);
			flage_insertbook = true;
		}else {
			bookJPanel.setVisible(false);
			insertbookJPanel.setVisible(true);
		}
	}
	//Insert->Book
	public static void InserttoBook() {
		insertbookJPanel.setVisible(false);
		bookJPanel.setVisible(true);
	}

	//Book->Delete
	public static void BooktoDeleteBook() {
		if(!flage_deletebook) {
			bookJPanel.setVisible(false);
			container.add(deletebookJPanel);
			flage_deletebook = true;
		}else {
			bookJPanel.setVisible(false);
			deletebookJPanel.setVisible(true);
		}
	}
	//Delete->Book
	public static void DeleteBooktoBook() {
		deletebookJPanel.setVisible(false);
		bookJPanel.setVisible(true);
	}

	//Book->UpdateBook
	public static void BooktoUpdate() {
		if(!flage_updatebook) {
			bookJPanel.setVisible(false);
			container.add(updatebookJPanel);
			flage_updatebook = true;
		}else {
			bookJPanel.setVisible(false);
			updatebookJPanel.setVisible(true);
		}
	}
	//UpdateBook->Book
	public static void UpdatetoBook() {
		updatebookJPanel.setVisible(false);
		bookJPanel.setVisible(true);
	}

	//Book->State
	public static void BooktoState() {
		if(!flage_state) {
			bookJPanel.setVisible(false);
			container.add(stateJPanel);
			flage_state = true;
		}else {
			bookJPanel.setVisible(false);
			stateJPanel.setVisible(true);
		}
	}
	//State->Book
	public static void StatetoManager() {
		stateJPanel.setVisible(false);
		bookJPanel.setVisible(true);
	}

	//State->StateInfo
	public static void StatetoStateInfo() {
		if(!flage_stateInfo) {
			stateJPanel.setVisible(false);
			container.add(stateInfoJPanel);
			flage_stateInfo = true;
		}else {
			stateJPanel.setVisible(false);
			stateInfoJPanel.setVisible(true);
		}
	}
	//StateInfo->State
	public static void StateInfotoState() {
		stateInfoJPanel.setVisible(false);
		stateJPanel.setVisible(true);
	}

	//Choose->User
	public static void ChoosetoUser() {
		if(!flage_user) {
			chooseJPanel.setVisible(false);
			container.add(userJPanel);
			flage_user = true;
		}else {
			chooseJPanel.setVisible(false);
			userJPanel.setVisible(true);
		}
	}
	//User->Choose
	public static void UsertoChoose() {
		userJPanel.setVisible(false);
		chooseJPanel.setVisible(true);
	}

	//User->Borrow
	public static void UsertoBorrow() {
		if(!flage_borrow) {
			userJPanel.setVisible(false);
			container.add(borrowJPanel);
			flage_borrow = true;
		}else {
			userJPanel.setVisible(false);
			borrowJPanel.setVisible(true);
		}
	}
	//Borrow->User
	public static void BorrowtoUser() {
		borrowJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}

	//Borrow->BorrowInfo
	public static void BorrowtoBorrowInfo() {
		if(!flage_borrowInfo) {
			borrowJPanel.setVisible(false);
			container.add(borrowInfoJPanel);
			flage_borrowInfo = true;
		}else {
			borrowJPanel.setVisible(false);
			borrowInfoJPanel.setVisible(true);
		}
	}
	//BorrowInfo->Borrow
	public static void BorrowInfotoBorrow() {
		borrowInfoJPanel.setVisible(false);
		borrowJPanel.setVisible(true);
	}

	//User->Return
	public static void UsertoReturn() {
		if(!flage_return) {
			userJPanel.setVisible(false);
			container.add(returnJPanel);
			flage_return = true;
		}else {
			userJPanel.setVisible(false);
			returnJPanel.setVisible(true);
		}
	}
	//Return->User
	public static void ReturentoUser() {
		returnJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}

	//User->Personal
	public static void UsertoPersonal() {
		if(!flage_personal) {
			userJPanel.setVisible(false);
			container.add(personalJPanel);
			flage_personal = true;
		}else {
			userJPanel.setVisible(false);
			personalJPanel.setVisible(true);
		}
	}

	//Personal->User
	public static void PersonaltoUser() {
		personalJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}
	///////////////////////////////////////////////////
	//Choose->People
	public static void ChoosetoPeople() {
		if(!flage_people) {
			chooseJPanel.setVisible(false);
			container.add(peopleJPanel);
			flage_people = true;
		}else {
			chooseJPanel.setVisible(false);
			peopleJPanel.setVisible(true);
		}
	}
	//People->choose
	public static void PeopletoChoose() {
		peopleJPanel.setVisible(false);
		chooseJPanel.setVisible(true);
	}
	//People->Insert
	public static void PeopletoInsertPeople() {
		if(!flage_insertpeople) {
			peopleJPanel.setVisible(false);
			container.add(insertpeopleJPanel );
			flage_insertpeople = true;
		}else {
			peopleJPanel.setVisible(false);
			insertpeopleJPanel .setVisible(true);
		}
	}
	//Insert->People
	public static void InserttoPeople() {
		insertpeopleJPanel .setVisible(false);
		peopleJPanel.setVisible(true);
	}
	//People->Delete
	public static void PeopletoDeletePeople() {
		if(!flage_deletepeople) {
			peopleJPanel.setVisible(false);
			container.add(deletepeopleJPanel);
			flage_deletebook = true;
		}else {
			peopleJPanel.setVisible(false);
			deletepeopleJPanel.setVisible(true);
		}
	}
	//Delete->People
	public static void DeletePeopletoPeople() {
		deletepeopleJPanel.setVisible(false);
		peopleJPanel.setVisible(true);
	}
	//People->UpdatePeople
	public static void PeopletoUpdatePeople() {
		if(!flage_updatepeople) {
			peopleJPanel.setVisible(false);
			container.add(updatepeopleJPanel);
			flage_updatepeople = true;
		}else {
			peopleJPanel.setVisible(false);
			updatepeopleJPanel.setVisible(true);
		}
	}
	//UpdatePeople->People
	public static void UpdatePeopletoPeople() {
		updatepeopleJPanel.setVisible(false);
		peopleJPanel.setVisible(true);
	}
	//People->searchinfo
	public static void PeopletoSearchInfo() {
		if(!flage_searchpeople) {
			searchInfoPeopleJPanel.setVisible(false);
			container.add(searchInfoPeopleJPanel);
			flage_searchpeople = true;
		}else {
			peopleJPanel.setVisible(false);
			searchInfoPeopleJPanel.setVisible(true);
		}
	}
	//Searchinfo->People
	public static void SearchInfotoPeople() {
		searchInfoPeopleJPanel.setVisible(false);
		peopleJPanel.setVisible(true);
	}

	//////////////////////////////////////////////////

	//main->choose
	public static void MaintoChoose() {
		if(!flage_choose) {
			bgp.setVisible(false);
			container.add(chooseJPanel);
			flage_choose = true;
		}else {
			bgp.setVisible(false);
			chooseJPanel.setVisible(true);
		}
	}
	//choose->main
	public static void ChoosetoMain() {
		chooseJPanel.setVisible(false);
		bgp.setVisible(true);
	}
	//////////////////////////////////////////////////

	//��¼ע���¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pswd = String.valueOf(tf_password.getPassword()); // String type of password
		if (e.getSource() == btn_login) {
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Password is wrong, please try again ", "error", JOptionPane.ERROR_MESSAGE);
			} else if (pswd.equals("")) {
				JOptionPane.showMessageDialog(null, "Account is wrong, please try again ", "error", JOptionPane.ERROR_MESSAGE);
			} else {

            /*if (rb_customer.isSelected()) {

               boolean isExist = TableOperate.isExist_Customer(tf_user.getText(), pswd);
               if (isExist) {
                  JOptionPane.showMessageDialog(null, "Login Success!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                  Information.user = tf_user.getText();

                  MaintoChoose();
               } else {
                  JOptionPane.showMessageDialog(null, "Account is wrong, please try again", "error", JOptionPane.ERROR_MESSAGE);
               }
            } else {
            */
				boolean isExist = TableOperate.isExist_Manager(tf_user.getText(), pswd);
				if (isExist) {
					JOptionPane.showMessageDialog(null, "Login Success!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
					Information.manager = tf_user.getText();
					ChooseInterface.setManager();
					MaintoChoose();
				} else {
					JOptionPane.showMessageDialog(null, "Account is wrong, please try again", "error", JOptionPane.ERROR_MESSAGE);
				}
				//}
			}
		}
	}


	class BackgroundPanel extends JPanel{
		Image im;
		public BackgroundPanel(Image im){
			this.im=im;
			this.setOpaque(true);
		}
		//Draw the back ground.
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		}

	}



}



