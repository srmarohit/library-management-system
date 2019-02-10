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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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

					ReturnBook frame = new ReturnBook();
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
	public void delete() {
		con = ConnectDb.getCon();
		try {
			String sql = "delete from issueBook where book_id=?";
			st = con.prepareStatement(sql);
			st.setString(1, textField.getText());
			int i = st.executeUpdate();
			if (i > 0)
				JOptionPane.showConfirmDialog(null, "Book Returned");
			else
				JOptionPane.showMessageDialog(null, "error in Deleting");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}

	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Book_id");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(52, 52, 87, 24);
		contentPane.add(lblNewLabel);

		JLabel lblStudentid = new JLabel("Student_id");
		lblStudentid.setForeground(Color.BLACK);
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentid.setBounds(243, 52, 87, 24);
		contentPane.add(lblStudentid);

		JLabel lblBook = new JLabel("Book");
		lblBook.setForeground(Color.BLACK);
		lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBook.setBounds(52, 98, 71, 24);
		contentPane.add(lblBook);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(300, 98, 71, 24);
		contentPane.add(lblName);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(52, 143, 87, 24);
		contentPane.add(lblCourse);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(Color.BLACK);
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBranch.setBounds(303, 144, 68, 24);
		contentPane.add(lblBranch);

		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setForeground(Color.BLACK);
		lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfIssue.setBounds(52, 188, 105, 29);
		contentPane.add(lblDateOfIssue);

		JLabel lblDateOfReturn = new JLabel("Date of Return");
		lblDateOfReturn.setForeground(Color.BLACK);
		lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfReturn.setBounds(52, 234, 118, 29);
		contentPane.add(lblDateOfReturn);

		textField = new JTextField();
		textField.setForeground(new Color(105, 105, 105));
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setBounds(128, 56, 105, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(105, 105, 105));
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_1.setBounds(340, 56, 93, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con = ConnectDb.getCon();
					String sql = "select * from issueBook where student_id = ? and book_id =?";
					st = con.prepareStatement(sql);
					st.setString(1, textField_1.getText());
					st.setString(2, textField.getText());
					rs = st.executeQuery();
					while (rs.next()) {
						textField_2.setText(rs.getString("bname"));
						textField_3.setText(rs.getString("sname"));
						textField_4.setText(rs.getString("course"));
						textField_5.setText(rs.getString("branch"));
						textField_6.setText(rs.getString("dateOfIssue"));
					}
					st.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-28-search.png"));
		btnNewButton.setBounds(443, 52, 105, 29);
		contentPane.add(btnNewButton);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setForeground(new Color(0, 100, 0));
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_2.setBounds(128, 102, 162, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setForeground(new Color(0, 100, 0));
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(369, 102, 179, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setForeground(new Color(0, 100, 0));
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(128, 147, 162, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 100, 0));
		textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(369, 147, 179, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 100, 0));
		textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(167, 194, 162, 20);
		contentPane.add(textField_6);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton()
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-46-calendar.png"));
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		dateChooser.setBounds(167, 234, 172, 29);
		contentPane.add(dateChooser);

		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con = ConnectDb.getCon();
					String sql = "insert into returnBook(book_id, student_id, bname, sname,course, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
					st = con.prepareStatement(sql);
					st.setString(1, textField.getText());
					st.setString(2, textField_1.getText());
					st.setString(3, textField_2.getText());
					st.setString(4, textField_3.getText());
					st.setString(5, textField_4.getText());
					st.setString(6, textField_5.getText());
					st.setString(7, textField_6.getText());

					st.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
					int i = st.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Processing..");
						delete();
					} else
						JOptionPane.showMessageDialog(null, "error");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});
		btnNewButton_1
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-389-exit.png"));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(47, 79, 79));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnNewButton_1.setBounds(369, 179, 149, 35);
		contentPane.add(btnNewButton_1);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		btnBack.setForeground(new Color(165, 42, 42));
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnBack.setBounds(369, 231, 149, 35);
		contentPane.add(btnBack);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 69, 0), 2, true), "Return-Panel",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel.setBounds(10, 24, 569, 269);
		contentPane.add(panel);
	}
}
