import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectDb {

	public static Connection getCon() {
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "forbidden");
			
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return con;
	}
}
