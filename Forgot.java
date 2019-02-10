import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Forgot extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

					Forgot frame = new Forgot();
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
	public Forgot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(109, 83, 87, 29);
		contentPane.add(lblUsername);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(109, 122, 75, 21);
		contentPane.add(lblName);

		JLabel lblYourSecurityQuestion = new JLabel("Your Security Question");
		lblYourSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourSecurityQuestion.setBounds(109, 154, 156, 27);
		contentPane.add(lblYourSecurityQuestion);

		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnswer.setBounds(109, 192, 104, 21);
		contentPane.add(lblAnswer);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(109, 224, 104, 21);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setForeground(new Color(105, 105, 105));
		textField.setBounds(277, 88, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setForeground(new Color(165, 42, 42));
		textField_1.setColumns(10);
		textField_1.setBounds(277, 123, 139, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setForeground(new Color(72, 61, 139));
		textField_2.setColumns(10);
		textField_2.setBounds(277, 161, 221, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_3.setForeground(new Color(205, 92, 92));
		textField_3.setColumns(10);
		textField_3.setBounds(277, 193, 139, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_4.setForeground(new Color(50, 205, 50));
		textField_4.setColumns(10);
		textField_4.setBounds(277, 225, 139, 20);
		contentPane.add(textField_4);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConnectDb.getCon();
					String sql = "select * from account where username=?";
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, textField.getText());
					ResultSet rs = st.executeQuery();

					while (rs.next()) {
						textField_1.setText(rs.getString("name"));
						textField_2.setText(rs.getString("sec_q"));
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-28-search.png"));
		btnNewButton.setForeground(new Color(128, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(428, 83, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConnectDb.getCon();
					String sql = "select * from account where sec_ans=?";
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, textField_3.getText());
					ResultSet rs = st.executeQuery();

					while (rs.next()) {
						textField_4.setText(rs.getString("password"));
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnRetrieve.setHorizontalAlignment(SwingConstants.LEFT);
		btnRetrieve
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-201-download.png"));
		btnRetrieve.setForeground(new Color(107, 142, 35));
		btnRetrieve.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRetrieve.setBounds(426, 188, 119, 29);
		contentPane.add(btnRetrieve);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login_user lu = new Login_user();
				lu.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setForeground(new Color(184, 134, 11));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(233, 270, 101, 29);
		contentPane.add(btnBack);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(139, 69, 19), 2), "Forgot-Panel",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
		panel.setBounds(47, 45, 508, 281);
		contentPane.add(panel);
	}

}
