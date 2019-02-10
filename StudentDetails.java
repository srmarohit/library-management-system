import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con = null;
	ResultSet rs;
	PreparedStatement st;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					StudentDetails frame = new StudentDetails();
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
	public void student() {
		try {
			con = ConnectDb.getCon();
			String sql = "select * from student";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public StudentDetails() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 133, 771, 288);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				search.setText(table.getModel().getValueAt(row, 1).toString());
			}
		});
		table.setBackground(new Color(240, 248, 255));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con = ConnectDb.getCon();
					String sql = "select * from student where concat(name, student_id) like ?";
					st = con.prepareStatement(sql);
					st.setString(1, "%" + search.getText() + "%");
					rs = st.executeQuery();

					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					st.close();
					con.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-28-search.png"));
		btnNewButton.setForeground(new Color(199, 21, 133));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setBounds(564, 89, 138, 33);
		contentPane.add(btnNewButton);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con = ConnectDb.getCon();
					String sql = "delete from student where name = '" + search.getText() + "'";
					st = con.prepareStatement(sql);

					JDialog.setDefaultLookAndFeelDecorated(true);
					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.NO_OPTION) {

					} else if (response == JOptionPane.YES_OPTION) {
						int rs = st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Deleted !!");
					} else if (response == JOptionPane.CLOSED_OPTION) {
					}
					st.close();
					con.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-17-bin.png"));
		btnDelete.setForeground(new Color(199, 21, 133));
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnDelete.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		btnDelete.setBounds(712, 89, 138, 33);
		contentPane.add(btnDelete);

		JLabel lblNewLabel = new JLabel("Library");
		lblNewLabel.setForeground(new Color(102, 205, 170));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(267, 21, 92, 47);
		contentPane.add(lblNewLabel);

		JLabel lblManagement = new JLabel("Management");
		lblManagement.setForeground(new Color(127, 255, 212));
		lblManagement.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
		lblManagement.setBounds(382, 21, 164, 47);
		contentPane.add(lblManagement);

		JLabel lblSystem = new JLabel("System");
		lblSystem.setForeground(new Color(107, 142, 35));
		lblSystem.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
		lblSystem.setBounds(564, 21, 92, 47);
		contentPane.add(lblSystem);

		search = new JTextField();
		search.setBackground(new Color(255, 240, 245));
		search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
		search.setForeground(new Color(47, 79, 79));
		search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		search.setBounds(189, 89, 357, 33);
		contentPane.add(search);
		search.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Back");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_2
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		lblNewLabel_2.setBounds(97, 89, 72, 33);
		contentPane.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Student-Deatails",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
		panel.setBounds(68, 59, 790, 376);
		contentPane.add(panel);

		student();
	}
}
