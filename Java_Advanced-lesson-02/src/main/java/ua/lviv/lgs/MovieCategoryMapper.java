package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieCategoryMapper {

	public static MovieCategory map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String categoryName = result.getString("category_name");

		return new MovieCategory(id, categoryName);
	}

}
