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
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection con;
	PreparedStatement st;
	ResultSet rs;
	private JComboBox comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					AddStudent frame = new AddStudent();
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
	public void random() {
		Random rd = new Random();
		textField.setText("" + rd.nextInt(10000 + 1));
	}

	public AddStudent() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Student_id");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(64, 63, 102, 22);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(25, 25, 112));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(64, 97, 102, 22);
		contentPane.add(lblName);

		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(new Color(25, 25, 112));
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFathersName.setBounds(64, 130, 102, 22);
		contentPane.add(lblFathersName);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(new Color(25, 25, 112));
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBranch.setBounds(64, 209, 102, 22);
		contentPane.add(lblBranch);

		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(25, 25, 112));
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(64, 242, 102, 22);
		contentPane.add(lblYear);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(new Color(25, 25, 112));
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSemester.setBounds(64, 275, 102, 22);
		contentPane.add(lblSemester);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(new Color(47, 79, 79));
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setBounds(174, 66, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(47, 79, 79));
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(174, 100, 156, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(new Color(47, 79, 79));
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(174, 133, 156, 20);
		contentPane.add(textField_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "ETC", "Mechanical", "CSE", "IT", "Civil", "Automobile", "EEE", "Other" }));
		comboBox.setForeground(new Color(47, 79, 79));
		comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox.setBounds(176, 211, 154, 20);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third", "Four" }));
		comboBox_1.setForeground(new Color(47, 79, 79));
		comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox_1.setBounds(176, 244, 154, 20);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(
				new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
		comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox_2.setForeground(new Color(47, 79, 79));
		comboBox_2.setBounds(176, 277, 154, 20);
		contentPane.add(comboBox_2);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBorder(new LineBorder(new Color(255, 182, 193), 1, true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = ConnectDb.getCon();
					String sql = "insert into student(student_id, name, father, course, branch, year, semester) values(?, ?, ?, ?, ?, ?, ?)";
					st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					st.setString(2, textField_1.getText());
					st.setString(3, textField_2.getText());
					st.setString(4, (String) comboBox_3.getSelectedItem());
					st.setString(5, (String) comboBox.getSelectedItem());
					st.setString(6, (String) comboBox_1.getSelectedItem());
					st.setString(7, (String) comboBox_2.getSelectedItem());

					int i = st.executeUpdate();
					if (i > 0)
						JOptionPane.showMessageDialog(null, "Successfully Added");
					else
						JOptionPane.showMessageDialog(null, "error");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-7-user-add.png"));
		btnNewButton.setForeground(new Color(32, 178, 170));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBounds(64, 321, 111, 33);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("Back");
		btnBack.setBorder(new LineBorder(new Color(189, 183, 107), 1, true));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		btnBack.setForeground(new Color(165, 42, 42));
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnBack.setBounds(198, 321, 111, 33);
		contentPane.add(btnBack);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setForeground(new Color(25, 25, 112));
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(64, 173, 102, 22);
		contentPane.add(lblCourse);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(
				new String[] { "B.E", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com" }));
		comboBox_3.setForeground(new Color(47, 79, 79));
		comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox_3.setBounds(176, 176, 154, 20);
		contentPane.add(comboBox_3);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 2, true), "Add-Student",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(10, 38, 358, 348);
		contentPane.add(panel);
		random();
	}
}
