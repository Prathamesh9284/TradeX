package com.tradex.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashBoard {

	private JFrame frame;
	private static DashBoard window; 
	private static ArrayList al;
	/**
	 * Launch the application.
	 */
	public void build(ArrayList a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					al = new ArrayList(a);
					window = new DashBoard(al);
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
	public DashBoard(ArrayList a) {
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
		mvd.setIcon(new ImageIcon(DashBoard.class.getResource("/com/tradex/images/Choose_a_package___Logo_Maker___Designhill_-_Brave_28-09-2022_19_36_24-removebg-preview.png")));
		mvd.setHorizontalAlignment(SwingConstants.CENTER);
		mvd.setBounds(0, 21, 458, 97);
		frame.getContentPane().add(mvd);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		panel.setBounds(0, 118, 200, 621);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
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
				BitcoinTrade b = new BitcoinTrade(al);
				b.start(al);
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
		panel_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1.setBounds(0, 151, 200, 78);
		panel.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("");
		lblNewLabel_4_2_1_1.setBounds(10, 20, 50, 50);
		panel_1_1_1_1.add(lblNewLabel_4_2_1_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("");
		lblNewLabel_4_1_2_1.setBounds(10, 11, 50, 50);
		panel_1_1_1_1.add(lblNewLabel_4_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Transfer Bitcoin");
		lblNewLabel_1_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BitcoinTransfer tb = new BitcoinTransfer(al);
				tb.start(al);
				window.frame.dispose();
			}
		});
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
		profile.setBackground(SystemColor.menu);
		profile.setBounds(0, 0, 200, 78);
		panel.add(profile);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("");
		lblNewLabel_4_2_1_2.setBounds(10, 20, 50, 50);
		profile.add(lblNewLabel_4_2_1_2);
		
		JLabel lblNewLabel_4_1_2_2 = new JLabel("");
		lblNewLabel_4_1_2_2.setBounds(10, 11, 50, 50);
		profile.add(lblNewLabel_4_1_2_2);
		
		JLabel username = new JLabel("Wallet");
		username.setForeground(Color.MAGENTA);
		username.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		username.setBounds(55, 11, 120, 50);
		profile.add(username);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA));
		panel_1_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1_1.setBounds(0, 228, 200, 78);
		panel.add(panel_1_1_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("");
		lblNewLabel_4_2_1_1_1.setBounds(10, 20, 50, 50);
		panel_1_1_1_1_1.add(lblNewLabel_4_2_1_1_1);
		
		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("");
		lblNewLabel_4_1_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
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
		
		JLabel lblNewLabel_1 = new JLabel((String)al.get(2));
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 24));
		lblNewLabel_1.setBounds(289, 138, 304, 86);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(DashBoard.class.getResource("/com/tradex/images/user-286-256 (1).png")));
		lblNewLabel_4_1.setBounds(220, 128, 88, 107);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setFont(new Font("HP Simplified", Font.PLAIN, 17));
		lblNewLabel.setBounds(289, 225, 29, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("tradex"+(String)al.get(1));
		lblNewLabel_2.setFont(new Font("HP Simplified", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(324, 225, 134, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblEmailId = new JLabel("Email Id :");
		lblEmailId.setFont(new Font("HP Simplified", Font.PLAIN, 17));
		lblEmailId.setBounds(289, 278, 68, 38);
		frame.getContentPane().add(lblEmailId);
		
		JLabel lblNewLabel_2_1 = new JLabel((String)al.get(4));
		lblNewLabel_2_1.setFont(new Font("HP Simplified", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(367, 278, 240, 38);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblPhoneNo = new JLabel("Phone No. :");
		lblPhoneNo.setFont(new Font("HP Simplified", Font.PLAIN, 17));
		lblPhoneNo.setBounds(628, 225, 78, 38);
		frame.getContentPane().add(lblPhoneNo);
		
		JLabel lblNewLabel_2_2 = new JLabel((String)al.get(3));
		lblNewLabel_2_2.setFont(new Font("HP Simplified", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(697, 225, 105, 38);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.MAGENTA);
		separator.setBounds(220, 345, 756, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.MAGENTA);
		separator_1.setBounds(277, 198, 152, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblTotalBtc = new JLabel("Total BTC :");
		lblTotalBtc.setFont(new Font("HP Simplified", Font.PLAIN, 17));
		lblTotalBtc.setBounds(289, 392, 78, 38);
		frame.getContentPane().add(lblTotalBtc);
		
		JLabel lblNewLabel_1_1 = new JLabel((String)al.get(6));
		lblNewLabel_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(289, 439, 140, 86);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel close_lbl = new JLabel("X");
		close_lbl.setForeground(Color.RED);
		close_lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		close_lbl.setBounds(970, 0, 36, 37);
		frame.getContentPane().add(close_lbl);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(DashBoard.class.getResource("/com/tradex/images/dark-mode-18.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1017, 118);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(220, 358, 756, 250);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAccountBalance = new JLabel("Account Balance :");
		lblAccountBalance.setBounds(407, 32, 120, 38);
		panel_1.add(lblAccountBalance);
		lblAccountBalance.setFont(new Font("HP Simplified", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_1_1 = new JLabel((String)al.get(7)+" rs");
		lblNewLabel_1_1_1.setBounds(407, 81, 225, 86);
		panel_1.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 24));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(DashBoard.class.getResource("/com/tradex/images/131378-grey-and-white-polygon-pattern-background.jpg")));
		lblNewLabel_5.setBounds(201, 118, 800, 621);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
