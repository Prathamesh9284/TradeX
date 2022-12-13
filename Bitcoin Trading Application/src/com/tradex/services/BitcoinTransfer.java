package com.tradex.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.tradex.services.DashBoard;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class BitcoinTransfer {

	private JFrame frame;
	private static ArrayList al;
	private static BitcoinTransfer window;
	private JTextField amount1;
	private JPasswordField pass1;
	private JTextField id;
	private JTextField otp;

	/**
	 * Launch the application.
	 */
	public void start(ArrayList a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					al = new ArrayList(a);
					window = new BitcoinTransfer(a);

					window.frame.setUndecorated(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BitcoinTransfer(ArrayList a) {
		al = new ArrayList(a);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel mvd = new JLabel("");
		mvd.setIcon(new ImageIcon(DashBoard.class.getResource(
				"/com/tradex/images/Choose_a_package___Logo_Maker___Designhill_-_Brave_28-09-2022_19_36_24-removebg-preview.png")));
		mvd.setHorizontalAlignment(SwingConstants.CENTER);
		mvd.setBounds(0, 21, 458, 97);
		frame.getContentPane().add(mvd);

		JLabel close_lbl = new JLabel("X");
		close_lbl.setForeground(Color.RED);
		close_lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		close_lbl.setBounds(970, 0, 36, 37);
		frame.getContentPane().add(close_lbl);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(DashBoard.class.getResource("/com/tradex/images/dark-mode-18.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1017, 118);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1
				.setIcon(new ImageIcon(BitcoinTransfer.class.getResource("/com/tradex/images/user-286-256 (1).png")));
		lblNewLabel_4_1.setBounds(218, 131, 88, 107);
		frame.getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_1 = new JLabel((String) al.get(2));
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 24));
		lblNewLabel_1.setBounds(286, 129, 304, 86);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setFont(new Font("HP Simplified", Font.PLAIN, 14));
		lblNewLabel.setBounds(286, 189, 29, 38);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("tradex" + (String) al.get(1));
		lblNewLabel_2.setFont(new Font("HP Simplified", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(316, 190, 105, 38);
		frame.getContentPane().add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.MAGENTA);
		separator_1.setBounds(286, 190, 152, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.MAGENTA);
		separator.setBounds(218, 249, 756, 2);
		frame.getContentPane().add(separator);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(
				new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		panel_1.setBounds(276, 330, 637, 359);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Enter Bitcoin Amount :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(50, 39, 158, 32);
		panel_1.add(lblNewLabel_3);

		amount1 = new JTextField();
		amount1.setOpaque(false);
		amount1.setColumns(10);
		amount1.setBorder(null);
		amount1.setBounds(50, 70, 235, 37);
		panel_1.add(amount1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.MAGENTA);
		separator_1_1.setBounds(50, 105, 235, 2);
		panel_1.add(separator_1_1);

		JLabel lblNewLabel_3_2 = new JLabel("Id  (Reciever's):");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(350, 39, 111, 32);
		panel_1.add(lblNewLabel_3_2);

		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setForeground(Color.MAGENTA);
		separator_1_1_2.setBounds(50, 215, 235, 2);
		panel_1.add(separator_1_1_2);

		Random rm = new Random();
		int num = rm.nextInt(999999); 

		JButton btnSell = new JButton("Sell");
		btnSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				AccessToData up = new AccessToData();
				
				int btc = Integer.parseInt((String) al.get(6));
				int amount = Integer.parseInt(amount1.getText());
				String password = new String(pass1.getPassword());
				
				btc = btc - amount;
				if(num==Integer.valueOf(otp.getText()))
				{
				try {
					if (btc < 0) {
						JOptionPane.showMessageDialog(null, "You don't have sufficient balance");
					} else if ((btc >= 0) && !(password.equals((String) al.get(5)))) {
						JOptionPane.showMessageDialog(null, "Password is Incorrect");
					} else {
						al.set(6, Integer.toUnsignedString(btc));
						
						up.transferBitcoin( id.getText(),amount,(String)al.get(3),(String)al.get(6));
						JOptionPane.showMessageDialog(null,  "Btc = " + btc);

					}
				} catch (Exception ex) {

				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Enterd OTP is invalid");
				}
			}
		});
		btnSell.setForeground(Color.WHITE);
		btnSell.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		btnSell.setBackground(new Color(204, 0, 204));
		btnSell.setBounds(270, 270, 100, 31);
		panel_1.add(btnSell);

		pass1 = new JPasswordField();
		pass1.setOpaque(false);
		pass1.setBorder(null);
		pass1.setBounds(50, 180, 235, 37);
		panel_1.add(pass1);
		
		id = new JTextField();
		id.setOpaque(false);
		id.setColumns(10);
		id.setBorder(null);
		id.setBounds(350, 70, 235, 37);
		panel_1.add(id);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.MAGENTA);
		separator_1_1_1.setBounds(350, 105, 235, 2);
		panel_1.add(separator_1_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Enter Password :");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_1.setBounds(50, 150, 111, 32);
		panel_1.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Enter OTP :");
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_2.setBounds(350, 150, 111, 32);
		panel_1.add(lblNewLabel_3_2_2);
		
		otp = new JTextField();
		otp.setOpaque(false);
		otp.setColumns(10);
		otp.setBorder(null);
		otp.setBounds(350, 180, 235, 37);
		panel_1.add(otp);
		
		
		JLabel lblGetOtp = new JLabel("Get OTP");
		lblGetOtp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(al);
				lblGetOtp.setForeground(Color.gray);
				EmailNotification em = new EmailNotification();
				em.sendOtpTomail(num, (String)al.get(4));

			}
		});
		lblGetOtp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGetOtp.setForeground(new Color(204, 0, 204));
		lblGetOtp.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblGetOtp.setBounds(524, 151, 61, 31);
		panel_1.add(lblGetOtp);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setForeground(Color.MAGENTA);
		separator_1_1_1_1.setBounds(350, 215, 235, 2);
		panel_1.add(separator_1_1_1_1);
		
		

		JLabel lblNewLabel_1_1 = new JLabel("Transfer Bitcoin :");
		lblNewLabel_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(276, 269, 335, 50);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		panel.setBounds(0, 118, 200, 621);
		frame.getContentPane().add(panel);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(0, 74, 200, 78);
		panel.add(panel_1_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("");
		lblNewLabel_4_2_1.setBounds(10, 20, 50, 50);
		panel_1_1_1.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("");
		lblNewLabel_4_1_2.setBounds(10, 11, 50, 50);
		panel_1_1_1.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Trade Bitcoin");
		lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BitcoinTrade bt = new BitcoinTrade(al);
				bt.start(al);
				window.frame.dispose();
			}
			
		});
		lblNewLabel_1_1_2.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(55, 11, 120, 50);
		panel_1_1_1.add(lblNewLabel_1_1_2);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		panel_1_1_1_1.setBackground(SystemColor.menu);
		panel_1_1_1_1.setBounds(0, 151, 200, 78);
		panel.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("");
		lblNewLabel_4_2_1_1.setBounds(10, 20, 50, 50);
		panel_1_1_1_1.add(lblNewLabel_4_2_1_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("");
		lblNewLabel_4_1_2_1.setBounds(10, 11, 50, 50);
		panel_1_1_1_1.add(lblNewLabel_4_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Transfer Bitcoin");
		lblNewLabel_1_1_2_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_2_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(55, 11, 120, 50);
		panel_1_1_1_1.add(lblNewLabel_1_1_2_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.MAGENTA);
		separator_2.setBounds(10, 568, 180, 2);
		panel.add(separator_2);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Log Out");
		lblNewLabel_1_1_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.frame.dispose();
				LoginPage lp = new LoginPage();
				lp.main(null);
			}
		});
		lblNewLabel_1_1_2_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_2_1_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1_1.setBounds(70, 571, 120, 44);
		panel.add(lblNewLabel_1_1_2_1_1);
		
		JPanel profile = new JPanel();
		profile.setLayout(null);
		profile.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		profile.setBackground(Color.WHITE);
		profile.setBounds(0, 0, 200, 78);
		panel.add(profile);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("");
		lblNewLabel_4_2_1_2.setBounds(10, 20, 50, 50);
		profile.add(lblNewLabel_4_2_1_2);
		
		JLabel lblNewLabel_4_1_2_2 = new JLabel("");
		lblNewLabel_4_1_2_2.setBounds(10, 11, 50, 50);
		profile.add(lblNewLabel_4_1_2_2);
		
		JLabel username = new JLabel("Wallet");
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoard db = new DashBoard(al);
				db.build(al);
				window.frame.dispose();
				
			}
		});
		username.setForeground(Color.MAGENTA);
		username.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		username.setBounds(55, 11, 120, 50);
		profile.add(username);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		panel_1_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1_1.setBounds(0, 228, 200, 78);
		panel.add(panel_1_1_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("");
		lblNewLabel_4_2_1_1_1.setBounds(10, 20, 50, 50);
		panel_1_1_1_1_1.add(lblNewLabel_4_2_1_1_1);
		
		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("");
		lblNewLabel_4_1_2_1_1.setBounds(10, 11, 50, 50);
		panel_1_1_1_1_1.add(lblNewLabel_4_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Transaction History");
		lblNewLabel_1_1_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				History h;
				try {
					h = new History(al);
					h.start(al);
					window.frame.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		lblNewLabel_1_1_2_1_2.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_2_1_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1_2.setBounds(55, 11, 120, 50);
		panel_1_1_1_1_1.add(lblNewLabel_1_1_2_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(BitcoinTransfer.class.getResource("/com/tradex/images/131378-grey-and-white-polygon-pattern-background.jpg")));
		lblNewLabel_5.setBounds(201, 118, 800, 621);
		frame.getContentPane().add(lblNewLabel_5);

	}
}
