package com.tradex.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;



public class OtpConfirmation {

	static JFrame frame;
	private JTextField email;
	private JLabel emailRequired;
	private JLabel pass1Required;
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_7;
	private JLabel close_lbl;
	private static OtpConfirmation window;
	private JLabel lblNewLabel_7;
	private JLabel mvd;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField otp;
	private static ArrayList al;
	/**
	 * Launch the application.
	 */
	public void start(ArrayList a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					al = new ArrayList(a);
					OtpConfirmation window = new OtpConfirmation(al);
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
	public OtpConfirmation(ArrayList a) {
		al = new ArrayList(a);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			System.out.println(al);
			
			frame = new JFrame();
			frame.getContentPane().setBackground(Color.WHITE);
			frame.setBounds(100,100,1000,735);
			frame.getContentPane().setLayout(null);
			
			
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(153, 0, 255), new Color(153, 0, 255), new Color(204, 0, 204)));
			panel.setBounds(98, 200, 797, 419);
			frame.getContentPane().add(panel);
			panel.setOpaque(true);
			panel.setLayout(null);
			
			separator_2 = new JSeparator();
			separator_2.setBounds(440, 127, 326, 2);
			panel.add(separator_2);
			
			separator_3 = new JSeparator();
			separator_3.setBounds(440, 200, 326, 2);
			panel.add(separator_3);
			
			emailRequired = new JLabel("* Required");
			emailRequired.setBounds(705, 105, 61, 24);
			panel.add(emailRequired);
			emailRequired.setForeground(Color.RED);
			emailRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
			
			pass1Required = new JLabel("* Required");
			pass1Required.setBounds(705, 142, 61, 24);
			panel.add(pass1Required);
			pass1Required.setForeground(Color.RED);
			pass1Required.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
			
			JLabel invalidOtp = new JLabel("* OTP does not match");
			invalidOtp.setHorizontalAlignment(SwingConstants.CENTER);
			invalidOtp.setBounds(642, 144, 124, 20);
			panel.add(invalidOtp);
			invalidOtp.setForeground(Color.RED);
			invalidOtp.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
			
			JLabel invalidEmail = new JLabel("* Invalid Email Id");
			invalidEmail.setBounds(674, 68, 92, 20);
			panel.add(invalidEmail);
			invalidEmail.setForeground(Color.RED);
			invalidEmail.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
			invalidEmail.setVisible(false);
			invalidOtp.setVisible(false);
			pass1Required.setVisible(false);
			emailRequired.setVisible(false);
			
			close_lbl = new JLabel("X");
			close_lbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			close_lbl.setForeground(Color.RED);
			close_lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
			close_lbl.setBounds(970, 0, 36, 37);
			frame.getContentPane().add(close_lbl);
			
			lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Downloads\\Bitcoin-is-not-a-currency-for-a-government-it-is-a-global-currency-for-the-people.jpg"));
			lblNewLabel_7.setBounds(10, 10, 393, 400);
			panel.add(lblNewLabel_7);
			
			lblNewLabel_1 = new JLabel("Password :");
			lblNewLabel_1.setForeground(new Color(204, 0, 204));
			lblNewLabel_1.setBounds(440, 135, 117, 29);
			panel.add(lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
			
			email = new JTextField((String)al.get(2));
			email.setBounds(440, 92, 235, 37);
			panel.add(email);
			email.setColumns(10);
			email.setOpaque(false);
			email.setBorder(null);
			
			lblNewLabel_2 = new JLabel("Email :");
			lblNewLabel_2.setForeground(new Color(204, 0, 204));
			lblNewLabel_2.setBounds(440, 63, 77, 29);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
			Random rm = new Random();
			int num = rm.nextInt(999999); 
			JLabel lblGetOtp = new JLabel("Get OTP");
			lblGetOtp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(al);
					lblGetOtp.setForeground(Color.gray);
					EmailNotification em = new EmailNotification();
					em.sendOtpTomail(num, (String)al.get(2));

				}
			});
			lblGetOtp.setHorizontalAlignment(SwingConstants.RIGHT);
			lblGetOtp.setForeground(new Color(204, 0, 204));
			lblGetOtp.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
			lblGetOtp.setBounds(705, 171, 61, 31);
			panel.add(lblGetOtp);
			
			otp = new JTextField();
			otp.setOpaque(false);
			otp.setColumns(10);
			otp.setBorder(null);
			otp.setBounds(440, 165, 235, 37);
			panel.add(otp);
			
			
			
			mvd = new JLabel("");
			mvd.setHorizontalAlignment(SwingConstants.CENTER);
			mvd.setIcon(new ImageIcon(SignUpPage.class.getResource("/com/tradex/images/Choose_a_package___Logo_Maker___Designhill_-_Brave_28-09-2022_19_36_24-removebg-preview.png")));
			mvd.setBounds(0, 20, 458, 97);
			frame.getContentPane().add(mvd);
			
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(SignUpPage.class.getResource("/com/tradex/images/dark-mode-18.jpg")));
			lblNewLabel_4.setBounds(0, 0, 1017, 118);
			frame.getContentPane().add(lblNewLabel_4);
			
			JLabel lblNewLabel = new JLabel("Sign Up\r\n");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(204, 0, 204));
			lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 35));
			lblNewLabel.setBounds(433, 127, 127, 63);
			frame.getContentPane().add(lblNewLabel);
			
			separator_7 = new JSeparator();
			separator_7.setBounds(433, 185, 125, 2);
			frame.getContentPane().add(separator_7);
			separator_7.setForeground(new Color(204, 0, 204));
			
			JSeparator separator_7_1 = new JSeparator();
			separator_7_1.setBounds(433, 180, 125, 2);
			frame.getContentPane().add(separator_7_1);
			separator_7_1.setForeground(new Color(204, 0, 204));
			
			JLabel forgotPassword = new JLabel("Forgot Password");
			forgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
			
			forgotPassword.setForeground(new Color(204, 0, 204));
			forgotPassword.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
			forgotPassword.setBounds(433, 675, 142, 31);
			frame.getContentPane().add(forgotPassword);
			
			JLabel lblCreateAccount = new JLabel("Create  Account");
			lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateAccount.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SignUpPage sp = new SignUpPage();
					
					LoginPage lp = new LoginPage();
					window.frame.dispose();
					sp.main(null);
				}
			});
			lblCreateAccount.setForeground(new Color(204, 0, 204));
			lblCreateAccount.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
			lblCreateAccount.setBounds(433, 702, 142, 31);
			frame.getContentPane().add(lblCreateAccount);
			
			JButton btnNewButton = new JButton("Sign Up");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Boolean b1,b2;
					int rowsAffected;
					AccessToData in = new AccessToData();
					if(num==Integer.valueOf(otp.getText()))
					{
						try {
							rowsAffected = in.insertInfo(al);
							if(rowsAffected == 0)
							{
								JOptionPane.showMessageDialog(null,"Registration failed try again");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Account created successfully!!!");
								LoginPage lp = new LoginPage();
								lp.main(null);
								window.frame.dispose();
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						invalidOtp.setVisible(true);
					}
				
				}
			});
			
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
			btnNewButton.setBackground(new Color(204, 0, 204));
			btnNewButton.setBounds(433, 640, 142, 31);
			frame.getContentPane().add(btnNewButton);
			
		
			
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Downloads\\131378-grey-and-white-polygon-pattern-background.jpg"));
			lblNewLabel_5.setBounds(0, 118, 1000, 618);
			frame.getContentPane().add(lblNewLabel_5);
			
			
		}
}
