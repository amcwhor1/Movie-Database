package movie.model;

import java.sql.*;
import java.util.ArrayList;

/** Class: 
	* @author Alex McWhorter
	* @version 1.0
	* Completed: Summer 2017
	* 
	* Purpose of Class: - Inside the empty param constructor, it calls on the Connector method 
	* I made in the SqliteConnection class. Now, i can create a MovieModel object in every subsequent
	* class to connect to the database stored in the javafx project file.
	*  
*/

public class MovieModel
{

	Connection connection;
	Statement statement;
	ResultSet resultSet;

	public MovieModel()
	{
		connection = SqliteConnection.Connector();
		if(connection == null) System.exit(1);
		try
		{
			statement = connection.createStatement();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isDbConnected()
	{
		try
		{
			return !connection.isClosed();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLogin(String user, String pass) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sqlCall = "select * FROM admin where userName = ? and password = ?";
		try
		{
			preparedStatement = connection.prepareStatement(sqlCall);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}finally
		{
			preparedStatement.close();
			resultSet.close();
		}
	}
	

	/**
	 * @param title
	 * @param cast
	 * @param rating
	 * @param genre
	 * @param runtime
	 * @param category
	 * @param releaseDate
	 * @param summary
	 */
	public void addMovie(String title, String cast, String rating, String genre, String runtime, String category, String releaseDate, String summary)
	{
		String sqlCall = "INSERT into Movie(title, cast, rating, genre, runtime, category, releaseDate, summary) values('"
				+ title + " ',' " + cast + " ',' " + rating + " ',' " + genre + " ',' " + runtime + " ',' " + category + " ',' " + releaseDate + " ',' " + summary + "');";

		try
		{
			statement.executeUpdate(sqlCall);
		} catch (SQLException e)
		{
			sqlCall = "UPDATE Movie title = '" + title + " ', cast = '" + cast + " ', rating = ' " + rating + " ', genre = '" +
					genre + " ', runtime = ' " + runtime + " ', category = ' " + category + " ', releaseDate = ' " + releaseDate + " ', summary = ' " + summary + "';";
			try
			{
				statement.executeUpdate(sqlCall);
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}

	public void updateMovie(String title, String cast, String rating, String genre, String runtime, String category, String releaseDate, String summary)
	{

		String sqlCall = "UPDATE Movie set cast = '" + cast + " ', rating = ' " + rating + " ', genre = '" +
				genre + " ', runtime = ' " + runtime + " ', category = ' " + category + " ', releaseDate = ' " + releaseDate + " ', summary = ' " + summary + 
				"' WHERE title = '" + title + "';";
		
		try
		{
			statement.executeUpdate(sqlCall);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			

	}



	public ArrayList<String> getMovies()
	{
		ArrayList<String> movieAL = new ArrayList();
		String sqlCall = "SELECT title FROM Movie;";
		try
		{
			resultSet = statement.executeQuery(sqlCall);
			while(resultSet.next())
			{
				movieAL.add(resultSet.getString("Title"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieAL;

	}

	public Object[] getMovie(String title)
	{
		Object[] movieInfo = new Object[7];

		String sqlCall = "SELECT * FROM Movie where title = '" + title + "';";
		try
		{
			resultSet = statement.executeQuery(sqlCall);
			while(resultSet.next())
			{
				movieInfo[0] = resultSet.getString("cast");
				movieInfo[1] = resultSet.getDouble("rating");
				movieInfo[2] = resultSet.getString("genre");
				movieInfo[3] = resultSet.getString("runtime");
				movieInfo[4] = resultSet.getString("runtime");
				movieInfo[5] = resultSet.getString("ReleaseDate");
				movieInfo[6] = resultSet.getString("summary");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return movieInfo;
	}

	/**
	 * @param text
	 */
	public void deleteMovie(String text)
	{
		String sqlCALL = "Delete FROM movie where title = '" + text + "';";
		try
		{
			statement.executeUpdate(sqlCALL);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @param newValue
	 * @return
	 */
	public ArrayList<String> getMovieGenres(String newValue)
	{
		
		ArrayList<String> movieAL = new ArrayList();
		String sqlCall = "SELECT title FROM Movie where genre = '" + newValue + "';";
		try
		{
			resultSet = statement.executeQuery(sqlCall);
			while(resultSet.next())
			{
				movieAL.add(resultSet.getString("Title"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieAL;
	}



}




