package com.tradex.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

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



public class LoginPage {
	JFrame LoginPage;
	private JTextField phoneNo;
	private JTextField email;
	private JPasswordField pass1;
	private JLabel phoneNoRequired;
	private JLabel emailRequired;
	private JLabel pass1Required;
	private static ArrayList al;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_7;
	private JLabel close_lbl;
	private static LoginPage window;
	private JLabel lblNewLabel_7;
	private JLabel mvd;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoginPage();
					window.LoginPage.setUndecorated(true);
					window.LoginPage.setLocationRelativeTo(null);
					window.LoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		LoginPage = new JFrame();
		LoginPage.getContentPane().setBackground(Color.WHITE);
		LoginPage.setBounds(100, 100, 1000, 735);
		LoginPage.getContentPane().setLayout(null);
		ArrayList al = new ArrayList(7);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(153, 0, 255),
				new Color(153, 0, 255), new Color(204, 0, 204)));
		panel.setBounds(98, 200, 797, 419);
		LoginPage.getContentPane().add(panel);
		panel.setOpaque(true);
		panel.setLayout(null);

		separator_1 = new JSeparator();
		separator_1.setBounds(440, 168, 326, 2);
		panel.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBounds(440, 242, 326, 2);
		panel.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(440, 313, 326, 2);
		panel.add(separator_3);

		phoneNoRequired = new JLabel("* Required");
		phoneNoRequired.setBounds(705, 143, 61, 24);
		panel.add(phoneNoRequired);
		phoneNoRequired.setForeground(Color.RED);
		phoneNoRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));

		emailRequired = new JLabel("* Required");
		emailRequired.setBounds(705, 217, 61, 24);
		panel.add(emailRequired);
		emailRequired.setForeground(Color.RED);
		emailRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));

		pass1Required = new JLabel("* Required");
		pass1Required.setBounds(705, 291, 61, 24);
		panel.add(pass1Required);
		pass1Required.setForeground(Color.RED);
		pass1Required.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));

		JLabel invalidPassword = new JLabel("* Password does not match");
		invalidPassword.setBounds(619, 255, 147, 20);
		panel.add(invalidPassword);
		invalidPassword.setForeground(Color.RED);
		invalidPassword.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));

		JLabel invalidEmail = new JLabel("* Invalid Email Id");
		invalidEmail.setBounds(674, 187, 92, 20);
		panel.add(invalidEmail);
		invalidEmail.setForeground(Color.RED);
		invalidEmail.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));

		JLabel invalidPhoneNo = new JLabel("* Invalid Phone Number");
		invalidPhoneNo.setBounds(641, 113, 125, 20);
		panel.add(invalidPhoneNo);
		invalidPhoneNo.setForeground(Color.RED);
		invalidPhoneNo.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		invalidPhoneNo.setVisible(false);
		invalidEmail.setVisible(false);
		invalidPassword.setVisible(false);
		pass1Required.setVisible(false);
		emailRequired.setVisible(false);
		phoneNoRequired.setVisible(false);

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
		LoginPage.getContentPane().add(close_lbl);

		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(
				"C:\\Users\\Prathamesh\\Downloads\\Bitcoin-is-not-a-currency-for-a-government-it-is-a-global-currency-for-the-people.jpg"));
		lblNewLabel_7.setBounds(10, 10, 393, 400);
		panel.add(lblNewLabel_7);

		pass1 = new JPasswordField();
		pass1.setBounds(440, 278, 235, 37);
		panel.add(pass1);
		pass1.setOpaque(false);
		pass1.setBorder(null);

		lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_1.setBounds(440, 249, 117, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));

		email = new JTextField();
		email.setBounds(440, 205, 235, 37);
		panel.add(email);
		email.setColumns(10);
		email.setOpaque(false);
		email.setBorder(null);

		lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2.setBounds(440, 178, 77, 29);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));

		phoneNo = new JTextField();
		phoneNo.setBounds(440, 131, 235, 37);
		panel.add(phoneNo);
		phoneNo.setOpaque(false);
		phoneNo.setBorder(null);
		phoneNo.setColumns(10);

		lblNewLabel_2_2 = new JLabel("Mobile No. :");
		lblNewLabel_2_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_2.setBounds(440, 104, 77, 29);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));

		mvd = new JLabel("");
		mvd.setHorizontalAlignment(SwingConstants.CENTER);
		mvd.setIcon(new ImageIcon(SignUpPage.class.getResource(
				"/com/tradex/images/Choose_a_package___Logo_Maker___Designhill_-_Brave_28-09-2022_19_36_24-removebg-preview.png")));
		mvd.setBounds(0, 20, 458, 97);
		LoginPage.getContentPane().add(mvd);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SignUpPage.class.getResource("/com/tradex/images/dark-mode-18.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1017, 118);
		LoginPage.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(204, 0, 204));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(417, 126, 160, 63);
		LoginPage.getContentPane().add(lblNewLabel);

		separator_7 = new JSeparator();
		separator_7.setBounds(417, 185, 160, 2);
		LoginPage.getContentPane().add(separator_7);
		separator_7.setForeground(new Color(204, 0, 204));

		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setBounds(417, 180, 160, 2);
		LoginPage.getContentPane().add(separator_7_1);
		separator_7_1.setForeground(new Color(204, 0, 204));

		JLabel forgotPassword = new JLabel("Forgot Password");
		forgotPassword.setHorizontalAlignment(SwingConstants.CENTER);

		forgotPassword.setForeground(new Color(204, 0, 204));
		forgotPassword.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		forgotPassword.setBounds(433, 675, 142, 31);
		LoginPage.getContentPane().add(forgotPassword);

		JLabel lblCreateAccount = new JLabel("Create  Account");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpPage sp = new SignUpPage();

				LoginPage lp = new LoginPage();
				window.LoginPage.dispose();
				sp.main(null);
			}
		});
		lblCreateAccount.setForeground(new Color(204, 0, 204));
		lblCreateAccount.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblCreateAccount.setBounds(433, 702, 142, 31);
		LoginPage.getContentPane().add(lblCreateAccount);
		AccessToData out = new AccessToData();
		JButton btnNewButton = new JButton("Next");

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				try {
					Boolean b1, b2;
					b2 = true;
					String emailstr = "hi";

					b1 = Pattern.compile("^[6-9]{1}[0-9]{9}$").matcher(phoneNo.getText()).matches();
					if (phoneNo.getText().trim().isEmpty() == true) {
						phoneNoRequired.setVisible(true);
						invalidPhoneNo.setVisible(false);
						b2 = false;
					} else if (b1 == false) {
						invalidPhoneNo.setVisible(true);
						phoneNoRequired.setVisible(false);
						b2 = false;
					} else {
						phoneNoRequired.setVisible(false);
						invalidPhoneNo.setVisible(false);

					}
					b1 = Pattern.compile("[a-zA-Z0-9]{3,20}@[A-Za-z]{3,10}.(com|in)").matcher(email.getText())
							.matches();
					if (email.getText().trim().isEmpty() == true) {
						emailRequired.setVisible(true);
						invalidEmail.setVisible(false);
						b2 = false;
					} else if (b1 == false) {

						invalidEmail.setVisible(true);
						emailRequired.setVisible(false);
						b2 = false;
					} else {
						emailRequired.setVisible(false);
						invalidEmail.setVisible(false);
						emailstr = email.getText();
					}
					String password1, password2;

					password1 = new String(pass1.getPassword());

					if (password1.trim().isEmpty() == true) {
						pass1Required.setVisible(true);
						b2 = false;
					} else {
						pass1Required.setVisible(false);
					}

					ArrayList arl = new ArrayList();

					arl = out.validateUser(emailstr);
					
					if((Boolean)arl.get(0)==true)
					{
						password2 = (String)arl.get(5);
						if(((Boolean)arl.get(0)==true)&&!(password2.equals(password1)))
						{
							
							invalidPassword.setVisible(true);
						}
						else if(((Boolean)arl.get(0)==true)&&(password2.equals(password1)))
						{
							
							JOptionPane.showMessageDialog(null, "Login successfull!!!");
							DashBoard d = new DashBoard(arl);
							window.LoginPage.dispose();
							
							
							d.build(arl);
						}
						
					}
					else if((Boolean)arl.get(0)==false)
					{
						JOptionPane.showMessageDialog(null, "First Sign Up");
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(204, 0, 204));
		btnNewButton.setBounds(433, 640, 142, 31);
		LoginPage.getContentPane().add(btnNewButton);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(
				"C:\\Users\\Prathamesh\\Downloads\\131378-grey-and-white-polygon-pattern-background.jpg"));
		lblNewLabel_5.setBounds(0, 118, 1000, 618);
		LoginPage.getContentPane().add(lblNewLabel_5);

	}

}
