package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieCategoryDAO {

	private static String READ_ALL = "select * from category_movie";
	private static String CREATE = "insert into category_movie(`category_name`) values (?)";
	private static String READ_BY_ID = "select * from category_movie where id =?";
	private static String UPDATE_BY_ID = "update category_movie set category_name=? where id = ?";
	private static String DELETE_BY_ID = "delete from category_movie where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MovieCategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(MovieCategory movieCategory) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, movieCategory.getCategoryName());
		preparedStatement.executeUpdate();
	}

	public MovieCategory read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return MovieCategoryMapper.map(result);
	}

	public void update(MovieCategory movieCategory) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, movieCategory.getCategoryName());
		preparedStatement.setInt(2, movieCategory.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<MovieCategory> readAll() throws SQLException {
		List<MovieCategory> listOfCategoryMovie = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfCategoryMovie.add(MovieCategoryMapper.map(result));
		}
		return listOfCategoryMovie;
	}
}