import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con;
	ResultSet rs;
	PreparedStatement st;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					Statistics frame = new Statistics();
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

	public void issueBook() {
		try {
			con = ConnectDb.getCon();
			String sql = "select * from issueBook";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void returnBook() {
		try {
			con = ConnectDb.getCon();
			String sql = "select * from returnBook";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Statistics() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 51, 708, 217);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(224, 255, 255));
		table.setForeground(new Color(128, 128, 0));
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setForeground(new Color(0, 128, 128));
		panel.setBounds(26, 36, 737, 240);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		lblNewLabel.setForeground(new Color(204, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		lblNewLabel.setBounds(661, 13, 96, 27);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 316, 717, 217);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setBackground(new Color(204, 255, 255));
		table_1.setForeground(new Color(153, 51, 0));
		table_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2, true), "Return-Book-Details",
				TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 102, 51)));
		panel_1.setBounds(22, 299, 741, 240);
		contentPane.add(panel_1);

		issueBook();
		returnBook();
	}
}
