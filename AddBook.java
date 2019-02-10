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
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	Connection con = null;
	PreparedStatement st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					AddBook frame = new AddBook();
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
		textField.setText("" + rd.nextInt(1000 + 1));
	}

	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(73, 84, 90, 22);
		contentPane.add(lblNewLabel);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(new Color(47, 79, 79));
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIsbn.setBounds(73, 117, 90, 22);
		contentPane.add(lblIsbn);

		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setForeground(new Color(47, 79, 79));
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPublisher.setBounds(73, 150, 90, 22);
		contentPane.add(lblPublisher);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(47, 79, 79));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(73, 216, 90, 22);
		contentPane.add(lblPrice);

		JLabel lblPages = new JLabel("Pages");
		lblPages.setForeground(new Color(47, 79, 79));
		lblPages.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPages.setBounds(73, 249, 90, 22);
		contentPane.add(lblPages);

		JLabel label_4 = new JLabel("Book_id");
		label_4.setForeground(new Color(47, 79, 79));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(73, 51, 90, 22);
		contentPane.add(label_4);

		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setForeground(new Color(47, 79, 79));
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdition.setBounds(73, 183, 90, 22);
		contentPane.add(lblEdition);

		textField = new JTextField();
		textField.setForeground(new Color(47, 79, 79));
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setBounds(169, 54, 198, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(47, 79, 79));
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(169, 87, 198, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(new Color(47, 79, 79));
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(169, 120, 198, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setForeground(new Color(47, 79, 79));
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(169, 153, 198, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setForeground(new Color(47, 79, 79));
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(169, 219, 198, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setForeground(new Color(47, 79, 79));
		textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(169, 252, 198, 20);
		contentPane.add(textField_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
		comboBox.setBounds(173, 186, 194, 20);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = ConnectDb.getCon();
					String sql = "insert into book(book_id, name, isbn, publisher, edition, price, pages) values(?, ?, ?, ?, ?, ?, ?)";
					st = con.prepareStatement(sql);

					// st.setInt(1, Integer.parseInt(textField.getText()));
					st.setString(1, textField.getText());
					st.setString(2, textField_1.getText());
					st.setString(3, textField_2.getText());
					st.setString(4, textField_3.getText());
					st.setString(5, (String) comboBox.getSelectedItem());
					st.setString(6, textField_4.getText());
					st.setString(7, textField_5.getText());

					int rs = st.executeUpdate();
					if (rs > 0)
						JOptionPane.showMessageDialog(null, "Successfully Added");
					else
						JOptionPane.showMessageDialog(null, "Error");
					st.close();
				} catch (Exception e2) {
					// TODO: handle exception
					// e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getMessage());

				}

			}
		});
		btnNewButton.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-320-sort.png"));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton.setBounds(102, 300, 100, 33);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnBack.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
		btnBack.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\glyphicons-222-unshare.png"));
		btnBack.setForeground(new Color(160, 82, 45));
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(212, 300, 108, 33);
		contentPane.add(btnBack);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 29, 398, 344);
		contentPane.add(panel);
		random();

	}
}
