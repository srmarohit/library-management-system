import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					Home frame = new Home();
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
	public Home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 668);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 7, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
		menuBar.setBackground(Color.GRAY);
		menuBar.setMaximumSize(new Dimension(300, 3));
		menuBar.setMinimumSize(new Dimension(100, 3));
		menuBar.setBounds(10, 11, 650, 25);
		contentPane.add(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setForeground(Color.DARK_GRAY);
		mnFile.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		mnFile.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-389-exit.png"));
		menuBar.add(mnFile);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setBackground(new Color(211, 211, 211));
		mntmLogout.setForeground(new Color(105, 105, 105));
		mntmLogout.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login_user lu = new Login_user();
				lu.setVisible(true);
			}
		});
		mnFile.add(mntmLogout);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setForeground(new Color(105, 105, 105));
		mntmExit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		mntmExit.setBackground(new Color(211, 211, 211));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(ABORT);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.DARK_GRAY);
		mnHelp.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-52-pocket.png"));
		mnHelp.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		mnHelp.setSelectedIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-52-pocket.png"));
		menuBar.add(mnHelp);

		JMenuItem mntmReadme = new JMenuItem("ReadMe");
		mntmReadme.setBackground(new Color(211, 211, 211));
		mntmReadme.setForeground(new Color(105, 105, 105));
		mntmReadme.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		mnHelp.add(mntmReadme);

		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mntmAboutUs.setForeground(new Color(105, 105, 105));
		mntmAboutUs.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		mntmAboutUs.setBackground(new Color(211, 211, 211));
		mntmAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				aboutUs au = new aboutUs();
				au.setVisible(true);
			}
		});
		mnHelp.add(mntmAboutUs);

		JMenu mnRecord = new JMenu("Record");
		mnRecord.setFont(new Font("Georgia", Font.BOLD, 16));
		mnRecord.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-65-stackoverflow.png"));
		menuBar.add(mnRecord);

		JMenuItem bookdetails = new JMenuItem("Book_Details");
		bookdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				BookDetails bd = new BookDetails();
				bd.setVisible(true);
			}
		});
		bookdetails.setBackground(new Color(211, 211, 211));
		bookdetails.setForeground(Color.DARK_GRAY);
		bookdetails.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		mnRecord.add(bookdetails);

		JMenuItem studentdetails = new JMenuItem("Student_Details");
		studentdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentDetails sd = new StudentDetails();
				sd.setVisible(true);
			}
		});
		studentdetails.setBackground(new Color(211, 211, 211));
		studentdetails.setForeground(Color.DARK_GRAY);
		studentdetails.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		mnRecord.add(studentdetails);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\band.jpg"));
		lblNewLabel_1.setBounds(673, 0, 92, 75);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setForeground(new Color(204, 51, 102));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel.setBounds(268, 30, 401, 61);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\AddBook.png"));
		lblNewLabel_2.setBounds(60, 98, 159, 152);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\statistics.png"));
		lblNewLabel_3.setBounds(300, 102, 134, 128);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\AddStudent.jpg"));
		lblNewLabel_4.setBounds(506, 97, 225, 152);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AddBook ab = new AddBook();
				ab.setVisible(true);
			}
		});
		btnNewButton.setIcon(
				new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-89-address-book.png"));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setBounds(60, 271, 159, 44);
		contentPane.add(btnNewButton);

		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Statistics st = new Statistics();
				st.setVisible(true);
			}
		});
		btnStatistics
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-42-charts.png"));
		btnStatistics.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatistics.setForeground(new Color(139, 0, 0));
		btnStatistics.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnStatistics.setBounds(313, 271, 139, 44);
		contentPane.add(btnStatistics);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddStudent as = new AddStudent();
				as.setVisible(true);
			}
		});
		btnAddStudent
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-25-parents.png"));
		btnAddStudent.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddStudent.setForeground(new Color(139, 0, 0));
		btnAddStudent.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnAddStudent.setBounds(562, 271, 167, 44);
		contentPane.add(btnAddStudent);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Operation", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel.setBounds(26, 76, 739, 254);
		contentPane.add(panel);

		JButton btnNewButton_1 = new JButton("Issue Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				IssueBook ib = new IssueBook();
				ib.setVisible(true);
			}
		});
		btnNewButton_1
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-209-cart-in.png"));
		btnNewButton_1.setForeground(new Color(128, 0, 128));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_1.setBounds(76, 564, 143, 41);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Return Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ReturnBook rb = new ReturnBook();
				rb.setVisible(true);
			}
		});
		btnNewButton_2
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-389-exit.png"));
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_2.setBounds(332, 564, 159, 41);
		contentPane.add(btnNewButton_2);

		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				aboutUs au = new aboutUs();
				au.setVisible(true);
			}
		});
		btnAboutUs.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-38-rss.png"));
		btnAboutUs.setForeground(new Color(34, 139, 34));
		btnAboutUs.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAboutUs.setBounds(562, 564, 159, 41);
		contentPane.add(btnAboutUs);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\issue.jpg"));
		lblNewLabel_5.setBounds(60, 379, 159, 163);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\return.jpg"));
		lblNewLabel_6.setBounds(332, 390, 139, 152);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\about.jpg"));
		lblNewLabel_7.setBounds(562, 390, 157, 152);
		contentPane.add(lblNewLabel_7);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(205, 133, 63), 2), "Action", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(233, 150, 122)));
		panel_1.setBounds(28, 358, 737, 260);
		contentPane.add(panel_1);
	}
}
