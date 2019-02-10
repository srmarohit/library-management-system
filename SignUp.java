import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(99, 86, 92, 26);
		contentPane.add(lblUsername);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(99, 123, 92, 26);
		contentPane.add(lblName);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(99, 160, 92, 26);
		contentPane.add(lblPassword);

		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setForeground(Color.DARK_GRAY);
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(99, 234, 92, 26);
		contentPane.add(lblAnswer);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
				"Your child SuperHero?", "Your childhood Name ?" }));
		comboBox.setBounds(265, 202, 148, 20);
		contentPane.add(comboBox);

		JLabel lblSecurityQuestion = new JLabel("Security Question :");
		lblSecurityQuestion.setForeground(Color.DARK_GRAY);
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecurityQuestion.setBounds(99, 197, 140, 26);
		contentPane.add(lblSecurityQuestion);

		textField = new JTextField();
		textField.setBounds(265, 91, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(265, 128, 148, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(265, 165, 148, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(265, 239, 148, 20);
		contentPane.add(textField_3);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(138, 43, 226));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectDb.getCon();
					String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, textField.getText());
					st.setString(2, textField_1.getText());
					st.setString(3, textField_2.getText());
					st.setString(4, (String) comboBox.getSelectedItem());
					st.setString(5, textField_3.getText());

					int i = st.executeUpdate();
					if (i > 0)
						JOptionPane.showMessageDialog(null, "successfully Created");

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-7-user-add.png"));
		btnNewButton.setBounds(159, 289, 120, 33);
		contentPane.add(btnNewButton);

		JButton btnGetPassword = new JButton("Back");
		btnGetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login_user lu = new Login_user();
				lu.setVisible(true);
			}
		});
		btnGetPassword.setBackground(new Color(139, 0, 0));
		btnGetPassword.setForeground(new Color(139, 0, 0));
		btnGetPassword
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		btnGetPassword.setHorizontalAlignment(SwingConstants.LEFT);
		btnGetPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGetPassword.setBounds(319, 289, 103, 33);
		contentPane.add(btnGetPassword);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(34, 139, 34));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
		panel.setBounds(31, 46, 476, 296);
		contentPane.add(panel);
	}
}
