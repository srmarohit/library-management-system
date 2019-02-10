import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login_user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					Login_user frame = new Login_user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_user() {
		setBackground(new Color(169, 169, 169));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(124, 89, 95, 24);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(124, 124, 95, 24);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setForeground(new Color(0, 100, 0));
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setBounds(210, 93, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordField.setBounds(210, 128, 157, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-204-lock.png"));
		lblNewLabel_1.setBounds(377, 79, 46, 34);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-45-keys.png"));
		lblNewLabel_2.setBounds(377, 124, 46, 34);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setBorder(new LineBorder(new Color(173, 255, 47), 1, true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean status = false;
				try {
					Connection con = ConnectDb.getCon();
					String sql = "select * from account where username=? and password=?";
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, textField.getText());
					st.setString(2, passwordField.getText());

					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Successfuly Log in..");
						setVisible(false);
						Loading ld = new Loading();
						ld.setUploading();
						ld.setVisible(true);
					} else
						JOptionPane.showMessageDialog(null, "Invalid Login...!.");

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(46, 139, 87));
		btnNewButton.setBackground(new Color(250, 250, 210));
		btnNewButton.setIcon(
				new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-211-arrow-left.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(149, 181, 113, 39);
		contentPane.add(btnNewButton);
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setBorder(new LineBorder(new Color(189, 183, 107), 1, true));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SignUp su = new SignUp();
				su.setVisible(true);
			}
		});
		btnSignup.setForeground(new Color(139, 69, 19));
		btnSignup.setBackground(new Color(255, 235, 205));
		btnSignup.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-25-parents.png"));
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignup.setBounds(289, 181, 113, 39);
		contentPane.add(btnSignup);

		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBorder(new LineBorder(new Color(238, 232, 170), 1, true));
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Forgot forgot = new Forgot();
				forgot.setVisible(true);
			}
		});
		btnForgotPassword.setForeground(new Color(205, 92, 92));
		btnForgotPassword.setBackground(new Color(253, 245, 230));
		btnForgotPassword
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-138-cogwheels.png"));
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnForgotPassword.setBounds(199, 231, 179, 39);
		contentPane.add(btnForgotPassword);

		JLabel lblNewLabel_3 = new JLabel("Trouble in LogIn.....");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(75, 264, 113, 20);
		contentPane.add(lblNewLabel_3);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 2, true), "LogIn-Panel",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(46, 139, 87)));
		panel.setBounds(24, 40, 434, 263);
		contentPane.add(panel);
	}
}
