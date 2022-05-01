package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.sport;


public class sportsDao {


	private Connection connection; 	
	private final String GET_SPORTS_QUERY = "SELECT * FROM sports";
	private final String GET_SPORTS_BY_ID_QUERY = "SELECT * FROM SPORTS WHERE id = ?";
	private final String CREATE_NEW_SPORTS_QUERY = "INSERT INTO SPORTS(name) VALUES(?)";
	private final String DELETE_SPORTS_BY_ID_QUERY = "DELETE FROM sports WHERE id = ?";
	
	public sportsDao() {
		connection = DBConnection.getConnection();
		
	}
	
	public List<sport> getSports() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_SPORTS_QUERY).executeQuery();
		List<sport> sports = new ArrayList<sport>();
		
		while (rs.next()) {
			sports.add(populateSport(rs.getInt(1), rs.getString(2)));
		}
		
		return sports;
	}
	
	public sport getSportById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SPORTS_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateSport(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewSport(String sportName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_SPORTS_QUERY);
		ps.setString(1, sportName);
		ps.executeUpdate();
	}
	
	public void deleteSportById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SPORTS_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private sport populateSport(int id, String name) throws SQLException {
		return new sport();
	}
	
	
}
