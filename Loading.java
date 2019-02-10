import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
	int s;
	Thread th;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

					Loading frame = new Loading();
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

	public void setUploading() {
		setVisible(false);
		th.start();
	}

	public void run() {
		try {
			for (int i = 0; i < 200; i++) {
				s = s + 1;
				int m = progressBar.getMaximum();
				int v = progressBar.getValue();
				if (v < m) {
					progressBar.setValue(progressBar.getValue() + 1);
				} else {
					i = 201;
					setVisible(false);
					Home home = new Home();
					home.setVisible(true);
				}
				Thread.sleep(50);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Loading() {
		super("Loading");
		setBackground(new Color(0, 255, 255));
		setResizable(false);
		th = new Thread((Runnable) this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbllibraryManagement = new JLabel("#Smart Library ");
		lbllibraryManagement.setForeground(new Color(72, 209, 204));
		lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		lbllibraryManagement.setBounds(62, 46, 260, 44);
		contentPane.add(lbllibraryManagement);

		JLabel lblNewLabel = new JLabel("2.1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setBounds(319, 52, 46, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("v");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(311, 68, 21, 14);
		contentPane.add(lblNewLabel_1);

		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
		progressBar.setStringPainted(true);
		progressBar.setBounds(103, 135, 205, 19);
		contentPane.add(progressBar);

		JLabel lblNewLabel_2 = new JLabel("Please Wait....");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(160, 82, 45));
		lblNewLabel_2.setBounds(169, 165, 89, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\giphy-downsized.gif"));
		lblNewLabel_3.setBounds(145, 190, 113, 130);
		contentPane.add(lblNewLabel_3);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(127, 255, 212), 2), "Loading..", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(32, 178, 170)));
		panel.setBounds(10, 11, 378, 345);
		contentPane.add(panel);
	}
}
