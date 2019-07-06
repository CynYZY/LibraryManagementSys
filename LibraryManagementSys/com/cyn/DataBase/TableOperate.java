package com.cyn.DataBase;

import java.sql.*;

import com.cyn.Book;
import com.cyn.People;
import com.cyn.Static.Information;

public class TableOperate {

	public TableOperate() {
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connect to MySQL successfully");
            String url=Information.JDBC_URL;
            Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("");
            ResultSet rs = stmt.executeQuery("select * from temp");
                while (rs.next()){
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.println();
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
	}
    

    public static boolean isExist_Manager(String user,String password) {
    	try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("isExist_Manager");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("isExist_Manager");

            String sql = "select * from Manager";
            ResultSet rs = stmt.executeQuery(sql);
                System.out.println("    "+"\t"+"\t"+"\t"+"    ");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }

    public static void insertBook(String number,String classnumber,String name,String classname,String price,String state,String total) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("insertBook");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("insertBook");
            //String sql = "insert into "+classname+"Book"+" values('"+number+"','"+classnumber+"','"+name+"','"+classname+"','"+price+"','"+state+"','"+total+"','null','null','null');";
            String sql = "insert into "+classname+"book"+" values('"+number+"','"+classnumber+"','"+name+"','"+classname+"','"+price+"','"+state+"','"+total+"');";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    //insert people
    public static void insertPeople(String firstname,String middlename,String lastname,String birthday,String gender,String card,String address,String tel) {
        try{
            //Class.forName()
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("insertPeople");

            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("insertPeople");
            //String sql = "insert into "+classname+"Book"+" values('"+number+"','"+classnumber+"','"+name+"','"+classname+"','"+price+"','"+state+"','"+total+"','null','null','null');";
            String sql = "insert into "+" "+"people"+" values('"+firstname+"','"+middlename+"','"+lastname+"','"+birthday+"','"+gender+"','"+card+"','"+address+"','"+tel+"');";    //Ҫִ�е�SQL
            TableOperate.newCustomer(card);
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public static boolean isExist_people(String card) {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("isExist_Manager");

            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("isExist_People");

            String sql = "select * from people ;";
            ResultSet rs = stmt.executeQuery(sql);
                System.out.println("        "+"\t"+"\t"+"\t"+"         ");
            while (rs.next()){
                System.out.print(rs.getString(6) + "\t");
                System.out.println();
                if(rs.getString(6).equals(card) ) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }





    public static void deleteBook(String number, String classname) {
    	try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url=Information.JDBC_URL;
            Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement();
            PreparedStatement stmts = conn.prepareStatement("delete from "+classname+"book where number = '"+number+"';");
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    //delete people
    public static void deletePeople(String card) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url=Information.JDBC_URL;
            Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement();
            PreparedStatement stmts = conn.prepareStatement("delete from "+" "+"people where card_number = '"+card+"';");
            stmts.executeUpdate();
            Statement stmt1 = conn.createStatement();
            PreparedStatement stmts1 = conn.prepareStatement("drop table "+card+"customer;");
            stmts1.executeUpdate();

            stmts.close();
            stmts1.close();
            stmt.close();
            stmt1.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void search_classname(String classname) {
    	Information.bookArray.clear();
    	try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url=Information.JDBC_URL;
            Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from "+classname+"Book;");
                while (rs.next()){
                	Book book = new Book();
                    book.number = rs.getString(1);
                    book.classnumber = rs.getString(2);
                    book.name = rs.getString(3);
                    book.classname = rs.getString(4);
                    book.price = rs.getString(5);
                    book.state = rs.getString(6);
                    book.total = rs.getString(7);
                    book.current = rs.getString(8);
                    book.dateon = rs.getString(9);
                    book.dateoff = rs.getString(10);
                    Information.bookArray.add(book);
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    ///////////////////////人物/////////////////////////
    public static void search_peoplename(String peoplename) {
        Information.peopleArray.clear();
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url=Information.JDBC_URL;
            Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from "+" "+"people;");
            while (rs.next()){
                People people = new People();
                people.firstname= rs.getString(1);
                people.middlename = rs.getString(2);
                people.lastname = rs.getString(3);
                people.birthday = rs.getString(4);
                people.gender = rs.getString(5);
                people.card_number = rs.getString(6);
                people.address= rs.getString(7);
                people.tel = rs.getString(8);
                Information.peopleArray.add(people);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void borrowBook_Update(String classname,String number,String card,String dateon,String dateoff) {
    	try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url=Information.JDBC_URL;
            Connection conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement();
            PreparedStatement stmts_state = conn.prepareStatement("update "+classname+"Book set state = 'out' where number = '"+number+"';\n");
            stmts_state.executeUpdate();  
            stmts_state.close();
            
            /*PreparedStatement stmts_current = conn.prepareStatement("update "+classname+"Book set current = '"+user+"' where number = '"+number+"';\n");
            stmts_current.executeUpdate();  
            stmts_current.close();
            
            PreparedStatement stmts_dateoff = conn.prepareStatement("update "+classname+"Book set dateoff = '"+dateoff+"' where number = '"+number+"';\n");
            stmts_dateoff.executeUpdate();
            stmts_dateoff.close();
             */
            String sql2 = "insert into "+card+"customer values ('"+card+"','"+number+"','"+classname+"','"+dateon+"','"+dateoff+"');";   //Ҫִ�е�SQL
            PreparedStatement customer = conn.prepareStatement(sql2);
            customer.executeUpdate();
            customer.close();
            
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    public static void newCustomer(String card) {
    	try{
            //Class.forName()
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("newCustomer");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("newCustomer");

            String sql = "CREATE TABLE "+card+"Customer (card VARCHAR(255) ,number VARCHAR(255) primary key ,classname VARCHAR(255),dateon VARCHAR(255),dateoff VARCHAR(255));";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    

    public static void returnBook_Update(String classname,String number) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("returnBook_Update");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("returnBook_Update");

            String sql = "update "+classname+"Book set state = 'in' where number = '"+number+"';\n";    //Ҫִ�е�SQL
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.executeUpdate();  
            stmts_state.close();
            
           /* sql = "update "+classname+"Book set current = 'null' where number = '"+number+"';\n";
            PreparedStatement stmts_current = conn.prepareStatement(sql);
            stmts_current.executeUpdate();  
            stmts_current.close();
            
            sql = "update "+classname+"Book set dateoff = 'null' where number = '"+number+"';\n";
            PreparedStatement stmts_dateoff = conn.prepareStatement(sql);
            stmts_dateoff.executeUpdate();
            stmts_dateoff.close();




            String sql2 = "delete from "+card+"customer where number='"+number+"';";   //Ҫִ�е�SQL
            PreparedStatement customer = conn.prepareStatement(sql2);
            customer.executeUpdate();
            customer.close();
            */

            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }


   //获取行数
    public static boolean getcount(String card) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("returnBook_Delete");

            String url = Information.JDBC_URL;
            Connection con;

            con = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rset = null;
            rset = stmt.executeQuery("select * from " + card + "customer");
            rset.last();
            int rowCount = rset.getRow(); //获得ResultSet的总行数
            if (rowCount >= 3) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
    

    public static void search_personal(String user) {
    	Information.bookArray.clear();
    	try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("search_personal");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("search_personal");

            String sql = "select * from "+user+"Customer;";
            ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                	Book book = new Book();
                    book.number = rs.getString(1);
                    book.classname = rs.getString(2);
                    book.name = rs.getString(3);
                    book.dateoff = rs.getString(4);
                    Information.bookArray.add(book);
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }


    public static boolean isExist_Table(String table) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("isExist_Table");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("isExist_Table");

            String sql = "show tables";
            ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    if(table.equals(rs.getString(1))) {
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }

    public static String search_bookname(String classname,String number) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("search_bookname");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("search_bookname");

            String sql = "select * from "+classname+"book where number='"+number+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                return rs.getString(3);
            }
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	return "null";
    }
    
	//�����鼮״̬
    public static String search_bookstate(String classname,String number) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("search_bookstate");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("search_bookstate");

            String sql = "select * from "+classname+"book where number='"+number+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                return rs.getString(6);
            }
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	return "null";
    }
    

    public static int search_bookdateoff(String classname,String number) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("search_bookdateoff");
                
            String url=Information.JDBC_URL;
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement();
            System.out.println("search_bookdateoff");

            String sql = "select * from "+classname+"book where number='"+number+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                return Integer.parseInt(rs.getString(10));
            }
            rs.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	return 0;
    }
}
