package movie.model;
import java.sql.*;

/** Class: 
* @author Alex McWhorter
* @version 1.0
* Completed: Summer 2017
* 
* Purpose of Class: - Contains the static method that allows java classes to connect
* to sqLite db in the MDB javaFX project folder 
* 
*/

public class SqliteConnection
{

	public static Connection Connector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:TheMovieDatabase.db");
			return conn; 
		}catch(Exception e)
		{
			System.out.println(e);
			return null; 
		} 
		
		
	} 
	
}
