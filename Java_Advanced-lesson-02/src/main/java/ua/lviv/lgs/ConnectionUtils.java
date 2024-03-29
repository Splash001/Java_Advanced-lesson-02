package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "Splash001";
	private static String URL = "jdbc:mysql://localhost/movie_library?serverTimezone=UTC";

	public static Connection openConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}
