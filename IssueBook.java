import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	Connection con;
	ResultSet rs;
	PreparedStatement st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Book_id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setBounds(47, 63, 100, 23);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(47, 79, 79));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(47, 97, 100, 23);
		contentPane.add(lblName);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(new Color(47, 79, 79));
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIsbn.setBounds(47, 131, 100, 23);
		contentPane.add(lblIsbn);

		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setForeground(new Color(47, 79, 79));
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPublisher.setBounds(47, 165, 100, 23);
		contentPane.add(lblPublisher);

		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setForeground(new Color(47, 79, 79));
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdition.setBounds(47, 199, 100, 23);
		contentPane.add(lblEdition);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(47, 79, 79));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(47, 233, 100, 23);
		contentPane.add(lblPrice);

		JLabel lblPages = new JLabel("Pages");
		lblPages.setForeground(new Color(47, 79, 79));
		lblPages.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPages.setBounds(47, 267, 100, 23);
		contentPane.add(lblPages);

		textField = new JTextField();
		textField.setForeground(new Color(47, 79, 79));
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setBounds(126, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					con = ConnectDb.getCon();
					String sql = "select * from book where book_id = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					rs = st.executeQuery();
					while (rs.next()) {
						textField_1.setText(rs.getString("name"));
						textField_2.setText(rs.getString("isbn"));
						textField_3.setText(rs.getString("publisher"));
						textField_4.setText(rs.getString("edition"));
						textField_5.setText(rs.getString("price"));
						textField_6.setText(rs.getString("pages"));
					}
					st.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-28-search.png"));
		btnNewButton.setForeground(new Color(85, 107, 47));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBounds(234, 59, 100, 33);
		contentPane.add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(new Color(47, 79, 79));
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_1.setBounds(126, 100, 208, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setForeground(new Color(47, 79, 79));
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(126, 131, 208, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setForeground(new Color(47, 79, 79));
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(126, 168, 208, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setForeground(new Color(47, 79, 79));
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(126, 202, 208, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setForeground(new Color(47, 79, 79));
		textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(126, 236, 208, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setForeground(new Color(47, 79, 79));
		textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(126, 270, 208, 20);
		contentPane.add(textField_6);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
		panel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setBounds(10, 38, 345, 288);
		contentPane.add(panel);

		JLabel lblStudentid = new JLabel("Student_id");
		lblStudentid.setForeground(new Color(47, 79, 79));
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentid.setBounds(384, 63, 100, 23);
		contentPane.add(lblStudentid);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setForeground(new Color(47, 79, 79));
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName_1.setBounds(384, 103, 100, 23);
		contentPane.add(lblName_1);

		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(new Color(47, 79, 79));
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFathersName.setBounds(384, 147, 100, 23);
		contentPane.add(lblFathersName);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setForeground(new Color(47, 79, 79));
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(384, 187, 100, 23);
		contentPane.add(lblCourse);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(new Color(47, 79, 79));
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBranch.setBounds(384, 233, 100, 23);
		contentPane.add(lblBranch);

		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(47, 79, 79));
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(384, 284, 100, 23);
		contentPane.add(lblYear);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(new Color(47, 79, 79));
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSemester.setBounds(384, 336, 100, 23);
		contentPane.add(lblSemester);

		textField_7 = new JTextField();
		textField_7.setForeground(new Color(47, 79, 79));
		textField_7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(508, 66, 86, 20);
		contentPane.add(textField_7);

		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					con = ConnectDb.getCon();
					String sql = "select * from student where student_id = ?";
					st = con.prepareStatement(sql);
					st.setString(1, textField_7.getText());
					rs = st.executeQuery();
					while (rs.next()) {
						textField_8.setText(rs.getString("name"));
						textField_9.setText(rs.getString("father"));
						textField_10.setText(rs.getString("course"));
						textField_11.setText(rs.getString("branch"));
						textField_12.setText(rs.getString("year"));
						textField_13.setText(rs.getString("semester"));
					}
					st.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-28-search.png"));
		button.setForeground(new Color(0, 100, 0));
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		button.setBounds(604, 63, 100, 33);
		contentPane.add(button);

		textField_8 = new JTextField();
		textField_8.setForeground(new Color(47, 79, 79));
		textField_8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(508, 106, 208, 20);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setForeground(new Color(47, 79, 79));
		textField_9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(508, 150, 208, 20);
		contentPane.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setForeground(new Color(47, 79, 79));
		textField_10.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(508, 190, 208, 20);
		contentPane.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setForeground(new Color(47, 79, 79));
		textField_11.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(508, 236, 208, 20);
		contentPane.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setForeground(new Color(47, 79, 79));
		textField_12.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(508, 286, 208, 20);
		contentPane.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setForeground(new Color(47, 79, 79));
		textField_13.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(508, 338, 208, 20);
		contentPane.add(textField_13);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180), 2, true), "Student-Deatails",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
		panel_1.setForeground(new Color(0, 100, 0));
		panel_1.setBounds(360, 38, 378, 372);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1 = new JLabel(" Date of Issue :");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 340, 118, 26);
		contentPane.add(lblNewLabel_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton()
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-46-calendar.png"));
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateChooser.setForeground(new Color(105, 105, 105));
		dateChooser.setBounds(137, 337, 162, 29);
		contentPane.add(dateChooser);

		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = ConnectDb.getCon();
					String sql = "insert into issueBook(book_id, student_id, bname, sname, course, branch, dateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
					st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					st.setString(2, textField_7.getText());
					st.setString(3, textField_1.getText());
					st.setString(4, textField_8.getText());
					st.setString(5, textField_10.getText());
					st.setString(6, textField_11.getText());
					st.setString(7, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
					int i = st.executeUpdate();
					if (i > 0)
						JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
					else
						JOptionPane.showMessageDialog(null, "error");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnIssue.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-260-barcode.png"));
		btnIssue.setForeground(new Color(85, 107, 47));
		btnIssue.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnIssue.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		btnIssue.setBounds(47, 377, 118, 33);
		contentPane.add(btnIssue);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		btnBack.setForeground(new Color(85, 107, 47));
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnBack.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		btnBack.setBounds(199, 377, 100, 33);
		contentPane.add(btnBack);
	}
}
