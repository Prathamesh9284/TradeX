package com.tradex.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class AccessToData {
	private static String url = "jdbc:mysql://localhost:3306/bitcointrading";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String pass = "";
	private int numberOfRowsAffected;

	private static PreparedStatement pr;
	private static Connection con;
	private Statement st;
	private ResultSet rs;
	private static String name, userPass;

	//ArrayList al = new ArrayList(4);

	public int insertInfo(ArrayList al) {

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();
			st.executeUpdate("create table "+"id"+(String)al.get(1)+"(status varchar(20),btc varchar(10),account_btc varchar(10),data_n_time varchar(30))");
			
			pr = con.prepareStatement(
					"insert into userinfo(name,mobile_no,email,password,btc,rupee) values(?,?,?,?,10,10000000)");
			pr.setString(1, (String) al.get(0));
			pr.setString(2, (String) al.get(1));
			pr.setString(3, (String) al.get(2));
			pr.setString(4, (String) al.get(3));
			numberOfRowsAffected = pr.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberOfRowsAffected;
	}

	public ArrayList validateUser(String email) throws SQLException, ClassNotFoundException {
		ArrayList al = new ArrayList();
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
		pr = con.prepareStatement("select id,name,mobile_no,email,password,btc,rupee from userinfo where email = ?");

		pr.setString(1, email);
		rs = pr.executeQuery();
		boolean b = rs.next();
		if (!b) {
			al.add(false);
		} else {
			al.add(true);
			al.add(rs.getString(1));
			al.add(rs.getString(2));
			al.add(rs.getString(3));
			al.add(rs.getString(4));
			al.add(rs.getString(5));
			al.add(rs.getString(6));
			al.add(rs.getString(7));

		}
		return al;
	}

	public void tradeBitcoin(String btc,String account_btc, String rupee, String email) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
		String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
		String p = ("id"+email);
		pr = con.prepareStatement("insert into "+p+" values(?,?,?,?)");
		pr.setString(1, "Sell");
		pr.setString(2, btc+"-");
		pr.setString(3, account_btc);
		pr.setString(4, s);
		pr.executeUpdate();
		pr = con.prepareStatement("update userinfo set btc = ? where mobile_no = ?");
		pr.setString(1, btc);
		pr.setString(2, email);
		pr.executeUpdate();
		pr = con.prepareStatement("update userinfo set rupee = ? where mobile_no = ?");
		pr.setString(1, rupee);
		pr.setString(2, email);
		pr.executeUpdate();
	}
	
	public void tradeBitcoinBuy(String btc,String account_btc, String rupee, String email) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
		String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
		String p = ("id"+email);
		pr = con.prepareStatement("insert into "+p+" values(?,?,?,?)");
		pr.setString(1, "Buy");
		pr.setString(2, btc+"+");
		pr.setString(3, account_btc);
		pr.setString(4, s);
		pr.executeUpdate();
		pr = con.prepareStatement("update userinfo set btc = ? where mobile_no = ?");
		pr.setString(1, btc);
		pr.setString(2, email);
		pr.executeUpdate();
		pr = con.prepareStatement("update userinfo set rupee = ? where mobile_no = ?");
		pr.setString(1, rupee);
		pr.setString(2, email);
		pr.executeUpdate();
	}

	public void transferBitcoin(String id, int amount, String email, String btc)
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
		int bid = Integer.parseInt(id);
		
		String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
		String p = ("id"+email);
		pr = con.prepareStatement("insert into "+p+" values(?,?,?,?)");
		pr.setString(1, "Transferred");
		pr.setString(2, Integer.toString(amount)+"-");
		pr.setString(3, btc);
		pr.setString(4, s);
		pr.executeUpdate();
		
		pr = con.prepareStatement("update userinfo set btc = ? where mobile_no = ?");
		pr.setString(1, btc);
		pr.setString(2, email);
		pr.executeUpdate();

		
		pr = con.prepareStatement("select mobile_no,btc from userinfo where id = ?");
		pr.setInt(1, bid);
		rs = pr.executeQuery();
		rs.next();
		String reciever = "id"+rs.getString(1);
		String btco = rs.getString(2);
		int account_btc = amount + Integer.parseInt(btco);
		
		pr = con.prepareStatement("update userinfo set btc = ? where id = ?");
		pr.setString(1, Integer.toString(account_btc));
		pr.setInt(2, bid);
		pr.executeUpdate();
		
		
		pr = con.prepareStatement("insert into "+reciever+" values(?,?,?,?)");
		pr.setString(1, "Recieved");
		pr.setString(2, Integer.toString(amount)+"+");
		pr.setString(3, Integer.toString(account_btc));
		pr.setString(4, s);
		pr.executeUpdate();
		
		

	}
	
	public String[][] getHistory(String email) throws Exception {
		
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
		String p = ("id"+email);
		String data[][] = new String[100][4];
		pr = con.prepareStatement("select * from "+p);
		
		System.out.println(p);
		//pr.setString(1, p);
		rs = pr.executeQuery();
		int j = 0;
		rs.last();
		rs.next();
		while(rs.previous()) {
			
			
			data[j][0] = rs.getString(1);
			data[j][1] = rs.getString(2);
			data[j][2] = rs.getString(3);
			data[j][3] = rs.getString(4);
			
			j++;
			
			System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
		}
		
		
		return data;
	}

}
