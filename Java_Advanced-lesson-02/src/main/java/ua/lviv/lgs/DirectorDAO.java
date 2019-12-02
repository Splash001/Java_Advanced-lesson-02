package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO {

	private static String READ_ALL = "select * from director";
	private static String CREATE = "insert into director(`first_name`, `last_name`, `email`, `address`, `birthday_date`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from director where id =?";
	private static String UPDATE_BY_ID = "update director set first_name=?, last_name = ?, email = ?, address = ?, birthday_date = ? where id = ?";
	private static String DELETE_BY_ID = "delete from director where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public DirectorDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Director director) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, director.getFirstName());
		preparedStatement.setString(2, director.getLastName());
		preparedStatement.setString(3, director.getEmail());
		preparedStatement.setString(4, director.getAddress());
		preparedStatement.setInt(5, director.getBirthdayDate());
		preparedStatement.executeUpdate();
	}

	public Director read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return DirectorMapper.map(result);
	}

	public void update(Director director) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, director.getFirstName());
		preparedStatement.setString(2, director.getLastName());
		preparedStatement.setString(3, director.getEmail());
		preparedStatement.setString(4, director.getAddress());
		preparedStatement.setInt(5, director.getBirthdayDate());
		preparedStatement.setInt(6, director.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Director> readAll() throws SQLException {
		List<Director> listOfDirectors = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfDirectors.add(DirectorMapper.map(result));
		}
		return listOfDirectors;
	}

}