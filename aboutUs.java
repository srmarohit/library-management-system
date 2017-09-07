import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class aboutUs extends JFrame {

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

					aboutUs frame = new aboutUs();
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

	public aboutUs() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ram\\Desktop\\rohit.jpg"));
		setBackground(new Color(173, 216, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBorder(new LineBorder(new Color(127, 255, 0), 3, true));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\Capture1.PNG"));
		lblNewLabel.setBounds(300, 112, 247, 294);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		JToggleButton tglbtnDeveloper = new JToggleButton("Developer");
		tglbtnDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setVisible(!lblNewLabel.isVisible());
			}
		});

		tglbtnDeveloper.setBorder(new LineBorder(new Color(47, 79, 79), 2, true));
		tglbtnDeveloper.setBackground(new Color(211, 211, 211));
		tglbtnDeveloper.setForeground(new Color(160, 82, 45));
		tglbtnDeveloper.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tglbtnDeveloper.setBounds(386, 67, 133, 34);
		contentPane.add(tglbtnDeveloper);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\AddBook.png"));
		lblNewLabel_1.setBounds(369, 112, 150, 188);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Library");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setForeground(new Color(0, 250, 154));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_2.setBounds(119, 44, 150, 55);
		contentPane.add(lblNewLabel_2);

		JLabel lblMangement = new JLabel("Mangement");
		lblMangement.setVerticalAlignment(SwingConstants.TOP);
		lblMangement.setForeground(new Color(127, 255, 0));
		lblMangement.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
		lblMangement.setBounds(33, 91, 205, 40);
		contentPane.add(lblMangement);

		JLabel lblSystem = new JLabel("System");
		lblSystem.setVerticalAlignment(SwingConstants.TOP);
		lblSystem.setForeground(new Color(154, 205, 50));
		lblSystem.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
		lblSystem.setBounds(226, 91, 150, 40);
		contentPane.add(lblSystem);

		JLabel lblNewLabel_3 = new JLabel("v");
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel_3.setBounds(129, 131, 25, 21);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("2.1");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(new Color(0, 206, 209));
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
		lblNewLabel_4.setBounds(150, 118, 66, 40);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Developer : ");
		lblNewLabel_5.setForeground(new Color(154, 205, 50));
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_5.setBounds(63, 198, 103, 34);
		contentPane.add(lblNewLabel_5);

		JLabel lblRohitShrma = new JLabel("ROHIT SH@RMA");
		lblRohitShrma.setForeground(new Color(34, 139, 34));
		lblRohitShrma.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblRohitShrma.setBounds(176, 201, 168, 31);
		contentPane.add(lblRohitShrma);

		JLabel lblNewLabel_6 = new JLabel("srmarohit@gmail.com");
		lblNewLabel_6.setForeground(new Color(47, 79, 79));
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_6.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-14-e-mail-envelope.png"));
		lblNewLabel_6.setBounds(63, 253, 281, 34);
		contentPane.add(lblNewLabel_6);

		JLabel lblHttpswwwyoutubecomchannelucitykfopmmwfonxhxrw = new JLabel(
				"https://www.youtube.com/channel/UCI7tyKFOPMMWF_OnXhx04rw");
		lblHttpswwwyoutubecomchannelucitykfopmmwfonxhxrw.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-23-youtube.png"));
		lblHttpswwwyoutubecomchannelucitykfopmmwfonxhxrw.setForeground(new Color(47, 79, 79));
		lblHttpswwwyoutubecomchannelucitykfopmmwfonxhxrw.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblHttpswwwyoutubecomchannelucitykfopmmwfonxhxrw.setBounds(63, 290, 484, 34);
		contentPane.add(lblHttpswwwyoutubecomchannelucitykfopmmwfonxhxrw);

		JLabel lblWwwfacebookcomfansofcricketever = new JLabel("www.facebook.com/fansofcricketever");
		lblWwwfacebookcomfansofcricketever.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-31-facebook.png"));
		lblWwwfacebookcomfansofcricketever.setForeground(new Color(47, 79, 79));
		lblWwwfacebookcomfansofcricketever.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		lblWwwfacebookcomfansofcricketever.setBounds(63, 328, 441, 34);
		contentPane.add(lblWwwfacebookcomfansofcricketever);

		JLabel label = new JLabel("7974977568");
		label.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-62-whatsapp.png"));
		label.setForeground(new Color(47, 79, 79));
		label.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(63, 369, 168, 34);
		contentPane.add(label);

		JLabel lblWwwshubjotformio = new JLabel("www.shub.jotform.io");
		lblWwwshubjotformio.setIcon(new ImageIcon(
				"C:\\Users\\ram\\Desktop\\glyphicons_free\\glyphicons_free\\glyphicons-social\\png\\glyphicons-social-10-wordpress.png"));
		lblWwwshubjotformio.setForeground(new Color(47, 79, 79));
		lblWwwshubjotformio.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		lblWwwshubjotformio.setBounds(241, 369, 271, 34);
		contentPane.add(lblWwwshubjotformio);
	}
}
