import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibraryManagementSystem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					LibraryManagementSystem window = new LibraryManagementSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryManagementSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login_user lu = new Login_user();
				lu.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ram\\Desktop\\glyphicons_free\\used\\Capture.PNG"));
		lblNewLabel.setBounds(-39, 0, 823, 440);
		frame.getContentPane().add(lblNewLabel);
	}
}
